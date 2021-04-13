package com.guighost.dao;

import com.guighost.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @InterfaceName UserDao
 * @Description TODO
 * @Author GuiGhost
 * @Date 2021/01/26 13:49
 * @Version 1.0
 **/
public interface UserMapper {

    @Select("select id,name username,pwd password from user")
    List<User> getUsers();

    //方法有多个参数时，每个参数前必须加上@Param("xxx")注解
    @Select("select id,name username,pwd password from user where id = #{id}")
    User getUserById(@Param("id") int id);

    //增加
    @Insert("insert into user(id,name,pwd) values(#{id},#{username},#{password})")
    int addUser(User user);

    //修改
    @Update("update user set name = #{username} where id = #{id}")
    int updateUser(User user);

    //删除
    @Delete("delete from user where id = #{id}")
    int deleteUser(@Param("id") int id);

}
