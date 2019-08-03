package com.nxs.motogpriders

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.nxs.motogpriders.adapter.Profiles
import com.nxs.motogpriders.adapter.RidersAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var riderItems: MutableList<Profiles> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initdata()
        recview.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = RidersAdapter(riderItems)
        }
    }

    private fun initdata() {
        val riderName = resources.getStringArray(R.array.riderName)
        val riderImages = resources.obtainTypedArray(R.array.riderImages)
        val riderTeam = resources.getStringArray(R.array.riderTeam)
        val riderDescription = resources.getStringArray(R.array.riderDescription)

        for (i in riderName.indices) {
            riderItems.add(
                Profiles(
                    riderName[i],
                    riderDescription[i],
                    riderImages.getResourceId(i, 0),
                    riderTeam[i]
                )
            )
        }
        riderImages.recycle()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
         when (item.itemId) {
            R.id.action_about -> startActivity(Intent(this, AboutActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }
}
