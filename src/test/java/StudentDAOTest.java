import entity.Department;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentDAOTest {
    private static final Configuration configuration = new Configuration()
            .configure("hibernate-test.cfg.xml")
            .addAnnotatedClass(Department.class)
            .addAnnotatedClass(Student.class);
    private static final HibernateFactory hibernateFactory = new HibernateFactory(configuration);
    private static final Session session = hibernateFactory.sessionFactory().openSession();
    Student student = new Student();
    StudentDAO studentDAO = new StudentDAO();
    Integer id = 1;

    @AfterAll
    public static void tearDown() {
        if (session != null) session.getSessionFactory().close();
        System.out.println("Session closed\n");
    }


    @Test
    @Order(1)
    void add() {
        student.setId(id);
        student.setName("Physic");
        student.setSkin("White");

        studentDAO.add(student, hibernateFactory);

        Assertions.assertTrue(student.getId() > 0);
    }

    @Test
    @Order(2)
    void update() {
        student.setId(id);
        student.setName("UpdateTestName");
        student.setSkin("White");

        studentDAO.update(student, hibernateFactory, id);

        Student student1 = student;

        assertSame("UpdateTestName", student1.getName());

    }

    @Test
    @Order(3)
    void delete() {
    }

    @Test
    @Order(4)
    void read() {
    }

    @AfterEach
    public void deleteDataBase() {
//        Session session = hibernateFactory.sessionFactory().openSession();
//        student.setId(id);
//        session.beginTransaction();
//        session.delete(student);
//        session.getTransaction().commit();
    }
}