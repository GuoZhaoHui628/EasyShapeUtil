package com.kstar.easyshapeutil;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tv1,tv2,tv3,tv4;
    private TextView v1,v2,v3,v4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) this.findViewById(R.id.tv1);
        tv2 = (TextView) this.findViewById(R.id.tv2);
        tv3 = (TextView) this.findViewById(R.id.tv3);
        tv4 = (TextView) this.findViewById(R.id.tv4);

        v1 = (TextView) this.findViewById(R.id.v1);
        v2 = (TextView) this.findViewById(R.id.v2);
        v3 = (TextView) this.findViewById(R.id.v3);
        v4 = (TextView) this.findViewById(R.id.v4);
        v1.setOnClickListener(this);
        v2.setOnClickListener(this);
        v3.setOnClickListener(this);
        v4.setOnClickListener(this);

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View v) {
        Drawable background = v.getBackground();
        TextView tv = (TextView) v;
        int cornerDP = Integer.parseInt(tv.getText().toString());
        float cornerSize = this.getResources().getDisplayMetrics().density*cornerDP;
        if(background instanceof ColorDrawable){
            ColorDrawable colordDrawable = (ColorDrawable) background;
            int color = colordDrawable.getColor();
            EasyShapeUtils.setShapeColor(tv1,color);
            EasyShapeUtils.setShapeCorner2Color(tv2,color,cornerSize);
            EasyShapeUtils.setShapeCorner2Color2Stroke(tv3,color,cornerSize,getRandomColor(), (int) (cornerSize/2));
            EasyShapeUtils.setShapeGradient(tv4,new int[]{getRandomColor(),color,getRandomColor()});
        }

    }

    /**
     * 获取随机颜色
     * @return
     */
    private int getRandomColor(){
        Random random = new Random();
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return Color.rgb(r,g,b);
    }
}
