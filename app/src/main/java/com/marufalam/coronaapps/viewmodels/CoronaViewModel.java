package com.marufalam.coronaapps.viewmodels;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.marufalam.coronaapps.models.CoronaResponseModel;
import com.marufalam.coronaapps.networks.CoronaService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CoronaViewModel extends ViewModel {
    final String TAG = ViewModel.class.getSimpleName();
    public MutableLiveData<CoronaResponseModel> coronaResponseModelMutableLD = new MutableLiveData<>();

    public CoronaViewModel() {
        loadCurrentData();
    }

    private void loadCurrentData() {
//https://corona.lmao.ninja/v2/countries/Bangladesh?yesterday=true&strict=true&query
        final String endUrl = String.format("%s?yesterday=true&strict=true&query","Bangladesh");
        CoronaService.getServiceInstance()
                .getCoronaService(endUrl)
                .enqueue(new Callback<CoronaResponseModel>() {

                    @Override
                    public void onResponse(Call<CoronaResponseModel> call, Response<CoronaResponseModel> response) {
                        if (response.code() == 200){
                            coronaResponseModelMutableLD.postValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<CoronaResponseModel> call, Throwable t) {
                        Log.e(TAG, "onFailure: "+t.getLocalizedMessage());

                    }
                });

    }

}
