package com.example.bmicalculator;

public class Model {
    private int weight;
    private int heightFT;
    private int height;
    private int result;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeightFT() {
        return heightFT;
    }

    public void setHeightFT(int heightFT) {
        this.heightFT = heightFT;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public Model(int weight, int heightFT, int height, int result) {
        this.weight = weight;
        this.heightFT = heightFT;
        this.height = height;
        this.result = result;
    }
}
