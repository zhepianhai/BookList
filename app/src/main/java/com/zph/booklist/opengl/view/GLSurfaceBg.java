package com.zph.booklist.opengl.view;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

import com.zph.booklist.opengl.render.BgRender;

/**
 * Created by zph on 2018/1/17.
 */

public class GLSurfaceBg  extends GLSurfaceView{
    private BgRender mBgRender;
    private Context mContext;
    public GLSurfaceBg(Context context) {
        super(context);
        this.mContext=context;
    }

    public GLSurfaceBg(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
}
