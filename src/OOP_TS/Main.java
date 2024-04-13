package OOP_TS;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int option = getOption();
            switch (option) {
                case 1:
                    addTeacher();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    addTeacherStudentConnection();
                    break;
                case 4:
                    System.out.println("---------------------------");
                    Database.printTeacher();
                    break;
                case 5:
                    System.out.println("---------------------------");
                    Database.printStudent();
                    break;
                case 6:
                    printStudentsWithTeachers();
                    break;
                case 7:
                    printTeachersWithStudents();
                    break;
                case 8:
                    System.exit(0);
            }
        }
    }

    public static void printMenu() {
        String menu = "1) Yeni müəllim yaratmaq\n" +
                "2) Yeni şagird yaratmaq\n" +
                "3) Yeni teacher-student əlaqəsi yaratmaq.\n" +
                "4) Mövcud müəllimləri görmək \n" +
                "5) Mövcud şagirdləri görmək\n" +
                "6) Bir müəllimin dərs veridiyi şagirdləri görmək\n" +
                "7) Bir şagirdin aldığı dərsləri görmək\n" +
                "8) Sistemdən çıxış\n";
        System.out.println(menu);
    }

    public static int getOption() {
        while (true) {
            try {
                System.out.print("Enter option: ");
                return scanner.nextInt();
            } catch (Exception e) {
                System.err.println("Invalid input. Please enter a valid option.");
                scanner.nextLine();
            }
        }
    }

    public static void addTeacher() {
        System.out.print("Name : ");
        String teacherName = scanner.next();
        System.out.print("Surname : ");
        String teacherSurname = scanner.next();
        System.out.print("Birth-Date : ");
        String teacherDate = scanner.next();
        System.out.print("E-mail : ");
        String teacherEmail = scanner.next();

        Teacher teacher = new Teacher(teacherName, teacherSurname, teacherDate, teacherEmail);
        Database.addTeacher(teacher);
    }

    public static void addStudent() {
        System.out.print("Name : ");
        String studentName = scanner.next();
        System.out.print("Surname : ");
        String studentSurname = scanner.next();
        System.out.print("Birth-Date : ");
        String studentDate = scanner.next();
        System.out.print("E-mail : ");
        String studentEmail = scanner.next();

        Student student = new Student(studentName, studentSurname, studentDate, studentEmail);
        Database.addStudent(student);
    }

    public static void addTeacherStudentConnection() {
        System.out.print("Teacher ID : ");
        long teacherID = scanner.nextLong();
        System.out.print("Student ID : ");
        long studentID = scanner.nextLong();
        System.out.print("Subject : ");
        String subject = scanner.next();
        System.out.print("Class Number : ");
        String classNumber = scanner.next();

        // Find teacher and student by ID
        Teacher teacher = findTeacherByID(teacherID);
        Student student = findStudentByID(studentID);

        if (teacher != null && student != null) {
            TeacherStudent teacherStudent = new TeacherStudent(teacher, student, subject, classNumber);
            Database.addTeacherStudentConnection(teacherStudent);
        } else {
            System.out.println("Teacher or student not found!");
        }
    }

    private static Teacher findTeacherByID(long teacherID) {
        for (Teacher teacher : Database.teachers) {
            if (teacher != null && teacher.getID() == teacherID) {
                return teacher;
            }
        }
        return null;
    }

    private static Student findStudentByID(long studentID) {
        for (Student student : Database.students) {
            if (student != null && student.getID() == studentID) {
                return student;
            }
        }
        return null;
    }

    private static void printStudentsWithTeachers() {
        System.out.print("Teacher's ID : ");
        long id = scanner.nextLong();
        for (TeacherStudent teacherStudent : Database.teacherStudents) {
            if (teacherStudent != null && teacherStudent.getTeacher().getID() == id) {
                System.out.println("Student: " + teacherStudent.getStudent().getName() + " " +
                        teacherStudent.getStudent().getSurname());
            }
        }
    }

    private static void printTeachersWithStudents() {
        System.out.print("Student's ID : ");
        long id = scanner.nextLong();
        for (TeacherStudent teacherStudent : Database.teacherStudents) {
            if (teacherStudent != null && teacherStudent.getStudent().getID() == id) {
                System.out.println("Teacher: " + teacherStudent.getTeacher().getName() + " " +
                        teacherStudent.getTeacher().getSurname());
            }
        }
    }
}