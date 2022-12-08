package com.example.applistadecompras.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applistadecompras.R;
import com.example.applistadecompras.model.User;
import com.example.applistadecompras.repository.UserSQLRepository;

public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private UserSQLRepository banco;

    public UserAdapter(UserSQLRepository banco) {
        this.banco = banco;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutVH = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_user_vh, parent, false);
        return new UserViewHolder(layoutVH);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        User obj = banco.getUsers().get(position);
        ((TextView) holder.itemView.findViewById(R.id.textViewVH_ITEM)).setText(obj.getLogin());
        ((TextView) holder.itemView.findViewById(R.id.textViewVH_SENHA)).setText(obj.getSenha());

    }

    @Override
    public int getItemCount() {
        return banco.getUsers().size();

    }


    class UserViewHolder extends RecyclerView.ViewHolder {
        public View view;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
        }

    }
}