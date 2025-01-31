package com.jiyoung.learntogether.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes
    val stringResourceId: Int,
    val num: Int,
    @DrawableRes
    val imageResourceId: Int,

)
