package com.arifandi.saltnews.common

import android.widget.ImageView
import androidx.annotation.DrawableRes
import coil.load
import coil.transform.RoundedCornersTransformation
import com.arifandi.saltnews.R

/**
 * Created by Muh Arifandi on 7,July,2022
 */
interface ImageSource {
    fun show(url: String, imageView: ImageView)

    class NetImageSource(
        @DrawableRes private val placeHolderResourceId: Int = R.drawable.ic_baseline_image_24,
        @DrawableRes private val errorResourceId: Int = R.drawable.ic_baseline_error_24,
        private val radiusRoundedCorner: Float = 0f,
    ) : ImageSource {
        override fun show(url: String, imageView: ImageView) {
            imageView.load(url) {
                placeholder(placeHolderResourceId)
                error(errorResourceId)
                transformations(RoundedCornersTransformation(radiusRoundedCorner))
            }
        }
    }
}