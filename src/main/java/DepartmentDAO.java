import entity.Department;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class DepartmentDAO {
    public void add(Department department) {
        HibernateFactory hibernateFactory = new HibernateFactory();
        Session session = hibernateFactory.sessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(department);
            session.getTransaction().commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            throw new RuntimeException();
        } finally {
            session.close();
        }
    }

    public void update(Department department) {
        HibernateFactory hibernateFactory = new HibernateFactory();
        Session session = hibernateFactory.sessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(department);
            session.getTransaction().commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            throw new RuntimeException();
        } finally {
            session.close();
        }
    }

    public void delete(Department department) {
        HibernateFactory hibernateFactory = new HibernateFactory();
        Session session = hibernateFactory.sessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(department);
            session.getTransaction().commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            throw new RuntimeException();
        } finally {
            session.close();
        }
    }

    public void read(Integer departmentId) {
        HibernateFactory hibernateFactory = new HibernateFactory();
        Session session = hibernateFactory.sessionFactory().openSession();
        Department departmentObj;

        try {
            departmentObj = session.get(Department.class, departmentId);
            if (departmentObj != null) {
                System.out.println("Department id = " + departmentId + " ,department color = " + departmentObj.getColor() +
                        " ,department name = " + departmentObj.getName());
            } else {
                System.out.println((Object) null);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        } finally {
            session.close();
        }
    }
}
