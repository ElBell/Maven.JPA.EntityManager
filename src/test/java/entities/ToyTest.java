package entities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ToyTest {
    private Toy toy;

    @Before
    public void SetUp() {
        toy = new Toy();
    }

    @Test
    public void setId() {
        //Given
        int expected = 1180345736;

        //When
        toy.setId(expected);

        //Then
        int actual = toy.getId();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setSqueaker() {
        //Given
        boolean expected = true;

        //When
        toy.setSqueaker(true);

        //Then
        boolean actual = toy.isSqueaker();
        Assert.assertTrue(actual);
    }

    @Test
    public void setColor() {
        //Given
        String expected = "WhosAGoodToy";
        //When
        toy.setColor(expected);

        //Then
        String actual = toy.getColor();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCost() {
        //Given
        double expected = 10.3;

        //When
        toy.setCost(expected);

        //Then
        double actual = toy.getCost();
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testDog() {
        //Given
        Dog expected = new Dog();

        //When
        toy.setOwner(expected);

        //Then
        Dog actual = toy.getOwner();
        Assert.assertEquals(expected, actual);
    }
}
