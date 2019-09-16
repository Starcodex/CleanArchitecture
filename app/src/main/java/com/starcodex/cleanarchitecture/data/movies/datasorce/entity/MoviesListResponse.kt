package com.starcodex.cleanarchitecture.data.movies.datasorce.entity

class MoviesListResponse(var results: List<MovieEntity>)

fun MoviesListResponse.mapToDomain() =
    this.results.map { it.mapToDomain() }
