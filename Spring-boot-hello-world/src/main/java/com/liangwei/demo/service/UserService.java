package com.liangwei.demo.service;

import com.liangwei.demo.model.User;
import org.apache.ibatis.annotations.*;
import java.util.List;

public interface UserService {

    void AddUser(User user);

    void delUserById(@Param("no") int no);

    void updateUserByNo(User user);

    List<User> getUser();
}
