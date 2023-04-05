package Ui;

import Utils.TeacherService;
import Utils.studentService;
import pojo.Student;
import pojo.Teacher;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.io.IOException;

public class AddTeacherJFrame extends JFrame {
    String sex;

    public AddTeacherJFrame() {
        TeacherService service = new TeacherService();

        this.setTitle("教师添加界面");
        this.setSize(400, 430);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setResizable(false);


        //教师姓名
        JLabel jLabel = new JLabel("教师姓名:");
        jLabel.setBounds(100, 50, 60, 20);
        jLabel.setBorder(new BevelBorder(0));
        this.getContentPane().add(jLabel);
        //输入框
        JTextField jTextField = new JTextField();
        jTextField.setBounds(170, 50, 100, 20);
        this.getContentPane().add(jTextField);


        //教师编号
        JLabel jLabel1 = new JLabel("教师编号:");
        jLabel1.setBounds(100, 90, 60, 20);
        jLabel1.setBorder(new BevelBorder(0));
        this.getContentPane().add(jLabel1);
        //输入框
        JTextField jTextField1 = new JTextField();
        jTextField1.setBounds(170, 90, 100, 20);
        this.getContentPane().add(jTextField1);


        //教师性别
        JLabel jLabel2 = new JLabel("性 别 :");
        jLabel2.setBounds(100, 130, 60, 20);
        jLabel2.setBorder(new BevelBorder(0));
        this.getContentPane().add(jLabel2);

        JRadioButton man = new JRadioButton("男");
        JRadioButton woman = new JRadioButton("女");
        ButtonGroup group = new ButtonGroup();
        group.add(man);
        group.add(woman);
        JPanel jPanel = new JPanel();
        jPanel.setBounds(170, 125, 100, 30);
        jPanel.add(man);
        jPanel.add(woman);
        this.add(jPanel);
        man.addActionListener(e -> {
            sex = "男";

        });
        woman.addActionListener(e -> {
            sex = "女";
        });


        //教师科目
        JLabel jLabel4 = new JLabel("教师科目:");
        jLabel4.setBounds(100, 170, 60, 20);
        jLabel4.setBorder(new BevelBorder(0));
        this.getContentPane().add(jLabel4);
        //输入框
        JTextField jTextField4 = new JTextField();
        jTextField4.setBounds(170, 170, 100, 20);
        this.getContentPane().add(jTextField4);


        //确认按钮
        JButton jButton = new JButton("添加");
        jButton.setBounds(120, 220, 60, 20);
        this.getContentPane().add(jButton);
        //添加功能


        jButton.addActionListener(e -> {
            String name = jTextField.getText();
            int id = 0;
            try {
                id = Integer.parseInt(jTextField1.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "添加失败");
                throw new RuntimeException(ex);
            }
            String lesson = jTextField4.getText();

            Teacher teacher = new Teacher(id, name, sex, lesson);

            try {
                Teacher teacher1 = service.selectTeacher(id);
                if (teacher1 != null) {
                    JOptionPane.showMessageDialog(this, "添加失败，该教师编号已存在");
                    this.dispose();
                    new AddTeacherJFrame();
                }
                service.add(teacher);
                JOptionPane.showMessageDialog(this, "添加成功");
                this.dispose();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        });


        //重置按钮
        JButton jButton1 = new JButton("重置");
        jButton1.setBounds(200, 220, 60, 20);
        this.getContentPane().add(jButton1);

        //重置功能
        jButton1.addActionListener(e -> {
            this.dispose();
            new AddTeacherJFrame();

        });

        JLabel jLabel5 = new JLabel(new ImageIcon("imags/list.png"));
        jLabel5.setBounds(0, 0, 500, 430);
        this.getContentPane().add(jLabel5);
        this.setVisible(true);
    }
}
