package com.android.lab.data

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest

object NetworkManager: ConnectivityManager.NetworkCallback() {

    private lateinit var connectivityManager: ConnectivityManager

    private val networkRequest = NetworkRequest.Builder()
        .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
        .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
        .build()

    var isConnected: Boolean = false
        private set

    fun start(appContext: Context) {
        connectivityManager = appContext.getSystemService(ConnectivityManager::class.java) as ConnectivityManager
        connectivityManager.requestNetwork(networkRequest, this)
    }

    override fun onAvailable(network: Network) {
        super.onAvailable(network)
        isConnected = true
    }

    override fun onLost(network: Network) {
        super.onLost(network)
        isConnected = false
    }
}
