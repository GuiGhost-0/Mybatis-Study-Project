package com.guighost.dao;

import com.guighost.pojo.User;
import com.guighost.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;


/**
 * @ClassName UserDaoTest
 * @Description TODO
 * @Author GuiGhost
 * @Date 2021/01/26 13:51
 * @Version 1.0
 **/
public class UserDaoTest {
    static Logger logger = Logger.getLogger(UserDaoTest.class);

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

            logger.info("\n我开始了");
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
    public void testLog4j(){
        logger.info("info:我进入了Log4j");
        logger.debug("debug:我进入了Log4j");
        logger.error("error:我进入了Log4j");
        System.out.println("hahah");
    }
}
