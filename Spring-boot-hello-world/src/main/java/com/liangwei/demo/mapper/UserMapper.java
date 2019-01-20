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

    @Insert({"insert into user(id, name, email) values(#{id}, #{name}, #{email})"})
    void AddUser(User userInfo);

    @Delete("delect from user_info where id=#{id}")
    User delUserById(@Param("id") String id);

    @Update("update user set name = #{name} and email = #{email} where id = #{id}")
    User updateUserById(Integer id);

    @Select("select * from user")
    List<User> getUser();
}
