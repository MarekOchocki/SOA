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
    @Path("/getStudent")
    @Produces({MediaType.APPLICATION_JSON})
    public Student getStudent(IntegerDto studentId)
    {
        return db.getStudent(studentId.content);
    }

    @GET
    @Path("/getStudents")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Student> getStudents(IntegerDto studentId)
    {
        return db.getStudents();
    }

    @DELETE
    @Path("/removeStudent")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response removeStudent(IntegerDto studentId)
    {
        if(db.removeStudent(studentId.content))
            return Response.status(Response.Status.OK).build();
        return Response.status(Response.Status.CONFLICT).entity("Student with id " + studentId.toString() + " does not exist.").build();
    }

    @PUT
    @Path("/updateStudent")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updateStudent(UpdateStudentNameDto dto)
    {
        if(db.updateName(dto.id, dto.new_name))
            return Response.status(Response.Status.OK).build();
        return Response.status(Response.Status.CONFLICT).entity("Student with id " + dto.toString() + " does not exist.").build();
    }

    @POST
    @Path("/addSubject")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response addSubject(AddSubjectCommand cmd)
    {
        if(db.addSubject(cmd.studentId, new Subject(cmd.subjectName)))
            return Response.status(Response.Status.CREATED).build();
        return Response.status(Response.Status.CONFLICT).entity("Student with id " + cmd.studentId.toString() + " does not exist").build();
    }

    @DELETE
    @Path("/removeSubject")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response removeSubject(RemoveSubjectCommand cmd)
    {
        if(db.removeSubject(cmd.studentId, new Subject(cmd.subjectName)))
            return Response.status(Response.Status.OK).build();
        return Response.status(Response.Status.CONFLICT).entity("Student with id " + cmd.studentId.toString() + " does not exist").build();
    }

    @GET
    @Path("/filterBySubject")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Student> filterBySubject(StringDto subjectName)
    {
        return db.filterBySubject(subjectName.content);
    }

    @GET
    @Path("/filterByName")
    @Produces({MediaType.APPLICATION_JSON})
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
    }
}