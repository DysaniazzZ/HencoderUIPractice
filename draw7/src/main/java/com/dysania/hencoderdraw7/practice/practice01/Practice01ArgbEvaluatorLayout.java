package com.dysania.hencoderdraw7.practice.practice01;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.dysania.hencoderdraw7.R;

public class Practice01ArgbEvaluatorLayout extends RelativeLayout {
    Practice01ArgbEvaluatorView view;
    Button animateBt;

    public Practice01ArgbEvaluatorLayout(Context context) {
        super(context);
    }

    public Practice01ArgbEvaluatorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice01ArgbEvaluatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        view = findViewById(R.id.objectAnimatorView);
        animateBt = findViewById(R.id.animateBt);

        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animator = ObjectAnimator.ofInt(view, "color", 0xffff0000, 0xff00ff00);

                // 修复闪烁问题
                // 1、API 21 后新加入的方法
                // ObjectAnimator animator = ObjectAnimator.ofArgb(view, "color", 0xffff0000, 0xff00ff00);
                // 2、使用 ObjectAnimator.setEvaluator() 来设置 ArgbEvaluator
                animator.setEvaluator(new ArgbEvaluator());

                animator.setInterpolator(new LinearInterpolator());
                animator.setDuration(2000);
                animator.start();
            }
        });
    }
}
