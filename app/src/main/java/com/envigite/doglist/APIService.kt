package com.envigite.doglist

import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface APIService {
//    @Headers("Accept: application/json")  Es la forma sencilla de hacer un header, cuando el proyecto es pequeño y tiene pocas llamadas.
    //    La otra es meter un header a travez d eun Interceptor.

//    @GET
//    suspend fun getDogsByBreeds(@Url url: String): Response<DogResponse>

    @GET("api/breed/{hound}/images/")
    suspend fun getDogsByBreeds(@Path("hound") breed: String): Response<DogResponse>

    //Ejemplo Query
    @GET("/example/example2/v2/loquesea")
    suspend fun getDogsByBreeds2(@Query("pet") pet: String, @Query("name") name: String): Response<DogResponse>

    //Ejemplo de llamada Post
    @POST
    fun getEverything(@Body examplePostDto: ExamplePostDto): Call<*>

    //Mandar una imágen al servidor
    @Multipart
    @POST
    fun getEverything2(@Part image: MultipartBody.Part): Call<*>
//    val requestBody = RequestBody.create(MediaType.parse(getContentResolver().getType(fileUri)), file);
//    val a = MultipartBody.Part.createFormData("picture", file.getName(), requestBody);
}

//Esta data class debería ir en otro archivo
data class ExamplePostDto(val name: String, val age: Int) //Example Post Data transfer object