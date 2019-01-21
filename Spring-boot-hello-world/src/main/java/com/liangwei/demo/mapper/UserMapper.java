package com.liangwei.demo.mapper;

import java.util.List;
import com.liangwei.demo.model.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserMapper {

    @Insert({"insert into user(no, name, email) values(#{no}, #{name}, #{email})"})
    void AddUser(User userInfo);

    @Delete("delect from user_info where no=#{no}")
    User delUserById(@Param("id") int id);

    @Update("update user set name = #{name} and email = #{email} where no = #{no}")
    User updateUserById(@Param("no") int id, @Param("name") String name, @Param("email") String email);

    @Select("select * from user")
    List<User> getUser();
}
