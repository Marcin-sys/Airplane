import entity.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class HibernateFactoryTest {

    @Test
    void sessionFactory() {
    }

    private static SessionFactory sessionFactory;
    private Session session;

    @BeforeAll
    public static void setup() {
        HibernateFactory factory = new HibernateFactory();
        sessionFactory = factory.sessionFactory();
        System.out.println("SessionFactory created");
    }

    @AfterAll
    public static void tearDown() {
        if (sessionFactory != null) sessionFactory.close();
        System.out.println("SessionFactory destroyed");
    }

    @Test
    public void testCreate() {
        System.out.println("Test create...");

        session.beginTransaction();

        Department department = new Department();
        department.setId(789);
        Integer id = (Integer) session.save(department);
        session.getTransaction().commit();

        Assertions.assertTrue(id > 0);

    }

    @Test
    public void testUpdate() {
        System.out.println("Test update...");

        Integer id = 1;
        Department department = new Department();
        department.setId(id);
        department.setName("Human");
        department.setColor("Green");

        session.beginTransaction();
        session.update(department);
        session.getTransaction().commit();

        Department updatedDepartment = session.find(Department.class, id);
        assertEquals("Human", updatedDepartment.getName());
    }

    @Test
    public void testGet() {
    }

    @Test
    public void testList() {
    }

    @Test
    public void testDelete() {
    }

    @BeforeEach
    public void openSession() {
        session = sessionFactory.openSession();
        System.out.println("Session created");
    }

    @AfterEach
    public void closeSession() {
        if (session != null) session.close();
        System.out.println("Session closed\n");
    }
}