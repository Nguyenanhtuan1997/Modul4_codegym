package abc.service;

import abc.dao.StudentDAO;
import abc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // tự động tạo bean tương ứng
public class StudentService {

    @Autowired // đánh dấu tiêm bean tương ứng
    private StudentDAO studentDAO;

    // hàm hiển thị list danh sách student
    public List<Student> getAll() {
     return studentDAO.getAll();
    }

    public void addStudent(Student student){
        studentDAO.addStudent(student);
    }
}
