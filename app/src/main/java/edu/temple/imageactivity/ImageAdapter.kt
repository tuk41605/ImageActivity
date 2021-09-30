package edu.temple.imageactivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

/*
   ImageAdapter class extends the RecyclerView.Adapter class per instructions.
   I had to do research on the ClickListener implementation, as initially I wasn't
   sure how to approach the issue.
*/

class ImageAdapter(private val itemList: List<SpaceItem>,
    private val listener: ClickListener) :
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.space_item, parent, false)
        return ImageViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val currItem = itemList[position]
        holder.imageView.setImageResource(currItem.image)
    }

    override fun getItemCount() = itemList.size

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener {
       val imageView: ImageView = itemView.findViewById(R.id.space_image_view)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val retrieved = itemList[this.adapterPosition]
            listener.onClick(retrieved)
        }
    }

    interface ClickListener {
        fun onClick(retrieved: SpaceItem)
    }
}