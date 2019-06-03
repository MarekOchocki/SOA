package pl.edu.agh.soa;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.FileOutputStream;
import java.util.Base64;
import java.util.List;


public class RestMain {

    private static String endpoint = "http://localhost:8080/rest-api/rest";

    private static void writeStudents()
    {
        ResteasyClient client = new ResteasyClientBuilder().build();
        System.out.println(getStudents().toString());
        System.out.println();
        client.close();
    }

    public static void main(String[] args) throws InterruptedException {

        Token token = login("admin", "admin");
        System.out.println("token: " + token.tokenstr + "\n\n");

        writeStudents();

        System.out.println("Add Student7:");
        System.out.println(addStudent(new AddStudentCommand("Student7", 7), token));
        writeStudents();

        System.out.println("update student name:");
        System.out.println(updateStudent(new UpdateStudentNameDto(7, "NowyStudent7"), token).toString());
        writeStudents();

        System.out.println("Remove Student7:");
        System.out.println(removeStudent(7, token));
        writeStudents();

        System.out.println("Add Student10:");
        System.out.println(addStudent(new AddStudentCommand("Student10", 10), token));
        writeStudents();

        System.out.println("Add subject C++ to Student10:");
        System.out.println(addSubject(new AddSubjectCommand(10, "C++"), token));
        writeStudents();

        System.out.println("Get Students with subject C++:");
        System.out.println(filterBySubject("C++").toString());
        System.out.println();

        System.out.println("Add Student Kowalski:");
        System.out.println(addStudent(new AddStudentCommand("Kowalski", 11), token));
        writeStudents();

        System.out.println("Get students with name Kowalski:");
        System.out.println(filterByName("Kowalski").toString());
        System.out.println();

        System.out.println("Try to add student with wrong token:");
        System.out.println(addStudent(new AddStudentCommand("wrongToken", 401), null));
        System.out.println(addStudent(new AddStudentCommand("wrongToken", 401), new Token("abc")));
        writeStudents();

        System.out.println("Remove subject C++ from Student10:");
        System.out.println(removeSubject(10, "C++", token));
        writeStudents();

        System.out.println("Download avatar:");
        String avatar = downloadAvatar(2);

        String destinationFilepath = "/home/marek/SOA/downloaded_avatar.jpg";
        try (FileOutputStream imageOutFile = new FileOutputStream(destinationFilepath)) {
            byte[] imageByteArray = Base64.getDecoder().decode(avatar);
            imageOutFile.write(imageByteArray);
        } catch (Exception ignored) {
        }
        System.out.println("Avatar saved to " + destinationFilepath);

        removeStudent(10, token);
        removeStudent(11, token);
    }

    private static Response sendPostRequest(ResteasyClient client, String targetPath, Object obj) {
        return sendPostRequest(client, targetPath, obj, null);
    }

    private static Response sendPostRequest(ResteasyClient client, String targetPath, Object obj, Token token)
    {
        ResteasyWebTarget target = client.target(endpoint + targetPath);
        Invocation.Builder req = target.request();
        if(token != null)
            req = req.header("Authorization", token.tokenstr);
        return req.post(Entity.entity(obj, MediaType.APPLICATION_JSON));
    }

    private static Response sendPutRequest(ResteasyClient client, String targetPath, Object obj) {
        return sendPutRequest(client, targetPath, obj, null);
    }

    private static Response sendPutRequest(ResteasyClient client, String targetPath, Object obj, Token token)
    {
        ResteasyWebTarget target = client.target(endpoint + targetPath);
        Invocation.Builder req = target.request();
        if(token != null)
            req = req.header("Authorization", token.tokenstr);
        return req.put(Entity.entity(obj, MediaType.APPLICATION_JSON));
    }

    private static Response sendGetRequest(ResteasyClient client, String targetPath)
    {
        ResteasyWebTarget target = client.target(endpoint + targetPath);
        Invocation.Builder req = target.request();
        return req.get();
    }

    private static Response sendDeleteRequest(ResteasyClient client, String targetPath, Token token)
    {
        ResteasyWebTarget target = client.target(endpoint + targetPath);
        Invocation.Builder req = target.request();
        if(token != null)
            req = req.header("Authorization", token.tokenstr);
        return req.delete();
    }


    private static Token login(String login, String password)
    {
        ResteasyClient client = new ResteasyClientBuilder().build();
        CredentialsDto credentials = new CredentialsDto(login, password);
        Response res = sendPostRequest(client, "/login", credentials);
        Token out = res.getStatus() == 200 ? new Token(res.readEntity(String.class)) : null;
        client.close();
        return out;
    }

    private static Integer addStudent(AddStudentCommand cmd, Token token)
    {
        ResteasyClient client = new ResteasyClientBuilder().build();
        Integer out = sendPostRequest(client, "/addStudent", cmd, token).getStatus();
        client.close();
        return out;
    }

    private static Student getStudent(Integer studentId)
    {
        ResteasyClient client = new ResteasyClientBuilder().build();
        Response result = sendGetRequest(client, "/getStudent/" + studentId.toString());
        Student out = result.readEntity(Student.class);
        client.close();
        return out;
    }

    private static StudentListDto getStudents()
    {
        ResteasyClient client = new ResteasyClientBuilder().build();
        Response result = sendGetRequest(client, "/getStudents");
        StudentListDto out = result.readEntity(StudentListDto.class);
        client.close();
        return out;
    }

    private static Integer removeStudent(Integer studentId, Token token)
    {
        ResteasyClient client = new ResteasyClientBuilder().build();
        Integer out = sendDeleteRequest(client, "/removeStudent/" + studentId.toString(), token).getStatus();
        client.close();
        return out;
    }

    private static Integer updateStudent(UpdateStudentNameDto dto, Token token)
    {
        ResteasyClient client = new ResteasyClientBuilder().build();
        Integer out = sendPutRequest(client, "/updateStudent", dto, token).getStatus();
        client.close();
        return out;
    }

    private static Integer addSubject(AddSubjectCommand cmd, Token token)
    {
        ResteasyClient client = new ResteasyClientBuilder().build();
        Integer out = sendPostRequest(client, "/addSubject", cmd, token).getStatus();
        client.close();
        return out;
    }

    private static Integer removeSubject(Integer studentId, String subjectName, Token token)
    {
        ResteasyClient client = new ResteasyClientBuilder().build();
        Integer out = sendDeleteRequest(client, "/removeSubject/" + studentId.toString() + "/" + subjectName, token).getStatus();
        client.close();
        return out;
    }

    private static StudentListDto filterBySubject(String subjectName)
    {
        ResteasyClient client = new ResteasyClientBuilder().build();
        Response result = sendGetRequest(client, "/filterBySubject/" + subjectName);
        StudentListDto out = result.readEntity(StudentListDto.class);
        client.close();
        return out;
    }

    private static StudentListDto filterByName(String studentName)
    {
        ResteasyClient client = new ResteasyClientBuilder().build();
        Response result = sendGetRequest(client, "/filterByName/" + studentName);
        StudentListDto out = result.readEntity(StudentListDto.class);
        client.close();
        return out;
    }

    public static String downloadAvatar(Integer studentId)
    {
        ResteasyClient client = new ResteasyClientBuilder().build();
        Response result = sendGetRequest(client, "/downloadAvatar/" + studentId.toString());
        String out;
        if(result.getStatus() == 200)
            out = result.readEntity(String.class);
        else
            out = null;
        client.close();
        return out;
    }
}
