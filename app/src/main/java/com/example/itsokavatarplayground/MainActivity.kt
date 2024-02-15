package com.example.itsokavatarplayground

import android.graphics.drawable.AnimatedVectorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private lateinit var mAvatarView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        mAvatarView = findViewById(R.id.avatar)
    }

    override fun onStart() {
        super.onStart()

        (mAvatarView.drawable as AnimatedVectorDrawable).start()
    }
}