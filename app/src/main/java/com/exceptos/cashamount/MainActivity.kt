package com.exceptos.cashamount

import android.os.Bundle
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    var animFadeIn: Animation? = null
    var animFadeOut:Animation? = null
    var animZoomIn:Animation? = null
    var animZoomOut:Animation? = null
    var animSlideDown: Animation? = null
    var animTogether:Animation? = null

    var cashAmount: String = "0"
    var inputMade: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_main)

        animFadeIn = AnimationUtils.loadAnimation(applicationContext, R.anim.fade_in)
        animFadeOut = AnimationUtils.loadAnimation(applicationContext, R.anim.fade_out)
        animZoomIn = AnimationUtils.loadAnimation(applicationContext, R.anim.zoom_in)
        animZoomOut = AnimationUtils.loadAnimation(applicationContext, R.anim.zoom_out)
        animTogether = AnimationUtils.loadAnimation(applicationContext, R.anim.together)
        animSlideDown = AnimationUtils.loadAnimation(applicationContext, R.anim.slide_down)

        cash_amount_view.text = CashAmountFormat(cashAmount.toInt())

        zero_text.setOnClickListener {

            zero_text.startAnimation(animZoomIn)
            handleZoomInOutAnimation(animZoomIn!!, zero_text, null)

            animateDigit("0")

        }

        one_text.setOnClickListener {

            one_text.startAnimation(animZoomIn)
            handleZoomInOutAnimation(animZoomIn!!, one_text, null)

            animateDigit("1")

        }

        two_text.setOnClickListener {

            two_text.startAnimation(animZoomIn)
            handleZoomInOutAnimation(animZoomIn!!, two_text, null)
            animateDigit("2")

        }

        three_text.setOnClickListener {

            three_text.startAnimation(animZoomIn)
            handleZoomInOutAnimation(animZoomIn!!, three_text, null)
            animateDigit("3")
        }

        four_text.setOnClickListener {

            four_text.startAnimation(animZoomIn)
            handleZoomInOutAnimation(animZoomIn!!, four_text, null)
            animateDigit("4")
        }

        five_text.setOnClickListener {

            five_text.startAnimation(animZoomIn)
            handleZoomInOutAnimation(animZoomIn!!, five_text, null)
            animateDigit("5")
        }

        six_text.setOnClickListener {

            six_text.startAnimation(animZoomIn)
            handleZoomInOutAnimation(animZoomIn!!, six_text, null)
            animateDigit("6")
        }

        seven_text.setOnClickListener {

            seven_text.startAnimation(animZoomIn)
            handleZoomInOutAnimation(animZoomIn!!, seven_text, null)
            animateDigit("7")
        }

        eight_text.setOnClickListener {

            eight_text.startAnimation(animZoomIn)
            handleZoomInOutAnimation(animZoomIn!!, eight_text, null)
            animateDigit("8")
        }

        nine_text.setOnClickListener {

            nine_text.startAnimation(animZoomIn)
            handleZoomInOutAnimation(animZoomIn!!, nine_text, null)
            animateDigit("9")
        }

        delete_img.setOnClickListener {

            delete_img.startAnimation(animZoomIn)
            handleZoomInOutAnimation(animZoomIn!!, null, delete_img)
            deleteInputAmount()
        }
    }

    fun animateDigit (digit: String) {

        inputMade = true

        if (cashAmount == "0" && inputMade) {

            cash_amount_view.startAnimation(animFadeIn)
            animFadeIn!!.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationRepeat(p0: Animation?) {

                }

                override fun onAnimationEnd(p0: Animation?) {

                    cashAmount += digit
                    cash_amount_view.text = CashAmountFormat(cashAmount.toInt())

                }

                override fun onAnimationStart(p0: Animation?) {
                }

            })

        } else {

            digit_to_animate.text = digit
            digit_to_animate.startAnimation(animTogether)

            animTogether!!.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationRepeat(p0: Animation?) {

                }

                override fun onAnimationEnd(p0: Animation?) {

                    cashAmount += digit
                    digit_to_animate.text = ""
                    cash_amount_view.text = CashAmountFormat(cashAmount.toInt())

                }

                override fun onAnimationStart(p0: Animation?) {
                }

            })
        }

    }

    fun handleZoomInOutAnimation(animation: Animation, textView: TextView?, imageView: ImageView?){

        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(p0: Animation?) {
            }

            override fun onAnimationEnd(p0: Animation?) {
                if(textView != null) {

                    textView.startAnimation(animZoomOut)
                } else {

                    imageView!!.startAnimation(animZoomOut)
                }
            }

            override fun onAnimationStart(p0: Animation?) {
            }
        })
    }

    fun CashAmountFormat(inputAmt: Int): String? {

        return NumberFormat.getNumberInstance(Locale.US).format(inputAmt)
    }

    fun deleteInputAmount() {

        if(cash_amount_view.text != "0") {

            cashAmount = cashAmount.substring(0, cashAmount.length - 1)
            cash_amount_view.text = CashAmountFormat(cashAmount.toInt())
        }
    }

}
