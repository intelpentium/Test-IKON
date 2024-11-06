package tech.project.ikon.transfer.service;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tech.project.ikon.transfer.Result;
import tech.project.ikon.transfer.model.NasabahPotensial;
import tech.project.ikon.transfer.model.RequestNasabahPotensial;
import tech.project.ikon.transfer.rest.INasabahRest;

public class NasabahPotensialService {
    @Inject
    INasabahRest iNasabahRest;

    @Inject
    public NasabahPotensialService(){}

//    public void getNasabahPotensial(String officerCode){
//        iNasabahRest.nasabahPotensial(officerCode).enqueue(new Callback<NasabahPotensial>() {
//            @Override
//            public void onResponse(Call<NasabahPotensial> call, Response<NasabahPotensial> response) {
//                if (response.isSuccessful()) {
//                    NasabahPotensial nasabahPotensial = response.body();
//                    Result.Success<NasabahPotensial> result = new Result.Success<>(nasabahPotensial);
//                    EventBus.getDefault().post(result);
//                } else {
//                    EventBus.getDefault().post(new Result.Error(new Exception("Ambil Data Error")));
//                }
//            }
//
//            @Override
//            public void onFailure(Call<NasabahPotensial> call, Throwable t) {
//                Log.e("Error Service : ", t.getMessage());
//                EventBus.getDefault().post("Koneksi Service Error");
//            }
//        });
//    }

    public void getNasabahPotensial(RequestNasabahPotensial requestNasabahPotensial){
        iNasabahRest.nasabahPotensial(requestNasabahPotensial).enqueue(new Callback<NasabahPotensial>() {
            @Override
            public void onResponse(Call<NasabahPotensial> call, Response<NasabahPotensial> response) {
                Log.e("BISMILLAH", ""+response.body());
                if (response.isSuccessful()) {
                    NasabahPotensial nasabahPotensial = response.body();
                    Result.Success<NasabahPotensial> result = new Result.Success<>(nasabahPotensial);
                    EventBus.getDefault().post(result);
                } else {
                    EventBus.getDefault().post(new Result.Error(new Exception("Ambil Data Error")));
                }
            }

            @Override
            public void onFailure(Call<NasabahPotensial> call, Throwable t) {
                Log.e("Error Service : ", t.getMessage());
                EventBus.getDefault().post("Koneksi Service Error");
            }
        });
    }
}
