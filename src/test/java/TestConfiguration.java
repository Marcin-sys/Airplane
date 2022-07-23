import entity.Department;
import entity.Student;
import org.hibernate.cfg.Configuration;

public class TestConfiguration {
    public Configuration getHibernateConfiguration() {
        final Configuration testConfiguration = new Configuration().configure("hibernate-test.cfg.xml")
                .addAnnotatedClass(Department.class).addAnnotatedClass(Student.class);
        return testConfiguration;
    }
}
