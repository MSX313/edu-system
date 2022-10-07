package org.msx.software.edu.system.controller.mapper;

import org.msx.software.edu.system.controller.vm.UserEntityVm;

public interface UserViewModelMapper {

    UserEntityVm map(Object userData);
}