
package hello;

public class Student {
    private final String nume;
    private final String prenume;
    private final long id;
    
    public Student( long id,String nume, String prenume) {
        this.nume = nume;
        this.prenume = prenume;
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public long getId() {
        return id;
    }
    
    
    
    
    
    
}
