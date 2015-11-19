package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    
    private static final String template1 = "Studentul cu numele %s";
    private static final String template2 = "si prenumele %s";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/student")
    public Student student(@RequestParam(value = "nume", defaultValue = "Maria") String nume, @RequestParam(value = "prenume", defaultValue = "Rose") String prenume) {
        return new Student(counter.incrementAndGet(),
                            String.format(template1, nume),
                            String.format(template2, prenume)
        );
    }
}

