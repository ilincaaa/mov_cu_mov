
package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;



@RestController
public class WishController {
  private List<Wish> wishes = new ArrayList<Wish>();

  WishController() {
    Wish w1 = new Wish("love","Ben",1);
    Wish w2 = new Wish("happiness","Benny",2);
    Wish w3 = new Wish("luck","Rose",3);
    
    wishes.add(w1);
    wishes.add(w2);
    wishes.add(w3);
  }

  @RequestMapping(value="/wish", method = RequestMethod.GET)
  public List<Wish> index() {
    return this.wishes;
  }

  @RequestMapping(value="/wish/{id}", method = RequestMethod.GET)
  public ResponseEntity arata(@PathVariable("id") int id) {
    for(Wish w : this.wishes) {
      if(w.getId() == id) {
        return new ResponseEntity<Wish>(w, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/wish/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Wish w : this.wishes) {
      if(w.getId() == id) {
        this.wishes.remove(w);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

@RequestMapping(value="/wish/{id}/{nume}/{gen}", method = RequestMethod.PUT)
 public List<Wish> update(@PathVariable("id") int id,@PathVariable("nume") String nume,@PathVariable("nume") String sir){
    for(Wish w : this.wishes) {
      if(w.getId() == id) {
         w.setNume(nume);
         w.setSir(sir);
      }
    }
     return this.wishes;
  }
  
  @RequestMapping(value="/wish", method = RequestMethod.POST)
   public ResponseEntity create(@RequestBody Wish w) {
         wishes.add(w);
         return new ResponseEntity<Wish>(w, new HttpHeaders(), HttpStatus.OK);
  }
}

