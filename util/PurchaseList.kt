package com.google.ai.sample.util

class PurchaseList {

    private val purchases: MutableList<Purchase> = mutableListOf()

    fun getPurchases(): List<Purchase> {
        return purchases
    }

    fun addPurchase(purchase: Purchase) {
        purchases.add(purchase)
    }

    fun removePurchase(purchase: Purchase) {
        purchases.remove(purchase)
    }
}