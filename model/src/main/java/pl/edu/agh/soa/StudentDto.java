package pl.edu.agh.soa;

public class StudentDto {
    public boolean isOk;
    public Student student;

    public StudentDto() {
    }

    public boolean isOk() {
        return isOk;
    }

    public void setOk(boolean ok) {
        isOk = ok;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
