package com.intenso.roguelike.scala

object TypeDefs {

  type Pos = (Int,Int)
  type Matrix = Array[Array[Byte]]
  val x:Matrix = Array.ofDim(2)
  type AsciiMapper = Byte => Char
}
