package com.intenso.roguelike.scala

object Main extends App {

  println("Hello World")

  type Pos = (Int,Int)
  type Matrix = Array[Array[Byte]]
  type AsciiMapper = Byte => Char

}
