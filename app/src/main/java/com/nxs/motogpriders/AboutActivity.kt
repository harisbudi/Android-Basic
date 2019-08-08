package com.nxs.motogpriders

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nxs.motogpriders.adapter.CircleTransform
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "About Me"
        }

        myName.text = "Haris Budi Erwanto"
        myEmail.text = "thehariest@gmail.com"
        Picasso.get()
            .load(R.drawable.my_profile)
            .transform(CircleTransform())
            .into(myImage)
    }
}
