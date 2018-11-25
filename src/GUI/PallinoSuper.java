package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Resources;

public class PallinoSuper extends Thread {

    Rectangle pointRect;
    BufferedImage point;
    private Rectangle p0, p1, p2, p3;

    private boolean attivo;

    private ArrayList<Rectangle> pointsSuper;

    private boolean visibile = true;

    public PallinoSuper() {

        this.point = Resources.getImage("/img/point.png");
        //   this.pointRect = new Rectangle(this.x, this.y, point.getWidth(null), point.getHeight(null));

        p0 = new Rectangle(60, 510, point.getWidth(null), point.getHeight(null));
        p1 = new Rectangle(60, 638, point.getWidth(null), point.getHeight(null));
        p2 = new Rectangle(954, 510, point.getWidth(null), point.getHeight(null));
        p3 = new Rectangle(950, 638, point.getWidth(null), point.getHeight(null));

        pointsSuper = new ArrayList<>();

        pointsSuper.add(p0);
        pointsSuper.add(p1);
        pointsSuper.add(p2);
        pointsSuper.add(p3);

        this.start();
    }

    public void draw(Graphics g) {

        if (visibile == true) {
            for (int i = 0; i < pointsSuper.size(); i++) {
                g.drawImage(point, pointsSuper.get(i).x, pointsSuper.get(i).y, point.getWidth(), point.getHeight(), null);
            }
        }
    }

    public ArrayList<Rectangle> getPointsSuper() {
        return pointsSuper;
    }

    public void visible() {

        if (visibile == true) {
            visibile = false;
        } else {
            visibile = true;
        }
    }

    @Override
    public void run() {

        this.attivo = true;

        while (this.attivo) {

            visible();

            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ghost.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
