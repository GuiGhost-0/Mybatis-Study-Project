package com.guighost.dao;

import com.guighost.pojo.User;

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
    //查询所有用户
    List<User> getUserList();
    //根据id查询用户
    User getUserById(int id);
    //添加一个用户
    boolean addUser(User user);
    //修改用户
    boolean updateUser(User user);
    //删除用户
    boolean deleteUser(int id);
}
