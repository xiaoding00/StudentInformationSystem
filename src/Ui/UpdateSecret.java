package Ui;

import Utils.UserService;
import Utils.studentService;
import pojo.User;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.io.IOException;

public class UpdateSecret extends JFrame {
    UserService service1 = new UserService();

    public UpdateSecret(User user,MainJframe mainJframe) {
        studentService service = new studentService();

        this.setTitle("用户修改界面");
        this.setSize(400, 430);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setResizable(false);

        //学生姓名
        JLabel jLabel = new JLabel("当前用户名为:     " + user.getId());
        jLabel.setBounds(100, 50, 180, 20);
        jLabel.setBorder(new BevelBorder(0));
        this.getContentPane().add(jLabel);


        //原密码
        JLabel jLabel1 = new JLabel("原密码:");
        jLabel1.setBounds(100, 90, 60, 20);
        jLabel1.setBorder(new BevelBorder(0));
        this.getContentPane().add(jLabel1);
        //输入框
        JPasswordField jPasswordField = new JPasswordField();
        jPasswordField.setBounds(170, 90, 100, 20);
        this.getContentPane().add(jPasswordField);

        //新密码
        JLabel jLabel2 = new JLabel("新密码:");
        jLabel2.setBounds(100, 130, 60, 20);
        jLabel2.setBorder(new BevelBorder(0));
        this.getContentPane().add(jLabel2);
        //输入框
        JPasswordField jPasswordField1 = new JPasswordField();
        jPasswordField1.setBounds(170, 130, 100, 20);
        this.getContentPane().add(jPasswordField1);

        //确认密码
        JLabel jLabel3 = new JLabel("确认密码:");
        jLabel3.setBounds(100, 170, 60, 20);
        jLabel3.setBorder(new BevelBorder(0));
        this.getContentPane().add(jLabel3);
        //输入框
        JPasswordField jPasswordField2 = new JPasswordField();
        jPasswordField2.setBounds(170, 170, 100, 20);
        this.getContentPane().add(jPasswordField2);

        //确认，重置按钮
        JButton jButton = new JButton("确认");
        jButton.setBounds(120, 210, 60, 20);
        this.getContentPane().add(jButton);

        jButton.addActionListener(e -> {
            String id = user.getId();
            String password = user.getPassword();
            String old = jPasswordField.getText();
            String new1 = jPasswordField1.getText();
            String new2 = jPasswordField2.getText();
            if (!(old.equals(password))){
                JOptionPane.showMessageDialog(this, "原密码错误");
                this.dispose();
                new UpdateSecret(user,mainJframe);
                return;
            }

            if (!(new1.equals(new2))) {
                JOptionPane.showMessageDialog(this, "两次密码不相同");
                this.dispose();
                new UpdateSecret(user,mainJframe);
                return;
            }
            try {
                service1.updateById(id, new1);
                JOptionPane.showMessageDialog(this, "密码修改成功");
                this.dispose();
                mainJframe.dispose();
                new LoginJFrame();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        });


        //重置
        JButton jButton1 = new JButton("重置");
        jButton1.setBounds(190, 210, 60, 20);
        this.getContentPane().add(jButton1);

        jButton1.addActionListener(e -> {
            this.dispose();
            new UpdateSecret(user,mainJframe);
        });

        //背景
        JLabel jLabel4 = new JLabel(new ImageIcon("imags/list.png"));
        jLabel4.setBounds(0, 0, 500, 430);
        this.getContentPane().add(jLabel4);


        this.setVisible(true);
    }


}
