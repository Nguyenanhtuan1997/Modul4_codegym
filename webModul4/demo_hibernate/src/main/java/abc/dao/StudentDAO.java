package abc.dao;

import abc.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component // tự động tạo bean bên Service
public class StudentDAO {
    SessionFactory sessionFactory; // đánh dấu tiêm bean tương ứng bên dispatcher-servlet

    public StudentDAO(SessionFactory sessionFactory) {  // tương ứng với @Autowired(tiêm bean)
        this.sessionFactory = sessionFactory;
    }

    public List<Student> getAll() {
        Session session = sessionFactory.openSession();
        List<Student> students = session.createQuery("SELECT s FROM Student s", Student.class).getResultList();
        return students;
    }

    public void addStudent(Student student){
        Session session = sessionFactory.openSession();
        session.save(student);
    }

}
