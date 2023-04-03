package com.example.datastorage.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.datastorage.MainActivity;
import com.example.datastorage.R;
import com.example.datastorage.User.User;
import com.example.datastorage.crud.userCRUD;
import com.example.datastorage.formUserActivity;
import com.example.datastorage.userEditFormActivity;

import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {
    public UserAdapter(Context context, List<User> objects){
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, @Nullable View convertView, ViewGroup parent) {
        User user = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.layout_listviewuser, parent, false);
        }
        TextView txvNama = (TextView) convertView.findViewById(R.id.txvNama);
        TextView txvTipe = (TextView) convertView.findViewById(R.id.txvTipe);
        TextView txvPanjang = (TextView) convertView.findViewById(R.id.txvPanjang);
        TextView txvStatus = (TextView) convertView.findViewById(R.id.txvStatus);
        txvNama.setText(user.getNama());
        txvTipe.setText(user.getTipe());
        txvPanjang.setText(user.getPanjang());
        txvStatus.setText(user.getStatus());

        Button btnEdit = (Button) convertView.findViewById(R.id.btnEdit);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), userEditFormActivity.class);
                intent.putExtra("status", user.getStatus());
                intent.putExtra("nama", user.getNama());
                intent.putExtra("panjang", user.getPanjang());
                intent.putExtra("tipe", user.getTipe());
                getContext().startActivity(intent);
            }
        });

        Button btnDelete = (Button) convertView.findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userCRUD usercrud = new userCRUD();
                usercrud.deleteDataUser(user.getStatus());
                notifyDataSetChanged();

            }
        });
        return convertView;
    }
}
