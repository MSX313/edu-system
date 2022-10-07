package org.msx.software.edu.system.business.operation.authentication;

import org.msx.software.edu.system.model.entity.UserEntity;
import org.msx.software.edu.system.business.operation.EntityFinder;

public interface UserFinder extends EntityFinder<UserEntity> {

    UserEntity findByUsername(String username);
}