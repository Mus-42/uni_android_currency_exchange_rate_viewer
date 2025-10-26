package knu.mus.currencyexchangerateviewer

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    val viewModel by viewModels<CurrencyListViewModel>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val adapter = CurrenciesAdapter();

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.setLayoutManager(LinearLayoutManager(this));
        recyclerView.adapter = adapter;


        // TODO viewModel.someData.onObserve do something with adapter

        viewModel.liveData.observe(this) { newCurrencyItems: List<CurrencyItem> ->
            Log.d(TAG, "submit list ${newCurrencyItems.size}")
            adapter.submitList(newCurrencyItems)
        }

        viewModel.load();
    }

    companion object {
        const val TAG = "CurrMain";
    }
}