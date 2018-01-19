package com.zph.booklist.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ViewAnimator;

import com.zph.booklist.R;
import com.zph.booklist.opengl.render.BgRender;
import com.zph.booklist.opengl.view.GLSurfaceBg;

public class ActMainLoginIp extends AppCompatActivity implements View.OnClickListener,Runnable {
    private GLSurfaceBg glv;
    private ImageView layout;
    // 颜色的最大值255，中间值127
    private final static int MAX_VALUE = 255, MID_VALUE = 127;
    // 临时 色相，饱和度，明度
    private float mHue, mSaturation, mLum;
    // 被处理的图像
    private Bitmap bitmap;
    // 临时变换值
    private int tempValue = MID_VALUE;
    // 运行标志位
    private boolean runFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        glv = new GLSurfaceBg(this);
//        if (BaseGLESSeting.CheckSupposeGLES(this)) {
//            this.rendererSet = true;
//            glv.setEGLContextClientVersion(2); // Pick an OpenGL ES 2.0 context.
//            glv.setRenderer(new BgRender(this));
//            setContentView(glv);

//            mViewMain.addView(glv);
//        } else {
//            Toast.makeText(this, R.string.not_suppose_opengl, Toast.LENGTH_SHORT).show();
//        }
        setContentView(R.layout.activity_act_main_login_ip);
        this.initView();
    }

    private void initView() {
        layout = findViewById(R.id.layout_id);
//        Animation animation = AnimationUtils.loadAnimation(this,
//                R.anim.bg_ins);
//        animation.setFillAfter(true);
//        layout.startAnimation(animation);

//        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.icoon_bg_login_2);
        bitmap =
        ActMainLoginIp.scaleImage(this, layout, R.mipmap.icoon_bg_login_2);
//        layout.setImageBitmap(bitmap);
//        layout.setImageBitmap(ImageHelper.handleImageEffect(bitmap, mHue, mSaturation, mLum));
        layout.postDelayed(this, 50);
    }

    @Override
    public void onClick(View v) {
    }


    int progress = 0;

    @Override
    public void run() {
        Log.i("TAG", "AAAA");
        layout.setImageBitmap(ImageHelper.handleImageEffect(bitmap, mHue, mSaturation, mLum));

        layout.postDelayed(this, 50);
        if (progress <= 100 && progress >= 5) {
            progress += 5;
        } else {
            progress -= 5;
        }
        mHue = (progress - MID_VALUE) * 1.0f / MID_VALUE * 180;
    }

    public static class ImageHelper {
        /**
         * 处理图像
         *
         * @param bitmap  原图
         * @param degrees 色相值
         * @param sat     饱和度值
         * @param lum     明度值
         * @return 处理后的图像
         */
        public static Bitmap handleImageEffect(Bitmap bitmap, float degrees, float sat, float lum) {
            Log.i("TAG", "height:" + bitmap.getHeight());
            Bitmap temp = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);

            Canvas canvas = new Canvas(temp);

            Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

            // 设置色相
            ColorMatrix hueMatrix = new ColorMatrix();
            hueMatrix.setRotate(0, degrees);
            hueMatrix.setRotate(1, degrees);
            hueMatrix.setRotate(2, degrees);

            // 设置饱和度
            ColorMatrix saturationMatrix = new ColorMatrix();
            saturationMatrix.setSaturation(1);

            // 设置明度
            ColorMatrix lumMatrix = new ColorMatrix();
            lumMatrix.setScale(lum, lum, lum, 0);

            // 融合
            ColorMatrix imageMatrix = new ColorMatrix();
//            imageMatrix.postConcat(lumMatrix);
            imageMatrix.postConcat(saturationMatrix);
            imageMatrix.postConcat(hueMatrix);

            // 给paint设置颜色属性
            paint.setColorFilter(new ColorMatrixColorFilter(imageMatrix));

            // 绘制
            canvas.drawBitmap(bitmap, 0, 0, paint);

            return temp;

        }
    }


    public static Bitmap scaleImage(final Activity activity, final View view, int drawableResId) {

        // 获取屏幕的高宽
        Point outSize = new Point();
        activity.getWindow().getWindowManager().getDefaultDisplay().getSize(outSize);

        // 解析将要被处理的图片
        Bitmap resourceBitmap = BitmapFactory.decodeResource(activity.getResources(), drawableResId);


        // 开始对图片进行拉伸或者缩放

        // 使用图片的缩放比例计算将要放大的图片的高度
        int bitmapScaledHeight = Math.round(resourceBitmap.getHeight() * outSize.x * 1.0f / resourceBitmap.getWidth());

        // 以屏幕的宽度为基准，如果图片的宽度比屏幕宽，则等比缩小，如果窄，则放大
        final Bitmap scaledBitmap = Bitmap.createScaledBitmap(resourceBitmap, outSize.x, bitmapScaledHeight, false);


        // 当UI绘制完毕，我们对图片进行处理
        int viewHeight = view.getMeasuredHeight();


        // 计算将要裁剪的图片的顶部以及底部的偏移量
        int offset = (scaledBitmap.getHeight() - viewHeight) / 2;


        // 对图片以中心进行裁剪，裁剪出的图片就是非常适合做引导页的图片了
        Bitmap finallyBitmap = Bitmap.createBitmap(scaledBitmap, 0, offset, scaledBitmap.getWidth(),
                scaledBitmap.getHeight() - offset * 2);

        return finallyBitmap;
    }
}
