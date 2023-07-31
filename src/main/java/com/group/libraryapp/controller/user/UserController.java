package com.group.libraryapp.controller.user;

import com.group.libraryapp.domain.user.Fruit;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.service.fruit.FruitService;
import com.group.libraryapp.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

//   @Autowired
    private final UserService userService;
// 필드에 바로 사용: 테스트를 어렵게 만드는 요인
    private final FruitService fruitService;

//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
// setter: 사용하면 오작동이할 수 있음

    public UserController(UserService userService, @Qualifier("main")FruitService fruitService){
        this.userService = userService;
        this.fruitService = fruitService;
    }
// 제일 나은거: 생성자 사용

    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequest request) {
        userService.saveUser(request);
    }

    @GetMapping("/fruit")
    public Fruit fruit() {
        return new Fruit("바나나", 2000);
    }

    @GetMapping("/user")
    public List<UserResponse> getUsers() {
        return userService.getUsers();
    }
    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request) {
        userService.updateUser(request);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name) {
        userService.deleteUser(name);
    }

}
