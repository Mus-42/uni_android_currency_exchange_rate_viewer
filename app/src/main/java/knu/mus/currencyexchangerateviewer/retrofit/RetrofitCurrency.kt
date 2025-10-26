package knu.mus.currencyexchangerateviewer.retrofit

import knu.mus.currencyexchangerateviewer.items.CurrencyItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitCurrency {

    private val BASE_URL = "https://api.privatbank.ua/"

    private var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private var service = retrofit.create(ServiceCurrency::class.java)

    fun getCurrencyExchange(date: String, resultCallback: (CurrencyItem?) -> Unit){
        val call = service.getCurrencyExchange(date)

        call?.enqueue(object: Callback<CurrencyItem?>{
            override fun onResponse(call: Call<CurrencyItem?>, response: Response<CurrencyItem?>) {
                resultCallback(response.body())
            }

            override fun onFailure(call: Call<CurrencyItem?>, t: Throwable) {
                resultCallback(null)
            }
        })
    }
}