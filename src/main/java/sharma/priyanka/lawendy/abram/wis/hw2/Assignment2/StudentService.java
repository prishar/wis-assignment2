package sharma.priyanka.lawendy.abram.wis.hw2.Assignment2;

import javafx.application.Application;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/rest/student")
class StudentService {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public HashMap<Long, Student> getAllStudents() {
        return Assignment2Application.hmStudent;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Student addStudent(@RequestParam(value = "name") String name,
                              @RequestParam(value = "subject", defaultValue = "unknown") String subject) {
        Student student = new Student(name, subject);
        Assignment2Application.hmStudent.put(new Long(student.getId()), student);
        return student;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Student updateStudent(@RequestBody Student student) throws Exception {
        if (Assignment2Application.hmStudent.containsKey(new Long(student.getId()))) {
            Assignment2Application.hmStudent.put(new Long(student.getId()), student);
        } else {
            throw new Exception("Student " + student.getId() + " does not exists");
        }
        return student;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Student deleteStudent(@PathVariable long id) throws Exception {
        Student student;
        if (Assignment2Application.hmStudent.containsKey(new Long(id))) {
            student = Assignment2Application.hmStudent.get(new Long(id));
            Assignment2Application.hmStudent.remove(new Long(id));
        } else {
            throw new Exception("Student " + id + " does not exists");
        }
        return student;
    }
}