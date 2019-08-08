package com.nxs.motogpriders

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nxs.motogpriders.adapter.CircleTransform
import com.nxs.motogpriders.adapter.Profiles
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val item = intent.getParcelableExtra<Profiles>("RIDER_LIST")

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = item.name
        }

        riderName.text = item.name
        riderTeam.text = item.team
        riderDesc.text = item.description

        Picasso.get()
            .load(item.image)
            .transform(CircleTransform())
            .into(profileImg)
    }
}
