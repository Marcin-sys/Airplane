import entity.Department;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DepartmentDAOTest {
    private static final Configuration configuration = new Configuration()
            .configure("hibernate-test.cfg.xml")
            .addAnnotatedClass(Department.class)
            .addAnnotatedClass(Student.class);
    private static final HibernateFactory hibernateFactory = new HibernateFactory(configuration);
    private static final Session session = hibernateFactory.sessionFactory().openSession();
    Department department = new Department();
    DepartmentDAO departmentDAO = new DepartmentDAO();
    Integer id = 1;

    @AfterAll
    public static void tearDown() {
        if (session != null) session.getSessionFactory().close();
        System.out.println("Session closed\n");
    }

    @Test
    @Order(1)
    void add() {
        department.setId(id);
        department.setName("Physic");
        department.setColor("White");

        departmentDAO.add(department, hibernateFactory);

        Assertions.assertTrue(department.getId() > 0);
    }

    @Test
    @Order(2)
    void get() {
        department.setId(id);
        session.beginTransaction();
        session.merge(department);
        session.getTransaction().commit();
        department = departmentDAO.get(hibernateFactory, id);
        Assertions.assertTrue(department.getId() > 0);
        session.close();
    }

    @Test
    @Order(3)
    void update() {
        department.setId(id);
        department.setName("UpdateTestName");
        departmentDAO.update(department, hibernateFactory, id);

        Department department1 = department;

        assertSame("UpdateTestName", department1.getName());
    }

    @Test
    @Order(4)
    void read() {
        department.setId(1);
        department.setName("ReadTestName");
        department.setColor("ReadTestColor");
        departmentDAO.update(department, hibernateFactory, id);

        String departmentInformation = departmentDAO.read(hibernateFactory, id);
        String result = "Department id = 1 ,department color = " +
                "ReadTestColor ,department name = ReadTestName";

        assertEquals(result, departmentInformation);
    }

    @Test
    @Order(5)
    void delete() {
        department.setId(id);
        department.setName("DeleteTestName");
        department.setColor("DeleteTestColor");
        departmentDAO.add(department, hibernateFactory);

        Session session = hibernateFactory.sessionFactory().openSession();
        departmentDAO.delete(hibernateFactory, id);

        Department deletedDepartment = session.find(Department.class, id);

        Assertions.assertNull(deletedDepartment);
    }

    @AfterEach
    public void deleteTestDataBase() {
        Session session = hibernateFactory.sessionFactory().openSession();
        department.setId(id);
        session.beginTransaction();
        if (department != null) {
            session.remove(department);
            session.getTransaction().commit();
        }
    }
}