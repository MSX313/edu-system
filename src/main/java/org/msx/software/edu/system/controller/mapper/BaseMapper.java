package org.msx.software.edu.system.controller.mapper;

import lombok.AllArgsConstructor;
import org.msx.software.edu.system.model.entity.util.Entity;
import org.msx.software.edu.system.model.entity.UserEntity;
import org.msx.software.edu.system.controller.vm.BaseViewModel;
import org.msx.software.edu.system.business.operation.EntityFinder;
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
@AllArgsConstructor
public class BaseMapper<E extends Entity, V extends BaseViewModel> implements Mapper<E, V> {

    private final static String UNKNOWN = "نا مشخص";
    @Qualifier("userFinderImpl")
    private final EntityFinder<UserEntity> userFinder;

    @Override
    public void map(E from, V to) {
        to.setId(from.getId());
        to.setInsertUser(from.getInsertUser());
        to.setUpdateUser(from.getUpdateUser());
        to.setInsertDateTime(from.getInsertDateTime());
        to.setUpdateDateTime(from.getUpdateDateTime());
        to.setIsActive(from.isActive());
        to.setVersion(from.getVersion());
        try {
            setInsertingUserFullName(from, to);
            setUpdatingUserFullName(from, to);
        } catch (Exception ex) {
            to.setInsertUserFullName(UNKNOWN);
            to.setUpdateUserFullName(UNKNOWN);
        }
    }

    @Override
    public List<V> map(List<E> source, Class<? extends V> clazz) {
        List<V> result = new ArrayList<>();
        if (source != null) {
            for (E from : source) {
                try {
                    V to = clazz.newInstance();
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
    public Set<V> map(Set<E> source, Class<? extends V> clazz) {
        Set<V> result = new HashSet<>();
        if (source != null) {
            for (E from : source) {
                try {
                    V to = clazz.newInstance();
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
    public Page<V> map(Page<E> source, Class<? extends V> clazz) {
        List<V> result = new ArrayList<>();
        if (source != null) {
            for (E from : source.getContent()) {
                try {
                    V to = clazz.newInstance();
                    map(from, to);
                    result.add(to);
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e.getMessage());
                }
            }
            return new PageImpl<V>(result, source.getPageable(), source.getTotalElements());
        } else {
            return Page.empty(Pageable.unpaged());
        }
    }

    private void setInsertingUserFullName(E from, V to) {
        UserEntity insertingUser =
                userFinder.findById(Long.valueOf(from.getInsertUser()));
        to.setInsertUserFullName(String.format("%s %s", insertingUser.getFirstName(), insertingUser.getLastName()));
    }

    private void setUpdatingUserFullName(E from, V to) {
        UserEntity updatingUser =
                userFinder.findById(Long.valueOf(from.getUpdateUser()));
        to.setUpdateUserFullName(String.format("%s %s", updatingUser.getFirstName(), updatingUser.getLastName()));
    }
}