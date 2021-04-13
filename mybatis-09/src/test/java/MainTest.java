import com.guighost.dao.BlogMapper;
import com.guighost.pojo.Blog;
import com.guighost.utils.IDUtils;
import com.guighost.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

/**
 * @author GuiGhost
 * @date 2021/02/12
 * 说明：
 */
public class MainTest {
    @Test
    public void test(){
        System.out.println(IDUtils.getId());
        System.out.println(IDUtils.getId());
        System.out.println(IDUtils.getId());
    }

    @Test
    public void addBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IDUtils.getId());
        blog.setTitle("我是高手");
        blog.setAuthor("鬼鬼");
        blog.setCreateTime(new Date());
        blog.setViews(999);
        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("牛逼的人");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("风一样的男子");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("你好，大神");
        mapper.addBlog(blog);


        sqlSession.close();
    }

    @Test
    public void queryBlogIF(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Map map = new HashMap();
//        map.put("title","登顶");
        map.put("author","鬼鬼");
//        map.put("views",999);
//        map.put("id","0949be8a84f84986aae90462490c2d62");
        List<Blog> blogs = mapper.queryBlogIF(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void queryBlogForEach(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map map = new HashMap();
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        map.put("ids",ids);
        List<Blog> blogs = mapper.queryBlogByForeach(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
}
