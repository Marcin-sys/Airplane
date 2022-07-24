import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDAO {
    public void add(Student student,HibernateFactory hibernateFactory) {
        Session session = hibernateFactory.sessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(student);
            session.getTransaction().commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            throw new RuntimeException();
        } finally {
            session.close();
        }
    }

    public void update(Student student,HibernateFactory hibernateFactory,Integer id) {
        Session session = hibernateFactory.sessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        student.setId(id);
        try {
            session.merge(student);
            session.getTransaction().commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            throw new RuntimeException();
        } finally {
            session.close();
        }
    }

    public void delete(Student student,HibernateFactory hibernateFactory) {
        Session session = hibernateFactory.sessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(student);
            session.getTransaction().commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            throw new RuntimeException();
        } finally {
            session.close();
        }
    }

    public String read(HibernateFactory hibernateFactory,Integer studentId) {
        Session session = hibernateFactory.sessionFactory().openSession();
        Student studentObj;
        String information = null;

        try { //TODO
            studentObj = session.get(Student.class, studentId);
            if (studentObj != null) {
                information = ("Student id = " + studentId +
                        " ,student name = " + studentObj.getName() +
                        " ,student skin = " + studentObj.getSkin() +
                        " ,student department id = "
                        + studentObj.getDepartment().getId());
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
}
