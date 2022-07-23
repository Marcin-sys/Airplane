import entity.Department;
import entity.Student;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateFactory {
    Configuration configuration;

    public HibernateFactory(){
        configuration = new HibernateFactory().getHibernateConfiguration();
    }
    public HibernateFactory(Configuration passConfiguration){
        configuration = passConfiguration;
    }

    private Configuration getHibernateConfiguration() {
        Configuration standardConfiguration = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Department.class).addAnnotatedClass(Student.class);
        return standardConfiguration;
    }

    public SessionFactory sessionFactory() {
        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder()
                .applySettings(getHibernateConfiguration().getProperties());
        return getHibernateConfiguration().buildSessionFactory(registryBuilder.build());
    }
}
