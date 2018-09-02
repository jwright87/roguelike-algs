package com.intenso.roguelike.levelgen;

public abstract class AsciiConverter {

    private static final char WALL = '#';
    private static final char FLOOR = '.';
    private static final char UPSTAIRS = '>';
    private static final char DOWNSTAIRS = '<';

    static char convert(byte b) {
        switch (b) {
            case LevelValues.WALL:
                return WALL;
            case LevelValues.FLOOR:
                return FLOOR;
            case LevelValues.UPSTAIRS:
                return UPSTAIRS;
            case LevelValues.DOWNSTAIRS:
                return DOWNSTAIRS;
            default:
                throw new RuntimeException("Unknown byte value, cannot convert " + b);
        }

    }

    public static void print(byte[][] arr) {
        for (int y=0;y<arr[0].length;y++) {
            for (int x=0;x<arr.length;x++) {
                System.out.print(convert(arr[x][y]));
            }
            System.out.println();
         }
    }
}
