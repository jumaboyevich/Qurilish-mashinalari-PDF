package com.example.qurilishmashinalari;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qurilishmashinalari.adapters.ListAdapter;
import com.example.qurilishmashinalari.adapters.ThemeAdapter;
import com.example.qurilishmashinalari.notes.ListNote;
import com.example.qurilishmashinalari.notes.ThemeNote;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainFragment extends Fragment implements ThemeAdapter.ItemClickListener {


    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);


        List<ListNote> listNoteList=new ArrayList<>();
        List<ThemeNote> themeNoteList=new ArrayList<>();
        themeNoteList.add(new ThemeNote("1.1. Mashina detallarini o’zaro almashinuvchanligini ta’minlovchi o’lchamlari", new int[]{8,9}));
        themeNoteList.add(new ThemeNote("1.2. Birikmalar", new int[]{9,10,11,12,13,14,15,16,17,18,19}));
        themeNoteList.add(new ThemeNote("1.3. Uzatmalar va ularni turlari", new int[]{20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40}));
        themeNoteList.add(new ThemeNote("1.4. Po’lat arqonlar", new int[]{40,41,42,43,44,45,46,47,48,49,50}));
        themeNoteList.add(new ThemeNote("1.5. O’q, val, podshipnik va muftalar", new int[]{50,51,52,53,54,55,56,57,58,59,60,61}));
        themeNoteList.add(new ThemeNote("1.6. Blok va polistpastlar", new int[]{61,62,63,64,65}));
        themeNoteList.add(new ThemeNote("1.7. To’xtatgichlar va tormozlar", new int[]{65,66,67,68,69,70,71}));
        themeNoteList.add(new ThemeNote("1.8. Tormozlar", new int[]{68,69,70,71,}));
        themeNoteList.add(new ThemeNote("1.9. Qurilish mashinalari haqida umumiy ma’lumot", new int[]{72,73,74,75}));
//        themeNoteList.add(new ThemeNote("", new int[]{1,2,3}));


        listNoteList.add(new ListNote("I-BOB MASHINA DETALLARI HAQIDA UMUMIY MA’LUMOTLAR", themeNoteList));

        RecyclerView recyclerView = view.findViewById(R.id.list_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        ListAdapter adapter = new ListAdapter(requireActivity(), listNoteList, this);

        recyclerView.setAdapter(adapter);

        view.findViewById(R.id.btn_floating).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                List<SearchListItem> searchListItems = new ArrayList<>();
//
//                searchListItems.add(new SearchListItem(1,"Title 1"));
//                searchListItems.add(new SearchListItem(2,"Title 2"));
//                searchListItems.add(new SearchListItem(3,"Title 3"));
//                searchListItems.add(new SearchListItem(4,"Title 4"));
//                SearchableDialog searchableDialog = new SearchableDialog(requireActivity(), searchListItems, "Title");
//                searchableDialog.show();
            }
        });

    }

    @Override
    public void onItemClick(ThemeNote themeNote) {
        Bundle bundle = new Bundle();
        bundle.putString("title", themeNote.getTitle());
        bundle.putString("data", Arrays.toString(themeNote.getPages()));


        navController.navigate(R.id.action_mainFragment_to_pdfFragment, bundle);
    }
}