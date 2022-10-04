public class StudentMember extends Member {
    private int studentId;
    private String collegeName;

    public StudentMember(String email, String name, String address,
                         String gender, float height, float startWeight, String chosenPackage, int studentId, String collegeName) {
        super(email, name, address, gender, height, startWeight, chosenPackage);
        this.studentId = studentId;
        this.collegeName = collegeName;
    }

   
    public int getStudentId() {
        return studentId;
    }

   
    public String getCollegeName() {
        return collegeName;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nStudent Member**"
                + "\nStudent ID:" + studentId
                + "\nCollege Name ID:" + collegeName;
    }
}