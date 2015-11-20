package hello;

public class Wish {

    private  String sir;
    private  String nume;
    private  int id;

    public Wish(String sir, String nume, int id) {
        this.sir = sir;
        this.nume = nume;
        this.id = id;
    }

    public void setSir(String sir) {
        this.sir = sir;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSir() {
        return sir;
    }

    public String getNume() {
        return nume;
    }

    public int getId() {
        return id;
    }

}
