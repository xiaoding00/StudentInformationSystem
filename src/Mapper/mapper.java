package Mapper;

import org.apache.ibatis.annotations.*;
import pojo.Class;
import pojo.Student;
import pojo.Teacher;
import pojo.User;

import java.util.List;

public interface mapper {
    @Select("select * from tb_student where id=#{id}")
    Student seletById(@Param("id") int id);

    @Insert("insert into tb_student values (#{id},#{name},#{sex},#{className})")
    void add(Student student);


    @Delete("delete from tb_student where id=#{id}")
    void delete(@Param("id") int id);


    @Update("update  tb_student set sex = #{sex},className = #{className},name = #{name} where id=#{id}")
    void update(@Param("id") int id,@Param("sex") String sex,@Param("className") String className,@Param("name") String name);


    @Select("select * from tb_student")
        List<Student> selectAll();

    @Select("select count(*) from tb_student")
    int total();

    //管理账号查询
    @Select("select  * from tb_user where id=#{id} and password =#{password}")
    User selectByuse(@Param("id")String id, @Param("password") String password);

    //查询是否存在该用户
    @Select("select  * from tb_user where id=#{id} ")
    User selectByID(@Param("id")String id);

    //添加用户
    @Insert("insert into  tb_user values (#{id},#{password})")
    void addByUser(User user);

    //修改用户密码
    @Update("update  tb_user set  password=#{password} where id=#{id} ")
    void updateById(@Param("id") String id,@Param("password") String password);

    //添加教师
    @Insert("insert into  tb_teacher values (#{id},#{name},#{sex},#{lesson})")
    void addByTeacher(Teacher teacher);



    @Delete("delete from tb_teacher where id=#{id}")
    void deleteTeacher(@Param("id") int id);


    @Update("update  tb_teacher set sex = #{sex},lesson = #{lesson},name = #{name} where id=#{id}")
    void updateTeacher(@Param("id") int id,@Param("sex") String sex,@Param("lesson") String lesson,@Param("name") String name);


    @Select("select * from tb_teacher where id=#{id}")
    Teacher seletByTeacher(@Param("id") int id);

    @Select("select * from tb_teacher")
    List<Teacher> selectAllTeacher();

    @Select("select count(*) from tb_teacher")
    int totalTeache();


    //班级
    @Insert("insert into tb_class values (#{className},#{information},#{number})")
        void addClass(Class class1);

    @ResultMap("class")
    @Select("select * from tb_class")
    List<Class> selectAllClass();

    @Select("select count(*) from tb_class")
    int totalClass();

    @Select("select count(*) from tb_student where className=#{name}")
    int totalnum(@Param("name") String name);


    @Select("select * from tb_class where name=#{name}")
     Class c(@Param("name") String name);



}
