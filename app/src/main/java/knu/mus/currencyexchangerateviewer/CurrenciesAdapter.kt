package knu.mus.currencyexchangerateviewer

import android.view.LayoutInflater
import android.view.View
import android.util.Log
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import knu.mus.currencyexchangerateviewer.items.ExchangeRate

class CurrenciesAdapter :
    ListAdapter<ExchangeRate, CurrenciesAdapter.ViewHolder>(ItemDiffCallback) {

    init {
        Log.d(TAG, "CurrenciesAdapter init")
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val currency: TextView = view.findViewById(R.id.currency)
        val buy: TextView = view.findViewById(R.id.buy)
        val sell: TextView = view.findViewById(R.id.sell)

        fun bind(item: ExchangeRate) {
            currency.text = item.currency
            buy.text = item.purchaseRate.toString()
            sell.text = item.saleRate.toString()
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

object ItemDiffCallback : DiffUtil.ItemCallback<ExchangeRate>() {
    override fun areItemsTheSame(oldItem: ExchangeRate, newItem: ExchangeRate): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ExchangeRate, newItem: ExchangeRate): Boolean {
        return oldItem.currency == newItem.currency
    }
}
