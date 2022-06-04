package com.marufalam.coronaapps.networks;

import com.marufalam.coronaapps.models.CoronaResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface CoronaServiceApi {
    @GET
    Call<CoronaResponseModel> getCoronaService(@Url String url);

}
