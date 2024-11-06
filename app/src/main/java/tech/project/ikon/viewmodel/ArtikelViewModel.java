package tech.project.ikon.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import javax.inject.Inject;

import tech.project.ikon.transfer.model.Artikel;
import tech.project.ikon.transfer.service.ArtikelService;

public class ArtikelViewModel extends ViewModel {

    @Inject
    public ArtikelViewModel(){}

    @Inject
    ArtikelService artikelService;

    MutableLiveData<ArrayList<Artikel>> artikelMutableLiveData = new MutableLiveData<>();

    public void getArtikel(){
        artikelService.getArtikel();
    }

    public MutableLiveData<ArrayList<Artikel>> getArtikelMutableLiveData() {
        return artikelMutableLiveData;
    }

    public void setArtikelMutableLiveData(ArrayList<Artikel> artikel){
        this.artikelMutableLiveData.postValue(artikel);
    }
}
