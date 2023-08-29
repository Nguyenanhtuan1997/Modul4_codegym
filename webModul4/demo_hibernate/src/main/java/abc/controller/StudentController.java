package abc.controller;

import abc.model.ClassRoom;
import abc.model.Student;
import abc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home");
        List<Student> students = studentService.getAll();
        modelAndView.addObject("students", students);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("student", new Student());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Student student, int idClass){
        ClassRoom classRoom = new ClassRoom(1,"C03");
        ClassRoom classRoom1 = new ClassRoom(2,"C04");
        student.setClassRoom(classRoom);
        student.setClassRoom(classRoom1);
        studentService.addStudent(student);
        return "redirect:/students";
    }
}
