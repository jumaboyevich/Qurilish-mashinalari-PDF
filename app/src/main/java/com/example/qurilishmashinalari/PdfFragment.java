package com.example.qurilishmashinalari;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.qurilishmashinalari.notes.ThemeNote;
import com.github.barteksc.pdfviewer.PDFView;

import java.util.Arrays;
import java.util.Objects;


public class PdfFragment extends Fragment {

    ThemeNote themeNote=new ThemeNote("", new int[]{});


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pdf, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        PDFView pdfView = view.findViewById(R.id.pdfView);

      String txt_array =  requireArguments().getString("data");

        int[] arr = Arrays.stream(txt_array.substring(1, txt_array.length()-1).split(","))
                .map(String::trim).mapToInt(Integer::parseInt).toArray();

        pdfView.fromAsset("book.pdf")
                .pages(arr)
                .load();

    }
}