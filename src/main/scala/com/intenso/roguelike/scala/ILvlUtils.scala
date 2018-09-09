package com.intenso.roguelike.scala
import TypeDefs._
import com.intenso.roguelike.levelgen.Dir

trait ILvlUtils {


  /**
    * Pick a random position within the matrix
    * @param matrix
    * @return
    */
  def pickRandomPos(matrix:Matrix):Pos

  /**
    * Pick a random position excluding outer edges
    * @param matrix
    * @return
    */
  def pickRandomInnerPos(matrix:Matrix):Pos

  /**
    * Pick random position on outer edge of map (e.g for a door)
    * @param matrix
    * @return
    */
  def pickRandomOuterPos(matrix:Matrix):Pos

  /**
    * Whether one can move from the position to a given direction (that it is within the map and not a wall)
    * @param matrix
    * @param pos
    * @param dir
    * @return
    */
  def canMove(matrix: Matrix,pos:Pos,dir:Dir):Boolean


  /**
    * Check that a wall or the end of the matrix does not impede moving left
    * @param matrix
    * @param pos
    * @return
    */
  def canMoveLeft(matrix: Matrix,pos:Pos):Boolean

  /**
    * Check that a wall or the end of the matrix does not impede moving right
    * @param matrix
    * @param pos
    * @return
    */
  def canMoveRight(matrix: Matrix,pos:Pos):Boolean

  /**
    * Check that a wall or the end of the matrix does not impede moving up
    * @param matrix
    * @param pos
    * @return
    */
  def canMoveUp(matrix: Matrix,pos:Pos):Boolean

  /**
    * Check that a wall or the end of the matrix does not impede moving down
    * @param matrix
    * @param pos
    * @return
    */
  def canMoveDown(matrix: Matrix,pos:Pos):Boolean


  def isWall(matrix: Matrix,pos: Pos):Boolean

  def isFloor(matrix: Matrix,pos: Pos):Boolean
}
