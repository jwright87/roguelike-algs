package com.intenso.roguelike.scala

import java.lang.ArrayIndexOutOfBoundsException

import com.intenso.roguelike.levelgen.Dir
import com.intenso.roguelike.scala.TypeDefs.{Matrix, Pos}

import scala.util.Random

class SLvlUtils(r: Random) extends ILvlUtils {
  /**
    * Pick a random position within the matrix
    *
    * @param matrix
    * @return
    */
  override def pickRandomPos(matrix: Matrix): (Int, Int) = {
    (r.nextInt(matrix.length), r.nextInt(matrix(0).length))
  }

  /**
    * Pick a random position excluding outer edges
    *
    * @param matrix
    * @return
    */
  override def pickRandomInnerPos(matrix: Matrix): (Int, Int) = {
    (1 + r.nextInt(matrix.length) - 2, 1 + r.nextInt(matrix(0).length - 2))
  }

  /**
    * Pick random position on outer edge of map (e.g for a door)
    *
    * @param matrix
    * @return
    */
  override def pickRandomOuterPos(matrix: Matrix): (Int, Int) = {
    val x = if (r.nextBoolean()) 0 else matrix.length - 1
    val y = if (r.nextBoolean()) 0 else matrix(0).length - 1
    (x, y)
  }

  /**
    * Whether one can move from the position to a given direction (that it is within the map and not a wall)
    *
    * @param matrix
    * @param pos
    * @param dir
    * @return
    */
  override def canMove(matrix: Matrix, pos: (Int, Int), dir: Dir): Boolean = {
    //TODO
    false
  }

  /**
    * Check that a wall or the end of the matrix does not impede moving left
    *
    * @param matrix
    * @param pos
    * @return
    */
  override def canMoveLeft(matrix: Matrix, pos: (Int, Int)): Boolean = {
    val newPos = moveLeft(pos)
    !isWall(newPos)
  }

  /**
    * Check that a wall or the end of the matrix does not impede moving right
    *
    * @param matrix
    * @param pos
    * @return
    */
  override def canMoveRight(matrix: Matrix, pos: (Int, Int)): Boolean = ???

  /**
    * Check that a wall or the end of the matrix does not impede moving up
    *
    * @param matrix
    * @param pos
    * @return
    */
  override def canMoveUp(matrix: Matrix, pos: (Int, Int)): Boolean = ???

  /**
    * Check that a wall or the end of the matrix does not impede moving down
    *
    * @param matrix
    * @param pos
    * @return
    */
  override def canMoveDown(matrix: Matrix, pos: (Int, Int)): Boolean = ???

  override def isWall(matrix: Matrix, pos: (Int, Int)): Boolean = ???

  override def isFloor(matrix: Matrix, pos: (Int, Int)): Boolean = ???

  def moveLeft(pos: Pos): Pos = {
    (pos._1 - 1, pos._2)
  }

  def moveRight(pos: Pos): Pos = {
    (pos._1 + 1, pos._2)
  }

  def moveUp(pos: Pos): Pos = {
    (pos._1, pos._2 - 1)
  }

  def moveDown(pos: Pos): Pos = {
    (pos._1, pos._2 + 1)
  }

  def posWithinMatrix(matrix: Matrix, pos: Pos): Boolean = {

    try {
      matrix(pos._1)(pos._2)
    } catch {
      case _: ArrayIndexOutOfBoundsException => return false
    }
    true
  }
}
