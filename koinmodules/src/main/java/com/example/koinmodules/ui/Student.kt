package com.example.koinmodules.ui

class Student(val course: SchoolCourse, val friend: Friend) {
    fun beSmart() {
        course.study()
        friend.hangout()
    }
}

class SchoolCourse {
    fun study() {
        println("I am study")
    }
}

class Friend {
    fun hangout() {
        println("I am hanging out")
    }
}