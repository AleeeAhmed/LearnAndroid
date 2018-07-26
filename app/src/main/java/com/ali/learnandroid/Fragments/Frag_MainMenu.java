package com.ali.learnandroid.Fragments;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.ali.learnandroid.R;
import com.ali.learnandroid.Utils.ExitDialog;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag_MainMenu extends Fragment {

    //region initializations
    View view;
    RelativeLayout rlMainMenu;
    FragmentTransaction fragmentTransaction;
    Button btnAlertDialogs, btnToasts, btnFAB, btnSnackBars, btnAsyncTasks;
    Button btnExtras, btnPopUpMenu, btnToolbar, btnPickers, btnAnimations;
    Button btnLists, btn2;//, btnFAB, btnSnackBars, btnAsyncTasks;
    private Animation animFadeIn, animFadeOut, animZoomIn, animZoomOut, animRotate, animZoomInRotate;
    private Animation animMove, animMainMenu1, animMainMenu2, animBounce;//, animZoomOut, animRotate, animZoomInRotate;
    Button[] allButtons;
    //endregion

    public Frag_MainMenu() {
        // Required empty public constructor
    }

    private void init() {

        fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();

        btnAlertDialogs = view.findViewById(R.id.btnAlertDialogs);
        btnToasts = view.findViewById(R.id.btnToasts);
        btnSnackBars = view.findViewById(R.id.btnSnackBar);
        btnFAB = view.findViewById(R.id.btnFAB);
        btnExtras = view.findViewById(R.id.btnExtras);
        btnAsyncTasks = view.findViewById(R.id.btnAsyncTask);
        btnPopUpMenu = view.findViewById(R.id.btnPopUpMenu);
        btnToolbar = view.findViewById(R.id.btnToolbar);
        btnPickers = view.findViewById(R.id.btnPickers);
        btnAnimations = view.findViewById(R.id.btnAnimations);
        btnLists = view.findViewById(R.id.btnLists);
        btn2 = view.findViewById(R.id.btn2);

        rlMainMenu = view.findViewById(R.id.RL_MainMenu);

        allButtons = new Button[]{btnToolbar, btnPickers, btnAlertDialogs, btnPopUpMenu,
                btnToasts, btnSnackBars, btnFAB, btnAsyncTasks, btnExtras, btnAnimations, btnLists, btn2};

    }

    @Override
    public void onResume() {
        getActivity().setTitle("Learn Android");
        super.onResume();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_menu, container, false);

        init();     //initializing all views
        loadAnimations();   //initializing  animations



        //applying animation on all buttons
        for (Button button : allButtons) {
            button.startAnimation(animZoomInRotate);
    /*            YoYo.with(Techniques.FadeInLeft)
                        .duration(3100)
                        .playOn(button);*/
        }


        //setting title of Toolbar
        getActivity().setTitle("Learn Android");


        btnAlertDialogs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyAnimation(btnAlertDialogs);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fragmentTransaction.replace(R.id.fl_Home,
                                new Frag_AlertDialogs()).addToBackStack(null).commit();
                    }
                }, 1400);
            }
        });

        btnFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyAnimation(btnFAB);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fragmentTransaction.replace(R.id.fl_Home, new Frag_FAB()).addToBackStack(null).commit();
                    }
                }, 1400);
            }
        });

        btnSnackBars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyAnimation(btnSnackBars);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fragmentTransaction.replace(R.id.fl_Home, new Frag_SnackBars()).addToBackStack(null).commit();
                    }
                }, 1400);

            }
        });

        btnExtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyAnimation(btnExtras);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fragmentTransaction.replace(R.id.fl_Home, new Frag_Extras()).addToBackStack(null).commit();
                    }
                }, 1400);

            }
        });

        btnAsyncTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyAnimation(btnAsyncTasks);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fragmentTransaction.replace(R.id.fl_Home, new Frag_AsyncTasks()).addToBackStack(null).commit();
                    }
                }, 1400);

            }
        });

        btnToasts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyAnimation(btnToasts);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fragmentTransaction.replace(R.id.fl_Home, new Frag_Toasts()).addToBackStack(null).commit();
                    }
                }, 1400);

            }
        });

        btnPopUpMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyAnimation(btnPopUpMenu);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fragmentTransaction.replace(R.id.fl_Home, new Frag_PopUpMenu()).addToBackStack(null).commit();
                    }
                }, 1400);

            }
        });

        btnToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyAnimation(btnToolbar);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fragmentTransaction.replace(R.id.fl_Home, new Frag_Toolbar()).addToBackStack(null).commit();
                    }
                }, 1400);

            }
        });

        btnPickers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyAnimation(btnPickers);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fragmentTransaction.replace(R.id.fl_Home, new Frag_Pickers()).addToBackStack(null).commit();
                    }
                }, 1400);

            }
        });

        btnAnimations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyAnimation(btnAnimations);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fragmentTransaction.replace(R.id.fl_Home, new Frag_Anim()).addToBackStack(null).commit();
                    }
                }, 1400);

            }
        });
        btnLists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyAnimation(btnLists);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fragmentTransaction.replace(R.id.fl_Home, new Frag_Lists()).addToBackStack(null).commit();
                    }
                }, 1400);

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //applyAnimation(btnAnimations);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getActivity(), "Under Construction..", Toast.LENGTH_SHORT).show();
                    }
                }, 1400);

            }
        });


        //on back button clicked
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                    ExitDialog.show(getActivity());
                    return true;
                }
                return false;
            }
        });

        return view;
    }


    //Applying after click on button animations
    public void applyAnimation(final Button btnClicked) {

        for (Button button : allButtons) {
            if (button == btnClicked) {
                button.startAnimation(animMainMenu2);
            } else {
                button.startAnimation(animMainMenu1);
            }
        }
        animMainMenu1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                for (Button button : allButtons) {
                    if (button != btnClicked) {
                        button.setVisibility(View.INVISIBLE);
                    }
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }

    //intializing animations
    private void loadAnimations() {
        //Loading Animations

        animFadeIn = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_in);
        animFadeOut = AnimationUtils.loadAnimation(getActivity(),R.anim.fade_out);
        animZoomIn = AnimationUtils.loadAnimation(getActivity(),R.anim.zoom_in);
        animZoomOut = AnimationUtils.loadAnimation(getActivity(),R.anim.zoom_out);
        animRotate = AnimationUtils.loadAnimation(getActivity(),R.anim.rotate);
        animZoomInRotate = AnimationUtils.loadAnimation(getActivity(),R.anim.zoom_in_rotate);
        animMove = AnimationUtils.loadAnimation(getActivity(),R.anim.move);
        animBounce = AnimationUtils.loadAnimation(getActivity(),R.anim.bounce);
        animMainMenu1 = AnimationUtils.loadAnimation(getActivity(),R.anim.main_menu_anim_one);
        animMainMenu2 = AnimationUtils.loadAnimation(getActivity(),R.anim.main_menu_anim_two);

    }


}
