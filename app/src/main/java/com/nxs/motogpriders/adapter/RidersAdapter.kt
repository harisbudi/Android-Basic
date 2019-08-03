package com.nxs.motogpriders.adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nxs.motogpriders.DetailActivity
import com.nxs.motogpriders.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_rider_profile.view.*

class RidersAdapter(
    private val list: MutableList<Profiles>
) : RecyclerView.Adapter<RidersViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RidersViewHolder {
        val holder = RidersViewHolder(
            LayoutInflater.from(p0.context).inflate(R.layout.list_rider_profile, p0, false)
        )
        holder.itemView.setOnClickListener {
            val i = Intent(p0.context, DetailActivity::class.java)
            i.putExtra("RIDER_LIST", list[holder.adapterPosition])
            p0.context.startActivity(i)
        }
        return holder
    }

    override fun getItemCount(): Int = list.size
    override fun onBindViewHolder(holder: RidersViewHolder, position: Int) = holder.bind(list[position])
}

class RidersViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: Profiles) {
        view.name.text = item.name
        view.team.text = item.team
        item.image.let {
            Picasso.get()
                .load(it)
                .transform(CircleTransform())
                .into(view.profileImg)
        }
    }
}