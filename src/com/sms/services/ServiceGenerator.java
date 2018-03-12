/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.services;

/**
 *
 * @author jilanis
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ServiceGenerator {

    private static final String API_BASE_URL = "http://localhost:5555/";

    private static OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
    
    Gson gson = new GsonBuilder().setLenient().create();


    private Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson));

    public  <S> S createService(Class<S> serviceClass) {
        OkHttpClient httpClient = clientBuilder.build();
        return retrofitBuilder.client(httpClient).build().create(serviceClass);
    }
}