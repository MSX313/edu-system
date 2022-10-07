package org.msx.software.edu.system.controller.mapper;

import lombok.RequiredArgsConstructor;
import org.msx.software.edu.system.business.operation.EntityFinder;
import org.msx.software.edu.system.controller.vm.util.BaseEntityVm;
import org.msx.software.edu.system.model.entity.UserEntity;
import org.msx.software.edu.system.model.entity.util.Entity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class BaseMapper<ENTITY extends Entity, ViewModel extends BaseEntityVm> implements Mapper<ENTITY, ViewModel> {

    private final static String UNKNOWN = "نا مشخص";
    @Qualifier("userFinderImpl")
    private final EntityFinder<UserEntity> userFinder;

    @Override
    public void map(ENTITY baseEntity, ViewModel baseEntityVm) {
        baseEntityVm.setId(baseEntity.getId());
        baseEntityVm.setInsertUser(baseEntity.getInsertUser());
        baseEntityVm.setUpdateUser(baseEntity.getUpdateUser());
        baseEntityVm.setInsertDateTime(baseEntity.getInsertDateTime());
        baseEntityVm.setUpdateDateTime(baseEntity.getUpdateDateTime());
        baseEntityVm.setIsActive(baseEntity.isActive());
        baseEntityVm.setVersion(baseEntity.getVersion());
        try {
            setInsertingUserFullName(baseEntity, baseEntityVm);
            setUpdatingUserFullName(baseEntity, baseEntityVm);
        } catch (Exception ex) {
            baseEntityVm.setInsertUserFullName(UNKNOWN);
            baseEntityVm.setUpdateUserFullName(UNKNOWN);
        }
    }

    @Override
    public List<ViewModel> map(List<ENTITY> source, Class<? extends ViewModel> clazz) {
        List<ViewModel> result = new ArrayList<>();
        if (source != null) {
            for (ENTITY from : source) {
                try {
                    ViewModel to = clazz.newInstance();
                    map(from, to);
                    result.add(to);
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e.getMessage());
                }
            }
        }
        return result;
    }

    @Override
    public Set<ViewModel> map(Set<ENTITY> source, Class<? extends ViewModel> clazz) {
        Set<ViewModel> result = new HashSet<>();
        if (source != null) {
            for (ENTITY from : source) {
                try {
                    ViewModel to = clazz.newInstance();
                    map(from, to);
                    result.add(to);
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e.getMessage());
                }
            }
        }
        return result;
    }

    @Override
    public Page<ViewModel> map(Page<ENTITY> source, Class<? extends ViewModel> clazz) {
        List<ViewModel> result = new ArrayList<>();
        if (source != null) {
            for (ENTITY from : source.getContent()) {
                try {
                    ViewModel to = clazz.newInstance();
                    map(from, to);
                    result.add(to);
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e.getMessage());
                }
            }
            return new PageImpl<>(result, source.getPageable(), source.getTotalElements());
        } else {
            return Page.empty(Pageable.unpaged());
        }
    }

    private void setInsertingUserFullName(ENTITY baseEntity, ViewModel baseEntityVm) {
        UserEntity insertingUser =
                userFinder.findById(Long.valueOf(baseEntity.getInsertUser()));
        baseEntityVm.setInsertUserFullName(
                String.format("%s %s",
                        insertingUser.getFirstName(), insertingUser.getLastName()));
    }

    private void setUpdatingUserFullName(ENTITY baseEntity, ViewModel to) {
        UserEntity updatingUser =
                userFinder.findById(Long.valueOf(baseEntity.getUpdateUser()));
        to.setUpdateUserFullName(
                String.format("%s %s",
                        updatingUser.getFirstName(), updatingUser.getLastName()));
    }
}