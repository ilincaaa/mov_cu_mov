
package hello;

    import java.util.concurrent.atomic.AtomicLong;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RequestParam;
    import org.springframework.web.bind.annotation.RestController;

    @RestController
    public class PersoanaController {

        private static final String firstName = "%s";
        private static final String lastName = "%s";

        @RequestMapping("/code")
        public Persoana persoana(@RequestParam(value = "nume", defaultValue = "Ionescu") String nume,
                                 @RequestParam(value = "prenume", defaultValue = "Stefan") String prenume,
                                 @RequestParam(value = "varsta", defaultValue = "23") int varsta)
                
        {
            return new Persoana(String.format(firstName, nume),
                                String.format(lastName, prenume), 
                                varsta);
        }
}
