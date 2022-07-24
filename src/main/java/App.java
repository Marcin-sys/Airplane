import entity.Department;
import entity.Student;


public class App {
    public static void main(String[] args) {
        HibernateFactory hibernateFactory = new HibernateFactory();
        System.out.println("1");
        System.out.println("1");
        DepartmentDAO departmentDAO = new DepartmentDAO();
        System.out.println("1");
        StudentDAO studentDAO = new StudentDAO();
        Department department = new Department();
        Student student = new Student();

        System.out.println("1");
        department.setColor("green");
        department.setName("Jumbojet");

        student.setId(1);
        student.setName("Popolupo");
        student.setSkin("white");
        student.setDepartment(department);

        departmentDAO.add(department, hibernateFactory);
        studentDAO.add(student, hibernateFactory);

        department.setName("updated student");
        department.setColor("black");

        studentDAO.update(student, hibernateFactory,1);
        departmentDAO.update(department, hibernateFactory, 3);

        departmentDAO.read(hibernateFactory, 1);
        studentDAO.read(hibernateFactory,1);
    }
}
