package Utils;

import Mapper.mapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Student;
import pojo.Teacher;

import java.io.IOException;
import java.util.List;

public class TeacherService {

    //添加
    public void add(Teacher teacher) throws IOException {
        sqlFactory sqlFactory=new sqlFactory();
        SqlSessionFactory sqlSessionFactory = sqlFactory.sqlFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        mapper mapper = sqlSession.getMapper(mapper.class);
       mapper.addByTeacher(teacher);
        sqlSession.commit();
        sqlSession.close();
    }


    //查找
    public Teacher selectTeacher(int id) throws IOException {
        sqlFactory sqlFactory=new sqlFactory();
        SqlSessionFactory sqlSessionFactory = sqlFactory.sqlFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        mapper mapper = sqlSession.getMapper(mapper.class);
        Teacher teacher = mapper.seletByTeacher(id);

        sqlSession.close();
        return teacher;
    }


    //  删除
    public void deledtByid(int id) throws IOException {
        sqlFactory sqlFactory=new sqlFactory();
        SqlSessionFactory sqlSessionFactory = sqlFactory.sqlFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        mapper mapper = sqlSession.getMapper(mapper.class);
        mapper.deleteTeacher(id);
        sqlSession.commit();
        sqlSession.close();
    }



    //修改
    public void update(int id,String sex,String lesson,String name) throws IOException {
        sqlFactory sqlFactory=new sqlFactory();
        SqlSessionFactory sqlSessionFactory = sqlFactory.sqlFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        mapper mapper = sqlSession.getMapper(mapper.class);
        mapper.updateTeacher(id, sex, lesson, name);
        sqlSession.commit();
        sqlSession.close();
    }

   // 查询所用
    public List<Teacher> selectAll() throws IOException {
        sqlFactory sqlFactory=new sqlFactory();
        SqlSessionFactory sqlSessionFactory = sqlFactory.sqlFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        mapper mapper = sqlSession.getMapper(mapper.class);
        List<Teacher> teachers = mapper.selectAllTeacher();
        sqlSession.commit();
        sqlSession.close();
        return teachers;
    }

    //查询数据数
    public int total() throws IOException {
        sqlFactory sqlFactory=new sqlFactory();
        SqlSessionFactory sqlSessionFactory = sqlFactory.sqlFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        mapper mapper = sqlSession.getMapper(mapper.class);
        int total = mapper.totalTeache();
        sqlSession.commit();
        sqlSession.close();
        return total;
    }
}
