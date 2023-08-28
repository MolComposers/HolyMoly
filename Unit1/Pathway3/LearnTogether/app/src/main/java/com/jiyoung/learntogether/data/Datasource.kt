package com.jiyoung.learntogether.data

import com.jiyoung.learntogether.R
import com.jiyoung.learntogether.model.Affirmation
import com.jiyoung.learntogether.model.Topic

class Datasource {
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

    fun loadGridCards(): List<Topic> {
        return listOf(
            Topic(R.string.architecture, 58, R.drawable.img_art1),
            Topic(R.string.crafts, 121, R.drawable.img_art2),
            Topic(R.string.business, 78, R.drawable.img_art3),
            Topic(R.string.culinary, 118, R.drawable.img_art1),
            Topic(R.string.design, 423, R.drawable.img_art2),
            Topic(R.string.fashion, 92, R.drawable.img_art3),
            Topic(R.string.film, 165, R.drawable.img_art1),
            Topic(R.string.gaming, 164, R.drawable.img_art2),
            Topic(R.string.drawing, 326, R.drawable.img_art3),
            Topic(R.string.lifestyle, 305, R.drawable.img_art1),
            Topic(R.string.music, 212, R.drawable.img_art2),
            Topic(R.string.painting, 172, R.drawable.img_art3),
            Topic(R.string.photography, 321, R.drawable.img_art1),
            Topic(R.string.tech, 118, R.drawable.img_art2),
        )
    }
}
