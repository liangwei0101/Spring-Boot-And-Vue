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

    @Delete("delete from user where no=#{no}")
    void delUserById(@Param("no") int no);

    @Update("update user set name = #{name}, email = #{email} where no = #{no}")
    void updateUserByNo(@Param("name") String name, @Param("email") String email, @Param("no") int no);

    @Select("select * from user")
    List<User> getUser();
}
