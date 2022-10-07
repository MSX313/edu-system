package org.msx.software.edu.system.business.operation;

import org.msx.software.edu.system.model.entity.util.BaseEntity;

public interface EntityFinder<T extends BaseEntity> {

    T findById(Long id);
}