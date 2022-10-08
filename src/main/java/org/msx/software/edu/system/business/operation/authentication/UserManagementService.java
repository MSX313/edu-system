package org.msx.software.edu.system.business.operation.authentication;

import org.msx.software.edu.system.business.security.jwt.JwtResponse;
import org.msx.software.edu.system.controller.vm.RoleEntityVm;
import org.msx.software.edu.system.controller.vm.UserEntityVm;

import java.util.List;

public interface UserManagementService {

    String DEFAULT_PASSWORD = "1";

    void updateUser(UserEntityVm userEntityVm);

    JwtResponse login(UserEntityVm userEntityVm);

    List<UserEntityVm> getAllUsers();

    List<RoleEntityVm> getAllRoles();

    UserEntityVm changeUserRole(UserEntityVm userEntityVm);

    List<RoleEntityVm> getAllUserRoleList(String username);

    String refreshToken(String token);
}