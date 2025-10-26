package knu.mus.currencyexchangerateviewer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CurrencyListViewModel : ViewModel() {
    // TODO
    private val _liveData: MutableLiveData<List<CurrencyItem>> = MutableLiveData(listOf())
    val liveData: LiveData<List<CurrencyItem>>
        get() = _liveData

    fun load() {
        _liveData.value = listOf(
            CurrencyItem("UAH", 0.1f, 0.1f),
            CurrencyItem("USD", 0.1f, 0.1f),
            CurrencyItem("U1", 0.1f, 0.1f),
            CurrencyItem("UA", 0.1f, 0.1f),
        )
    }
}