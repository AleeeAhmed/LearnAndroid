package com.ali.learnandroid.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.ali.learnandroid.Activities.ToolbarCollapsing;
import com.ali.learnandroid.Activities.ToolbarRefresh;
import com.ali.learnandroid.Activities.ToolbarSearch;
import com.ali.learnandroid.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Frag_Toolbar extends Fragment {


    View view;
    Button btnCollapsingToolbar, btnRefresh, btnSearch ;
    public Frag_Toolbar() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_toolbar, container, false);

        getActivity().setTitle("Toolbar");

        btnCollapsingToolbar = view.findViewById(R.id.btnCollapsingToolbar);
        btnRefresh = view.findViewById(R.id.btnRefreshOnToolbar);
        btnSearch = view.findViewById(R.id.btnSearchOnToolbar);

        btnCollapsingToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ToolbarCollapsing.class));
            }
        });

        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ToolbarRefresh.class));
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ToolbarSearch.class));
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        getActivity().setTitle("Toolbar");
        super.onResume();
    }
}
