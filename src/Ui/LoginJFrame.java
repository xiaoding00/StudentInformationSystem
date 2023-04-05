package Ui;

import Utils.CheckCodeUtil;
import Utils.UserService;
import pojo.User;


import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.io.IOException;


public class LoginJFrame extends JFrame {


    /**
     * 登录界面
     *
     * @return
     */
    public LoginJFrame() throws IOException {
        UserService userService = new UserService();
        this.setTitle("登录界面");
        this.setSize(588, 430);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        this.setResizable(false);
        //Login

        JLabel jLabel5 = new JLabel(new ImageIcon("imags/LOGO.png"));
        jLabel5.setBounds(320, 15, 70, 50);
        this.getContentPane().add(jLabel5);
        //用户名
        JLabel jLabel = new JLabel("用户名：");
        jLabel.setBorder(new BevelBorder(0));
        jLabel.setBounds(340, 130, 60, 20);
        this.getContentPane().add(jLabel);

        //用户名输入框
        JTextField jTextField = new JTextField();
        jTextField.setBorder(new BevelBorder(1));
        jTextField.setBounds(420, 130, 100, 20);
        this.getContentPane().add(jTextField);

        //密码
        JLabel jLabel2 = new JLabel("密码：");
        jLabel2.setBorder(new BevelBorder(0));
        jLabel2.setBounds(340, 180, 60, 20);
        this.getContentPane().add(jLabel2);

        //用户名密码输入框
        JPasswordField jPasswordField = new JPasswordField();
        jPasswordField.setBorder(new BevelBorder(1));
        jPasswordField.setBounds(420, 180, 100, 20);
        this.getContentPane().add(jPasswordField);

        /**登录注册按钮
         *
         */

        JButton jButton = new JButton("登录");
        JButton jButton1 = new JButton("注册");
        jButton.setBounds(360, 270, 60, 20);
        this.getContentPane().add(jButton);
        jButton1.setBounds(430, 270, 60, 20);
        this.getContentPane().add(jButton1);

        /**
         * 验证码
         */
        //验证码
        JLabel jLabel4 = new JLabel("验证码：");
        jLabel4.setBorder(new BevelBorder(0));
        jLabel4.setBounds(340, 220, 60, 20);
        this.getContentPane().add(jLabel4);

        //验证码输入框

        JTextField jTextField1 = new JTextField();
        jTextField1.setBorder(new BevelBorder(1));
        jTextField1.setBounds(420, 220, 40, 20);
        this.getContentPane().add(jTextField1);


        //验证码

        String checkCode = CheckCodeUtil.checkCode();//验证码
        JLabel jLabel3 = new JLabel(checkCode);
        jLabel3.setBounds(475, 220, 40, 20);
        jLabel3.setBorder(new BevelBorder(1));
        this.getContentPane().add(jLabel3);

        //页面背景
        JLabel jLabel1 = new JLabel(new ImageIcon("imags/login.png"));
        jLabel1.setBounds(-10, -20, 588, 430);
        this.getContentPane().add(jLabel1);
        this.setDefaultCloseOperation(3);


        //登录按钮
        jButton.addActionListener(e -> {
            if (!(checkCode.equals(jTextField1.getText()))) {
                JOptionPane.showMessageDialog(null, "验证码错误");
                return;
            }
            String id = jTextField.getText();
            String password = jPasswordField.getText();
            try {
                User user = userService.getUser(id, password);
                if (user != null) {
                    JOptionPane.showMessageDialog(null, "登录成功，正在加载中。。。。。");
                    this.dispose();
                    new MainJframe(user);

                } else {
                    JOptionPane.showMessageDialog(null, "密码或用户名错误");
                    this.dispose();
                    new LoginJFrame();
                }

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        });


        //注册按钮
        jButton1.addActionListener(e -> {
            this.dispose();

            try {
                new RegisterJFrame();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });


        this.setVisible(true);


    }


}
