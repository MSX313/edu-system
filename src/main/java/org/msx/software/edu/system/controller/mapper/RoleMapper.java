package org.msx.software.edu.system.controller.mapper;

import org.msx.software.edu.system.business.operation.EntityFinder;
import org.msx.software.edu.system.controller.vm.RoleEntityVm;
import org.msx.software.edu.system.model.entity.RoleEntity;
import org.msx.software.edu.system.model.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper extends BaseMapper<RoleEntity, RoleEntityVm> {

    @Autowired
    public RoleMapper(@Qualifier("userFinderImpl") EntityFinder<UserEntity> userFinder) {
        super(userFinder);
    }

    @Override
    public void map(RoleEntity roleEntity, RoleEntityVm roleEntityVm) {
        super.map(roleEntity, roleEntityVm);
        roleEntityVm.setRoleCode(roleEntity.getCode());
        roleEntityVm.setRoleDescription(roleEntity.getDescription());
    }
}