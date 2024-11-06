package tech.project.ikon.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import tech.project.ikon.transfer.model.NasabahPotensial;
import tech.project.ikon.transfer.model.RequestNasabahPotensial;
import tech.project.ikon.transfer.service.NasabahPotensialService;

public class NasabahPotensialViewModel extends ViewModel {

    @Inject
    public NasabahPotensialViewModel(){}

    @Inject
    NasabahPotensialService nasabahPotensialService;

    MutableLiveData<NasabahPotensial> nasabahPotensialMutableLiveData = new MutableLiveData<>();

//    public void getDataNasabahPotensial(String officerCode){
//        nasabahPotensialService.getNasabahPotensial(officerCode);
//    }

    public void getDataNasabahPotensial(RequestNasabahPotensial requestNasabahPotensial){
        nasabahPotensialService.getNasabahPotensial(requestNasabahPotensial);
    }

    public MutableLiveData<NasabahPotensial> getNasabahPotensialMutableLiveData() {
        return nasabahPotensialMutableLiveData;
    }

    public void setNasabahPotensialMutableLiveData(NasabahPotensial nasabahPotensial){
        this.nasabahPotensialMutableLiveData.postValue(nasabahPotensial);
    }
}
