
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
public class FoodController {
  private List<Food> mancare = new ArrayList<Food>();

  FoodController() {
    Food f1 = new Food("Salata","antreu",1);
    Food f2 = new Food("Negresa","desert",2);
    Food f3 = new Food("Supa","principal",3);

    mancare.add(f1);
    mancare.add(f2);
    mancare.add(f3);
  }

  @RequestMapping(value="/food", method = RequestMethod.GET)
  public List<Food> index() {
    return this.mancare;
  }

  @RequestMapping(value="/food/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Food f : this.mancare) {
      if(f.getId() == id) {
        return new ResponseEntity<Food>(f, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/food/{id}", method = RequestMethod.DELETE)
  public ResponseEntity sterge(@PathVariable("id") int id) {
    for(Food f : this.mancare) {
      if(f.getId() == id) {
        this.mancare.remove(f);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

@RequestMapping(value="/food/{id}", method = RequestMethod.PUT)
  public ResponseEntity modificare(@PathVariable("id") int id) {
    for(Food f : this.mancare) {
      if(f.getId() == id) {
          f.setNume("Sarmale");
          f.setGen("Principal");
        return new ResponseEntity<Food>(f, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
  
  @RequestMapping(value="/food/{name}/{fel}", method = RequestMethod.POST)
  public ResponseEntity adaugare(@PathVariable("name") String name,@PathVariable("fel") String fel) {
         Food f4 = new Food(name,fel,mancare.size()+1);
         mancare.add(f4);
         return new ResponseEntity<Food>(f4, new HttpHeaders(), HttpStatus.OK);
  }
}

