package com.example.recyclerview

import java.io.Serializable
// Класс который хранит в себе, одно растение(Картинку) и текст
data class Plant(val imageId: Int, val title:String,val desc: String): Serializable

