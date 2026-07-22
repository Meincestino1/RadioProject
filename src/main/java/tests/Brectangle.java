package tests;

public class Brectangle {

    int width;
    int heigth;
    int area;

    public Brectangle() {
        this.width = 1;
        this.heigth = 1;
    }

    public Brectangle(int with, int height) {
        this.width = with;
        this.heigth = height;
    }

    int area () {
        area = width * heigth;
        return area;
    }





}
