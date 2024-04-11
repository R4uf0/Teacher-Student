package OOP_TS;

public class Student {
    private long ID;
    private String name;
    private String surname;
    private String birthdate;
    private String email;

    public Student(String name, String surname, String birthdate, String email) {
        this.ID = Database.studentIndex;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.email = email;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
