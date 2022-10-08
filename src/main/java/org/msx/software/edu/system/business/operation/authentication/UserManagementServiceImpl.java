package org.msx.software.edu.system.business.operation.authentication;

import lombok.AllArgsConstructor;
import org.msx.software.edu.system.business.exception.DataNotFoundException;
import org.msx.software.edu.system.business.security.UserPrinciple;
import org.msx.software.edu.system.business.security.jwt.JwtProvider;
import org.msx.software.edu.system.business.security.jwt.JwtResponse;
import org.msx.software.edu.system.business.security.jwt.TokenService;
import org.msx.software.edu.system.business.security.jwt.TokenServiceFactory;
import org.msx.software.edu.system.controller.mapper.Mapper;
import org.msx.software.edu.system.controller.vm.RoleEntityVm;
import org.msx.software.edu.system.controller.vm.UserEntityVm;
import org.msx.software.edu.system.model.entity.RoleEntity;
import org.msx.software.edu.system.model.entity.UserEntity;
import org.msx.software.edu.system.model.entity.util.BaseEntity;
import org.msx.software.edu.system.model.repository.RoleRepository;
import org.msx.software.edu.system.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.crypto.SecretKey;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserManagementServiceImpl implements UserManagementService {

    private final UserFinder userFinder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    @Qualifier("userMapperImpl")
    private final Mapper<UserEntity, UserEntityVm> userMapper;
    @Qualifier("roleMapper")
    private final Mapper<RoleEntity, RoleEntityVm> roleMapper;
    private final TokenServiceFactory tokenServiceFactory;
    private final SecretKey secretKey;
    private final JwtProvider jwtProvider;
    private final AuthenticationManager authenticationManager;

    @Override
    public void updateUser(UserEntityVm userEntityVm) {
        UserEntity userEntity;
        try {
            userEntity = userFinder.findByUsername(userEntityVm.getUsername());
        } catch (DataNotFoundException ex) {
            userEntity = new UserEntity();
            userEntity.setUserName(userEntityVm.getUsername());
            userEntity.setPassword(passwordEncoder.encode(DEFAULT_PASSWORD));
        }
        userEntity.setFirstName(userEntityVm.getFirstName());
        userEntity.setLastName(userEntityVm.getLastName());
        userEntity.setEmail(userEntityVm.getEmail());
        userEntity.setImage(userEntityVm.getProfileImageUrl());
        userRepository.save(userEntity);
    }

    @Override
    public JwtResponse login(UserEntityVm userEntityVm) {
        TokenService tokenService = tokenServiceFactory.getInstance(secretKey, jwtProvider, authenticationManager);
        Authentication authentication = tokenService.authenticate(userEntityVm.getUsername());
        String jwt = tokenService.getToken(authentication);
        UserPrinciple userDetails = (UserPrinciple) authentication.getPrincipal();
        return new JwtResponse(jwt, userDetails.getUsername(),
                userDetails.getFirstName(), userDetails.getLastName(), userDetails.getEmail(),
                userDetails.getImage(), userDetails.getAuthorities());
    }

    @Override
    public List<UserEntityVm> getAllUsers() {
        List<UserEntity> allUsers = userRepository.findAll();
        List<UserEntityVm> result = new ArrayList<>();
        allUsers.forEach(user -> {
            UserEntityVm userViewModel = new UserEntityVm();
            userMapper.map(user, userViewModel);
            result.add(userViewModel);
        });
        return result;
    }

    @Override
    public List<RoleEntityVm> getAllRoles() {
        List<RoleEntity> roles = roleRepository.findAll();
        List<RoleEntityVm> roleViewModels = new ArrayList<>();
        List<RoleEntity> sortedRoles = roles.stream().sorted(Comparator.comparing(BaseEntity::getId)).toList();
        for (RoleEntity role : sortedRoles) {
            RoleEntityVm roleViewModel = new RoleEntityVm();
            roleMapper.map(role, roleViewModel);
            roleViewModels.add(roleViewModel);
        }
        return roleViewModels;
    }

    @Override
    @Transactional
    public UserEntityVm changeUserRole(UserEntityVm userEntityVm) {
        UserEntity user = userFinder.findById(userEntityVm.getId());
        if (!userEntityVm.getRoles().isEmpty()) {
            Set<RoleEntity> roleEntities = roleRepository.findAllByCodeIn(userEntityVm.getRoles());
            user.setRoleSet(roleEntities);
        } else {
            user.setRoleSet(null);
        }
        userRepository.save(user);
        userMapper.map(user, userEntityVm);
        return userEntityVm;
    }

    @Override
    public List<RoleEntityVm> getAllUserRoleList(String username) {
        UserEntity user = userFinder.findByUsername(username);
        Set<RoleEntity> roleSet = user.getRoleSet();
        List<RoleEntityVm> roleViewModels = new ArrayList<>();
        if (roleSet != null) {
            List<RoleEntity> sortedRoles = roleSet.stream().sorted(Comparator.comparing(BaseEntity::getId)).toList();
            for (RoleEntity role : sortedRoles) {
                RoleEntityVm roleViewModel = new RoleEntityVm();
                roleMapper.map(role, roleViewModel);
                roleViewModels.add(roleViewModel);
            }
        }
        return roleViewModels;
    }

    @Override
    public String refreshToken(String token) {
        return tokenServiceFactory.getInstance(secretKey, jwtProvider, authenticationManager).refreshToken(token);
    }
}