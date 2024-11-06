package tech.project.ikon.ui.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import javax.inject.Inject;

import tech.project.ikon.databinding.ItemArtikelBinding;
import tech.project.ikon.transfer.model.Artikel;
import tech.project.ikon.ui.ArtikelActivity;

public class ArtikelViewAdapter extends RecyclerView.Adapter<ArtikelViewAdapter.MaturityNpViewHolder> {

    ItemArtikelBinding binding;
    ArrayList<Artikel> dataList;
    ButtonSelected buttonSelected;

    public interface ButtonSelected {
        void onItemButtonSelected(Artikel artikel);
    }

    @Inject
    public ArtikelViewAdapter() {
        this.dataList = new ArrayList<>();
    }
    public void setButtonSelected(ButtonSelected buttonSelected) {
        this.buttonSelected = buttonSelected;
    }

    @NonNull
    @Override
    public ArtikelViewAdapter.MaturityNpViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemArtikelBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ArtikelViewAdapter.MaturityNpViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtikelViewAdapter.MaturityNpViewHolder holder, int position) {
        if (null != dataList && dataList.size() > 0) {
            holder.bind(dataList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class MaturityNpViewHolder extends RecyclerView.ViewHolder {

        private final ItemArtikelBinding itemBinding;

        public MaturityNpViewHolder(ItemArtikelBinding binding) {
            super(binding.getRoot());
            itemBinding = binding;
        }

        public void bind(Artikel artikel) {
            itemBinding.title.setText(artikel.getTitle());
            itemBinding.body.setText(artikel.getBody());

            itemBinding.lineArtikel.setOnClickListener(v -> buttonSelected.onItemButtonSelected(artikel));
        }
    }

    public void insertData(ArrayList<Artikel> data) {
        dataList = new ArrayList<>();
        dataList.addAll(data);
        notifyDataSetChanged();
    }

    public ArrayList<Artikel> getList() {
        return dataList;
    }

    public void updateDataList(ArrayList<Artikel> data, String search) {
        dataList = new ArrayList<>();
        for (Artikel model : data) {
            final String title = model.getTitle() != null ? model.getTitle().toLowerCase() : "";

            if (title.contains(search.toLowerCase())) {
                dataList.add(model);
            }
        }
        notifyDataSetChanged();
    }
}
