import entity.Department;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDAO {
    public void add(Student student){
        HibernateFactory hibernateFactory = new HibernateFactory();
        Session session = hibernateFactory.sessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(student);
            session.getTransaction().commit();
        }catch (Exception ex){
            transaction.rollback();
            ex.printStackTrace();
            throw new RuntimeException();
        }finally {
            session.close();
        }
    }
    public void update(Student student){
        HibernateFactory hibernateFactory = new HibernateFactory();
        Session session = hibernateFactory.sessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(student);
            session.getTransaction().commit();
        }catch (Exception ex){
            transaction.rollback();
            ex.printStackTrace();
            throw new RuntimeException();
        }finally {
            session.close();
        }
    }
    public void delete(Student student){
        HibernateFactory hibernateFactory = new HibernateFactory();
        Session session = hibernateFactory.sessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(student);
            session.getTransaction().commit();
        }catch (Exception ex){
            transaction.rollback();
            ex.printStackTrace();
            throw new RuntimeException();
        }finally {
            session.close();
        }
    }
    public void read(Integer studentId) {
        HibernateFactory hibernateFactory = new HibernateFactory();
        Session session = hibernateFactory.sessionFactory().openSession();
        Student studentObj;

        try {
            studentObj = session.get(Student.class, studentId);
            if (studentObj != null) {
                System.out.println("Student id = " + studentId + " ,student name = " + studentObj.getName() +
                        " ,student skin = "+ studentObj.getSkin() + " ,student department id = " );
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
