import entity.Department;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class DepartmentDAO {
    public void add(Department department,HibernateFactory hibernateFactory) {
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

    public void update(Department department,HibernateFactory hibernateFactory,Integer id) {
        Session session = hibernateFactory.sessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        department.setId(id);
        try {
            session.merge(department);
            session.getTransaction().commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            throw new RuntimeException();
        } finally {
            session.close();
        }
    }

    public void delete(HibernateFactory hibernateFactory,Integer departmentId) {
        Session session = hibernateFactory.sessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Department departmentToDelete = session.find(Department.class,departmentId);
            if (departmentToDelete != null){
                session.delete(departmentToDelete);
                session.getTransaction().commit();
            }
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            throw new RuntimeException();
        } finally {
            session.close();
        }
    }

    public String read(HibernateFactory hibernateFactory,Integer departmentId) {
        Session session = hibernateFactory.sessionFactory().openSession();
        Department departmentObj;
        String information = null;

        try {
            departmentObj = session.get(Department.class, departmentId);
            if (departmentObj != null) {
                information = "Department id = " + departmentId +
                        " ,department color = " + departmentObj.getColor() +
                        " ,department name = " + departmentObj.getName();
            } else {
                System.out.println((Object) null);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        } finally {
            session.close();
        }return information;
    }

    public Department get(HibernateFactory hibernateFactory,Integer departmentId) {
        Session session = hibernateFactory.sessionFactory().openSession();
        Department departmentObj;
        try {
            departmentObj = session.get(Department.class, departmentId);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        } finally {
            session.close();
        }return departmentObj;
    }
}
