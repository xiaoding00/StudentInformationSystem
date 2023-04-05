package pojo;

public class Student {
    private int id;
    private String name;
    private String sex;
    private String className;

    public Student(int id, String name, String sex, String className) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.className = className;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
