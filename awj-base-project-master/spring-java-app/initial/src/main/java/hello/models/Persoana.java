package hello;

public class Persoana {

    private final String _name;
    private final String _surname;
    private final int _age;

    public Persoana(String _name, String _surname, int _age) {
        this._name = _name;
        this._surname = _surname;
        this._age = _age;
    }

    public String getName() {
        return _name;
    }

    public String getSurname() {
        return _surname;
    }

    public int getAge() {
        return _age;
    }
    
    

}
