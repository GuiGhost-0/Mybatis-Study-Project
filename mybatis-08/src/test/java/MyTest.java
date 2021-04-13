import com.guighost.dao.TeacherMapper;
import com.guighost.pojo.Teacher;
import com.guighost.utils.MybatisUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author GuiGhost
 * @date 2021/02/12
 * 说明：测试类
 */
public class MyTest {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);
        /**
         * Teacher(id=1, name=鬼老师,
         *          students=[Student(id=1, name=张三, tid=1),
         *          Student(id=2, name=李四, tid=1),
         *          Student(id=3, name=王五, tid=1),
         *          Student(id=4, name=赵六, tid=1),
         *          Student(id=5, name=孙七, tid=1)])
         * */
        sqlSession.close();
    }

    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher2(1);
        System.out.println(teacher);
        /**
         * Teacher(id=0, name=鬼老师, students=[
         * Student(id=1, name=张三, tid=1),
         * Student(id=2, name=李四, tid=1),
         * Student(id=3, name=王五, tid=1),
         * Student(id=4, name=赵六, tid=1),
         * Student(id=5, name=孙七, tid=1)
         * ])
         * */
        sqlSession.close();
    }
}
