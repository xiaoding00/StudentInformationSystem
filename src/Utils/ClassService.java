package Utils;

import Mapper.mapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Class;
import pojo.Student;
import pojo.Teacher;

import java.io.IOException;
import java.util.List;

public class ClassService {
    //添加
    public void add(Class class1) throws IOException {
        sqlFactory sqlFactory=new sqlFactory();
        SqlSessionFactory sqlSessionFactory = sqlFactory.sqlFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        mapper mapper = sqlSession.getMapper(mapper.class);
        mapper.addClass(class1);
        sqlSession.commit();
        sqlSession.close();
    }


    //查询所用
    public List<Class> selectAll() throws IOException {
        sqlFactory sqlFactory=new sqlFactory();
        SqlSessionFactory sqlSessionFactory = sqlFactory.sqlFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        mapper mapper = sqlSession.getMapper(mapper.class);
        List<Class> classes = mapper.selectAllClass();
        sqlSession.commit();
        sqlSession.close();
        return classes;
    }
    //查询数据数
    public int total() throws IOException {
        sqlFactory sqlFactory=new sqlFactory();
        SqlSessionFactory sqlSessionFactory = sqlFactory.sqlFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        mapper mapper = sqlSession.getMapper(mapper.class);
        int total = mapper.totalClass();
        sqlSession.commit();
        sqlSession.close();
        return total;
    }

    //查询数据数
    public int totalnum(String name) throws IOException {
        sqlFactory sqlFactory=new sqlFactory();
        SqlSessionFactory sqlSessionFactory = sqlFactory.sqlFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        mapper mapper = sqlSession.getMapper(mapper.class);
        int totalnum = mapper.totalnum(name);
        sqlSession.commit();
        sqlSession.close();
        return totalnum;
    }

    //查询数据数
    public Class getclass(String name) throws IOException {
        sqlFactory sqlFactory=new sqlFactory();
        SqlSessionFactory sqlSessionFactory = sqlFactory.sqlFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        mapper mapper = sqlSession.getMapper(mapper.class);
        Class c = mapper.c(name);
        sqlSession.commit();
        sqlSession.close();
        return c;
    }
}
