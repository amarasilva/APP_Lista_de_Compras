package com.example.applistadecompras.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applistadecompras.R;
import com.example.applistadecompras.model.Lista;
import com.example.applistadecompras.model.User;
import com.example.applistadecompras.repository.ListaSQLRepository;
import com.example.applistadecompras.view.CadastroItensActivity;

public class ListaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ListaSQLRepository banco;
    String user;
    public ListaAdapter(ListaSQLRepository banco, String user) {
        this.user = user;
        this.banco = banco;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutVH = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_lista_vh, parent, false);
        return new ListaAdapter.ListaViewHolder(layoutVH);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(!banco.getListaByLogin(user).isEmpty()&&position<banco.getListaByLogin(user).size()){
            Lista obj = banco.getListaByLogin(user).get(position);
            ((TextView) holder.itemView.findViewById(R.id.textViewVH_LISTANOME)).setText(obj.getNome());

            //insere clic no viewholder
            holder.itemView.setOnClickListener((view)->{
                Intent intent = new Intent(view.getContext(), CadastroItensActivity.class);
                view.getContext().startActivity(intent);
            });
        }
    }

    @Override
    public int getItemCount() {
        return banco.getListaByLogin(user).size();

    }


    class ListaViewHolder extends RecyclerView.ViewHolder {
        public View view;

        public ListaViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
        }

    }
}
