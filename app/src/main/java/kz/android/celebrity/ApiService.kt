package kz.android.celebrity

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
    @Headers("X-Api-Key:G+7vMUfMQfdL4r7b6y/HoA==AusKrOpk7HdD3rvP")
    @GET("celebrity")
    fun getCelebritiesByName(@Query("name") name: String): Call<List<Celebrity>>
}