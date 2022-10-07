package org.msx.software.edu.system.controller.mapper;

import org.msx.software.edu.system.controller.vm.util.BaseEntityVm;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;

public interface Mapper<ENTITY, ViewModel extends BaseEntityVm> {

    void map(ENTITY from, ViewModel to);

    List<ViewModel> map(List<ENTITY> source, Class<? extends ViewModel> clazz);

    Set<ViewModel> map(Set<ENTITY> source, Class<? extends ViewModel> clazz);

    Page<ViewModel> map(Page<ENTITY> source, Class<? extends ViewModel> clazz);
}