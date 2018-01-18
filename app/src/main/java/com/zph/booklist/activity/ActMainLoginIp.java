package com.zph.booklist.activity;

import android.annotation.TargetApi;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.zph.booklist.R;
import com.zph.booklist.opengl.render.BgRender;
import com.zph.booklist.opengl.view.GLSurfaceBg;

public class ActMainLoginIp extends AppCompatActivity implements View.OnClickListener {
    private GLSurfaceBg glv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        glv = new GLSurfaceBg(this);
//        if (BaseGLESSeting.CheckSupposeGLES(this)) {
//            this.rendererSet = true;
            glv.setEGLContextClientVersion(2); // Pick an OpenGL ES 2.0 context.
            glv.setRenderer(new BgRender(this));
            setContentView(glv);
            
//            mViewMain.addView(glv);
//        } else {
//            Toast.makeText(this, R.string.not_suppose_opengl, Toast.LENGTH_SHORT).show();
//        }
//        setContentView(R.layout.activity_act_main_login_ip);
//        this.initView();
    }

    private void initView() {

    }

    @Override
    public void onClick(View v) {
    }
}
