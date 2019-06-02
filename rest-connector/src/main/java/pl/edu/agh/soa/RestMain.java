package pl.edu.agh.soa;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.ws.rs.*;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


public class RestMain {

    private static String endpoint = "http://localhost:8080/rest-api/rest";

    public static void main(String[] args)
    {
        CredentialsDto credentials = new CredentialsDto();
        credentials.login = "admin";
        credentials.password = "admin";

        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(endpoint + "/login");
        Response res = target.request().post(Entity.entity(credentials, MediaType.APPLICATION_JSON));
        String token = res.readEntity(String.class);
        System.out.println(token);
    }
/*
    private static Response sendRequest(String path, Object obj, String token)
    {
        Client client = ClientBuilder.newBuilder().build();
        WebTarget wb = client.target(endpoint);
        Invocation.Builder out = wb.path(path).request();
        if(token != null)
            out.header("Authorization", token);
        return out;
    }
    
    public static Response login(CredentialsDto credentials)
    {
        Client client = ClientBuilder.newBuilder().build();
        WebTarget wb = client.target(endpoint);
        Invocation.Builder out = wb.path("/login").request();
        Invocation.Builder req = getRequestBuilder(client, "/login");
        return req.post(Entity.entity(credentials, MediaType.APPLICATION_JSON));
    }

    public Response addStudent(AddStudentCommand cmd)
    {
        if(db.addStudent(cmd.name, cmd.studentId))
            return Response.status(Response.Status.OK).build();
        return Response.status(Response.Status.CONFLICT).entity("Student with id " + cmd.studentId.toString() + " does already exist.").build();
    }

    public Student getStudent(IntegerDto studentId)
    {
        return db.getStudent(studentId.content);
    }

    public List<Student> getStudents(IntegerDto studentId)
    {
        return db.getStudents();
    }

    public Response removeStudent(IntegerDto studentId)
    {
        if(db.removeStudent(studentId.content))
            return Response.status(Response.Status.OK).build();
        return Response.status(Response.Status.CONFLICT).entity("Student with id " + studentId.toString() + " does not exist.").build();
    }

    public Response updateStudent(UpdateStudentNameDto dto)
    {
        if(db.updateName(dto.id, dto.new_name))
            return Response.status(Response.Status.OK).build();
        return Response.status(Response.Status.CONFLICT).entity("Student with id " + dto.toString() + " does not exist.").build();
    }

    public Response addSubject(AddSubjectCommand cmd)
    {
        if(db.addSubject(cmd.studentId, new Subject(cmd.subjectName)))
            return Response.status(Response.Status.CREATED).build();
        return Response.status(Response.Status.CONFLICT).entity("Student with id " + cmd.studentId.toString() + " does not exist").build();
    }

    public Response removeSubject(RemoveSubjectCommand cmd)
    {
        if(db.removeSubject(cmd.studentId, new Subject(cmd.subjectName)))
            return Response.status(Response.Status.OK).build();
        return Response.status(Response.Status.CONFLICT).entity("Student with id " + cmd.studentId.toString() + " does not exist").build();
    }

    public List<Student> filterBySubject(StringDto subjectName)
    {
        return db.filterBySubject(subjectName.content);
    }

    public StudentListDto filterByName(StringDto studentName)
    {
        List<Student> db_res = db.filterByName(studentName.content);

        StudentListDto result = new StudentListDto();
        result.studentList = db_res;
        result.isOk = db_res != null;

        return result;
    }

    @GET
    @Path("/downloadAvatar")
    @Produces({MediaType.APPLICATION_JSON})
    public String downloadAvatar(IntegerDto studentId) {
        String avatar = db.getStudentAvatar(studentId.content);

        return avatar == null ? "" : avatar;
    }*/
}
