package org.msx.software.edu.system.business.security;

import lombok.AllArgsConstructor;
import org.msx.software.edu.system.business.common.codes.ExceptionMessageCode;
import org.msx.software.edu.system.model.entity.UserEntity;
import org.msx.software.edu.system.model.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity foundedUser = userRepository.findByUserName(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(ExceptionMessageCode.USERNAME_NOT_FOUND));
        return UserPrinciple.build(foundedUser);
    }
}