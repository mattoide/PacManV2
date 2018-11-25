package GUI;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Incrocio {

    private Rectangle g0, g1, g2, g3, g4, g5, g6, g7, g8, g9, g10, g11, g12, g13, g14, g15, g16, g17, g18, g19;
    private Rectangle g20, g21, g22, g23, g24, g25, g26, g27, g28, g29, g30, g31, g32, g33, g34, g35, g36, g37, g38, g39;
    private Rectangle g40, g41, g42, g43, g44, g45, g46, g47, g48, g49, g50, g51, g52, g53, g54, g55;

    private Rectangle[] cross;

    public Incrocio() {

        //w h
        //1
        g0 = new Rectangle(32, 24, 73, 52);
        g1 = new Rectangle(32, 104, 73, 48);
        g2 = new Rectangle(32, 167, 73, 48);
        g3 = new Rectangle(32, 432, 73, 48);
        g4 = new Rectangle(32, 487, 73, 48);
        g5 = new Rectangle(32, 560, 73, 48);
        g6 = new Rectangle(32, 618, 73, 48);

        //2
        g7 = new Rectangle(216, 24, 62, 62);
        g8 = new Rectangle(216, 100, 62, 62);
        g9 = new Rectangle(216, 170, 62, 58);
        g10 = new Rectangle(216, 290, 62, 62);
        g11 = new Rectangle(216, 421, 62, 58);
        g48 = new Rectangle(216, 487, 66, 52);
        g12 = new Rectangle(216, 550, 66, 52);

        //3
        g50 = new Rectangle(321, 104, 70, 48);
        g13 = new Rectangle(321, 162, 70, 50);
        g14 = new Rectangle(321, 243, 70, 45);
        g15 = new Rectangle(321, 299, 70, 45);
        g16 = new Rectangle(321, 425, 70, 49);
        g51 = new Rectangle(321, 489, 70, 48);
        g17 = new Rectangle(321, 557, 70, 49);

        //4
        g18 = new Rectangle(425, 24, 68, 52);
        g19 = new Rectangle(425, 98, 68, 52);
        g20 = new Rectangle(425, 173, 69, 52);
        g21 = new Rectangle(425, 432, 69, 50);
        g22 = new Rectangle(425, 488, 68, 50);
        g23 = new Rectangle(425, 560, 68, 52);
        g54 = new Rectangle(425, 618, 68, 48);
        //5
        g24 = new Rectangle(538, 24, 68, 52);
        g25 = new Rectangle(538, 98, 68, 52);
        g26 = new Rectangle(534, 173, 69, 52);
        g27 = new Rectangle(534, 432, 69, 50);
        g28 = new Rectangle(538, 488, 68, 50);
        g29 = new Rectangle(534, 560, 68, 52);
        g55 = new Rectangle(534, 618, 68, 48);

        //6
        g52 = new Rectangle(640, 104, 70, 48);
        g30 = new Rectangle(640, 162, 70, 50);
        g31 = new Rectangle(640, 243, 70, 45);
        g32 = new Rectangle(640, 299, 70, 45);
        g33 = new Rectangle(640, 425, 70, 49);
        g53 = new Rectangle(640, 489, 70, 48);
        g34 = new Rectangle(640, 557, 70, 49);

        //7
        g35 = new Rectangle(747, 24, 62, 62);
        g36 = new Rectangle(747, 100, 62, 62);
        g37 = new Rectangle(747, 170, 62, 58);
        g38 = new Rectangle(747, 290, 62, 62);
        g39 = new Rectangle(747, 421, 62, 58);
        g49 = new Rectangle(747, 487, 66, 52);
        g40 = new Rectangle(747, 550, 66, 52);

        //8
        g41 = new Rectangle(922, 24, 73, 52);
        g42 = new Rectangle(922, 104, 73, 48);
        g43 = new Rectangle(922, 167, 73, 48);
        g44 = new Rectangle(922, 432, 73, 48);
        g45 = new Rectangle(922, 487, 73, 48);
        g46 = new Rectangle(922, 560, 73, 48);
        g47 = new Rectangle(922, 618, 73, 48);

        cross = new Rectangle[]{
            g0, g1, g2, g3, g4, g5, g6, g7, g8, g9, g10, g11, g12, g13, g14, g15, g16, g17, g18, g19,
            g20, g21, g22, g23, g24, g25, g26, g27, g28, g29, g30, g31, g32, g33, g34, g35, g36, g37, g38, g39,
            g40, g41, g42, g43, g44, g45, g46, g47, g48, g49, g50, g51, g52, g53, g54, g55
        };
    }

    public void drawCross(Graphics2D cross) {

        cross.setPaint(Color.white);

       // cross.setColor(Color.green);
/*
        //1
        cross.fillRect(g0.x, g0.y, g0.width, g0.height);
        cross.fillRect(g1.x, g1.y, g1.width, g1.height);
        cross.fillRect(g2.x, g2.y, g2.width, g2.height);
        cross.fillRect(g3.x, g3.y, g3.width, g3.height);
        cross.fillRect(g4.x, g4.y, g4.width, g4.height);
        cross.fillRect(g5.x, g5.y, g5.width, g5.height);
        cross.fillRect(g6.x, g6.y, g6.width, g6.height);
        //2
        cross.fillRect(g7.x, g7.y, g7.width, g7.height);
        cross.fillRect(g8.x, g8.y, g8.width, g8.height);
        cross.fillRect(g9.x, g9.y, g9.width, g9.height);
        cross.fillRect(g10.x, g10.y, g10.width, g10.height);
        cross.fillRect(g11.x, g11.y, g11.width, g11.height);
        cross.fillRect(g48.x, g48.y, g48.width, g48.height);
        cross.fillRect(g12.x, g12.y, g12.width, g12.height);
        //3
        cross.fillRect(g50.x, g50.y, g50.width, g50.height);
        cross.fillRect(g13.x, g13.y, g13.width, g13.height);
        cross.fillRect(g14.x, g14.y, g14.width, g14.height);
        cross.fillRect(g15.x, g15.y, g15.width, g15.height);
        cross.fillRect(g16.x, g16.y, g16.width, g16.height);
        cross.fillRect(g51.x, g51.y, g51.width, g51.height);
        cross.fillRect(g17.x, g17.y, g17.width, g17.height);
        //4
        cross.fillRect(g18.x, g18.y, g18.width, g18.height);
        cross.fillRect(g19.x, g19.y, g19.width, g19.height);
        cross.fillRect(g20.x, g20.y, g20.width, g20.height);
        cross.fillRect(g21.x, g21.y, g21.width, g21.height);
        cross.fillRect(g22.x, g22.y, g22.width, g22.height);
        cross.fillRect(g23.x, g23.y, g23.width, g23.height);
        cross.fillRect(g54.x, g54.y, g54.width, g54.height);
        //5
        cross.fillRect(g24.x, g24.y, g24.width, g24.height);
        cross.fillRect(g25.x, g25.y, g25.width, g25.height);
        cross.fillRect(g26.x, g26.y, g26.width, g26.height);
        cross.fillRect(g27.x, g27.y, g27.width, g27.height);
        cross.fillRect(g28.x, g28.y, g28.width, g28.height);
        cross.fillRect(g29.x, g29.y, g29.width, g29.height);
        cross.fillRect(g55.x, g55.y, g55.width, g55.height);
        //6
        cross.fillRect(g52.x, g52.y, g52.width, g52.height);
        cross.fillRect(g30.x, g30.y, g30.width, g30.height);
        cross.fillRect(g31.x, g31.y, g31.width, g31.height);
        cross.fillRect(g32.x, g32.y, g32.width, g32.height);
        cross.fillRect(g33.x, g33.y, g33.width, g33.height);
        cross.fillRect(g53.x, g53.y, g53.width, g53.height);
        cross.fillRect(g34.x, g34.y, g34.width, g34.height);
        //7
        cross.fillRect(g35.x, g35.y, g35.width, g35.height);
        cross.fillRect(g36.x, g36.y, g36.width, g36.height);
        cross.fillRect(g37.x, g37.y, g37.width, g37.height);
        cross.fillRect(g38.x, g38.y, g38.width, g38.height);
        cross.fillRect(g39.x, g39.y, g39.width, g39.height);
        cross.fillRect(g49.x, g49.y, g49.width, g49.height);
        cross.fillRect(g40.x, g40.y, g40.width, g40.height);
        //8
        cross.fillRect(g41.x, g41.y, g41.width, g41.height);
        cross.fillRect(g42.x, g42.y, g42.width, g42.height);
        cross.fillRect(g43.x, g43.y, g43.width, g43.height);
        cross.fillRect(g44.x, g44.y, g44.width, g44.height);
        cross.fillRect(g45.x, g45.y, g45.width, g45.height);
        cross.fillRect(g46.x, g46.y, g46.width, g46.height);
        cross.fillRect(g47.x, g47.y, g47.width, g47.height);*/

        cross.draw(g0);
        cross.draw(g1);
        cross.draw(g2);
        cross.draw(g3);
        cross.draw(g4);
        cross.draw(g5);
        cross.draw(g6);
        cross.draw(g7);
        cross.draw(g8);
        cross.draw(g9);
        cross.draw(g10);
        cross.draw(g11);
        cross.draw(g12);
        cross.draw(g13);
        cross.draw(g14);
        cross.draw(g15);
        cross.draw(g16);
        cross.draw(g17);
        cross.draw(g18);
        cross.draw(g19);
        cross.draw(g20);
        cross.draw(g21);
        cross.draw(g22);
        cross.draw(g23);
        cross.draw(g24);
        cross.draw(g25);
        cross.draw(g26);
        cross.draw(g27);
        cross.draw(g28);
        cross.draw(g29);
        cross.draw(g30);
        cross.draw(g31);
        cross.draw(g32);
        cross.draw(g33);
        cross.draw(g34);
        cross.draw(g35);
        cross.draw(g36);
        cross.draw(g37);
        cross.draw(g38);
        cross.draw(g39);
        cross.draw(g40);
        cross.draw(g41);
        cross.draw(g42);
        cross.draw(g43);
        cross.draw(g44);
        cross.draw(g45);
        cross.draw(g46);
        cross.draw(g47);

    }

    public Rectangle[] getCross() {
        return cross;
    }

}
