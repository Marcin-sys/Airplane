import entity.Department;
import entity.Student;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateFactory {
    private Configuration getHibernateConfiguration() {
        Configuration configuration = new Configuration().configure()
                .addAnnotatedClass(Department.class).addAnnotatedClass(Student.class);
        return configuration;
    }

    public SessionFactory sessionFactory() {
        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder()
                .applySettings(getHibernateConfiguration().getProperties());
        return getHibernateConfiguration().buildSessionFactory(registryBuilder.build());
    }

}
