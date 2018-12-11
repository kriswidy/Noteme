package com.example.krisandroid.noteme.Rest;

import com.example.krisandroid.noteme.Models.AddNoteResponse;
import com.example.krisandroid.noteme.Models.Note;
import com.example.krisandroid.noteme.Models.NoteResponse;
import com.example.krisandroid.noteme.Models.RegistrasiUser;
import com.example.krisandroid.noteme.Models.ResponseDelete;
import com.example.krisandroid.noteme.Models.UserResponse;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/**
 * Created by kris on 09/12/18.
 */

public interface ApiInterface {
    @FormUrlEncoded
    @POST("login")
    Call<UserResponse> loginRequest(@Field("username") String username);

    @FormUrlEncoded
    @POST("register")
    Call<RegistrasiUser> regisUser(@Field("email") String email,
                                   @Field("username") String username,
                                   @Field("password") String password);

    @FormUrlEncoded
    @POST("note/note")
    Call<NoteResponse> tampilNote (@Field("id_user") String id_user);

    @FormUrlEncoded
    @POST("note")
    Call<AddNoteResponse> tambahNote (@Field("id_user") String id_user,
                                      @Field("judul") String judul,
                                      @Field("note") String note,
                                      @Field("tanggal") String tanggal);

    @FormUrlEncoded
    @PUT("note")
    Call<ResponseDelete> updateNote (@Field("judul") String judul,
                                     @Field("note") String note);

    @FormUrlEncoded
    @POST("note/delete")
    Call<ResponseDelete> deleteNote(@Field("judul") String judul);

}
