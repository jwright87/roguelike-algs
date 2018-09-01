package com.intenso.roguelike.levelgen;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.*;

public class RLUtilsTest {


    @Test
    public void randomCardinalDirectionTest() {
        Map<Dir, Integer> dirMap = new HashMap<>();
        for (int i = 0; i < 1000000; i += 750) {
            RLUtils utils = new RLUtils(new Random(i));
            Dir dir = utils.randomCardinalDirection();
            System.out.println(dir);
            int count = dirMap.getOrDefault(dir, 0);
            dirMap.put(dir, ++count);
        }
        System.out.printf("total up: %d down: %d left: %d right: %d%n",
                dirMap.get(Dir.UP), dirMap.get(Dir.DOWN), dirMap.get(Dir.LEFT),
                dirMap.get(Dir.RIGHT));
        // Check values are roughly equal given a variety of random seeds. 
        assertEquals(338, (int) dirMap.get(Dir.UP));
        assertEquals(337, (int) dirMap.get(Dir.DOWN));
        assertEquals(327, (int) dirMap.get(Dir.LEFT));
        assertEquals(332, (int) dirMap.get(Dir.RIGHT));
    }
    
    @Test
    public void canMoveInDirTest() {
        byte[][] arr = new byte[10][12];
        RLUtils utils = new RLUtils(new Random(99));
        assertTrue(utils.canMoveInDir(arr,new int[]{8,0},Dir.RIGHT));
        assertTrue(utils.canMoveInDir(arr,new int[]{0,10},Dir.DOWN));
        assertTrue(utils.canMoveInDir(arr,new int[]{9,1},Dir.UP));
        assertTrue(utils.canMoveInDir(arr,new int[]{1,11},Dir.LEFT));

        assertFalse(utils.canMoveInDir(arr,new int[]{9,0},Dir.RIGHT));
        assertFalse(utils.canMoveInDir(arr,new int[]{0,11},Dir.DOWN));
        assertFalse(utils.canMoveInDir(arr,new int[]{9,0},Dir.UP));
        assertFalse(utils.canMoveInDir(arr,new int[]{0,11},Dir.LEFT));

        arr = new byte[30][25];
        assertFalse(utils.canMoveInDir(arr,new int[]{2,24},Dir.DOWN));

    }

    @Test
    public void moveDownTest() {
        RLUtils utils = new RLUtils(new Random(99));
        int[] pos = utils.move(new int[]{1,3},Dir.DOWN);
        assertArrayEquals(new int[]{1,4},pos);
    }

    @Test
    public void moveUpTest() {
        RLUtils utils = new RLUtils(new Random(99));
        int[] pos = utils.move(new int[]{1,3},Dir.UP);
        assertArrayEquals(new int[]{1,2},pos);
    }

    @Test
    public void moveLeftTest() {
        RLUtils utils = new RLUtils(new Random(99));
        int[] pos = utils.move(new int[]{1,3},Dir.LEFT);
        assertArrayEquals(new int[]{0,3},pos);
    }

    @Test
    public void moveRightTest() {
        RLUtils utils = new RLUtils(new Random(99));
        int[] pos = utils.move(new int[]{1,3},Dir.RIGHT);
        assertArrayEquals(new int[]{2,3},pos);
    }

}