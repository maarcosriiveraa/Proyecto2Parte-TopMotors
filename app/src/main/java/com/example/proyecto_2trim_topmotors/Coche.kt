package com.example.proyecto_2trim_topmotors

data class Coche(
    val marca: String,
    val motor: String,
    val modelo: String,
    val potencia: String,
    val imagen: String,
    var isSelected: Boolean = false
)
