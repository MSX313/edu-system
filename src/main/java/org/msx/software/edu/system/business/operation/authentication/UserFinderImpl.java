package org.msx.software.edu.system.business.operation.authentication;

import lombok.RequiredArgsConstructor;
import org.msx.software.edu.system.business.exception.DataNotFoundException;
import org.msx.software.edu.system.model.entity.UserEntity;
import org.msx.software.edu.system.model.repository.UserRepository;
import org.msx.software.edu.system.business.common.codes.ExceptionMessageCode;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserFinderImpl implements UserFinder {

    private final UserRepository userRepository;

    @Override
    public UserEntity findById(Long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new DataNotFoundException(ExceptionMessageCode.
                    USERNAME_NOT_FOUND_WITH_ID, id);
        }
    }

    @Override
    public UserEntity findByUsername(String username) {
        Optional<UserEntity> user = userRepository.findByUserName(username);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new DataNotFoundException(ExceptionMessageCode.
                    USERNAME_NOT_FOUND_WITH_USERNAME, username);
        }
    }
}