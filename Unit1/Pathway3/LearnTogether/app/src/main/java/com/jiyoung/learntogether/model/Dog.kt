package com.jiyoung.learntogether.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.jiyoung.learntogether.R

data class Dog(
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    val age: Int,
    @StringRes val hobbies: Int
)

val dogs = listOf(
    Dog(R.drawable.img_art1, R.string.dog_name_1, 2, R.string.dog_description_1),
    Dog(R.drawable.img_art2, R.string.dog_name_2, 16, R.string.dog_description_2),
    Dog(R.drawable.img_art3, R.string.dog_name_3, 2, R.string.dog_description_3),
    Dog(R.drawable.img_art1, R.string.dog_name_4, 8, R.string.dog_description_4),
    Dog(R.drawable.img_art2, R.string.dog_name_5, 8, R.string.dog_description_5),
    Dog(R.drawable.img_art3, R.string.dog_name_6, 14, R.string.dog_description_6),
    Dog(R.drawable.img_art1, R.string.dog_name_7, 2, R.string.dog_description_7),
    Dog(R.drawable.img_art2, R.string.dog_name_8, 7, R.string.dog_description_8),
    Dog(R.drawable.img_art3, R.string.dog_name_9, 4, R.string.dog_description_9)
)
