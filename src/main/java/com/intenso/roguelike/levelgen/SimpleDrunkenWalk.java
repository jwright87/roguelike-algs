package com.intenso.roguelike.levelgen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class SimpleDrunkenWalk implements LevelGen {

    private static final Logger logger = LoggerFactory.getLogger(SimpleDrunkenWalk.class);
    private int percentFloors;
    private Random random;

    final int UP = 0;
    final int DOWN = 1;
    final int LEFT = 2;
    final int RIGHT = 3;

    private RLUtils utils;

    public SimpleDrunkenWalk(int percentFloors, Random random) {
        if (percentFloors > 100) {
            throw new RuntimeException("percentage cannot be greater than 100");
        }
        this.percentFloors = percentFloors;
        this.random = random;
        utils = new RLUtils(random);
    }

    @Override
    public byte[][] generate(int width, int height) {

        byte[][] arr = initMapAsWalls(width, height);
        int[] pos = pickRandomPosition(arr, random);
        arr = setPosAsFloor(arr, pos);

        int totalFloorsRequired = calculateNumberOfFloors(arr, percentFloors);
        int currentFloors = 1;
        int[] firstPos = pos;
        while (currentFloors < totalFloorsRequired) {
            pos = utils.move(pos, utils.randomValidDir(arr, pos));
            logger.debug("New Pos: {} {}", pos[0], pos[1]);
            if (utils.isWall(arr, pos)) {
                arr = setPosAsFloor(arr, pos);
                currentFloors++;
            }
        }
        int[] lastPos = pos;
        utils.setValue(arr,firstPos,LevelValues.DOWNSTAIRS);
        utils.setValue(arr,lastPos,LevelValues.UPSTAIRS);
        return arr;
    }

    int calculateNumberOfFloors(byte[][] arr, int percentFloors) {
        float total = arr[0].length * arr.length;
        return Math.round(total * (percentFloors / 100f));
    }


    byte[][] setPosAsFloor(byte[][] arr, int[] pos) {
        arr[pos[0]][pos[1]] = LevelValues.FLOOR;
        return arr;
    }

    int[] pickRandomPosition(byte[][] arr, Random r) {
        int x = r.nextInt(arr.length);
        int y = r.nextInt(arr[0].length);
        return new int[]{x, y};
    }

    byte[][] initMapAsWalls(int w, int h) {
        return initMapAs(w, h, LevelValues.WALL);
    }

    /**
     * Initiliases the array with all having a single type
     *
     * @param width
     * @param height
     * @param b
     * @return
     */
    byte[][] initMapAs(int width, int height, byte b) {
        byte[][] byteArr = new byte[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                byteArr[x][y] = b;
            }
        }
        return byteArr;
    }
}
