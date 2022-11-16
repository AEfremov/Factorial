package ru.efremov.factorialtest

sealed class State

object Error : State()
object Progress : State()
class Factorial(var value: String) : State()