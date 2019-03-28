package services;

import entities.Dog;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class DogServiceTest {
    private DogService dogService;
    private static int count = 0;
    @Before
    public void setUp() {
        dogService = new DogService();
    }

    @After
    public void tearDown() {
        dogService.clear();
        if (count > 1000) {
            count = 0;
        }
    }

    @Test
    public void create() {
        //Given
        Dog expected = new Dog();
        expected.setId(count);

        //When
        dogService.create(expected);

        //Then
        Dog actual = dogService.findById(count++);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findAll() {
        //Given
        List<Dog> expected = new ArrayList<>();
        expected.add(new Dog());
        expected.add(new Dog());
        expected.add(new Dog());
        expected.add(new Dog());
        expected.add(new Dog());
        expected.forEach(dog -> dog.setId(count++));
        expected.forEach(dog -> dogService.create(dog));

        //When
        List<Dog> actual = dogService.findAll();

        //Then
        Collections.sort(expected);
        Collections.sort(actual);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void delete() {
        //Given
        List<Dog> expected = new ArrayList<>();
        Dog removeDog = new Dog();
        expected.add(removeDog);
        expected.add(new Dog());
        expected.add(new Dog());
        expected.add(new Dog());
        expected.add(new Dog());
        expected.forEach(dog -> dog.setId(count++));
        expected.forEach(dog -> dogService.create(dog));

        //When
        dogService.delete(removeDog);

        //Then
        List<Dog> actual = dogService.findAll();
        expected.remove(removeDog);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void update() {
        //Given
        Dog firstDog = new Dog();
        firstDog.setId(count++);
        dogService.create(firstDog);
        Dog expected = new Dog();
        expected.setId(firstDog.getId());

        //When
        dogService.update(expected);

        //Then
        Dog actual = dogService.findById(firstDog.getId());
        Assert.assertEquals(expected, actual);
    }
}