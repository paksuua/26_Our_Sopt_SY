package com.example.soptseminar1weeks.book_recycler
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.soptseminar1weeks.R

class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val title = itemView.findViewById<TextView>(R.id.tv_books)
    val image = itemView.findViewById<ImageView>(R.id.img_books)

    fun bind(bookData: BookData){
        title.text = bookData.title
        Glide.with(itemView).load(bookData.image).into(image)
    }
}