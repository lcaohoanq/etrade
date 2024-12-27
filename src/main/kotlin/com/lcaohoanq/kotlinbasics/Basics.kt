package com.lcaohoanq.kotlinbasics

fun main(){
    print("Hello")

    hello()

    var name = "Haha"
    name = "Hoho"

    if(name == "Haha"){
        print("Name is Haha")
    } else {
        print("Name is not Haha")
    }

    val age = 20
    //age = 30 // Error: Val cannot be reassigned

    when(age){
        20 -> print("Age is 20")
        30 -> print("Age is 30")
        else -> print("Age is not 20 or 30")
    }

    var firstName = "Amit"
    var lastName = "Shekhar"
//Use string builder for better performance
    var message = StringBuilder("My name is: ")
        .append(firstName)
        .append(" ")
        .append(lastName)
        .toString()

    print(message)

}

fun hello(){
    print("Hello too")
}

abstract class Animal(protected var name: String) {
    abstract fun makeSound()
}

abstract class Fish(name: String, var weight: Int) : Animal(name)