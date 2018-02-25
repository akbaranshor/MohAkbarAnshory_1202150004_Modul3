package com.example.android.mohakbaranshory_1202150004_modul3;

/**
 * Buat kelas Water yang menampung nilai dari setiap objek
 * Created by Abay on 2/24/2018.
 */

public class Water {
    // Deklarasi variabel
    String title, descpription, detail;
    int image;

    // Konstruktor
    public Water(String title, String descpription, String detail, int image) {
        this.title = title;
        this.descpription = descpription;
        this.detail = detail;
        this.image = image;
    }

    // Mengembalikkan nilai title
    public String getTitle() {
        return title;
    }
    // Mengembalikkan nilai description
    public String getDescpription() {
        return descpription;
    }
    // Mengembalikkan nilai detail
    public String getDetail() {
        return detail;
    }
    // Mengembalikkan nilai image
    public int getImage() {
        return image;
    }
}
