package pl.edu.agh.soa;

import org.jboss.annotation.security.SecurityDomain;
import org.jboss.ws.api.annotation.WebContext;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.xml.bind.annotation.XmlElement;
import java.io.FileOutputStream;
import java.util.Base64;
import java.util.List;

@Stateless
@WebService
@DeclareRoles({"developer", "admin"})
@WebContext(authMethod = "BASIC", transportGuarantee = "NONE")
@SecurityDomain("marek")
public class MainSoapService {

    @Inject
    private Database db;

    @WebMethod
    @WebResult(name = "isOk")
    @RolesAllowed({"developer"})
    public Boolean addStudent(@WebParam(name = "name") @XmlElement(required = true) String name,
                              @WebParam(name = "studentId") @XmlElement(required = true) Integer studentId)
    {
        return db.addStudent(name, studentId);
    }

    @WebMethod
    @WebResult(name = "student")
    @PermitAll
    public Student getStudent(@WebParam(name = "studentId") @XmlElement(required = true) Integer studentId)
    {
        return db.getStudent(studentId);
    }

    @WebMethod
    @WebResult(name = "isOk")
    @PermitAll
    public Boolean removeStudent(@WebParam(name = "studentId") @XmlElement(required = true) Integer studentId)
    {
        return db.removeStudent(studentId);
    }

    @WebMethod
    @WebResult(name = "isOk")
    @PermitAll
    public Boolean addSubject(@WebParam(name = "studentId") @XmlElement(required = true) Integer studentId,
                              @WebParam(name = "subject") @XmlElement(required = true) String subjectName)
    {
        return db.addSubject(studentId, new Subject(subjectName));
    }

    @WebMethod
    @WebResult(name = "isOk")
    @PermitAll
    public Boolean removeSubject(@WebParam(name = "studentId") @XmlElement(required = true) Integer studentId,
                                 @WebParam(name = "subject") @XmlElement(required = true) String subjectName)
    {
        return db.removeSubject(studentId, new Subject(subjectName));
    }

    @WebMethod
    @WebResult(name = "students")
    @PermitAll
    public List<Student> filterBySubject(@WebParam(name = "subject") @XmlElement(required = true) String subjectName)
    {
        return db.filterBySubject(new Subject(subjectName));
    }

    @WebMethod
    @WebResult(name = "students")
    @PermitAll
    public List<Student> filterByName(@WebParam(name = "studentName") @XmlElement(required = true) String studentName)
    {
        return db.filterByName(studentName);
    }

    @WebMethod
    @WebResult(name = "avatarBase64")
    @PermitAll
    public String downloadAvatar(@WebParam(name = "studentId") @XmlElement(required = true) Integer studentId) {
        if (!db.containsStudent(studentId))
            return "Could not find student in database";

        String base64Image = db.getStudentAvatar(studentId);

        String destinationFilepath = "/home/marek/SOA/avatars" + studentId.toString() + ".jpg";
        try (FileOutputStream imageOutFile = new FileOutputStream(destinationFilepath)) {
            byte[] imageByteArray = Base64.getDecoder().decode(base64Image);
            imageOutFile.write(imageByteArray);
        } catch (Exception e) {
            return "";
        }

        return base64Image;
    }

}
