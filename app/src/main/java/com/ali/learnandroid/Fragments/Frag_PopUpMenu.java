package com.ali.learnandroid.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ali.learnandroid.Activities.PopUpMenuButtonImage;
import com.ali.learnandroid.Activities.PopUpMenuToolbar;
import com.ali.learnandroid.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Frag_PopUpMenu extends Fragment {

    View view;
    Button btnOnButtonImageClick, btnOnToolbar;


    public Frag_PopUpMenu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_pop_up_menu, container, false);

        getActivity().setTitle("Pop up Menu");

        btnOnButtonImageClick = view.findViewById(R.id.btnButtonPopUpMenu);
        btnOnToolbar = view.findViewById(R.id.btnToolbarPopUpMenu);

        btnOnButtonImageClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(getActivity(), PopUpMenuButtonImage.class));
            }
        });

        btnOnToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(getActivity(), PopUpMenuToolbar.class));
            }
        });


        return view;
    }

}
