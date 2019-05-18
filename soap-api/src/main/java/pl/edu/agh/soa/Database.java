package pl.edu.agh.soa;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

@Singleton
public class Database {

    public ArrayList<Student> students;

    @PostConstruct
    public void Init()
    {
        students = new ArrayList<>();
        ArrayList<Subject> tmp = new ArrayList<>();
        tmp.add(new Subject("SOA"));
        tmp.add(new Subject("C++"));
        tmp.add(new Subject("Java"));
        students.add(new Student("Kowalski", 2, tmp));

        getStudent(2).setAvatar(loadAvatar("/home/marek/SOA/avatars/Default-avatar.jpg"));

    }

    private String loadAvatar(String sourcePath)
    {
        File file = new File(sourcePath);
        try (FileInputStream imageInFile = new FileInputStream(file)) {
            byte[] imageData = new byte[(int) file.length()];
            imageInFile.read(imageData);
            return Base64.getEncoder().encodeToString(imageData);

        } catch (Exception e) {
            return "";
        }
    }

    public ArrayList<Student> getStudents()
    {
        return students;
    }

    public Boolean containsStudent(Integer id)
    {
        return students.stream().anyMatch( s -> s.getId().equals(id));
    }

    public Boolean addStudent(String name, Integer id)
    {
        if( containsStudent(id))
            return false;
        students.add(new Student(name, id));
        return true;
    }

    public Student getStudent(Integer id)
    {
        if(!containsStudent(id))
            return null;
        return students.stream().filter(s -> s.getId().equals(id)).findFirst().get();
    }

    public Boolean removeStudent(Integer id)
    {
        if(!containsStudent(id))
            return false;
        students.removeIf(s -> s.getId().equals(id));
        return true;
    }

    public Boolean addSubject(Integer studentId, Subject subject)
    {
        if(!containsStudent(studentId))
            return false;
        Student s = getStudent(studentId);
        s.addSubject(subject);
        return true;
    }

    public Boolean removeSubject(Integer studentId, Subject subject)
    {
        if(!containsStudent(studentId))
            return false;
        Student s = getStudent(studentId);
        s.removeSubject(subject);
        return true;
    }

    public String getStudentAvatar(Integer studentId)
    {
        if(!containsStudent(studentId))
            return "";
        Student s = getStudent(studentId);
        return s.getAvatar();
    }

    public List<Student> filterBySubject(Subject subj)
    {
        return students.stream().filter(s -> s.containsSubject(subj)).collect(Collectors.toList());
    }

    public List<Student> filterByName(String name)
    {
        return students.stream().filter(s -> s.getName().equals(name)).collect(Collectors.toList());
    }

}
