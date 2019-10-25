package com.starcodex.cleanarchitecture.data.movies.datasorce.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.RoomWarnings
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.starcodex.cleanarchitexture.domain.movies.model.MovieItem

@SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
@Entity(tableName = "MOVIE")
class MovieEntity (
    @SerializedName("id")
    @Expose
    @ColumnInfo(name = "id") @PrimaryKey
    var id: Int? = null,

    @SerializedName("title")
    @Expose
    @ColumnInfo(name = "title")
    var title: String? = null,

    @SerializedName("overview")
    @Expose
    @ColumnInfo(name = "overview")
    var overview: String? = null,

    @SerializedName("poster_path")
    @Expose
    @ColumnInfo(name = "poster_path")
    var poster_path: String? = null,

    @SerializedName("original_language")
    @Expose
    @ColumnInfo(name = "original_language")
    var original_language: String? = null,

    @SerializedName("release_date")
    @Expose
    @ColumnInfo(name = "release_date")
    var release_date: String? = null
)

fun MovieEntity.mapToDomain() =
    MovieItem(
        this.id,
        this.title,
        this.overview,
        this.poster_path
    )
