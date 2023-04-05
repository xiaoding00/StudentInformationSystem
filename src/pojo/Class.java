package pojo;

public class Class {
    private String className;
    private    String information;
    private int number;

    public Class(String className, String information, int number) {
        this.className = className;
        this.information = information;
        this.number = number;
    }

    public Class() {
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    @Override
    public String toString() {
        return "Class{" +
                "className='" + className + '\'' +
                ", information='" + information + '\'' +
                ", number=" + number +
                '}';
    }
}
