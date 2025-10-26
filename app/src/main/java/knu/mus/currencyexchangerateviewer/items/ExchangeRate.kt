package knu.mus.currencyexchangerateviewer.items


import com.google.gson.annotations.SerializedName

data class ExchangeRate(
    @SerializedName("currency")
    val currency: String?,
    @SerializedName("purchaseRate")
    val purchaseRate: Double?,
    @SerializedName("saleRate")
    val saleRate: Double?,
)