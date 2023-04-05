package Ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;

import Utils.ClassService;
import Utils.studentService;
import pojo.Class;
import pojo.Student;

public class AddStudentJFrame extends JFrame {
    String sex;
    String className;

    public AddStudentJFrame() throws IOException {
        studentService service = new studentService();
        ClassService service1 = new ClassService();
        this.setTitle("学生添加界面");
        this.setSize(400, 430);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setResizable(false);


        //学生姓名
        JLabel jLabel = new JLabel("学生姓名:");
        jLabel.setBounds(100, 50, 60, 20);
        jLabel.setBorder(new BevelBorder(0));
        this.getContentPane().add(jLabel);
        //输入框
        JTextField jTextField = new JTextField();
        jTextField.setBounds(170, 50, 100, 20);
        this.getContentPane().add(jTextField);


        //学生学号
        JLabel jLabel1 = new JLabel("学生学号:");
        jLabel1.setBounds(100, 90, 60, 20);
        jLabel1.setBorder(new BevelBorder(0));
        this.getContentPane().add(jLabel1);
        //输入框
        JTextField jTextField1 = new JTextField();
        jTextField1.setBounds(170, 90, 100, 20);
        this.getContentPane().add(jTextField1);


        List<Class> classes = service1.selectAll();
        //班级
        JComboBox box = new JComboBox();
        for (int i = 0; i < classes.size(); i++) {
            box.addItem(classes.get(i).getClassName());
        }

        JLabel jLabel3 = new JLabel("班级 :");
        jLabel3.setBounds(100, 180, 60, 20);
        jLabel3.setBorder(new BevelBorder(0));
        this.getContentPane().add(jLabel3);
        className = "计科一班";
        box.addActionListener(e -> {
            int selectedIndex = box.getSelectedIndex();
            className = (String) box.getItemAt(selectedIndex);

        });

        JPanel jPanel1 = new JPanel();
        jPanel1.setBounds(170, 180, 100, 30);
        jPanel1.add(box);
        this.getContentPane().add(jPanel1);


        //性别
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
                JOptionPane.showMessageDialog(this, "添加失败，学号为空");
                throw new RuntimeException(ex);
            }
            Student student = new Student(id, name, sex, className);

            try {
                Student student1 = service.selectStudent(id);
                if (student1 != null) {
                    JOptionPane.showMessageDialog(this, "该学号存在，添加失败");
                    this.dispose();
                    try {
                        new AddStudentJFrame();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    return;
                }
                service.add(student);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            JOptionPane.showMessageDialog(this, "添加成功");
            this.dispose();

        });


        //重置按钮
        JButton jButton1 = new JButton("重置");
        jButton1.setBounds(200, 220, 60, 20);
        this.getContentPane().add(jButton1);

        //重置功能
        jButton1.addActionListener(e -> {
            this.dispose();
            try {
                new AddStudentJFrame();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        });

        JLabel jLabel4 = new JLabel(new ImageIcon("imags/list.png"));
        jLabel4.setBounds(0, 0, 500, 430);
        this.getContentPane().add(jLabel4);
        this.setVisible(true);
    }
}
