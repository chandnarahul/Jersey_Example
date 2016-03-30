package jersey.example.api;

import jersey.example.api.pojo.CreateStudentResponse;
import jersey.example.api.pojo.StudentDetails;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by rahulc on 3/30/16.
 */
@Path("student")
public class Student {
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public CreateStudentResponse post(@HeaderParam("Authentication_Key") String authenticationKey, StudentDetails studentDetails) {
        return new CreateStudentResponse(authenticationKey, studentDetails);
    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response put(StudentDetails studentDetails) {
        return Response.status(Response.Status.OK).entity(studentDetails).build();
    }

    @GET
    public String get(@HeaderParam("Authentication_Key") String authenticationKey, @QueryParam("xyz") String xyz) {
        return "#get!! you set the auth key " + authenticationKey + " and passed query param xyz " + xyz;
    }
}
