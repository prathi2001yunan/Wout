package com.example.wout

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wout.databinding.FramlBinding

class MainAdapter( val listn :List<List1>): RecyclerView.Adapter<MainAdapter.mainClassHolder>() {
    var onItemclick:((List1)->Unit)?=null
    inner class mainClassHolder(val itemBinding: FramlBinding): RecyclerView.ViewHolder(itemBinding.root) {
        fun gun(task: List1) {
            itemBinding.txt12.text = task.tx1
            itemBinding.textView.text=task.tx2
            itemBinding.imageView.setImageResource(task.img)
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mainClassHolder {
        return mainClassHolder(FramlBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return listn.size
    }

    override fun onBindViewHolder(holder: mainClassHolder, position: Int) {
        val model:List1 = listn[position]
        holder.gun(model)
        holder.itemView.setOnClickListener{
            onItemclick?.invoke(model)

        }
    }
}