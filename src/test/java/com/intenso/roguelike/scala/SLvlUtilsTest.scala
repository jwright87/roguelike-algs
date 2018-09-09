package com.intenso.roguelike.scala

import org.scalatest.FunSuite

import scala.util.Random

class SLvlUtilsTest extends FunSuite {

  test("testPickRandomPos") {

    val matrix = Array.ofDim[Byte](10, 20)

    for (i <- 1 to 1000 by 10) {
      val util = new SLvlUtils(new Random(i))
      val pos = util.pickRandomPos(matrix)
      println(pos)
      assert(pos._1 < 10 && pos._2 < 20)
    }

  }

}
