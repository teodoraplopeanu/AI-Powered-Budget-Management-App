package com.google.ai.sample.util

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object JsonConverter {

    fun convertPurchaseListToJson(purchaseList: PurchaseList): String {
        val gson = Gson()
        return gson.toJson(purchaseList.getPurchases()) // or gson.toJson(purchaseList) if you want to include the list itself as json.
    }

    fun convertJsonToPurchaseList(json: String): PurchaseList {
        val gson = Gson()
        val purchaseList = PurchaseList()
        val type = object : TypeToken<List<Purchase>>() {}.type
        val purchases: List<Purchase> = gson.fromJson(json, type)
        //purchaseList.getPurchases().addAll(purchases)
        return purchaseList
    }
}