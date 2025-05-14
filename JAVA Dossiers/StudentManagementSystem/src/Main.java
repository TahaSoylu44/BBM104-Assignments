public class Main {
    public static void main(String[] args) {
        StudentManagementSystem.readPerson();
        StudentManagementSystem.readDepartment();
        StudentManagementSystem.readProgram();
        StudentManagementSystem.readCourse();
        StudentManagementSystem.readCourseAssignment();
        StudentManagementSystem.readGrades();


        Program program = (Program) AcademicEntity.getMapAcademicEntity().get("BBM");
        for (Course course : program.getCourseCatalog()) {
            System.out.println(course.getCode());
        }
    }
}