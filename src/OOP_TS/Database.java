package OOP_TS;

public class Database {
    public static TeacherStudent[] teacherStudents = new TeacherStudent[100];
    static Teacher[] teachers = new Teacher[100];
    static Student[] students = new Student[100];

    public static int teacherIndex = 1;
    public static int studentIndex = 1;
    public static int teacherStudentIndex = 1;

    public static void addTeacherStudentConnection(TeacherStudent teacherStudent) {
        teacherStudents[teacherStudentIndex++] = teacherStudent;
    }

    public static void addTeacher(Teacher teacher) {
        teachers[teacherIndex++] = teacher;
    }

    public static void addStudent(Student student) {
        students[studentIndex++] = student;
    }

    public static void printConnection() {
        for (TeacherStudent teacherStudent : teacherStudents) {
            if (teacherStudent != null) {
                System.out.println();
            }
        }
    }
    public static void printTeacher() {
        for (Teacher teacher : teachers) {
            if (teacher != null) {
                System.out.println(teacher.getID()+" "+ teacher.getName() + " " + teacher.getSurname());
                System.out.println("---------------------------");
            }
        }
    }

    public static void printStudent() {
        for (Student student : students) {
            if (student != null) {
                System.out.println(student.getID()+ " "+ student.getName() + " " + student.getSurname());
                System.out.println("---------------------------");
            }
        }
    }


}