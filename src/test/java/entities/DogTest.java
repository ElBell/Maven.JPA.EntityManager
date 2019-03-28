package entities;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DogTest {
    private Dog dog;

    @Before
    public void SetUp() {
        dog = new Dog();
    }

    @Test
    public void setId() {
        //Given
        int expected = 34;
        //When
        dog.setId(expected);

        //Then
        int actual = dog.getId();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setName() {
        //Given
        String expected = "WhosAGoodDog";
        //When
        dog.setName(expected);

        //Then
        String actual = dog.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setBreed() {
        //Given
        String expected = "Corgi";
        //When
        dog.setBreed(expected);

        //Then
        String actual = dog.getBreed();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setColor() {
        //Given
        String expected = "Brindle";
        //When
        dog.setColor(expected);

        //Then
        String actual = dog.getColor();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setToyList() {
        //Given
        List<Toy> expected = new ArrayList<Toy>();
        expected.add(new Toy());
        expected.add(new Toy());
        //When
        dog.setToyList(expected);

        //Then
        List<Toy> actual = dog.getToyList();
        Assert.assertEquals(expected, actual);
    }
}