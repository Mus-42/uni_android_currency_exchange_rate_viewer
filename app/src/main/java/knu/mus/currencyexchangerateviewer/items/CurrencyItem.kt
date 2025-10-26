package knu.mus.currencyexchangerateviewer.items


import com.google.gson.annotations.SerializedName

data class CurrencyItem(
    @SerializedName("exchangeRate")
    val exchangeRate: List<ExchangeRate>?
)