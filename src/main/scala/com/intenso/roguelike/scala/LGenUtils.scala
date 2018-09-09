package com.intenso.roguelike.scala

import com.intenso.roguelike.scala.TypeDefs.Matrix

object LGenUtils {

  def initMapAs(width: Int, height: Int, value: Byte): Matrix = {
    val matrix = Array.ofDim[Byte](width, height)
    for (y <- 0 until height; x <- 0 until width) {
      matrix(x)(y) = value
    }
    matrix
  }
}
