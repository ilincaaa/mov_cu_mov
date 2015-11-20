
package hello;

public class Student {
    private  String nume;
    private  int grupa;
    private  int id;

    public Student(String nume, int grupa, int id) {
        this.nume = nume;
        this.grupa = grupa;
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public int getGrupa() {
        return grupa;
    }

    public int getId() {
        return id;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setGrupa(int grupa) {
        this.grupa = grupa;
    }

    public void setId(int id) {
        this.id = id;
    }
    
   
}
