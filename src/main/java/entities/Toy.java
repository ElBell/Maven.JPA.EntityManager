package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Toy {
    @Id
    private int id;
    private boolean squeaker;
    private String color;
    private double cost;
    @ManyToOne
    private Dog owner;

    public Toy(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isSqueaker() {
        return squeaker;
    }

    public void setSqueaker(boolean squeaker) {
        this.squeaker = squeaker;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Dog getOwner() {
        return owner;
    }

    public void setOwner(Dog owner) {
        this.owner = owner;
    }
}
