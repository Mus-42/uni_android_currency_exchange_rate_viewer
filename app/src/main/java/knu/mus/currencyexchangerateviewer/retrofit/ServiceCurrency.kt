package knu.mus.currencyexchangerateviewer.retrofit

import knu.mus.currencyexchangerateviewer.items.CurrencyItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

//https://api.privatbank.ua/p24api/exchange_rates?date=01.12.2014
interface ServiceCurrency {
    @GET("p24api/exchange_rates?")
    fun getCurrencyExchange(
        @Query("date") date: String?,
    ): Call<CurrencyItem?>?
}