package com.example.applistadecompras.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applistadecompras.R;
import com.example.applistadecompras.model.Item;
import com.example.applistadecompras.model.User;
import com.example.applistadecompras.repository.ItemSQLRepository;

public class ItensAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ItemSQLRepository banco;
    private String idLista;

    public ItensAdapter(ItemSQLRepository banco, String idLista) {
        this.banco = banco;
        this.idLista = idLista;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutVH = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_vh, parent, false);
        return new ItensAdapter.ItemViewHolder(layoutVH);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Item obj = banco.getItemByLista(idLista).get(position);
        ((TextView) holder.itemView.findViewById(R.id.textViewVH_ITEM)).setText(obj.getNomeitem());


    }

    @Override
    public int getItemCount() {
        return banco.getItemByLista(idLista).size();

    }


    class ItemViewHolder extends RecyclerView.ViewHolder {
        public View view;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
        }

    }
}
