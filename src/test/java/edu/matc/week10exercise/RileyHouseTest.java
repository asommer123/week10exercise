package edu.matc.week10exercise;

import org.junit.Test;

import static org.junit.Assert.*;

public class RileyHouseTest {


    @Test
    public void addTest() throws Exception {
        RileyHouse rileyHouse = new RileyHouse();
        Child child = new Child(rileyHouse);

        child.setName("Test Child 1");
        rileyHouse.add(child);
    }

}