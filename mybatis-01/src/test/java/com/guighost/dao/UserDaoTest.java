package com.guighost.dao;

import com.guighost.pojo.User;
import com.guighost.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserDaoTest
 * @Description TODO
 * @Author GuiGhost
 * @Date 2021/01/26 13:51
 * @Version 1.0
 **/
public class UserDaoTest {
    @Test
    public void test(){
        //第一步获得SqlSession对象
        SqlSession sqlSession = null;

        try{
            sqlSession = MybatisUtils.getSqlSession();
            //方式一：getMapper
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.getUserList();

            //方式二：
//        List<User> userList = sqlSession.selectList("com.guighost.dao.UserDao.getUserList");

            for (User user : userList) {
                System.out.println(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);

        sqlSession.close();
    }


    //增删改需要提交事务
    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        boolean b = mapper.addUser(new User(4, "wangwu", "889"));
        if (b){
            System.out.println("success");
        }
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

//    万能的Map
    @Test
    public void testMap(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("userId",4);
        map.put("userName","zhaoliu");
        map.put("userPassword","5569");
        boolean b = mapper.addUserForMap(map);
        if (b){
            System.out.println("success");
        }
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        boolean b = mapper.updateUser(new User(4, "zhaoliu", "11235"));
        if (b){
            System.out.println("success");
        }
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        boolean b = mapper.deleteUser(4);
        if (b){
            System.out.println("success");
        }
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    //模糊查询
    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userLike = mapper.getUserLike("zh");
        for (User user : userLike) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
