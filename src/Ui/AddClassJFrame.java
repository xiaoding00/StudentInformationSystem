package Ui;

import Utils.ClassService;
import pojo.Class;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class AddClassJFrame extends JFrame {

    public AddClassJFrame() {

        ClassService service = new ClassService();
        this.setTitle("班级添加");
        this.setSize(400, 330);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(2);
        setAlwaysOnTop(true);
        this.setLayout(null);

        JLabel jLabel = new JLabel("班级名称：");
        jLabel.setBounds(80, 50, 70, 20);
        this.getContentPane().add(jLabel);

        JTextField jTextField = new JTextField();
        jTextField.setBounds(150, 50, 100, 20);
        this.getContentPane().add(jTextField);


        JLabel jLabel1 = new JLabel("班级信息：");
        jLabel1.setBounds(80, 120, 70, 20);
        this.getContentPane().add(jLabel1);

        JTextArea jTextArea = new JTextArea();
        jTextArea.setBounds(150, 120, 100, 50);
        this.getContentPane().add(jTextArea);


        JLabel jLabel3 = new JLabel("班级所纳人数：");
        jLabel3.setBounds(60, 190, 90, 20);
        this.getContentPane().add(jLabel3);

        JTextField jTextField2 = new JTextField();
        jTextField2.setBounds(150, 190, 100, 20);
        this.getContentPane().add(jTextField2);


        JButton jButton = new JButton("提交");
        jButton.setBounds(120, 220, 70, 20);
        this.getContentPane().add(jButton);

        JButton jButton1 = new JButton("重置");
        jButton1.setBounds(200, 220, 70, 20);
        this.getContentPane().add(jButton1);

        JLabel jLabel2 = new JLabel(new ImageIcon("imags/list.png"));
        jLabel2.setBounds(0, 0, 500, 400);
        this.getContentPane().add(jLabel2);

        jButton.addActionListener(e -> {
            String className = jTextField.getText();
            String information = jTextArea.getText();
            int number = 0;
            try {
                number = Integer.parseInt(jTextField2.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "人数为空，添加失败");
                throw new RuntimeException(ex);
            }
            Class c = new Class(className, information, number);
            try {
                Class getclass = service.getclass(className);
                if (getclass != null) {
                    JOptionPane.showMessageDialog(this, "添加失败，该班级已存在");
                    this.dispose();
                    new AddClassJFrame();
                    return;

                }
                service.add(c);
                JOptionPane.showMessageDialog(this, "班级添加成功");
                this.dispose();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });


        jButton1.addActionListener(e -> {
            this.dispose();
            new AddClassJFrame();

        });

        this.setVisible(true);
    }
}
