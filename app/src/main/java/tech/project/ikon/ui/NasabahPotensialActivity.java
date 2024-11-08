package tech.project.ikon.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Objects;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import tech.project.ikon.common.components.LoadingDialog;
import tech.project.ikon.transfer.Result;
import tech.project.ikon.databinding.ActivityNasabahPotensialBinding;
import tech.project.ikon.transfer.model.NasabahPotensial;
import tech.project.ikon.transfer.model.NasabahPotensialItem;
import tech.project.ikon.transfer.model.NasabahPotensialList;
import tech.project.ikon.transfer.model.RequestNasabahPotensial;
import tech.project.ikon.ui.Adapter.NasabahPotensialViewAdapter;
import tech.project.ikon.viewmodel.NasabahPotensialViewModel;

@AndroidEntryPoint
public class NasabahPotensialActivity extends AppCompatActivity {

    @Inject
    NasabahPotensialViewModel viewModel;
    @Inject
    NasabahPotensialViewAdapter nasabahPotensialViewAdapter;

    private ActivityNasabahPotensialBinding binding;
    private LoadingDialog loadingDialog;

    private NasabahPotensialList dataList;
    ArrayList<NasabahPotensialItem> dataListAll = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNasabahPotensialBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }

        initToolbar();
        initView();
        handleState();
    }

    private void initToolbar() {
        setSupportActionBar(binding.toolbar.toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Nasabah Potensial");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initView() {
        loadingDialog = new LoadingDialog(this);

        loadingDialog.show();

//        viewModel.getDataNasabahPotensial("W0027G");

        RequestNasabahPotensial dataNasPot = new RequestNasabahPotensial();
        dataNasPot.setDevice_id("91f0664a98dd9e41");

        viewModel.getDataNasabahPotensial(dataNasPot);


        binding.rcvData.setAdapter(nasabahPotensialViewAdapter);
    }

    private void handleState() {
        viewModel.getNasabahPotensialMutableLiveData().observe(this,
                dataList -> setDataNp(dataList.getNasabahPotensialList()));
    }

    private void setDataNp(NasabahPotensialList nasabahPotensialList) {
//        dataList = nasabahPotensialList;
//
//        dataListAll.addAll(dataList.getCustomerMaturityAll());
//        dataListAll.addAll(dataList.getCustomerTopUp());
//        dataListAll.addAll(dataList.getCustomerDropOut());
//        dataListAll.addAll(dataList.getCustomerProspek());

//        nasabahPotensialViewAdapter.insertData(nasabahPotensialList);

//        Log.e("BISMILLAH", nasabahPotensialList);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onDataNp(Result.Success result) {
        loadingDialog.dismiss();
        if (result.getData() instanceof NasabahPotensial) {
            try {
                NasabahPotensial dataNp = (NasabahPotensial) result.getData();
                viewModel.setNasabahPotensialMutableLiveData(dataNp);
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, "Data Request failed", Toast.LENGTH_LONG).show();
            }
        }
    }



    @Override
    public void onPause() {
        super.onPause();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }
}
