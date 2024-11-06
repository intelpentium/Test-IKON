package tech.project.ikon.ui.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import javax.inject.Inject;

import tech.project.ikon.databinding.ItemNasabahPotensialBinding;
import tech.project.ikon.transfer.model.NasabahPotensialItem;


public class NasabahPotensialViewAdapter extends RecyclerView.Adapter<NasabahPotensialViewAdapter
        .MaturityNpViewHolder> {

    ItemNasabahPotensialBinding binding;
    ArrayList<NasabahPotensialItem> dataList;

    @Inject
    public NasabahPotensialViewAdapter() {
        this.dataList = new ArrayList<>();
    }

    @NonNull
    @Override
    public MaturityNpViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemNasabahPotensialBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MaturityNpViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MaturityNpViewHolder holder, int position) {
        if (null != dataList && dataList.size() > 0) {
            holder.bind(dataList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class MaturityNpViewHolder extends RecyclerView.ViewHolder {

        private final ItemNasabahPotensialBinding itemBinding;

        public MaturityNpViewHolder(ItemNasabahPotensialBinding binding) {
            super(binding.getRoot());
            itemBinding = binding;
        }

        public void bind(NasabahPotensialItem nasabahPotensialItem) {
            itemBinding.productName.setText(nasabahPotensialItem.getNo_hp_sender());
            itemBinding.sentraName.setText(nasabahPotensialItem.getNo_hp_receiver());
            itemBinding.maturityDate.setText(nasabahPotensialItem.getPesan());
        }
    }

    public void insertData(ArrayList<NasabahPotensialItem> data) {
        dataList = new ArrayList<>();
        dataList.addAll(data);
        notifyDataSetChanged();
    }

    public ArrayList<NasabahPotensialItem> getList() {
        return dataList;
    }
}