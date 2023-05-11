package com.group.libraryapp.service.user;

import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.repository.user.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserService {

    private final UserRepository userRepository;

    public UserService(JdbcTemplate jdbcTemplate) {
        userRepository = new UserRepository(jdbcTemplate);
    }

    public void updateUser(JdbcTemplate jdbcTemplate, UserUpdateRequest request) {
        boolean isUserNotExist = userRepository.isUserNotExist(jdbcTemplate, request.getId());
        if (isUserNotExist){
            throw  new IllegalArgumentException();
        }

        userRepository.updateUserName(jdbcTemplate, request.getName(), request.getId());
    }
}
