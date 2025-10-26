package knu.mus.currencyexchangerateviewer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import knu.mus.currencyexchangerateviewer.items.CurrencyItem
import knu.mus.currencyexchangerateviewer.retrofit.RetrofitCurrency

class CurrencyViewModel {

    private val retrofitObject: RetrofitCurrency = RetrofitCurrency()

    private val _currency = MutableLiveData<CurrencyItem>()
    val currency: LiveData<CurrencyItem>
        get() = _currency

    fun fetchData(date: String){
        retrofitObject.getCurrencyExchange(date){
            _currency.value = it
        }
    }
}