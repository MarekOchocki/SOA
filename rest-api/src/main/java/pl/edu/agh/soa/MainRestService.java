package pl.edu.agh.soa;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("rest")

public class MainRestService {

    @Context
    UriInfo uriInfo;

    @Inject
    private Database db;

    @POST
    @Path("/login")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response login(CredentialsDto credentials)
    {
        if(credentials.login.equals("admin") && credentials.password.equals("admin"))
        {
            return Response.ok(TokenGenerator.generateToken(credentials.login)).build();
        }
        return Response.status(Response.Status.CONFLICT).entity("Login or password is not correct.").build();
    }

    @Authenticate
    @POST
    @Path("/addStudent")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response addStudent(AddStudentCommand cmd)
    {
        if(db.addStudent(cmd.name, cmd.studentId))
            return Response.status(Response.Status.OK).build();
        return Response.status(Response.Status.CONFLICT).entity("Student with id " + cmd.studentId.toString() + " does already exist.").build();
    }


    @GET
    @Path("/getStudent/{studentId}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Student getStudent(@PathParam("studentId") Integer studentId)
    {
        return db.getStudent(studentId);
    }

    @GET
    @Path("/getStudents")
    @Produces({MediaType.APPLICATION_JSON})
    public StudentListDto getStudents()
    {
        List<Student> db_res = db.getStudents();

        StudentListDto result = new StudentListDto();
        result.studentList = db_res;
        result.isOk = db_res != null;

        return result;
    }

    @Authenticate
    @DELETE
    @Path("/removeStudent/{studentId}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response removeStudent(@PathParam("studentId") Integer studentId)
    {
        if(db.removeStudent(studentId))
            return Response.status(Response.Status.OK).build();
        return Response.status(Response.Status.CONFLICT).entity("Student with id " + studentId.toString() + " does not exist.").build();
    }

    @Authenticate
    @PUT
    @Path("/updateStudent")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updateStudent(UpdateStudentNameDto dto)
    {
        if(db.updateName(dto.id, dto.new_name))
            return Response.status(Response.Status.OK).build();
        return Response.status(Response.Status.CONFLICT).entity("Student with id " + dto.toString() + " does not exist.").build();
    }

    @Authenticate
    @POST
    @Path("/addSubject")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response addSubject(AddSubjectCommand cmd)
    {
        if(db.addSubject(cmd.studentId, new Subject(cmd.subjectName)))
            return Response.status(Response.Status.CREATED).build();
        return Response.status(Response.Status.CONFLICT).entity("Student with id " + cmd.studentId.toString() + " does not exist").build();
    }

    @Authenticate
    @DELETE
    @Path("/removeSubject/{studentId}/{subjectName}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response removeSubject(@PathParam("studentId") Integer studentId, @PathParam("subjectName") String subjectName)
    {
        if(db.removeSubject(studentId, new Subject(subjectName)))
            return Response.status(Response.Status.OK).build();
        return Response.status(Response.Status.CONFLICT).entity("Student with id " + studentId.toString() + " does not exist").build();
    }

    @GET
    @Path("/filterBySubject/{subjectName}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public StudentListDto filterBySubject(@PathParam("subjectName") String subjectName)
    {
        List<Student> db_res = db.filterBySubject(subjectName);

        StudentListDto result = new StudentListDto();
        result.studentList = db_res;
        result.isOk = db_res != null;

        return result;
    }

    @GET
    @Path("/filterByName/{studentName}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public StudentListDto filterByName(@PathParam("studentName") String studentName)
    {
        List<Student> db_res = db.filterByName(studentName);

        StudentListDto result = new StudentListDto();
        result.studentList = db_res;
        result.isOk = db_res != null;

        return result;
    }

    @GET
    @Path("/downloadAvatar/{studentId}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public String downloadAvatar(@PathParam("studentId") Integer  studentId) {
        String avatar = db.getStudentAvatar(studentId);

        return avatar == null ? "" : avatar;
    }
}