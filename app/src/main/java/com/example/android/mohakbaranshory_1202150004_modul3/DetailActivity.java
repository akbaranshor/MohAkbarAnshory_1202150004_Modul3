package com.example.android.mohakbaranshory_1202150004_modul3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {
    ImageView battery;
    int container = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView textView = findViewById(R.id.titleDetail);
        ImageView imageView = findViewById(R.id.header);
        TextView lorem = findViewById(R.id.detail);
        // Mengambil variabel extra pada intent dan menyetelnya di layout detail
        textView.setText(getIntent().getStringExtra("title"));
        imageView.setImageResource(getIntent().getIntExtra("image", 0));
        lorem.setText(getIntent().getStringExtra("detail"));
        battery = findViewById(R.id.imageView3);

        // Set gambar awal pada detail layout
        battery.setImageResource(R.drawable.ic_battery_20);
    }

    // Method untuk mengurangi air
    public void decrease(View view) {
        if (between(container--, 1, 3)) level(container);
    }

    // Method untuk menambah air
    public void increase(View view) {
        if (between(container++, 1, 3)) level(container);
    }

    /**
     * Membuat batas nilai pada air
     *
     * @param i merupakan nilai air
     * @param minValueInclusive merupakan batas minimal dari level
     * @param maxValueInclusive merupakan batas maksimal dari level
     * @return nilai kembali terhadap ekspresi
     */
    public boolean between(int i, int minValueInclusive, int maxValueInclusive) {
        if (i >= minValueInclusive && i <= maxValueInclusive)  return true;
        else return false;
    }

    /**
     * Memberi level pada jumlah air, jika air bernilai 3 maka, akan muncul toast dan juga mengganti
     * gambar
     * @param lvl nilai yang didapat dari jumlah air
     */
    public void level(int lvl) {
        switch (lvl) {
            case 1:
                battery.setImageResource(R.drawable.ic_battery_20);
                Toast.makeText(this, "Air sedikit", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                battery.setImageResource(R.drawable.ic_battery_50_black_24dp);
                break;
            case 3:
                battery.setImageResource(R.drawable.ic_battery_full_black_24dp);
                Toast.makeText(this, "Air full", Toast.LENGTH_SHORT).show();
                break;
            default:
                if (lvl > 3) { container = 3; }
                else if (lvl < 1) { container = 1; }
        }
    }
}
