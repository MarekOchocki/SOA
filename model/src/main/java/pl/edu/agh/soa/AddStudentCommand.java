package pl.edu.agh.soa;

public class AddStudentCommand {
    public String name;
    public Integer studentId;

    public AddStudentCommand() {
    }

    public AddStudentCommand(String name, Integer studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}
