import entity.Department;
import entity.Student;

public class App {
    public static void main(String[] args) {
        DepartmentDAO departmentDAO = new DepartmentDAO();
        StudentDAO studentDAO = new StudentDAO();
        Department department = new Department();
        Student student = new Student();

        department.setColor("green");
        department.setName("Jumbojet");

        student.setId(10);
        student.setName("Popolupo");
        student.setSkin("white");
        student.setDepartment(department);

        departmentDAO.add(department);
        studentDAO.add(student);

        student.setId(1);
        student.setName("updated student");
        student.setSkin("black");

        studentDAO.update(student);

        departmentDAO.read(1);
        studentDAO.read(20);
    }
}
