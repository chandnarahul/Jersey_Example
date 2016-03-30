package test.jersey.example.api;

import jersey.example.api.Student;
import jersey.example.api.pojo.StudentDetails;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertTrue;

/**
 * Created by rahulc on 3/30/16.
 */
public class StudentTest extends JerseyTest {
    private static final String AUTHENTICATION_KEY = "test_key_123456";
    private static final String TEST_STUDENT = "TEST_STUDENT";
    private static final int ROLL_NUMBER = 123456;

    @Override
    public Application configure() {
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);
        return new ResourceConfig(Student.class);
    }

    @Test
    public void should_receive_queryParam_and_authenticationKey_back_from_get_call() {
        String test_xyz_param = "test_xyz_param";
        String response = target("student")
                .queryParam("xyz", test_xyz_param)
                .request()
                .header("Authentication_Key", AUTHENTICATION_KEY)
                .get(String.class);

        assertTrue(response.contains(test_xyz_param));
        assertTrue(response.contains(AUTHENTICATION_KEY));
    }

    @Test
    public void should_receive_studentResponse_back_from_post_call() {

        StudentDetails studentDetails = new StudentDetails();
        studentDetails.setName(TEST_STUDENT);
        studentDetails.setRollNumber(ROLL_NUMBER);
        Entity<StudentDetails> studentDetailsEntity = Entity.entity(studentDetails, MediaType.APPLICATION_JSON_TYPE);
        Response response = target("student")
                .request()
                .header("Authentication_Key", AUTHENTICATION_KEY)
                .post(studentDetailsEntity);

        String postResponse = response.readEntity(String.class);

        assertTrue(postResponse.contains(TEST_STUDENT));
        assertTrue(postResponse.contains(Integer.toString(ROLL_NUMBER)));
        assertTrue(postResponse.contains(AUTHENTICATION_KEY));
    }

    @Test
    public void should_receive_studentResponse_back_from_put_call() {
        StudentDetails studentDetails = new StudentDetails();
        studentDetails.setName(TEST_STUDENT);
        studentDetails.setRollNumber(ROLL_NUMBER);
        Entity<StudentDetails> studentDetailsEntity = Entity.entity(studentDetails, MediaType.APPLICATION_JSON_TYPE);
        Response response = target("student")
                .request()
                .put(studentDetailsEntity);

        String postResponse = response.readEntity(String.class);

        assertTrue(postResponse.contains(TEST_STUDENT));
        assertTrue(postResponse.contains(Integer.toString(ROLL_NUMBER)));
    }
}
