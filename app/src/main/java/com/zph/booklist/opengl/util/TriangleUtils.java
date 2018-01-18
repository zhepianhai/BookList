package com.zph.booklist.opengl.util;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by zph on 2018/1/18.
 * 动态生成triangle工具类，包括坐标点和颜色的随机值
 */

public class TriangleUtils {
    private static final  int BASENUMBER=3;

    private float Values[];
    private float Colors[];
    private float tableVertexDate[] = {
            -1f, 1f, 0f, 1f,     1.0f, 1.0f, 0.6f,

            0f, 1f, 0f, 1f,   0.3f, 0.7f, 0.7f,
            1f, 1f, 0f, 1f,    0.7f, 0.1f, 0.7f,

            1f,0f,0f,1f,     0.8f,0.3f,0.6f,
            1f,-1f,0f,1f,     0.4f,0.4f,0.6f,
            0f,-1f,0f,1f,     0.5f,0.5f,0.8f,


            -1f, -1f, 0f, 1f,    0.3f, 0.75f, 0.7f,
            -1f, 0f, 0f, 1f,   0.3f, 0.7f, 0.2f,
    };



    private float GetRandomColor(){
        float mColor=0.0f;

        return mColor;
    }
    public static float[] GetRandomTriangle(){
//        float tableVertexDate[] = {
//                0  0
//               -1 -1
//                1  -1
//                 1  1
//                -1  1

//                -1f, 1f, 0f, 1f,     1.0f, 1.0f, 0.6f,
//                0f, 1f, 0f, 1f,      0.3f, 0.7f, 0.7f,
//                1f, 1f, 0f, 1f,      0.7f, 0.1f, 0.7f,
//                1f,0f,0f,1f,         0.8f,0.3f,0.6f,
//                1f,-1f,0f,1f,        0.4f,0.4f,0.6f,
//                0f,-1f,0f,1f,        0.5f,0.5f,0.8f,
//                -1f, -1f, 0f, 1f,    0.3f, 0.75f, 0.7f,
//                -1f, 0f, 0f, 1f,     0.3f, 0.7f, 0.2f,
//        };
        float tableVertexDate[]=new float[42];
        tableVertexDate[0]=0f;
        tableVertexDate[1]=0f;
        tableVertexDate[2]=0f;
        tableVertexDate[3]=1f;

        tableVertexDate[4]=getRandom();
        tableVertexDate[5]=getRandom();
        tableVertexDate[6]=getRandom();


        tableVertexDate[7]=-1f;
        tableVertexDate[8]=-1f;
        tableVertexDate[9]=0f;
        tableVertexDate[10]=1f;

        tableVertexDate[11]=getRandom();
        tableVertexDate[12]=getRandom();
        tableVertexDate[13]=getRandom();
//
        tableVertexDate[14]=1f;
        tableVertexDate[15]=-1f;
        tableVertexDate[16]=0f;
        tableVertexDate[17]=1f;

        tableVertexDate[18]=getRandom();
        tableVertexDate[19]=getRandom();
        tableVertexDate[20]=getRandom();
//
        tableVertexDate[21]=1f;
        tableVertexDate[22]=1f;
        tableVertexDate[23]=0f;
        tableVertexDate[24]=1f;

        tableVertexDate[25]=getRandom();
        tableVertexDate[26]=getRandom();
        tableVertexDate[27]=getRandom();
//
        tableVertexDate[28]=-1f;
        tableVertexDate[29]=1f;
        tableVertexDate[30]=0f;
        tableVertexDate[31]=1f;

        tableVertexDate[32]=getRandom();
        tableVertexDate[33]=getRandom();
        tableVertexDate[34]=getRandom();
    //

        tableVertexDate[35]=-1f;
        tableVertexDate[36]=-1f;
        tableVertexDate[37]=0f;
        tableVertexDate[38]=1f;

        tableVertexDate[39]=getRandom();
        tableVertexDate[40]=getRandom();
        tableVertexDate[41]=getRandom();

        return tableVertexDate;
    }


    private static   float getRandom(){
        return new Random().nextFloat();
    }

}
