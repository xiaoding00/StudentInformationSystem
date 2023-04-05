package Ui;

import Utils.CheckCodeUtil;
import Utils.UserService;
import pojo.User;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class RegisterJFrame extends JFrame {
    /**
     * 注册界面
     *
     * @return
     */

    public RegisterJFrame() throws IOException {
        UserService userService = new UserService();
        this.setTitle("注册界面");
        this.setSize(600, 430);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);

        //用户名
        JLabel jLabel = new JLabel("用户名：");
        jLabel.setBorder(new BevelBorder(0));
        jLabel.setBounds(10, 130, 60, 20);
        this.getContentPane().add(jLabel);

        //用户名输入框
        JTextField jTextField = new JTextField();
        jTextField.setBorder(new BevelBorder(1));
        jTextField.setBounds(80, 130, 100, 20);
        this.getContentPane().add(jTextField);

        //密码
        JLabel jLabel2 = new JLabel("密码：");
        jLabel2.setBorder(new BevelBorder(0));
        jLabel2.setBounds(10, 180, 60, 20);
        this.getContentPane().add(jLabel2);

        //用户名密码输入框
        JPasswordField jPasswordField = new JPasswordField();
        jPasswordField.setBorder(new BevelBorder(1));
        jPasswordField.setBounds(80, 180, 100, 20);
        this.getContentPane().add(jPasswordField);

        /**登录注册按钮
         *
         */

        JButton jButton = new JButton("注册");
        JButton jButton1 = new JButton("重置");
        jButton.setBounds(10, 270, 60, 20);
        this.getContentPane().add(jButton);
        jButton1.setBounds(80, 270, 60, 20);
        this.getContentPane().add(jButton1);


        /**
         * 验证码
         */
        //验证码
        JLabel jLabel4 = new JLabel("验证码：");
        jLabel4.setBorder(new BevelBorder(0));
        jLabel4.setBounds(10, 220, 60, 20);
        this.getContentPane().add(jLabel4);

        //验证码输入框

        JTextField jTextField1 = new JTextField();
        jTextField1.setBorder(new BevelBorder(1));
        jTextField1.setBounds(80, 220, 40, 20);
        this.getContentPane().add(jTextField1);


        //验证码

        String checkCode = CheckCodeUtil.checkCode();//验证码
        JLabel jLabel3 = new JLabel(checkCode);
        jLabel3.setBounds(130, 220, 40, 20);
        jLabel3.setBorder(new BevelBorder(1));
        this.getContentPane().add(jLabel3);


        //背景
        JLabel jLabel5 = new JLabel(new ImageIcon("imags/register.png"));

        this.getContentPane().add(jLabel5);


        //注册
        jButton.addActionListener(e -> {

            if (!(checkCode.equals(jTextField1.getText()))) {
                JOptionPane.showMessageDialog(null, "验证码错误");
                return;
            }


            String id = jTextField.getText();
            String password = jPasswordField.getText();
            try {
                if (userService.getUser(id) != null) {
                    JOptionPane.showMessageDialog(null, "该用户名已存在");
                    this.dispose();
                    new RegisterJFrame();
                    return;
                } else {
                    User user = new User(id, password);
                    userService.addUser(user);
                    JOptionPane.showMessageDialog(null, "用户添加成功，正在返回登录界面。。。");
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            try {

                new LoginJFrame();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            this.dispose();
        });

        //重置
        jButton1.addActionListener(e -> {

            try {
                new RegisterJFrame();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            this.dispose();
        });


        this.setVisible(true);

    }
}
