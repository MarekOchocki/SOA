package pl.edu.agh.soa;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlType(name = "student")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
    public String name;
    public Integer id;
    @XmlElementWrapper
    @XmlElement(name = "subList")
    public ArrayList<Subject> subList;
    public String avatar;

    public Student(){
    }

    public Student(String name, Integer id)
    {
        this.name = name;
        this.id = id;
        this.subList = new ArrayList<>();
    }

    public Student(String name, Integer id, ArrayList<Subject> subList) {
        this.name = name;
        this.id = id;
        this.subList = subList;
    }

    public Boolean containsSubject(String subjName)
    {
        return subList.stream().anyMatch( s -> s.name.equals(subjName));
    }

    public void addSubject(Subject subj)
    {
        subList.add(subj);
    }

    public void removeSubject(Subject subj)
    {
        subList.remove(subj);
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<Subject> getSubList() {
        return subList;
    }

    public void setSubList(ArrayList<Subject> subList) {
        this.subList = subList;
    }

    public String toString()
    {
        String out = id.toString() + ": " + name + " (";
        for(int i = 0; i < subList.size(); i++)
        {
            if(i != 0)
                out += ", ";
            out += subList.get(i).toString();
        }
        out += ")";
        return out;
    }
}
