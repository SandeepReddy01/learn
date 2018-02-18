package com.amar.org.getdata;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by govt on 21-10-2017.
 */

public class MenuApiClient {

    private static MenuApiService apiService = null;

    private static void initialize() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .registerTypeAdapterFactory(new TypedArray())
                .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")
                .create();

        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(1, TimeUnit.MINUTES)
                .connectTimeout(1, TimeUnit.MINUTES)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();


        apiService = retrofit.create(MenuApiService.class);
    }

    public static MenuApiService getApiService() {
        initialize();
        return apiService;
    }

}
