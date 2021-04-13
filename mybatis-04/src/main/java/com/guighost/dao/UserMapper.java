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

    //分页
    List<User> getUserByLimit(Map<String,Integer> map);

    //RowBounds分页2
    List<User> getUserByRowBounds();
}
