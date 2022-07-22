import entity.Department;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentDAOTest {

    Department department = new Department();
    DepartmentDAO departmentDAO = new DepartmentDAO();

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
        department = departmentDAO.get(1);
        Assertions.assertTrue(department.getId()>0);
    }

    @Test
    void update() {

        department.setName("UpdateTestName");
        Integer id = 1;
        department.setId(id);
        departmentDAO.update(department,id);

        Department department1 = department;

        assertSame("UpdateTestName", department1.getName());
    }

    @Test
    void delete() {

        department.setId(1);



    }

    @Test
    void read() {
    }
}