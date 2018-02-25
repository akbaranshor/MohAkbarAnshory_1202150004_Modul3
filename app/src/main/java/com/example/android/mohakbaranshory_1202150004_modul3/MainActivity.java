package com.example.android.mohakbaranshory_1202150004_modul3;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecycleView;
    private ArrayList<Water> mWaterData;
    private WaterAdapter mAdapter;

    /**
     * Mengeset layout menjadi GridLayout agar adaptif
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecycleView = findViewById(R.id.recycleView);
        // Mengecek dari resource integers.xml dan melihat nilai kolomnya
        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);
        mRecycleView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));
        // Instansiasi array list
        mWaterData = new ArrayList<>();
        // Buat adapter
        mAdapter = new WaterAdapter(this, mWaterData);
        // Set adapter
        mRecycleView.setAdapter(mAdapter);
        // Memanggil method initializeData
        initializeData();
    }

    /**
     * Menginisialisasi data dan mengupdatenya pada adapter
     */

    private void initializeData() {
        TypedArray watersImageRes = getResources().obtainTypedArray(R.array.water_images);
        // Mendapatkan resource dari file XML
        String[] watersList = getResources().getStringArray(R.array.water_images);
        // Mengurangi duplikasi
        mWaterData.clear();
        // Buat ArrayList untuk memasukkan ke dalam kelas Water
        for (int i = 0; i < watersList.length; i++) {
            String[] judul = {"Ades", "Amidis", "Aqua", "Cleo", "Equil", "Evian",
                    "Leminerale", "Nestle", "Pristine", "Vit"};
            mWaterData.add(new Water(judul[i], "Air minum merk " + judul[i], "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                    "Pellentesque accumsan laoreet diam in viverra. Etiam consequat quis ligula id gravida." +
                    " Sed sed maximus nulla. Nunc pulvinar cursus justo eu luctus. Pellentesque pellentesque" +
                    " velit ut tortor imperdiet congue. Proin quam velit, luctus nec placerat eu, vehicula nec sapien. " +
                    "Vestibulum dapibus dictum dapibus. Sed a ipsum vel lectus pharetra auctor. " +
                    "Nam vel arcu quis orci elementum commodo. Duis luctus, risus in faucibus dapibus, diam augue " +
                    "feugiat enim, et eleifend libero augue ac massa.",
                    watersImageRes.getResourceId(i, 0)));
        }
        watersImageRes.recycle();
        mAdapter.notifyDataSetChanged();
    }
}
