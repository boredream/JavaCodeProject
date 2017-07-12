package com.boredream;

public class Test {

    public static void main(String[] args) {
        int imageWidth = 1600;
        int imageHeight = 600;

        int maxSize = 300;
        float ratio = 1f * imageWidth / imageHeight;
        int height,width;
        if(ratio < 0.5) {
            height = maxSize;
            width = maxSize/2;
        } else if(ratio < 1) {
            height = maxSize;
            width = (int) (ratio * maxSize);
        } else if(ratio < 2) {
            height = (int) (1f * maxSize / ratio);
            width = maxSize;
        } else {
            height = maxSize/2;
            width = maxSize;
        }

        System.out.println("image " + imageWidth + ":" + imageHeight);
        System.out.println("ratio " + ratio);
        System.out.println("view " + width + ":" + height);
    }
}
