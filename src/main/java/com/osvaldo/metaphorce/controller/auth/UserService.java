package com.osvaldo.metaphorce.controller.auth;




public interface UserService {

    UserEntity save(UserDto user);
    UserEntity findOne(String username);

}
