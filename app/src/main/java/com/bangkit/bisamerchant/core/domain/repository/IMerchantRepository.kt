package com.bangkit.bisamerchant.core.domain.repository

import com.bangkit.bisamerchant.core.domain.model.Merchant
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.firestore.QuerySnapshot
interface IMerchantRepository {
    suspend fun observeMerchantActive(callback: (Merchant) -> Unit): ListenerRegistration

    suspend fun observeMerchants(callback: (List<Merchant>) -> Unit): ListenerRegistration

    fun stopObserving()

    fun processMerchantActiveQuerySnapshot(querySnapshot: QuerySnapshot): Merchant

    fun processMerchantsQuerySnapshot(querySnapshot: QuerySnapshot): List<Merchant>

    suspend fun changeMerchantStatus(id: String?)

    suspend fun getMerchantId(): String

    suspend fun saveMerchantId(id: String)

    suspend fun saveAmountHide(hide: Boolean)

    suspend fun getAmountHide(): Boolean

    suspend fun deleteMerchant()
}