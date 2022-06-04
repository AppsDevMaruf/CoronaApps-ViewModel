package com.marufalam.coronaapps.networks;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CoronaService {
    public static CoronaServiceApi getServiceInstance() {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://corona.lmao.ninja/v2/countries/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(CoronaServiceApi.class);
    }

}
