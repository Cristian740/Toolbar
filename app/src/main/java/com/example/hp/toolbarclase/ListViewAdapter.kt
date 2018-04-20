package com.example.hp.toolbarclase

/**
 * Created by Hp on 18/4/2018.
 */
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import java.util.ArrayList
import java.util.Locale

class ListViewAdapter(
        // Declare Variables
        internal var mContext: Context, animalNamesList: MutableList<AnimalNames>) : BaseAdapter() {
        internal var inflater: LayoutInflater
        private var animalNamesList: MutableList<AnimalNames>? = null
        private val arraylist: ArrayList<AnimalNames>

    init {
        this.animalNamesList = animalNamesList
        inflater = LayoutInflater.from(mContext)
        this.arraylist = ArrayList()
        this.arraylist.addAll(animalNamesList)
    }

    inner class ViewHolder {
        internal var name: TextView? = null
    }

    override fun getCount(): Int {
        return animalNamesList!!.size
    }

    override fun getItem(position: Int): AnimalNames {
        return animalNamesList!![position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        var view = view
        val holder: ViewHolder
        if (view == null) {
            holder = ViewHolder()
            view = inflater.inflate(R.layout.listview_items, null)
            // Locate the TextViews in listview_items.xml
            holder.name = view!!.findViewById(R.id.name)
            view.tag = holder
        } else {
            holder = view.tag as ViewHolder
        }
        // Set the results into TextViews
        holder.name!!.setText(animalNamesList!![position].animalName)
        return view
    }

    // Filter Class
    fun filter(charText: String) {
        var charText = charText
        charText = charText.toLowerCase(Locale.getDefault())
        animalNamesList!!.clear()
        if (charText.length == 0) {
            animalNamesList!!.addAll(arraylist)
        } else {
            for (wp in arraylist) {
                if (wp.animalName.toLowerCase(Locale.getDefault()).contains(charText)) {
                    animalNamesList!!.add(wp)
                }
            }
        }
        notifyDataSetChanged()
    }

}