package GUI;

import java.awt.Rectangle;

public class Cella {

    private int x;
    private int y;
    private int h;
    private int w;
    private int tipo;
    private Rectangle rectCella;

    public Cella(int pX, int pY, int ptipo) {

        this.x = pX;
        this.y = pY;
        this.h = 35;
        this.w = 35;
        this.tipo = ptipo;

        this.rectCella = new Rectangle(this.x, this.y, this.w, this.h);

    }

    public Rectangle getRectCella() {
        return rectCella;
    }

    public int getH() {
        return h;
    }

    public int getW() {
        return w;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int eUn() {
        return tipo;
    }

    public String getMuroString() {

        switch (tipo) {
            case 1:
                return "è un muro";
            case 0:
                return "non è un muro";
            case 2:
                return "è un incrocio";
            default:
                break;
        }
        return "bhooo";
    }
}
