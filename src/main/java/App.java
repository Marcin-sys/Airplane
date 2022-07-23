import entity.Department;
import entity.Student;


public class App {
    public static void main(String[] args) {
        HibernateFactory hibernateFactory = new HibernateFactory();
        DepartmentDAO departmentDAO = new DepartmentDAO();
        StudentDAO studentDAO = new StudentDAO();
        Department department = new Department();
        Student student = new Student();

        department.setColor("green");
        department.setName("Jumbojet");

        student.setName("Popolupo");
        student.setSkin("white");
        student.setDepartment(department);

        departmentDAO.add(department,hibernateFactory);
        studentDAO.add(student);

        department.setName("updated student");
        department.setColor("black");

        studentDAO.update(student);
        departmentDAO.update(department,3);

        departmentDAO.read(1);
        studentDAO.read(20);
    }
}
