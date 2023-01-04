package com.example.WetPlant.domain.user;

import com.example.WetPlant.domain.user.dto.UserDTO;
import com.example.WetPlant.domain.user.dto.UserMapper;
import com.example.WetPlant.domain.user.dto.UserRegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/current")
    @PreAuthorize("hasAuthority('USER_READ')")
    public ResponseEntity<UserDTO> findCurrentuser() {
        User user = userService.getCurrentUser();
        return new ResponseEntity<>(userMapper.toDTO(user), HttpStatus.OK);
    }




    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@Validated @RequestBody UserRegisterDTO userRegisterDTO) {

        User user = userService.register(userMapper.fromUserRegisterDTO(userRegisterDTO));
        return new ResponseEntity<>(userMapper.toDTO(user), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('USER_MODIFY')")
    public ResponseEntity<UserDTO> updateById(@PathVariable UUID id, @Validated @RequestBody UserDTO userDTO) {
        User user = userService.updateById(id, userMapper.fromDTO(userDTO));
        return new ResponseEntity<>(userMapper.toDTO(user), HttpStatus.OK);
    }



    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('USER_DELETE')")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
