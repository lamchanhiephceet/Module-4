package com.codegym.springbootmigratewebapp.services;


import com.codegym.springbootmigratewebapp.models.MyUser;

import java.util.List;

public interface IMyUserService {
    List<MyUser> getUserList();
    void saveUser(MyUser user);
}
