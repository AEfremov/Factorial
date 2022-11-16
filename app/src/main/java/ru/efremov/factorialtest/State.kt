package ru.efremov.factorialtest

sealed class State

object Error : State()
object Progress : State()
class Result(var factorial: String) : State()