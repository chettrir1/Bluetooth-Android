package com.example.bluetooth_android.data.chat

import android.bluetooth.BluetoothSocket
import com.example.bluetooth_android.domain.chat.ConnectionResult
import com.example.bluetooth_android.domain.chat.TransferFailedException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException

class BluetoothDataTransferService(
    private val socket: BluetoothSocket
) {
    fun listenForIncomingMessage(): Flow<ConnectionResult> {
        return flow {
            if (!socket.isConnected) {
                return@flow
            }
            val buffer = ByteArray(1024)
            while (true) {
                val byteCount = try {
                    socket.inputStream.read(buffer)
                } catch (e: IOException) {
                    throw TransferFailedException()
                }
                emit(
                    ConnectionResult.TransferSucceeded(
                        message = buffer.decodeToString(
                            endIndex = byteCount
                        ).toBluetoothMessage(false)
                    )
                )
            }
        }.flowOn(Dispatchers.IO)
    }
}