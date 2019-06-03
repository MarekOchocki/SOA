package pl.edu.agh.soa;

public class AddSubjectCommand {
    public Integer studentId;
    public String subjectName;

    public AddSubjectCommand() {
    }

    public AddSubjectCommand(Integer studentId, String subjectName) {
        this.studentId = studentId;
        this.subjectName = subjectName;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
