import entity.Department;
import org.hibernate.Session;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DepartmentDAOTest {
    HibernateFactory hibernateFactory = new HibernateFactory();
    private final Session session = hibernateFactory.sessionFactory().openSession();
    Department department = new Department();
    DepartmentDAO departmentDAO = new DepartmentDAO();

    @Test
    @Order(1)
    void add() {

        department.setId(1);
        department.setName("Physic");
        department.setColor("White");

        departmentDAO.add(department);

        Assertions.assertTrue(department.getId() > 0);
    }

    @Test
    @Order(2)
    void get() {

        department = departmentDAO.get(1);
        Assertions.assertTrue(department.getId() > 0);
    }

    @Test
    @Order(3)
    void update() {

        department.setName("UpdateTestName");
        Integer id = 1;
        department.setId(id);
        departmentDAO.update(department, id);

        Department department1 = department;

        assertSame("UpdateTestName", department1.getName());
    }

    @Test
    @Order(4)
    void read() {
        Integer id = 1;
        department.setId(1);
        department.setName("ReadTestName");
        department.setColor("ReadTestColor");
        departmentDAO.update(department,id);

        String departmentInformation = departmentDAO.read(id);
        String result = "Department id = 1 ,department color = " +
                "ReadTestColor ,department name = ReadTestName";

        assertEquals(result,departmentInformation);
    }


    @Test
    @Order(5)
    void delete() {

        Integer id = 1;
        departmentDAO.delete(id);
        Department deletedDepartment = session.find(Department.class, 1);
        Assertions.assertNull(deletedDepartment);
    }
}