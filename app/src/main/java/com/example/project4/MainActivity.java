package com.example.project4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editUrl;
    private EditText editLokasi;
    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        editUrl = findViewById(R.id.edit_url);
        editLokasi = findViewById(R.id.edit_lokasi);
        editText = findViewById(R.id.edit_text);
    }

    public void openWebsite(View view) {
        String url = editUrl.getText().toString();
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
    }

    public void openLocation(View view) {
        String lokasi = editLokasi.getText().toString();
        Uri address = Uri.parse("geo:0,0?q=" + lokasi);
        Intent intent = new Intent(Intent.ACTION_VIEW, address);
        startActivity(intent);
    }

    public void shareText(View view) {
        String share = editText.getText().toString();
        ShareCompat.IntentBuilder
                .from(this)
                .setChooserTitle("Share this text with: ")
                .setText(share)
                .setType("text/plain")
                .startChooser();

    }

}