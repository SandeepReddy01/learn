package com.amar.org.getdata;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by govt on 21-10-2017.
 */

public interface MenuApiService {

    @GET("json/menu.json")
    Call<List<Menu>> getMenu();
}
