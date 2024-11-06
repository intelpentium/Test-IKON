package tech.project.ikon.ui;

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
import tech.project.ikon.databinding.ActivityArtikelBinding;
import tech.project.ikon.transfer.Result;
import tech.project.ikon.transfer.model.Artikel;
import tech.project.ikon.ui.Adapter.ArtikelViewAdapter;
import tech.project.ikon.viewmodel.ArtikelViewModel;

@AndroidEntryPoint
public class ArtikelActivity extends AppCompatActivity {

    @Inject
    ArtikelViewModel viewModel;
    @Inject
    ArtikelViewAdapter ArtikelViewAdapter;

    private ActivityArtikelBinding binding;
    private LoadingDialog loadingDialog;

    private Artikel dataList;
    ArrayList<Artikel> dataListAll = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityArtikelBinding.inflate(getLayoutInflater());
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
        Objects.requireNonNull(getSupportActionBar()).setTitle("Artikel");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initView() {
        loadingDialog = new LoadingDialog(this);

        loadingDialog.show();

        viewModel.getArtikel();

        binding.rcvData.setAdapter(ArtikelViewAdapter);
    }

    private void handleState() {
        viewModel.getArtikelMutableLiveData().observe(this,
                dataList -> setDataNp(dataList));
    }

    private void setDataNp(ArrayList<Artikel> artikel) {
        ArtikelViewAdapter.insertData(artikel);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onDataNp(Result.Success result) {
        loadingDialog.dismiss();
        if (result.getData() instanceof Artikel) {
            try {
                ArrayList<Artikel> dataNp = (ArrayList<Artikel>) result.getData();
                viewModel.setArtikelMutableLiveData(dataNp);
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
