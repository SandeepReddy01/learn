package com.amar.org.getdata;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by govt on 21-10-2017.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private ArrayList<Menu> menuList;
    public Context context;

    public DataAdapter(Context context, List<Menu> menuList){
        this.context = context;
        this.menuList = (ArrayList<Menu>) menuList;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_data, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        holder.view.setBackgroundColor(position % 2 == 0 ? Color.CYAN : Color.LTGRAY);
        final Menu menu = menuList.get(position);
        holder.idText.setText("ID: "+menuList.get(position).getId());
        holder.nameText.setText("Name: "+menuList.get(position).getName());
        holder.priceText.setText("Price: "+menuList.get(position).getPrice());
        holder.descText.setText("Description: "+menuList.get(position).getDesctiption());

        Picasso.with(context)
                .load(menuList.get(position).getThumbnail())
                .transform(new RoundedTransformation(100, 0))
                .resize(64, 64).into(holder.imageView);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context," "+menu.getName(),Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView idText, nameText, descText, priceText;
        private ImageView imageView;
        View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            idText = (TextView) itemView.findViewById(R.id.itext_id);
            nameText = (TextView) itemView.findViewById(R.id.itext_name);
            descText = (TextView) itemView.findViewById(R.id.itext_desc);
            priceText = (TextView) itemView.findViewById(R.id.itext_price);
            imageView = (ImageView) itemView.findViewById(R.id.image_view);

        }
    }
}
