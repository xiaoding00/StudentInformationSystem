package Utils;

import Mapper.mapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.User;

import java.io.IOException;

public class UserService {

    //登录
    public User getUser( String id ,String password) throws IOException {
        sqlFactory sqlFactory=new sqlFactory();
        SqlSessionFactory sqlSessionFactory = sqlFactory.sqlFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        mapper mapper = sqlSession.getMapper(mapper.class);
        User user = mapper.selectByuse(id, password);
        sqlSession.close();
        return user;
    }

    //判断用户名是否存在
    public User getUser( String id ) throws IOException {
        sqlFactory sqlFactory=new sqlFactory();
        SqlSessionFactory sqlSessionFactory = sqlFactory.sqlFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        mapper mapper = sqlSession.getMapper(mapper.class);
        User user = mapper.selectByID(id);
        sqlSession.close();
        return user;
    }

    //注册
    public void addUser( User user) throws IOException {
        sqlFactory sqlFactory=new sqlFactory();
        SqlSessionFactory sqlSessionFactory = sqlFactory.sqlFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        mapper mapper = sqlSession.getMapper(mapper.class);
        mapper.addByUser(user);

        sqlSession.commit();
        sqlSession.close();
    }
    //修改密码
    public void updateById(String id,String password) throws IOException {
        sqlFactory sqlFactory=new sqlFactory();
        SqlSessionFactory sqlSessionFactory = sqlFactory.sqlFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        mapper mapper = sqlSession.getMapper(mapper.class);
         mapper.updateById(id,password);

        sqlSession.commit();
        sqlSession.close();
    }
}
