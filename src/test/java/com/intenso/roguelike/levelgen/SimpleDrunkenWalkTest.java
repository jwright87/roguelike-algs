package com.intenso.roguelike.levelgen;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class SimpleDrunkenWalkTest {

    @Test
    public void generateTest() {
        SimpleDrunkenWalk sdw = new SimpleDrunkenWalk(65,new Random());
        byte[][] arr = sdw.generate(75,40);
        AsciiConverter.print(arr);
    }

    @Test
    public void calculateNumberOfFloorsTest() {
        byte[][] arr = new byte[20][30];
        int totalFloors = new SimpleDrunkenWalk(50,new Random(100))
                .calculateNumberOfFloors(arr,50);
        assertEquals(300,totalFloors);
    }
}