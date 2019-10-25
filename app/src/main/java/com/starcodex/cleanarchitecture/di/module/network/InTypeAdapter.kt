package com.starcodex.cleanarchitecture.di.module.network

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter

class IntTypeAdapter : TypeAdapter<Int>() {

    override fun read(reader: JsonReader?): Int {
        val defaultInvalidInt = -1

        if (reader == null) return defaultInvalidInt

        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull()
            return defaultInvalidInt
        }

        val stringNumber = reader.nextString()
        return try {
            stringNumber.toInt()
        } catch (e: NumberFormatException) {
            defaultInvalidInt
        }
    }

    override fun write(out: JsonWriter?, value: Int?) {
        out?.value(value)
    }
}