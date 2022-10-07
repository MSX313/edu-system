package org.msx.software.edu.system.controller.mapper;

import lombok.RequiredArgsConstructor;
import org.msx.software.edu.system.controller.vm.UserEntityVm;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

@Component
@RequiredArgsConstructor
public class UserViewModelMapperImpl implements UserViewModelMapper {

    private final UserMapper userMapper;

    @Override
    public UserEntityVm map(Object userData) {
        LinkedHashMap result = (LinkedHashMap) ((LinkedHashMap<?, ?>) userData).get("result");
        return userMapper.map(
                result.get("userId"), result.get("firstName"), result.get("lastName"),
                result.get("email"), result.get("profileImage"), new UserEntityVm());
    }
}