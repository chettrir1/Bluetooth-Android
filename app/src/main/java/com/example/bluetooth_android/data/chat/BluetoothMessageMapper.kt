package com.example.bluetooth_android.data.chat

import com.example.bluetooth_android.domain.chat.BluetoothMessage

fun BluetoothMessage.toByteArray(): ByteArray {
    return "$senderName#$message".encodeToByteArray()
}

fun String.toBluetoothMessage(isFromLocalUser: Boolean): BluetoothMessage {
    val name = substringBeforeLast("#")
    val message = substringAfter("#")
    return BluetoothMessage(senderName = name, message = message, isFromLocalUser = isFromLocalUser)
}