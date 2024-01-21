package com.example.bluetooth_android.domain.chat

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface BluetoothController {

    val scannedDevices: StateFlow<List<BluetoothDevice>>

    val paredDevices: StateFlow<List<BluetoothDevice>>

    fun startDiscovery()

    fun stopDiscovery()

    fun startBluetoothServer(): Flow<ConnectionResult>

    fun connectToDevice(device: BluetoothDevice): Flow<ConnectionResult>

    fun closeActiveConnection()
    fun release()
}