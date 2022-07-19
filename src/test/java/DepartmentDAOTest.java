import entity.Department;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentDAOTest {

    private DepartmentDAO departmentDAO;
    private Department department;

    @Test
    void add() {

        department.setId(1);
        department.setName("Physic");
        department.setColor("White");

        departmentDAO.add(department);

        Assertions.assertTrue(department.getId()>0);
    }

    @Test
    void get(){
        DepartmentDAO departmentDAO = new DepartmentDAO();
        Department department = departmentDAO.get(1);
        Assertions.assertTrue(department.getId()>0);
        System.out.println("imie"+ department.getName());
    }

    @Test
    void update() {
        DepartmentDAO departmentDAO = new DepartmentDAO();
        Department department = new Department();

        department.setName("UpdateTestName");
        Integer id = 1;
        department.setId(id);
        departmentDAO.update(department,id);

        Department department1 = department;


        assertSame("UpdateTestName", department1.getName());
    }

    @Test
    void delete() {
        DepartmentDAO departmentDAO = new DepartmentDAO();
        Department department = new Department();

        department.setId(1);



    }

    @Test
    void read() {
    }
}