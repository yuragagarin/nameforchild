package ru.ernestoguevara.nameforchild.data.repositories.remote

import retrofit2.http.GET
import retrofit2.http.QueryMap
import ru.ernestoguevara.nameforchild.data.entities.NamePopularDto

interface NamePopularApi {

    @GET("datasets/2011/rows")
    fun getBoyNamePopular(@QueryMap(encoded = true) params: Map<String, String>) : NamePopularDto

    @GET("datasets/2009/rows")
    fun getGirlNamePopular(@QueryMap(encoded = true) params: Map<String, String>) : NamePopularDto
}