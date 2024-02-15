package com.example.itsokavatarplayground

import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    private lateinit var mAvatarView: ImageView
    @DrawableRes private var mCurAvatarResId: Int = R.drawable.itsok_animated_wonder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        mAvatarView = findViewById(R.id.image_avatar)

        findViewById<MaterialButton>(R.id.button_change).apply {
            setOnClickListener { onChangeClicked() }
        }
    }

    private fun onChangeClicked() {
        setNextAvatarByCurrentAvatarId(mCurAvatarResId)
        startAvatarAnim()
    }

    private fun setNextAvatarByCurrentAvatarId(@DrawableRes avatarId: Int) {
        mCurAvatarResId = getNextAvatarIdByCurrentAvatarId(avatarId)

        val drawable = getDrawableByResId(mCurAvatarResId)

        mAvatarView.setImageDrawable(drawable)
    }

    private fun getNextAvatarIdByCurrentAvatarId(@DrawableRes avatarId: Int): Int {
        return when (avatarId) {
            R.drawable.itsok_animated_wonder -> R.drawable.itsok_animated_wonder_backwards
            R.drawable.itsok_animated_wonder_backwards -> R.drawable.itsok_animated_thinking
            R.drawable.itsok_animated_thinking -> R.drawable.itsok_animated_thinking_backwards
            R.drawable.itsok_animated_thinking_backwards -> R.drawable.itsok_animated_happy_memento
            R.drawable.itsok_animated_happy_memento -> R.drawable.itsok_animated_happy_memento_backwards
            R.drawable.itsok_animated_happy_memento_backwards -> R.drawable.itsok_animated_happy_bye
            R.drawable.itsok_animated_happy_bye -> R.drawable.itsok_animated_happy_bye_backwards
            R.drawable.itsok_animated_happy_bye_backwards -> R.drawable.itsok_animated_wonder
            else -> throw IllegalStateException()
        }
    }

    private fun getDrawableByResId(@DrawableRes drawableResId: Int): Drawable {
        return ResourcesCompat.getDrawable(resources, drawableResId, theme)!!
    }

    private fun startAvatarAnim() {
        (mAvatarView.drawable as AnimatedVectorDrawable).start()
    }

    override fun onStart() {
        super.onStart()

        startAvatarAnim()
    }
}