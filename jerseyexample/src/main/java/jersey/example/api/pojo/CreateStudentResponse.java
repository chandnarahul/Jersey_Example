package jersey.example.api.pojo;

/**
 * Created by rahulc on 3/30/16.
 */
public class CreateStudentResponse {
    private String key;
    private StudentDetails studentDetails;

    public CreateStudentResponse(String key, StudentDetails studentDetails) {
        this.key = key;
        this.studentDetails = studentDetails;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public StudentDetails getStudentDetails() {
        return studentDetails;
    }

    public void setStudentDetails(StudentDetails studentDetails) {
        this.studentDetails = studentDetails;
    }
}
