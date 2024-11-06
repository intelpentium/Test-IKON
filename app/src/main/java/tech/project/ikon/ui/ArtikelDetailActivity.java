package tech.project.ikon.ui;

import static android.app.PendingIntent.getActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import tech.project.ikon.databinding.ActivityArtikelDetailBinding;

public class ArtikelDetailActivity extends AppCompatActivity {

    private ActivityArtikelDetailBinding binding;

    private String userId, id, title, body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityArtikelDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initToolbar();
        initView();
    }

    private void initToolbar() {
        setSupportActionBar(binding.toolbar.toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Artikel Detail");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initView() {
        Bundle extras = this.getIntent().getExtras();
        if(extras != null) {

            userId = ""+extras.get("userId");
            id = ""+extras.get("id");
            title = ""+extras.get("title");
            body = ""+extras.get("body");
        }

        binding.userId.setText(userId);
        binding.id.setText(id);
        binding.title.setText(title);
        binding.body.setText(body);
    }
}
