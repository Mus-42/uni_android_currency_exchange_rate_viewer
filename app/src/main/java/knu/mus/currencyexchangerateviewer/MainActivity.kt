package knu.mus.currencyexchangerateviewer

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import knu.mus.currencyexchangerateviewer.items.ExchangeRate

class MainActivity : AppCompatActivity() {
    val viewModel by viewModels<CurrencyViewModel>();
    lateinit var dateEditText: EditText;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val adapter = CurrenciesAdapter();

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.setLayoutManager(LinearLayoutManager(this));
        recyclerView.adapter = adapter;

        viewModel.currency.observe(this) { newExchangeRates: List<ExchangeRate> ->
            Log.d(TAG, "submit list ${newExchangeRates.size}")
            adapter.submitList(newExchangeRates)
        }

        viewModel.fetchData(DEFAULT_DATE);

        dateEditText = findViewById(R.id.edit_text_date);

        findViewById<Button>(R.id.button_load).setOnClickListener {
            Log.d(TAG, "Fetching for ${dateEditText.text}");

            viewModel.fetchData(dateEditText.text.toString());
        };
    }

    companion object {
        const val TAG = "CurrMain";
        const val DEFAULT_DATE = "14.10.2025";
    }
}