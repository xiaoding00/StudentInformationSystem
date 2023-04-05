package Utils;

import Mapper.mapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Student;

import java.io.IOException;
import java.util.List;

public class studentService {


    //查找
  public Student selectStudent(int id) throws IOException {
      sqlFactory sqlFactory=new sqlFactory();
      SqlSessionFactory sqlSessionFactory = sqlFactory.sqlFactory();
      SqlSession sqlSession = sqlSessionFactory.openSession();
      mapper mapper = sqlSession.getMapper(mapper.class);
     Student student = mapper.seletById(id);

      sqlSession.close();
      return student;
  }


//  删除
  public void deledtByid(int id) throws IOException {
      sqlFactory sqlFactory=new sqlFactory();
      SqlSessionFactory sqlSessionFactory = sqlFactory.sqlFactory();
      SqlSession sqlSession = sqlSessionFactory.openSession();
      mapper mapper = sqlSession.getMapper(mapper.class);
      mapper.delete(id);
      sqlSession.commit();
      sqlSession.close();
  }



  //修改
  public void update(int id,String sex,String className,String name) throws IOException {
      sqlFactory sqlFactory=new sqlFactory();
      SqlSessionFactory sqlSessionFactory = sqlFactory.sqlFactory();
      SqlSession sqlSession = sqlSessionFactory.openSession();
      mapper mapper = sqlSession.getMapper(mapper.class);
      mapper.update(id,sex,className,name);
      sqlSession.commit();
      sqlSession.close();
  }

//添加
  public void add(Student student) throws IOException {
      sqlFactory sqlFactory=new sqlFactory();
      SqlSessionFactory sqlSessionFactory = sqlFactory.sqlFactory();
      SqlSession sqlSession = sqlSessionFactory.openSession();
      mapper mapper = sqlSession.getMapper(mapper.class);
     mapper.add(student);
      sqlSession.commit();
      sqlSession.close();
  }

  //查询所用
    public List<Student> selectAll() throws IOException {
        sqlFactory sqlFactory=new sqlFactory();
        SqlSessionFactory sqlSessionFactory = sqlFactory.sqlFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        mapper mapper = sqlSession.getMapper(mapper.class);
        List<Student> students = mapper.selectAll();
        sqlSession.commit();
        sqlSession.close();
        return students;
    }

    //查询数据数
    public int total() throws IOException {
        sqlFactory sqlFactory=new sqlFactory();
        SqlSessionFactory sqlSessionFactory = sqlFactory.sqlFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        mapper mapper = sqlSession.getMapper(mapper.class);
        int total = mapper.total();
        sqlSession.commit();
        sqlSession.close();
        return total;
    }
}
