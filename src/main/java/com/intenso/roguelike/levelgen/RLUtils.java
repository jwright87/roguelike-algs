package com.intenso.roguelike.levelgen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class RLUtils {

    private static final Logger logger = LoggerFactory.getLogger(RLUtils.class);
    private Random random;

    public RLUtils(Random random) {
        this.random = random;
    }

    public int[] move(int[] pos, Dir dir) {
        switch (dir) {
            case UP:
                return new int[]{pos[0], pos[1] - 1};
            case DOWN:
                return new int[]{pos[0], pos[1] + 1};
            case LEFT:
                    return new int[]{pos[0] - 1, pos[1]};
            case RIGHT:
                return new int[]{pos[0] + 1, pos[1]};
            default:
                throw new RuntimeException("Unknown direction");
        }
    }

    boolean isFloor(byte[][] arr, int[] pos) {
        if (arr[pos[0]][pos[1]] == LevelValues.FLOOR) {
            return true;
        }
        return false;
    }

    boolean isWall(byte[][] arr, int[] pos) {
        if (arr[pos[0]][pos[1]] == LevelValues.WALL) {
            return true;
        }
        return false;
    }

    public Dir randomValidDir(byte[][] arr, int[] pos) {
        Dir dir = randomCardinalDirection();
        if (canMoveInDir(arr, pos, dir)) {
            logger.debug("Random Dir returned: {}",dir);
            return dir;
        }
        return randomValidDir(arr, pos);
    }

    public Dir randomCardinalDirection() {
        switch (random.nextInt(4)) {
            case 0:
                return Dir.UP;
            case 1:
                return Dir.DOWN;
            case 2:
                return Dir.LEFT;
            case 3:
                return Dir.RIGHT;
            default:
                throw new RuntimeException("Unknown direction");
        }
    }

    /**
     * Whether a movement in a direction is possible within the map
     * ignoring walls etc. i.e. is within bounds.
     *
     * @param arr
     * @param pos
     * @param dir
     * @return
     */
    public boolean canMoveInDir(byte[][] arr, int[] pos, Dir dir) {
       logger.debug("Checking can move at pos {}  {}",pos[0],pos[1]);
        switch (dir) {
            case UP:
                if (pos[1] == 0) {
                    return false;
                }
                break;
            case DOWN:
                if (pos[1] >= arr[0].length - 1) {
                    return false;
                }
                break;
            case LEFT:
                if (pos[0] == 0) {
                    return false;
                }
                break;
            case RIGHT:
                if (pos[0] >= arr.length - 1) {
                    return false;
                }
                break;
            default:
                throw new RuntimeException("Unknown direction value: " + dir);
        }
        return true;
    }
}
