package com.soviatul.apk_politeknik.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.soviatul.apk_politeknik.DetailImageActivity
import com.soviatul.apk_politeknik.R
import com.soviatul.apk_politeknik.RecycleCardJurusan
import com.soviatul.apk_politeknik.model.ModelMovie

class jurusanAdapter (
    private val getActivity: RecycleCardJurusan,
    private val jurusanlist: List<ModelMovie>
) : RecyclerView.Adapter<jurusanAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtjurusan: TextView = itemView.findViewById(R.id.txtjurusan)
        val imgjurusan: ImageView = itemView.findViewById(R.id.imgjurusan)
        val cardview: CardView = itemView.findViewById(R.id.cardView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val nview = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemcard, parent, false)
        return MyViewHolder(nview)
    }

    override fun getItemCount(): Int {
        return jurusanlist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // Set data
        holder.txtjurusan.text = jurusanlist[position].title
        holder.imgjurusan.setImageResource(jurusanlist[position].image)

        // Set OnClickListener pada CardView
        holder.cardview.setOnClickListener {
            // Intent untuk membuka DetailImageActivity
            val intent = Intent(getActivity, DetailImageActivity::class.java)

            // Kirim data gambar ke DetailImageActivity
            intent.putExtra("imageResId", jurusanlist[position].image)

            // Mulai activity baru
            getActivity.startActivity(intent)
        }
    }
}