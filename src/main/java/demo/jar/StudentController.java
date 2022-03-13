package demo.jar;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @GetMapping("/student")
    public Student gStudent() {
        return new Student("juan", "perez");
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("juan", "perez"));
        students.add(new Student("juan1", "perez"));
        students.add(new Student("juan2", "perez"));
        students.add(new Student("juan3", "perez"));
        students.add(new Student("juan4", "perez"));
        return students;
    }

    @GetMapping("/student/{firstname}/{lastname}")
    public Student studentPathVar(@PathVariable("firstname") String firstName,
            @PathVariable("lastname") String lastName) {
        return new Student(firstName, lastName);
    }
    @GetMapping("/student/query")
    public Student studentReqParam(@RequestParam("firstname") String firstName,
            @RequestParam("lastname") String lastName) {
        return new Student(firstName, lastName);
    }
}
