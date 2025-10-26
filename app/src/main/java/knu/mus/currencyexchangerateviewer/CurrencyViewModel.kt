package knu.mus.currencyexchangerateviewer

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import knu.mus.currencyexchangerateviewer.items.ExchangeRate
import knu.mus.currencyexchangerateviewer.retrofit.RetrofitCurrency

class CurrencyViewModel : ViewModel() {

    private val retrofitObject: RetrofitCurrency = RetrofitCurrency()

    private val _currency = MutableLiveData<List<ExchangeRate>>(listOf())
    val currency: LiveData<List<ExchangeRate>>
        get() = _currency

    fun fetchData(date: String){
        retrofitObject.getCurrencyExchange(date){
            if (it?.exchangeRate == null){
                _currency.value = listOf()
            }else{
                _currency.value = it.exchangeRate.filter{ rate ->
                    (rate.purchaseRate != null) or (rate.saleRate != null)
                }
            }
        }
    }
}