package com.intenso.roguelike.scala

import com.intenso.roguelike.levelgen.{LevelGen, RLUtils}
import TypeDefs._

import scala.collection.mutable

class SimpleMaze(util: RLUtils) extends LevelGen {


  override def generate(width: Int, height: Int): Matrix = {

    val matrix: Matrix = Array.ofDim(width, height)

    val stack = new mutable.Stack[Pos]

    val startingPos = util.getRandomInnerPos(matrix)


    return null
  }
}
