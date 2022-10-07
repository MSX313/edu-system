package org.msx.software.edu.system.controller.mapper;

import org.msx.software.edu.system.business.operation.EntityFinder;
import org.msx.software.edu.system.controller.vm.UserEntityVm;
import org.msx.software.edu.system.model.entity.RoleEntity;
import org.msx.software.edu.system.model.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Component
public class UserMapperImpl extends BaseMapper<UserEntity, UserEntityVm> implements UserMapper {

    private static final String N_A = "N/A";
    private static final String EMPTY = "";

    @Autowired
    public UserMapperImpl(@Qualifier("userFinderImpl") EntityFinder<UserEntity> userFinder) {
        super(userFinder);
    }

    @Override
    public void map(UserEntity from, UserEntityVm to) {
        super.map(from, to);
        map(from.getUserName(), from.getFirstName(), from.getLastName(), from.getEmail(), from.getImage(), to);
        if (from.getRoleSet() != null) {
            List<String> roles =
                    from.getRoleSet().stream().map(RoleEntity::getCode).collect(Collectors.toList());
            to.setRoles(roles);
        } else {
            to.setRoles(new ArrayList<>());
        }
    }

    @Override
    public UserEntityVm map(
            Object userName, Object firstName, Object lastName, Object email,
            Object imageUrl, UserEntityVm userEntityVm) {
        if (firstName != null && firstName.toString().toLowerCase(Locale.ROOT).equals(N_A.toLowerCase(Locale.ROOT)))
            firstName = null;
        if (lastName != null && lastName.toString().toLowerCase(Locale.ROOT).equals(N_A.toLowerCase(Locale.ROOT)))
            lastName = null;
        if (email != null && email.toString().toLowerCase(Locale.ROOT).equals(N_A.toLowerCase(Locale.ROOT)))
            email = null;
        String strFirstName;
        String strLastName;
        String strEmail = email == null ? N_A : email.toString();
        if (firstName == null && lastName == null) {
            if (email == null) {
                strFirstName = strLastName = N_A;
            } else {
                strFirstName = EMPTY;
                strLastName = strEmail;
            }
        } else if (firstName == null || lastName == null) {
            strFirstName = firstName == null ? EMPTY : firstName.toString();
            strLastName = lastName == null ? EMPTY : lastName.toString();
        } else {
            strFirstName = firstName.toString();
            strLastName = lastName.toString();
        }
        userEntityVm.setUsername(userName.toString());
        userEntityVm.setFirstName(strFirstName);
        userEntityVm.setLastName(strLastName);
        userEntityVm.setEmail(strEmail);
        userEntityVm.setProfileImageUrl(imageUrl == null ? null : imageUrl.toString());
        return userEntityVm;
    }
}