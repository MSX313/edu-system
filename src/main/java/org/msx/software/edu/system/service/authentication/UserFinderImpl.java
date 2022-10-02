package org.msx.software.edu.system.service.authentication;

import lombok.RequiredArgsConstructor;
import org.msx.software.edu.system.exception.DataNotFoundException;
import org.msx.software.edu.system.model.entity.util.master.UserEntity;
import org.msx.software.edu.system.repository.util.master.UserRepository;
import org.msx.software.edu.system.util.codes.ExceptionMessageCode;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserFinderImpl implements UserFinder {

    private final UserRepository repository;

    @Override
    public UserEntity findById(Long id) {
        Optional<UserEntity> user = repository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new DataNotFoundException(ExceptionMessageCode.
                    USERNAME_NOT_FOUND_WITH_ID, id);
        }
    }

    @Override
    public UserEntity findByUsername(String username) {
        Optional<UserEntity> user = repository.findByUserName(username);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new DataNotFoundException(ExceptionMessageCode.
                    USERNAME_NOT_FOUND_WITH_USERNAME, username);
        }
    }
}