package hello;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WishController {
    private static final String template1 = "I am %s";
    private static final String template2 = "am I wish you %s";
  
    @RequestMapping("/wish")
    public Wish wish(@RequestParam(value = "nume", defaultValue = "Ilinca") String nume, @RequestParam(value = "feeling", defaultValue = "happiness") String feeling) {
        return new Wish (   String.format(template1, nume),
                            String.format(template2, feeling)
        );
    }

    
}
