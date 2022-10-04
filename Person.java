public class Person {
    private String name;
    private String email;
    private String address;
    private String gender;

    
    public Person(String email, String name, String address, String gender) {
        setName(name);
        this.email = email;
        this.address = address;
        setGender(gender);
    }

   
    public String getName() {
        return name;
    }

    
    public String getEmail() {
        return email;
    }

   
    public String getAddress() {
        return address;
    }

   
    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        try {
            this.name = name;
            if (name.length() >= 1 && name.length() <= 30) {
                this.name = name;
            } else if (name.length() > 30) {
                this.name = name.substring(0, 30);
            } else {
                System.out.println("Invalid name entered");
            }
        } catch (Exception e) {
            System.out.println("Issue with name");
        }
    }


   
    public void setAddress(String address) {
        this.address = address;
    }

   
    public void setGender(String gender) {
        this.gender = gender;
        switch (this.gender) {
            case "M":
            case "m":
                this.gender = "M";
                break;
            case "F":
            case "f":
                this.gender = "F";
                break;
            default:
                this.gender = "Unspecified";
        }
    }

   
    public String toString() {
        return "\nName: " + name
                + "\nEmail:" + email
                + "\nAddress:" + address
                + "\nGender:" + gender;
    }
}
