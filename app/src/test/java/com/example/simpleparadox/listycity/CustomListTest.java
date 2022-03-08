package com.example.simpleparadox.listycity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class CustomListTest {
    private CustomList list;

    @BeforeEach
    void setUp() {
        list = new CustomList(null, new ArrayList<City>());
    }

    @Test
    void addCity() {
        int listSize = list.getCount();
        list.addCity(new City("Edmonton", "AB"));
        assertEquals(listSize+1, list.getCount());
    }

    @Test
    void testHasCity() {
        City city = new City("Edmonton", "AB");
        assertFalse(list.hasCity(city));
        list.addCity(city);
        assertTrue(list.hasCity(city));
        assertFalse(list.hasCity(new City("Nowhere", "Nowhere")));
    }

    @Test
    void testDelete() throws Exception {
        City city = new City("Edmonton", "AB");
        assertThrows(Exception.class, () -> list.delete(city));
        list.addCity(city);
        list.delete(city);
    }

    @Test
    void testCountCities() throws Exception {
        City city = new City("Regina", "Saskatchewan");

        assertEquals(0, list.countCities());

        list.addCity(city);
        assertEquals(1, list.countCities());

        list.delete(city);
        assertEquals(0, list.countCities());

    }

}