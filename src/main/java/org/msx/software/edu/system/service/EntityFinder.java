package org.msx.software.edu.system.service;

import org.msx.software.edu.system.model.entity.util.master.BaseEntity;

public interface EntityFinder<T extends BaseEntity> {

    T findById(Long id);
}