
package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;


@RestController
public class StudentController {
  private List<Student> studenti = new ArrayList<Student>();

  StudentController() {
    Student s1 = new Student("Ion",331,1);
    Student s2 = new Student("Nicu",331,2);
    Student s3 = new Student("Costel",331,3);

    studenti.add(s1);
    studenti.add(s2);
    studenti.add(s3);
  }

  @RequestMapping(value="/student", method = RequestMethod.GET)
  public List<Student> index() {
    return this.studenti;
  }

  @RequestMapping(value="/student/{id}", method = RequestMethod.GET)
  public ResponseEntity arata(@PathVariable("id") int id) {
    for(Student s : this.studenti) {
      if(s.getId() == id) {
        return new ResponseEntity<Student>(s, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/student/{id}", method = RequestMethod.DELETE)
  public ResponseEntity sterge(@PathVariable("id") int id) {
    for(Student s : this.studenti) {
      if(s.getId() == id) {
        this.studenti.remove(s);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

@RequestMapping(value="/student/{id}", method = RequestMethod.PUT)
  public ResponseEntity modificare(@PathVariable("id") int id) {
    for(Student s : this.studenti) {
      if(s.getId() == id) {
          s.setNume("Nicu");
          s.setGrupa(332);
        return new ResponseEntity<Student>(s, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
  
  @RequestMapping(value="/student/{nume}/{grupa}", method = RequestMethod.POST)
  public ResponseEntity adaugare(@PathVariable("nume") String nume,@PathVariable("grupa") String grupa) {
         Student s4 = new Student(nume,Integer.parseInt(grupa),studenti.size()+1);
         studenti.add(s4);
         return new ResponseEntity<Student>(s4, new HttpHeaders(), HttpStatus.OK);
  }
}

