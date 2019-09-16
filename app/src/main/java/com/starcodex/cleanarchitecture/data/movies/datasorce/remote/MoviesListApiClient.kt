package com.starcodex.cleanarchitecture.data.movies.datasorce.remote

import com.starcodex.cleanarchitecture.BuildConfig.API_KEY
import com.starcodex.cleanarchitecture.data.movies.datasorce.entity.MoviesListResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesListApiClient {

    @GET("movie/{category}")
    fun getMoviesByCategory(
        @Path("category") category: String,
        @Query("api_key") apikey: String = API_KEY
    ): Observable<MoviesListResponse>
}