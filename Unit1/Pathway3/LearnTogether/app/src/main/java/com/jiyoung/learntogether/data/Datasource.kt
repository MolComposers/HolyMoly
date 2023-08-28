package com.jiyoung.learntogether.data

import com.jiyoung.learntogether.R
import com.jiyoung.learntogether.model.Affirmation

class Datasource() {
    fun loadAffirmations(): List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(R.string.affirmation1, R.drawable.img_art1),
            Affirmation(R.string.affirmation2, R.drawable.img_art2),
            Affirmation(R.string.affirmation3, R.drawable.img_art3),
            Affirmation(R.string.affirmation4, R.drawable.img_art1),
            Affirmation(R.string.affirmation5, R.drawable.img_art2),
            Affirmation(R.string.affirmation6, R.drawable.img_art3),
            Affirmation(R.string.affirmation7, R.drawable.img_art1),
            Affirmation(R.string.affirmation8, R.drawable.img_art2),
            Affirmation(R.string.affirmation9, R.drawable.img_art3),
            Affirmation(R.string.affirmation10, R.drawable.img_art1),
        )
    }
}
