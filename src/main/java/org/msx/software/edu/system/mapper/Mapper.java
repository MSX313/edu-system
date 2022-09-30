package org.msx.software.edu.system.mapper;

import org.msx.software.edu.system.model.view.util.BaseViewModel;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;

public interface Mapper<E, V extends BaseViewModel> {

    void map(E from, V to);

    List<V> map(List<E> source, Class<? extends V> clazz);

    Set<V> map(Set<E> source, Class<? extends V> clazz);

    Page<V> map(Page<E> source, Class<? extends V> clazz);
}