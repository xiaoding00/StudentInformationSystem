package Ui;

import pojo.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class MainJframe extends JFrame {
    /**
     * 主界面
     *
     * @return
     */
    public MainJframe(User user) {
        System.out.println(user);
        JLabel jLabel = new JLabel(new ImageIcon("imags/kun.png"));
        this.getContentPane().add(jLabel);
        this.setTitle("信息管理系统  v1.0");
        //设置界面的宽高
        this.setSize(1079, 608);
        //设置可改变界面
        this.setResizable(false);
        //设置界面制定
        this.setAlwaysOnTop(true);
        //设置页面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(3);

        //创建菜单条
        JMenuBar jMenuBar = new JMenuBar();
        //系统设置
        JMenu SystemJmenu = new JMenu("系统设置");
        JMenuItem updateSecret = new JMenuItem("修改密码");
        JMenuItem exitSystem = new JMenuItem("退出系统");
        SystemJmenu.add(updateSecret);
        SystemJmenu.add(exitSystem);
        jMenuBar.add(SystemJmenu);


        /**
         * 修改密码
         */


        updateSecret.addActionListener(e -> {
            new UpdateSecret(user,this);
        });


        /**
         * 退出xit
         */
        exitSystem.addActionListener(e -> {
                    System.exit(0);
                }
        );


        //学生管理
        JMenu StudentJmenu = new JMenu("学生管理");
        JMenuItem addStudent = new JMenuItem("学生添加");
        JMenuItem listStudent = new JMenuItem("学生列表");
        StudentJmenu.add(addStudent);
        StudentJmenu.add(listStudent);
        jMenuBar.add(StudentJmenu);

        addStudent.addActionListener(e -> {
            try {
                new AddStudentJFrame();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        listStudent.addActionListener(e -> {
            new StudentListJFrame();
        });


        //教师管理
        JMenu TeacherJmenu = new JMenu("教师管理");
        JMenuItem addTeacher = new JMenuItem("教师添加");
        JMenuItem listTeacher = new JMenuItem("教师列表");
        TeacherJmenu.add(addTeacher);
        TeacherJmenu.add(listTeacher);
        jMenuBar.add(TeacherJmenu);

        addTeacher.addActionListener(e -> {
            new AddTeacherJFrame();

        });
        listTeacher.addActionListener(e -> {
            new TeacherListJFrame();

        });


        //班级管理
        JMenu ClassJmenu = new JMenu("班级管理");
        JMenuItem addClass = new JMenuItem("班级添加");
        JMenuItem setClass = new JMenuItem("班级列表");
        ClassJmenu.add(addClass);
        ClassJmenu.add(setClass);
        jMenuBar.add(ClassJmenu);

        addClass.addActionListener(e -> {
            new AddClassJFrame();
        });

        setClass.addActionListener(e -> {
            new ClassListJFrame();
        });


        //帮助
        JMenu Help = new JMenu("帮助");
        JMenuItem AboutUs = new JMenuItem("关于我们");
        Help.add(AboutUs);
        jMenuBar.add(Help);

        //关于我们
        AboutUs.addActionListener(e -> {
            JDialog jDialog = new JDialog();
            JLabel jLabel1 = new JLabel("感谢您的观赏,该项目结束，祝您每日快乐,再见！");
            jLabel1.setBounds(0, 0, 200, 100);
            jDialog.getContentPane().add(jLabel1);
            jDialog.setSize(300, 100);
            jDialog.setAlwaysOnTop(true);
            jDialog.setLocationRelativeTo(null);
            jDialog.setVisible(true);

        });

        //添加JmenuBar菜单条
        this.setJMenuBar(jMenuBar);


        //设置界面的显示
        this.setVisible(true);

    }


}
