import entity.Department;
import entity.Student;

public class App {
    public static void main(String[] args) {
        AirplanesDAO airplanesDAO = new AirplanesDAO();
        Department department = new Department();
        Student student = new Student();

        department.setId(15);
        department.setColor("green");
        department.setName("Jumbojet");

        student.setId(10);
        student.setName("Popolupo");
        student.setSkin("white");

        airplanesDAO.add(department,student);
    }
}
