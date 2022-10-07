package org.msx.software.edu.system.service.authentication;

import org.msx.software.edu.system.model.entity.UserEntity;
import org.msx.software.edu.system.service.EntityFinder;

public interface UserFinder extends EntityFinder<UserEntity> {

    UserEntity findByUsername(String username);
}