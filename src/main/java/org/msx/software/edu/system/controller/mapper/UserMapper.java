package org.msx.software.edu.system.controller.mapper;

import org.msx.software.edu.system.controller.vm.UserEntityVm;
import org.msx.software.edu.system.model.entity.UserEntity;

public interface UserMapper extends Mapper<UserEntity, UserEntityVm> {

    UserEntityVm map(
            Object userName, Object firstName, Object lastName, Object email,
            Object imageUrl, UserEntityVm userEntityVm);
}