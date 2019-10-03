// Code generated by moshi-kotlin-codegen. Do not edit.
package com.melih.repository.entities

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.lang.NullPointerException
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List

class LaunchesEntityJsonAdapter(moshi: Moshi) : JsonAdapter<LaunchesEntity>() {
    private val options: JsonReader.Options =
            JsonReader.Options.of("id", "launches", "total", "offset", "count")

    private val longAdapter: JsonAdapter<Long> =
            moshi.adapter<Long>(Long::class.java, kotlin.collections.emptySet(), "id")

    private val listOfLaunchEntityAdapter: JsonAdapter<List<LaunchEntity>> =
            moshi.adapter<List<LaunchEntity>>(Types.newParameterizedType(List::class.java, LaunchEntity::class.java), kotlin.collections.emptySet(), "launches")

    private val intAdapter: JsonAdapter<Int> =
            moshi.adapter<Int>(Int::class.java, kotlin.collections.emptySet(), "total")

    override fun toString(): String = "GeneratedJsonAdapter(LaunchesEntity)"

    override fun fromJson(reader: JsonReader): LaunchesEntity {
        var id: Long? = null
        var launches: List<LaunchEntity>? = null
        var total: Int? = null
        var offset: Int? = null
        var count: Int? = null
        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.selectName(options)) {
                0 -> id = longAdapter.fromJson(reader) ?: throw JsonDataException("Non-null value 'id' was null at ${reader.path}")
                1 -> launches = listOfLaunchEntityAdapter.fromJson(reader) ?: throw JsonDataException("Non-null value 'launches' was null at ${reader.path}")
                2 -> total = intAdapter.fromJson(reader) ?: throw JsonDataException("Non-null value 'total' was null at ${reader.path}")
                3 -> offset = intAdapter.fromJson(reader) ?: throw JsonDataException("Non-null value 'offset' was null at ${reader.path}")
                4 -> count = intAdapter.fromJson(reader) ?: throw JsonDataException("Non-null value 'count' was null at ${reader.path}")
                -1 -> {
                    // Unknown name, skip it.
                    reader.skipName()
                    reader.skipValue()
                }
            }
        }
        reader.endObject()
        var result = LaunchesEntity()
        result = result.copy(
                id = id ?: result.id,
                launches = launches ?: result.launches,
                total = total ?: result.total,
                offset = offset ?: result.offset,
                count = count ?: result.count)
        return result
    }

    override fun toJson(writer: JsonWriter, value: LaunchesEntity?) {
        if (value == null) {
            throw NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.")
        }
        writer.beginObject()
        writer.name("id")
        longAdapter.toJson(writer, value.id)
        writer.name("launches")
        listOfLaunchEntityAdapter.toJson(writer, value.launches)
        writer.name("total")
        intAdapter.toJson(writer, value.total)
        writer.name("offset")
        intAdapter.toJson(writer, value.offset)
        writer.name("count")
        intAdapter.toJson(writer, value.count)
        writer.endObject()
    }
}
