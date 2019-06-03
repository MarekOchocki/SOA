package pl.edu.agh.soa;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "subject")
@XmlAccessorType(XmlAccessType.FIELD)
public class Subject {
    public String name;

    public Subject() {
    }

    public Subject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString()
    {
        return name;
    }
}
