package tech.project.ikon.transfer.service;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tech.project.ikon.transfer.Result;
import tech.project.ikon.transfer.model.Artikel;
import tech.project.ikon.transfer.rest.IArtikelRest;

public class ArtikelService {

    @Inject
    IArtikelRest artikelRest;

    @Inject
    public ArtikelService() {
    }

    public void getArtikel() {
        artikelRest.artikel().enqueue(new Callback<Artikel>() {
            @Override
            public void onResponse(Call<Artikel> call, Response<Artikel> response) {
                if (response.isSuccessful()) {
                    Artikel artikel = response.body();
                    Result.Success<Artikel> result = new Result.Success<>(artikel);
                    EventBus.getDefault().post(result);
                } else {
                    EventBus.getDefault().post(new Result.Error(new Exception("Ambil data error")));
                }
            }

            @Override
            public void onFailure(Call<Artikel> call, Throwable t) {
                EventBus.getDefault().post("Koneksi Error");
            }
        });
    }
}
