package pojo;

public class Teacher {
    private int id;
    private String name;
    private String sex;
    private String lesson;

    public Teacher(int id, String name, String sex, String lesson) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.lesson = lesson;
    }

    public Teacher() {
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

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }


    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", lesson='" + lesson + '\'' +
                '}';
    }
}
