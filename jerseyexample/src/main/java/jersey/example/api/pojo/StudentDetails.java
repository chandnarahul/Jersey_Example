package jersey.example.api.pojo;

/**
 * Created by rahulc on 3/30/16.
 */
public class StudentDetails {
    private String name;
    private int rollNumber;

    public StudentDetails(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }
}
