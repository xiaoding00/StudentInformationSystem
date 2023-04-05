package Ui;

import Utils.ClassService;
import pojo.Class;
import pojo.Teacher;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class ClassListJFrame extends JFrame {

    public ClassListJFrame() {
        ClassService service = new ClassService();
        this.setTitle("教师列表页面");
        this.setSize(600, 500);
        this.setDefaultCloseOperation(2);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        this.setLayout(null);
        //班级查询页面

        try {
            List<Class> classes = service.selectAll();//学生数据

            int total = service.total();//数据总和
            String[] columnName = {"班级", "信息", "实际人数", "所纳人数"};
            String[][] tableData = new String[total][columnName.length];
            for (int i = 0; i < total; i++) {
                tableData[i][0] = classes.get(i).getClassName();
                tableData[i][1] = classes.get(i).getInformation();
                tableData[i][2] = String.valueOf(service.totalnum(classes.get(i).getClassName()));        //实际人数
                tableData[i][3] = String.valueOf(classes.get(i).getNumber());
            }
            JTable jTable = new JTable(tableData, columnName);
            JScrollPane jScrollPane = new JScrollPane(jTable);
            jScrollPane.setBounds(70, 80, 400, 300);

            this.getContentPane().add(jScrollPane);


        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }


        JLabel jLabel1 = new JLabel(new ImageIcon("imags/list.png"));
        jLabel1.setBounds(0, 0, 600, 500);
        this.getContentPane().add(jLabel1);
        this.setVisible(true);
    }
}
