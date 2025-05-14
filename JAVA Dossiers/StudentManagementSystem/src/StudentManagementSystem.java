import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class StudentManagementSystem {
    // Function to read a text file
    /**
     * Reads the input files line by line and returns an ArrayList which includes the lines.
     * @param input        Takes my arguments as String input.
     * @return             Returns ArrayList which includes the lines as String list seperated by comma.
     *                     Example: [S,101,Benno Marco,marco@uni.edu,CS]
     */
    public static ArrayList<String[]> readTxtAsObject(String input) {
        ArrayList<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(Files.newInputStream(Paths.get(input)), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); // Split the line by comma
                data.add(parts);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        return data;
    }

    public static double convertToDouble(String grade){
        double result = 0.0;

        if (grade == null){
            return 0.0;
        }
        else {
            switch(grade){
                case "A1":
                    result = 4.00;
                    break;
                case "A2":
                    result = 3.50;
                    break;
                case "B1":
                    result = 3.00;
                    break;
                case "B2":
                    result = 2.50;
                    break;
                case "C1":
                    result = 2.00;
                    break;
                case "C2":
                    result = 1.50;
                    break;
                case "D1":
                    result = 1.00;
                    break;
                case "D2":
                    result = 0.50;
                    break;
                case "F3":
                    result = 0.00;
                    break;
            }
            return result;
        }
    }

    public static void readPerson() {
        //PERSONS
        String personsTXT = "persons.txt";
        ArrayList<String[]> personsData = readTxtAsObject(personsTXT);

        for (int i = 0; i < personsData.size(); i++) {
            String[] personsInfo = personsData.get(i);

            switch (personsInfo[0]){
                case "S":
                    Student student = new Student(personsInfo[1], personsInfo[2], personsInfo[3], personsInfo[4]);
                    Person.setMapPersons(personsInfo[0] + personsInfo[1], student);
                    break;
                case "F":
                    AcademicMember academic = new AcademicMember(personsInfo[1], personsInfo[2], personsInfo[3], personsInfo[4]);
                    Person.setMapPersons(personsInfo[0] + personsInfo[1], academic);
                    break;
                default:
                    System.out.println("Unknown person");
            }
        }
    }

    public static void readDepartment() {
        //DEPARTMENTS
        String departmentsTXT = "departments.txt";
        ArrayList<String[]> departmentsData = readTxtAsObject(departmentsTXT);
        Departments department;
        String academicKey;
        AcademicMember departmentHead;
        for (int i = 0; i < departmentsData.size(); i++) {
            String[] departmentsInfo = departmentsData.get(i);
            academicKey = "F" + departmentsInfo[3];
            departmentHead = (AcademicMember) Person.getMapPersons().get(academicKey);
            department = new Departments(departmentsInfo[0], departmentsInfo[1], departmentsInfo[2], departmentHead);
            AcademicEntity.setMapAcademicEntity(departmentsInfo[1],department);
        }
    }

    public static void readProgram() {
        //PROGRAM
        String programsTXT = "programs.txt";
        ArrayList<String[]> programsData = readTxtAsObject(programsTXT);
        Program program;
        Departments department;
        for (int i = 0; i < programsData.size(); i++) {
            String[] programsInfo = programsData.get(i);
            department = (Departments) AcademicEntity.getMapAcademicEntity().get(programsInfo[3]);   //Casting
            program = new Program(programsInfo[0],programsInfo[1],programsInfo[2],department,programsInfo[4],Integer.parseInt(programsInfo[5]));
            AcademicEntity.setMapAcademicEntity(programsInfo[0],program);
        }
    }

    public static void readCourse() {
        //COURSE
        String courseTXT = "courses.txt";
        ArrayList<String[]> courseData = readTxtAsObject(courseTXT);
        Course course;
        Departments department;
        Program program;
        for (int i = 0; i < courseData.size(); i++) {
            String[] courseInfo = courseData.get(i);
            department = (Departments) AcademicEntity.getMapAcademicEntity().get(courseInfo[2]);
            program = (Program) AcademicEntity.getMapAcademicEntity().get(courseInfo[5]);
            course = new Course(courseInfo[0],courseInfo[1],department,Integer.parseInt(courseInfo[3]),courseInfo[4],program);
            program.setCourseCatalog(course);   //Kurs ait oldugu programin kurs listesine eklendi.
            AcademicEntity.setMapAcademicEntity(courseInfo[0],course);
        }
    }

    public static void readCourseAssignment() {
        //COURSE ASSIGNMENT
        String courseAssignmentTXT = "assignments.txt";
        ArrayList<String[]> courseAssignmentData = readTxtAsObject(courseAssignmentTXT);
        Course course;
        String userKey;
        Person person;
        for (int i = 0; i < courseAssignmentData.size(); i++) {
            String[] courseAssignmentInfo = courseAssignmentData.get(i);
            userKey = courseAssignmentInfo[0] + courseAssignmentInfo[1];
            person = Person.getMapPersons().get(userKey);
            course = (Course) AcademicEntity.getMapAcademicEntity().get(courseAssignmentInfo[2]);
            person.setLectures(course);

            if (person instanceof AcademicMember) {
                course.setInstructor((AcademicMember) person);
            }
            else{
                course.setStudents((Student) person);
            }
        }
    }

    public static void readGrades() {
        //GRADES
        String gradesTXT = "grades.txt";
        ArrayList<String[]> gradesData = readTxtAsObject(gradesTXT);
        String studentKey;
        Student student;
        Course course;
        for (int i = 0; i < gradesData.size(); i++) {
            String[] gradesInfo = gradesData.get(i);
            studentKey = "S" + gradesInfo[1]; //Detected student key
            student = (Student) Person.getMapPersons().get(studentKey);  //Detected student object
            course = (Course) AcademicEntity.getMapAcademicEntity().get(gradesInfo[2]);   //Detected course object
            student.setLectureGrades(course, gradesInfo[0]);
        }
    }
}