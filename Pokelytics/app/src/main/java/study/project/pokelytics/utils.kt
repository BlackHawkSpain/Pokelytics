package study.project.pokelytics

import android.widget.ImageView
import com.squareup.picasso.Picasso

const val NAVIGATE_TIMEOUT = 1500L

fun ImageView.setImageToUrl(url: String, placeholder: Int = R.drawable.ic_pokeball) {
    if (url.isNotBlank()) {
        Picasso.get()
            .load(url)
            .placeholder(placeholder)
            .into(this)
    } else {
        Picasso.get()
            .load(placeholder)
            .into(this)
    }
}