package services;

import entities.Toy;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ToyServiceTest {
    private ToyService toyService;
    private static int count = 0;
    @Before
    public void setUp() {
        toyService = new ToyService();
    }

    @After
    public void tearDown() {
        toyService.clear();
        if (count > 1000) {
            count = 0;
        }
    }

    @Test
    public void create() {
        //Given
        Toy expected = new Toy();
        expected.setId(count);

        //When
        toyService.create(expected);

        //Then
        Toy actual = toyService.findById(count++);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findAll() {
        //Given
        List<Toy> expected = new ArrayList<>();
        expected.add(new Toy());
        expected.add(new Toy());
        expected.add(new Toy());
        expected.add(new Toy());
        expected.add(new Toy());
        expected.forEach(toy -> toy.setId(count++));
        expected.forEach(toy -> toyService.create(toy));

        //When
        List<Toy> actual = toyService.findAll();

        //Then
        Collections.sort(expected, Comparator.comparingInt(Toy::getId));
        Collections.sort(actual, Comparator.comparingInt(Toy::getId));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void delete() {
        //Given
        List<Toy> expected = new ArrayList<>();
        Toy removeToy = new Toy();
        expected.add(removeToy);
        expected.add(new Toy());
        expected.add(new Toy());
        expected.add(new Toy());
        expected.add(new Toy());
        expected.forEach(toy -> toy.setId(count++));
        expected.forEach(toy -> toyService.create(toy));

        //When
        toyService.delete(removeToy.getId());

        //Then
        List<Toy> actual = toyService.findAll();
        expected.remove(removeToy);
        Collections.sort(expected, Comparator.comparingInt(Toy::getId));
        Collections.sort(actual, Comparator.comparingInt(Toy::getId));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void update() {
        //Given
        Toy firstToy = new Toy();
        firstToy.setId(count++);
        toyService.create(firstToy);
        Toy expected = new Toy();
        expected.setId(firstToy.getId());

        //When
        toyService.update(expected);

        //Then
        Toy actual = toyService.findById(firstToy.getId());
        Assert.assertEquals(expected, actual);
    }
}
