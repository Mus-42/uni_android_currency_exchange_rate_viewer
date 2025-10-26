package knu.mus.currencyexchangerateviewer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.util.Log
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil

class CurrenciesAdapter :
    ListAdapter<CurrencyItem, CurrenciesAdapter.ViewHolder>(ItemDiffCallback) {

    init {
        Log.d(TAG, "CurrenciesAdapter init")
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView

        init {
            Log.d(TAG, "ViewHolder.init")
            textView = view.findViewById(R.id.textView)
        }

        fun bind(item: CurrencyItem) {
            Log.d(TAG, "BIND")
            // TODO
            textView.text = item.currency
        }
    }

    override fun getItemViewType(position: Int) : Int {
        return 0;
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        Log.d(TAG, "onCreateViewHolder")
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.currency_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder")
        val item = getItem(position)
        holder.bind(item)
    }

    companion object {
        const val TAG = "CurrAdapter";
    }
}

object ItemDiffCallback : DiffUtil.ItemCallback<CurrencyItem>() {
    override fun areItemsTheSame(oldItem: CurrencyItem, newItem: CurrencyItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: CurrencyItem, newItem: CurrencyItem): Boolean {
        return oldItem.currency == newItem.currency
    }
}
