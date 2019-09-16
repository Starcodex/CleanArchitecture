package com.starcodex.cleanarchitecture.data.movies.datasorce.entity

import androidx.room.*


@Entity(
    tableName = "CATEGORIES_MOVIES",
    indices = arrayOf(Index("category_name"),Index("movie_id")),
    primaryKeys = arrayOf("category_name","movie_id"),
    foreignKeys = [
        ForeignKey(
        entity = CategoryEntity::class,
        parentColumns = ["name"],
        childColumns = ["category_name"]
    ), ForeignKey(
            entity = MovieEntity::class,
            parentColumns = ["id"],
            childColumns = ["movie_id"])]
)
class CategoryMovieEntity (
    @ColumnInfo(name = "category_name")
    var category_name: String = "",
    @ColumnInfo(name = "movie_id")
    var movie_id: Int = 0
)