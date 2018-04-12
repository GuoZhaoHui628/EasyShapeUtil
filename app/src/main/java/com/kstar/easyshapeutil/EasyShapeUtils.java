package com.kstar.easyshapeutil;

import android.graphics.LinearGradient;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;

import static android.graphics.drawable.GradientDrawable.LINEAR_GRADIENT;


/**
 * Created by ${GuoZhaoHui} on 2018/4/12.
 * Email:guozhaohui628@gmail.com
 */

public class EasyShapeUtils {

    /**
     * 设置 shape 的颜色
     * @param view
     * @param solidColor
     */
    public static void setShapeColor(View view,int solidColor){
        if(view == null){
            return;
        }
        GradientDrawable gradientDrawable = (GradientDrawable) view.getBackground();
        gradientDrawable.setColor(solidColor);
    }

    /**
     * 设置shape倒角和颜色
     * @param view
     * @param solidColor
     * @param corner
     */
    public static void setShapeCorner2Color(View view, int solidColor, float corner){
        if(view == null){
            return;
        }
        GradientDrawable gradientDrawable = (GradientDrawable) view.getBackground();
        gradientDrawable.setColor(solidColor);
        gradientDrawable.setCornerRadius(corner);
    }

    /**
     * 设置shape倒角 颜色 和描边颜色和大小
     * @param view
     * @param solidColor
     * @param corner
     */
    public static void setShapeCorner2Color2Stroke(View view, int solidColor, float corner,int strokeColor,int strokeWidth){
        if(view == null){
            return;
        }
        GradientDrawable gradientDrawable = (GradientDrawable) view.getBackground();
        gradientDrawable.setColor(solidColor);
        gradientDrawable.setCornerRadius(corner);
        gradientDrawable.setStroke(strokeWidth, strokeColor);
    }

    /**
     * 设置矩形渐变，同时shape渐变类型只能是线性从上倒下，颜色数组中的顺序即是渐变顺序
     * @param view
     * @param colors
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public static void setShapeGradient(View view, int[] colors){
        if(view == null){
            return;
        }
        if(colors.length > 3){
            return;
        }
        GradientDrawable gradientDrawable = (GradientDrawable) view.getBackground();
        gradientDrawable.setGradientType(LINEAR_GRADIENT);
        gradientDrawable.setColors(colors);
    }

}
