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

        list.add(city);

        assertTrue(list.hasCity(city));
        assertFalse(list.hasCity(new City("Nowhere", "Nowhere")));
    }

}