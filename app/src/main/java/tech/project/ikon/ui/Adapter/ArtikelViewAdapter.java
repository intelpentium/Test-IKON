package tech.project.ikon.ui.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import javax.inject.Inject;

import tech.project.ikon.databinding.ItemArtikelBinding;
import tech.project.ikon.transfer.model.Artikel;

public class ArtikelViewAdapter extends RecyclerView.Adapter<ArtikelViewAdapter.MaturityNpViewHolder> {

    ItemArtikelBinding binding;
    ArrayList<Artikel> dataList;

    @Inject
    public ArtikelViewAdapter() {
        this.dataList = new ArrayList<>();
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
}
