package pl.edu.agh.soa;

import java.util.List;

public class StudentListDto {
    public boolean isOk;
    public List<Student> studentList;

    public StudentListDto() {
    }

    public boolean isOk() {
        return isOk;
    }

    public void setOk(boolean ok) {
        isOk = ok;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public String toString()
    {
        StringBuilder out = new StringBuilder("Students: ");
        for(Student s : studentList)
        {
            out.append("\n").append(s.toString());
        }
        return out.toString();
    }
}
