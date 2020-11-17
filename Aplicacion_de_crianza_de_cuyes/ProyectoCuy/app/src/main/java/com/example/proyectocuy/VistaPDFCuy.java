package com.example.proyectocuy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;

public class VistaPDFCuy extends AppCompatActivity {
    private PDFView pdfView;
    private File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_p_d_f_cuy);
        pdfView=findViewById(R.id.pdfCuy);

        Bundle bundle=getIntent().getExtras();
        if (bundle!=null){
            file=new File(bundle.getString("path",""));
        }
        pdfView.fromFile(file).enableSwipe(true).swipeHorizontal(false).enableDoubletap(true).enableAntialiasing(true).load();
    }
}