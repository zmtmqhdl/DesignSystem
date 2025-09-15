package com.example.data.protoSerializer

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.Serializer
import androidx.datastore.dataStore
import com.example.data.proto.CurrentAccountProto
import java.io.InputStream
import java.io.OutputStream


object CurrentAccountSerializer : Serializer<CurrentAccountProto> {
    override val defaultValue: CurrentAccountProto = CurrentAccountProto.getDefaultInstance()


    override suspend fun readFrom(input: InputStream): CurrentAccountProto =
        CurrentAccountProto.parseFrom(input)

    override suspend fun writeTo(t: CurrentAccountProto, output: OutputStream) {
        t.writeTo(output)
    }
}

val Context.currentAccountDataStore: DataStore<CurrentAccountProto>
        by dataStore(
            fileName = "current_account.pb",
            serializer = CurrentAccountSerializer
        )
