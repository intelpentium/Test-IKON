package tech.project.ikon.transfer.service;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tech.project.ikon.transfer.Result;
import tech.project.ikon.transfer.model.NasabahPotensial;

public class NasabahPotensialServiceCallback implements Callback<NasabahPotensial> {

    @Override
    public void onResponse(Call<NasabahPotensial> call, Response<NasabahPotensial> response) {
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
}
