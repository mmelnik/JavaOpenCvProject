package com.statistic;

public class HsvValuesHolder {
    private int hMin = 0;
    private int hMax = 255;
    private int sMin = 0;
    private int sMax = 255;
    private int vMin = 0;
    private int vMax = 255;

    public int gethMin() {
        return hMin;
    }

    public void sethMin(int hMin) {
        this.hMin = hMin;
    }

    public int gethMax() {
        return hMax;
    }

    public void sethMax(int hMax) {
        this.hMax = hMax;
    }

    public int getsMin() {
        return sMin;
    }

    public void setsMin(int sMin) {
        this.sMin = sMin;
    }

    public int getsMax() {
        return sMax;
    }

    public void setsMax(int sMax) {
        this.sMax = sMax;
    }

    public int getvMin() {
        return vMin;
    }

    public void setvMin(int vMin) {
        this.vMin = vMin;
    }

    public int getvMax() {
        return vMax;
    }

    public void setvMax(int vMax) {
        this.vMax = vMax;
    }
}
