package com.example.android.mohakbaranshory_1202150004_modul3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Membuat adapter agar menjembatani data dan layout
 * Created by Abay on 2/24/2018.
 */

public class WaterAdapter extends RecyclerView.Adapter<WaterAdapter.WaterViewHolder> {
    // Deklarasi variabel
    private ArrayList<Water> mWaterData;
    private Context context;

    // Konstruktor
    public WaterAdapter(Context context, ArrayList<Water> waters) {
        this.context = context;
        mWaterData = waters;
    }

    /**
     * Menyatukan layout list_item dengan recycleview
     *
     * @param parent
     * @param viewType
     * @return
     */

    @Override
    public WaterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WaterViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false));
    }

    /**
     * Mengeset gambar dan teks sekaligus mengetahui posisi
     *
     * @param holder merupakan perwujudan dari kelas WaterViewHolder
     * @param position
     */

    @Override
    public void onBindViewHolder(WaterViewHolder holder, int position) {
        Water currentWater = mWaterData.get(position);
        holder.bindTo(currentWater);
    }


    /**
     * Mengembalikan panjang arraylist
     *
     * @return panjang arraylist
     */
    @Override
    public int getItemCount() {
        return mWaterData.size();
    }

    /**
     * Buat Inner Class, yang mewarisi sifat dari ViewHolder, dan jija diklik maka akan munucul
     * ke detail merk air
     */

    class WaterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        // Deklarasi variabel
        private TextView mTitle, mDescription;
        ImageView mWatersImage;

        // Konstruktor dan menggunakan super, agar bisa mewarisi sifat parent classnya
        public WaterViewHolder(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.title);
            mDescription = itemView.findViewById(R.id.subTitle);
            mWatersImage = itemView.findViewById(R.id.watersImage);
            itemView.setOnClickListener(this);
        }

        // Menyetel gambar dan teks ke ViewHolder
        void bindTo(Water currentWater) {
            mTitle.setText(currentWater.getTitle());
            mDescription.setText(currentWater.getDescpription());
            mWatersImage.setImageResource(currentWater.getImage());
        }

        /**
         * Memasukan nilai ke dalam variabel extra dan mengisinya dengan nilai berdasarkan apa yang
         * kita klik, lalu pindah ke detail layout
         *
         * @param view
         */

        @Override
        public void onClick(View view) {
            Water currentWater = mWaterData.get(getAdapterPosition());
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("title", currentWater.getTitle());
            intent.putExtra("image", currentWater.getImage());
            intent.putExtra("detail", currentWater.getDetail());
            context.startActivity(intent);

        }
    }
}