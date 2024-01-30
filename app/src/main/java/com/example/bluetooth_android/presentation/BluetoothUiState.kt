package com.example.bluetooth_android.presentation

import com.example.bluetooth_android.domain.chat.BluetoothDevice
import com.example.bluetooth_android.domain.chat.BluetoothMessage

data class BluetoothUiState(
    val scannedDevices: List<BluetoothDevice> = emptyList(),
    val pairedDevices: List<BluetoothDevice> = emptyList(),
    val isConnected: Boolean = false,
    val isConnecting: Boolean = false,
    val errorMessage: String? = null,
    val message: List<BluetoothMessage> = emptyList()
)
