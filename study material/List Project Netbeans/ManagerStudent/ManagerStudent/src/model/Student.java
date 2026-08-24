package model;

/**
 *
 * @author WithTrung
 */
// model: lưu trữ thông tin sinh viên (thuộc tính, constructor, getter/setter)
public class Student {

    private static int idCounter = 1; // biến static dùng để tự tăng ID
    private int id;
    private String name;
    private String semester;
    private String courseName;

    // constructor rỗng
    public Student() {
    }

    // constructor có tham số
    public Student(String name, String semester, String courseName) {
        this.id = idCounter++; //gán idCount rồi tăng lên 1
        this.name = name;
        this.semester = semester;
        this.courseName = courseName;
    }

    // getter và setter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSemester() {
        return semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
