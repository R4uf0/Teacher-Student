package OOP_TS;

public class TeacherStudent {
    private long ID;
    private Teacher teacher;
    private Student student;
    private String subject;
    private String classNumber;

    public TeacherStudent(Teacher teacher, Student student, String subject, String classNumber) {
        this.ID = Database.teacherStudentIndex;
        this.teacher = teacher;
        this.student = student;
        this.subject = subject;
        this.classNumber = classNumber;
    }

    public long getID() {

        return ID;
    }

    public void setID(long ID) {

        this.ID = ID;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }
}

