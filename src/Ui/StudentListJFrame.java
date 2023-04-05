package Ui;

import Utils.studentService;
import pojo.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;

public class StudentListJFrame extends JFrame {
    public StudentListJFrame() {
        studentService service = new studentService();
        this.setTitle("学生列表页面");
        this.setSize(600, 500);
        this.setDefaultCloseOperation(2);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        this.setLayout(null);
        //查找功能
        JLabel jLabel = new JLabel("请输入学号:");
        jLabel.setBounds(100, 20, 70, 20);
        this.getContentPane().add(jLabel);
        JTextField jTextField = new JTextField();
        jTextField.setBounds(180, 20, 100, 20);
        this.getContentPane().add(jTextField);
        JButton jButton = new JButton("查找");
        jButton.setBounds(300, 20, 60, 20);
        JButton jButton1 = new JButton("查找所用");
        jButton1.setBounds(370, 20, 100, 20);
        this.getContentPane().add(jButton);
        this.getContentPane().add(jButton1);

        JLabel jLabel1 = new JLabel(new ImageIcon("imags/list.png"));
        jLabel1.setBounds(0, 0, 600, 500);
        this.getContentPane().add(jLabel1);
        this.setVisible(true);


        //查找按钮
        //查找功能
        jButton.addActionListener(e -> {
            JFrame jFrame = new JFrame("查询如下");
            jFrame.setSize(300, 350);
            jFrame.setAlwaysOnTop(true);
            jFrame.setLayout(null);
            jFrame.setResizable(false);
            jFrame.setLocationRelativeTo(null);


            //查询学号
            JLabel jLabel3 = new JLabel("学生学号:");
            jLabel3.setBounds(50, 20, 60, 20);
            jFrame.getContentPane().add(jLabel3);

            //查询显示
            JTextField jTextField1 = new JTextField();
            jTextField1.setBounds(120, 20, 100, 20);
            jFrame.getContentPane().add(jTextField1);


            //查询姓名
            JLabel jLabel4 = new JLabel("学生姓名:");
            jLabel4.setBounds(50, 50, 60, 20);
            jFrame.getContentPane().add(jLabel4);

            //查询显示
            JTextField jTextField2 = new JTextField();
            jTextField2.setBounds(120, 50, 100, 20);
            jFrame.getContentPane().add(jTextField2);


            //查询姓名
            JLabel jLabel5 = new JLabel("学生性别:");
            jLabel5.setBounds(50, 80, 60, 20);
            jFrame.getContentPane().add(jLabel5);

            //查询显示
            JTextField jTextField3 = new JTextField();
            jTextField3.setBounds(120, 80, 100, 20);
            jFrame.getContentPane().add(jTextField3);


            //查询姓名
            JLabel jLabel6 = new JLabel("学生班级:");
            jLabel6.setBounds(50, 110, 60, 20);
            jFrame.getContentPane().add(jLabel6);

            //查询显示
            JTextField jTextField4 = new JTextField();
            jTextField4.setBounds(120, 110, 100, 20);
            jFrame.getContentPane().add(jTextField4);

            //查询功能

            int id = Integer.parseInt(jTextField.getText());
            try {
                Student student = service.selectStudent(id);
                if (student == null) {
                    JOptionPane.showMessageDialog(jFrame, "查无此人");
                    return;

                }


                jTextField1.setText(String.valueOf(student.getId()));
                jTextField2.setText(student.getName());
                jTextField3.setText(student.getSex());
                jTextField4.setText(student.getClassName());
            } catch (IOException ex) {

                throw new RuntimeException(ex);

            }


            //删除，修改，返回
            JButton jButton2 = new JButton("删除");
            jButton2.setBounds(50, 170, 60, 20);
            jFrame.getContentPane().add(jButton2);

            //删除功能

            jButton2.addActionListener(e2 -> {

                int id1 = Integer.parseInt(jTextField1.getText());
                try {
                    service.deledtByid(id1);
                    JOptionPane.showMessageDialog(jFrame, "删除成功");
                    jFrame.dispose();

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });


            JButton jButton3 = new JButton("修改");
            jButton3.setBounds(120, 170, 60, 20);
            jFrame.getContentPane().add(jButton3);

            //修改功能
            jButton3.addActionListener(e3 -> {
                int id2 = Integer.parseInt(jTextField1.getText());
                String name = jTextField2.getText();
                String sex = jTextField3.getText();
                String className = jTextField4.getText();
                try {
                    service.update(id2, sex, className, name);
                    JOptionPane.showMessageDialog(jFrame, "修改成功");
                    jFrame.dispose();


                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });


            JButton jButton4 = new JButton("返回");
            jButton4.setBounds(190, 170, 60, 20);
            jFrame.getContentPane().add(jButton4);

            //返回功能
            jButton4.addActionListener(e1 -> {
                jFrame.dispose();
            });

            //背景
            JLabel jLabel2 = new JLabel(new ImageIcon("imags/list.png"));
            jLabel2.setBounds(0, 0, 400, 350);
            jFrame.getContentPane().add(jLabel2);
            jFrame.setVisible(true);

        });

        //查找所用
        /**
         * 查询所用
         * selectAll
         */
        jButton1.addActionListener(e -> {

                    try {
                        List<Student> students = service.selectAll();//学生数据

                        int total = service.total();//数据总和
                        String[] columnName = {"学号", "姓名", "性别", "班级"};
                        String[][] tableData = new String[total][columnName.length];
                        for (int i = 0; i < total; i++) {
                            tableData[i][0] = String.valueOf(students.get(i).getId());
                            tableData[i][1] = (students.get(i).getName());
                            tableData[i][2] = (students.get(i).getSex());
                            tableData[i][3] = (students.get(i).getClassName());
                        }
                        JTable jTable = new JTable(tableData, columnName);
                        JScrollPane jScrollPane = new JScrollPane(jTable);
                        jScrollPane.setBounds(70, 80, 400, 300);

                        this.getContentPane().add(jScrollPane);


                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                }
        );


    }
}
