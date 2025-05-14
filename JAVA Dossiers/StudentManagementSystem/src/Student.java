import java.util.HashMap;

public class Student extends Person {
    //VARIABLES
    private HashMap<Course, String> lectureGrades = new HashMap<>();

    Student(String ID, String name, String email, String department) {
        super(ID, name, email, department);
    }

    //GETTERS
    public HashMap<Course, String> getLectureGrades() {return lectureGrades;}

    //SETTERS
    public void setLectureGrades(Course course, String grade) {lectureGrades.put(course, grade);}

    public static double gpa(Student student){
        double result = 0.0;
        int topCredit = 0;
        String courseGrade;
        int courseCredit;

        for (Course course : student.getLectures()){
            courseGrade = student.getLectureGrades().get(course);
            courseCredit = course.getCredit();
            if (courseGrade != null){
                result = result + StudentManagementSystem.convertToDouble(courseGrade) * courseCredit;
                topCredit += courseCredit;
            }
        }
        return result / topCredit;
    }
}
