package com.jibble.test.api

import com.jibble.test.models.Album
import com.jibble.test.models.Post
import com.jibble.test.models.User
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by ogulcan on 07/02/2018.
 */
interface ApiServiceInterface {

    @GET("albums")
    fun getAlbumList(): Observable<Album>

    @GET("albums/{id}")
    fun getAlbum(@Path("id") id: Int): Observable<Album>

    @GET("posts")
    fun getPostList(): Observable<Post>

    @GET("posts/{id}")
    fun getPost(@Path("id") id: Int): Observable<Post>

    @GET("users")
    fun getUserList(): Observable<User>

    @GET("posts/{id}")
    fun getUser(@Path("id") id: Int): Observable<User>

    companion object Factory {
        fun create(): ApiServiceInterface {
            val retrofit = retrofit2.Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("")
                    .build()

            return retrofit.create(ApiServiceInterface::class.java)
        }
    }
}