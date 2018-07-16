package com.ali.learnandroid.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.ali.learnandroid.R;
import com.ali.learnandroid.Utils.CopyToClipBoard;
import com.ali.learnandroid.Utils.ZoomImage;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import es.dmoral.toasty.Toasty;

public class AnimationCustom extends AppCompatActivity {
    Button btnFadeIn, btnFadeOut, btnZoomIn, btnZoomOut, btnSlideUp, btnSlideDown,
            btnBounce, btnRotate, btnMove, btnSequential;

    ImageView ivFadeIn, ivFadeOut, ivZoomIn, ivZoomOut, ivSlideUp, ivSlideDown,
            ivBounce, ivRotate, ivMove, ivSequential, ivJava, ivXml;

    private Animation animFadeIn, animFadeOut, animZoomIn, animZoomOut, animRotate, animSequential;
    private Animation animMove, animSlideUp, animSlideDown, animBounce;

    private RelativeLayout rlCustomAnim;

    private void init() {

        ivXml = findViewById(R.id.ivXml);
        ivJava = findViewById(R.id.ivJava);
        ivFadeIn = findViewById(R.id.ivFadeIn);
        ivFadeOut = findViewById(R.id.ivFadeOut);
        ivZoomIn = findViewById(R.id.ivZoomIn);
        ivZoomOut = findViewById(R.id.ivZoomOut);
        ivSlideUp = findViewById(R.id.ivSlideUp);
        ivSlideDown = findViewById(R.id.ivSlideDown);
        ivBounce = findViewById(R.id.ivBounce);
        ivRotate = findViewById(R.id.ivRotate);
        ivMove = findViewById(R.id.ivMove);
        ivSequential = findViewById(R.id.ivSequential);


        btnFadeIn = findViewById(R.id.btnDemoFadeIn);
        btnFadeOut = findViewById(R.id.btnDemoFadeOut);
        btnZoomIn = findViewById(R.id.btnDemoZoomIn);
        btnZoomOut = findViewById(R.id.btnDemoZoomOut);
        btnSlideUp = findViewById(R.id.btnDemoSlideUp);
        btnSlideDown = findViewById(R.id.btnDemoSlideDown);
        btnBounce = findViewById(R.id.btnDemoBounce);
        btnRotate = findViewById(R.id.btnDemoRotate);
        btnMove = findViewById(R.id.btnDemoMove);
        btnSequential = findViewById(R.id.btnDemoSequential);

        rlCustomAnim = findViewById(R.id.RL_CustomAnim);


        animFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        animFadeOut = AnimationUtils.loadAnimation(this,R.anim.fade_out);
        animZoomIn = AnimationUtils.loadAnimation(this,R.anim.zoom_in);
        animZoomOut = AnimationUtils.loadAnimation(this,R.anim.zoom_out);
        animRotate = AnimationUtils.loadAnimation(this,R.anim.rotate);
        animSequential= AnimationUtils.loadAnimation(this,R.anim.sequential);
        animMove = AnimationUtils.loadAnimation(this, R.anim.move);
        animBounce = AnimationUtils.loadAnimation(this,R.anim.bounce);
        animSlideUp = AnimationUtils.loadAnimation(this,R.anim.slide_up);
        animSlideDown = AnimationUtils.loadAnimation(this,R.anim.silde_down);

    }


    @Override
    public void onResume() {
        rlCustomAnim.startAnimation(animFadeIn);
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_custom);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();     //initialisations

        rlCustomAnim.startAnimation(animFadeIn);

        ivJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(AnimationCustom.this, R.drawable.animations_apply);
            }
        });
        ivJava.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(AnimationCustom.this,
                        getResources().getString(R.string.animation_apply));
                return true;
            }
        });

        ivXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(AnimationCustom.this, R.drawable.animations_create_z);
            }
        });
        ivXml.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(AnimationCustom.this,
                        R.string.nothing_here, Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        ivFadeIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(AnimationCustom.this, R.drawable.animation_fade_in);
            }
        });
        ivFadeIn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(AnimationCustom.this,
                        getResources().getString(R.string.animation_fade_in));
                return true;
            }
        });

        ivFadeOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(AnimationCustom.this, R.drawable.animation_fade_out);
            }
        });
        ivFadeOut.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(AnimationCustom.this,
                        getResources().getString(R.string.animation_fade_out));
                return true;
            }
        });

        ivZoomIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(AnimationCustom.this, R.drawable.animations_zoom_in);
            }
        });
        ivZoomIn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(AnimationCustom.this,
                        getResources().getString(R.string.animation_zoom_in));
                return true;
            }
        });

        ivZoomOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(AnimationCustom.this, R.drawable.animations_zoom_out);
            }
        });
        ivZoomOut.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(AnimationCustom.this,
                        getResources().getString(R.string.animation_zoom_out));
                return true;
            }
        });

        ivSlideUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(AnimationCustom.this, R.drawable.animations_slide_up);
            }
        });
        ivSlideUp.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(AnimationCustom.this,
                        getResources().getString(R.string.animation_slide_up));
                return true;
            }
        });

        ivSlideDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(AnimationCustom.this, R.drawable.animations_slide_down);
            }
        });
        ivSlideDown.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(AnimationCustom.this,
                        getResources().getString(R.string.animation_slide_down));
                return true;
            }
        });

        ivBounce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(AnimationCustom.this, R.drawable.animations_bounce);
            }
        });
        ivBounce.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(AnimationCustom.this,
                        getResources().getString(R.string.animation_bounce));
                return true;
            }
        });

        ivMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(AnimationCustom.this, R.drawable.animations_move);
            }
        });
        ivMove.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(AnimationCustom.this,
                        getResources().getString(R.string.animation_move));
                return true;
            }
        });

        ivRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(AnimationCustom.this, R.drawable.animations_rotate);
            }
        });
        ivRotate.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(AnimationCustom.this,
                        getResources().getString(R.string.animation_rotate));
                return true;
            }
        });

        ivSequential.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(AnimationCustom.this, R.drawable.animations_sequential);
            }
        });
        ivSequential.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(AnimationCustom.this,
                        getResources().getString(R.string.animation_sequential));
                return true;
            }
        });

        btnFadeIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnFadeIn.startAnimation(animFadeIn);
            }
        });

        btnFadeOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnFadeOut.startAnimation(animFadeOut);
                animFadeOut.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        btnFadeOut.startAnimation(animFadeIn);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });

        btnZoomIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnZoomIn.startAnimation(animZoomIn);
            }
        });

        btnZoomOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnZoomOut.startAnimation(animZoomOut);
            }
        });

        btnSlideUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSlideUp.startAnimation(animSlideUp);
                animSlideUp.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        btnSlideUp.startAnimation(animSlideDown);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });

        btnSlideDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSlideDown.startAnimation(animSlideDown);
            }
        });

        btnBounce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnBounce.startAnimation(animBounce);
            }
        });

        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnMove.startAnimation(animMove);
            }
        });

        btnRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnRotate.startAnimation(animRotate);
            }
        });

        btnSequential.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSequential.startAnimation(animSequential);
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull
            String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == 100) {
            if (grantResults.length > 0 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                Toasty.success(this, "Permission allowed." +
                        "You can now view and share images. Thank you.", Toast.LENGTH_SHORT).show();

            } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {

                if (ActivityCompat.shouldShowRequestPermissionRationale(AnimationCustom.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                    Toasty.warning(getApplicationContext(),
                            "Please allow Storage Permission to view and share images.",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toasty.error(getApplicationContext(),
                            "You have to allow Storage Permission to view and share images.\n" +
                                    "Goto Permissions and allow the Storage permission.",
                            Toast.LENGTH_LONG).show();
                    Intent intent = new Intent();
                    intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    Uri uri = Uri.fromParts("package", getPackageName(), null);
                    intent.setData(uri);
                    startActivity(intent);
                }
            }
        }

    }

}
