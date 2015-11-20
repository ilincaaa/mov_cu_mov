/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

public class Food {
    private String nume;
    private String gen;
    private int id;

    public Food(String nume, String gen, int id) {
        this.nume = nume;
        this.gen = gen;
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public String getGen() {
        return gen;
    }

    public int getId() {
        return id;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
