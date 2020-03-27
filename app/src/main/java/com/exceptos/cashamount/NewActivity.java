package com.exceptos.cashamount;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;
import java.util.Locale;

public class NewActivity extends AppCompatActivity {

    Animation animFadeIn;
    Animation animFadeOut;
    Animation animZoomIn;
    Animation animZoomOut;
    Animation animSlideDown;
    Animation animTogether;
    Animation animShake;

    TextView zero_text, one_text, two_text,
            three_text, four_text, five_text,
            six_text, seven_text, eight_text,
            nine_text, cash_amount_view, digit_to_animate;

    ImageView delete_img;

    String cashAmount = "0";
    Boolean inputMade = false;

    Context context = this;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        animFadeIn = AnimationUtils.loadAnimation(context, R.anim.fade_in);
        animFadeOut = AnimationUtils.loadAnimation(context, R.anim.fade_out);
        animZoomIn = AnimationUtils.loadAnimation(context, R.anim.zoom_in);
        animZoomOut = AnimationUtils.loadAnimation(context, R.anim.zoom_out);
        animTogether = AnimationUtils.loadAnimation(context, R.anim.together);
        animSlideDown = AnimationUtils.loadAnimation(context, R.anim.slide_down);
        animShake = AnimationUtils.loadAnimation(context, R.anim.shake);

        zero_text = findViewById(R.id.zero_text);
        one_text = findViewById(R.id.one_text);
        two_text = findViewById(R.id.two_text);
        three_text = findViewById(R.id.three_text);
        four_text = findViewById(R.id.four_text);
        five_text = findViewById(R.id.five_text);
        six_text = findViewById(R.id.six_text);
        seven_text = findViewById(R.id.seven_text);
        eight_text = findViewById(R.id.eight_text);
        nine_text = findViewById(R.id.nine_text);
        cash_amount_view = findViewById(R.id.cash_amount_view);
        digit_to_animate = findViewById(R.id.digit_to_animate);
        delete_img = findViewById(R.id.delete_img);

        zero_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                zero_text.startAnimation(animZoomIn);
                handleZoomInOutAnimation(animZoomIn, zero_text, null);
                animateDigit("0");
            }
        });

        one_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                one_text.startAnimation(animZoomIn);
                handleZoomInOutAnimation(animZoomIn, one_text, null);
                animateDigit("1");
            }
        });

        two_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                two_text.startAnimation(animZoomIn);
                handleZoomInOutAnimation(animZoomIn, two_text, null);
                animateDigit("2");
            }
        });

        three_text.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                three_text.startAnimation(animZoomIn);
                handleZoomInOutAnimation(animZoomIn, three_text, null);
                animateDigit("3");
            }
        });

        four_text.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                four_text.startAnimation(animZoomIn);
                handleZoomInOutAnimation(animZoomIn, four_text, null);
                animateDigit("4");
            }
        });

        five_text.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                five_text.startAnimation(animZoomIn);
                handleZoomInOutAnimation(animZoomIn, five_text, null);
                animateDigit("5");
            }
        });

        six_text.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                six_text.startAnimation(animZoomIn);
                handleZoomInOutAnimation(animZoomIn, six_text, null);
                animateDigit("6");
            }
        });

        seven_text.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                seven_text.startAnimation(animZoomIn);
                handleZoomInOutAnimation(animZoomIn, seven_text, null);
                animateDigit("7");
            }
        });

        eight_text.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                eight_text.startAnimation(animZoomIn);
                handleZoomInOutAnimation(animZoomIn, eight_text, null);
                animateDigit("8");
            }
        });

        nine_text.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nine_text.startAnimation(animZoomIn);
                handleZoomInOutAnimation(animZoomIn, nine_text, null);
                animateDigit("9");
            }
        });

        delete_img.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                delete_img.startAnimation(animZoomIn);
                handleZoomInOutAnimation(animZoomIn, null, delete_img);
                deleteInputAmount();
            }
        });
    }

    public void animateDigit (final String digit) {

        inputMade = true;

        if (cashAmount.equals("0") && inputMade) {

            cash_amount_view.startAnimation(animFadeIn);
            animFadeIn.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    cashAmount += digit;
                    cash_amount_view.setText(CashAmountFormat(Integer.parseInt(cashAmount)));
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

        } else if (cashAmount.length() == 8) {
            cash_amount_view.startAnimation(animShake);

        } else {

            digit_to_animate.setText(digit);
            digit_to_animate.startAnimation(animTogether);

            animTogether.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {

                    cashAmount += digit;
                    digit_to_animate.setText("");
                    cash_amount_view.setText(CashAmountFormat(Integer.parseInt(cashAmount)));

                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
        }
    }

    public void handleZoomInOutAnimation(Animation animation, final TextView textView, final ImageView imageView) {

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(textView != null) {

                    textView.startAnimation(animZoomOut);
                } else {

                    imageView.startAnimation(animZoomOut);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public String CashAmountFormat (Integer inputAmt) {

        return NumberFormat.getNumberInstance(Locale.US).format(inputAmt);
    }

    public void deleteInputAmount() {

        if(cash_amount_view.getText() != "0") {

            cashAmount = cashAmount.substring(0, cashAmount.length() - 1);
            cash_amount_view.setText(CashAmountFormat(Integer.parseInt(cashAmount)));
        }
    }
}
