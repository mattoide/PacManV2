package GameLogic;

import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JLabel;

public class Punteggio extends JLabel {

    private int punti = 0;
    private final int puntiRandom = 100;
    private int puntiSuper = 500;

    public Punteggio() {

        this.setOpaque(true);
        this.setForeground(Color.RED);
        this.setBackground(Color.BLACK);
        //this.setBackground(Color.LIGHT_GRAY);

        this.setText("Punteggio = " + String.valueOf(this.punti));
    }

    public void setPoints(int pPunti) {
        this.punti = pPunti;
        this.setInfo();
    } 
    public void addPoint() {
        this.punti = this.punti +100;
                this.setInfo();

    }
    public void addPointSuper() {
        this.punti = this.punti +500;
                this.setInfo();

    }
    
    
    public void setInfo() {
        this.setText("Punteggio = " + String.valueOf(this.getPoints()));
    }

     public int getPoints() {
        return punti;
    }
}
