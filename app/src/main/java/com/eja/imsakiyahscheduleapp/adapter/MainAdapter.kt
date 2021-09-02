package com.eja.imsakiyahscheduleapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.eja.imsakiyahscheduleapp.R
import com.eja.imsakiyahscheduleapp.model.ModelMain
import kotlinx.android.synthetic.main.list_item_jadwal.view.*


class MainAdapter(
    private var context: Context,
    private var items: List<ModelMain>,
    private var xSelectData: onSelectData
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    interface onSelectData {
        fun onSelected(modelMain: ModelMain?)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.list_item_jadwal,
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val modelMain = items[position]
        holder.tvDateMasehi.text = modelMain.txtDate
        holder.tvDateHijri.text = modelMain.txtDay
        holder.rlPraylist.animation = AnimationUtils.loadAnimation(context, R.anim.anim)
        holder.rlPraylist.setOnClickListener {
            xSelectData.onSelected(modelMain)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemVew: View) : RecyclerView.ViewHolder(itemVew) {

        var rlPraylist: RelativeLayout
        var tvDateMasehi: TextView
        var tvDateHijri: TextView

        init {
            rlPraylist = itemVew.rlPrayList
            tvDateMasehi = itemVew.tvDateMasehi
            tvDateHijri = itemVew.tvDateHijri
        }
    }

}