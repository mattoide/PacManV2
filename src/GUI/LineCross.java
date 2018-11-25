package GUI;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class LineCross {

    private Line2D.Double currentLine0, currentLine1, currentLine2, currentLine3, currentLine4, currentLine5,
            currentLine6, currentLine7, currentLine8, currentLine9, currentLine10, currentLine11,
            currentLine12, currentLine13, currentLine14, currentLine15, currentLine16, currentLine17,
            currentLine18, currentLine19, currentLine20, currentLine21, currentLine22, currentLine23,
            currentLine24, currentLine25, currentLine26, currentLine27, currentLine28, currentLine29,
            currentLine30, currentLine31, currentLine32, currentLine33, currentLine34;

    private Line2D.Double[] lines;

    public LineCross() {

        currentLine0 = new Line2D.Double(104, 22, 104, 665);
        currentLine1 = new Line2D.Double(173, 22, 173, 665);
        currentLine2 = new Line2D.Double(216, 22, 216, 665);
        currentLine3 = new Line2D.Double(279, 22, 279, 665);
        currentLine4 = new Line2D.Double(323, 22, 323, 665);
        currentLine5 = new Line2D.Double(389, 22, 389, 665);
        currentLine6 = new Line2D.Double(426, 22, 426, 665);
        currentLine7 = new Line2D.Double(490, 22, 490, 665);
        currentLine8 = new Line2D.Double(537, 22, 537, 665);
        currentLine9 = new Line2D.Double(599, 22, 599, 665);
        currentLine10 = new Line2D.Double(642, 22, 642, 665);
        currentLine11 = new Line2D.Double(706, 22, 706, 665);
        currentLine12 = new Line2D.Double(748, 22, 748, 665);
        currentLine13 = new Line2D.Double(810, 22, 810, 665);
        currentLine14 = new Line2D.Double(852, 22, 852, 665);
        currentLine15 = new Line2D.Double(922, 22, 922, 665);

        currentLine16 = new Line2D.Double(10, 62, 1015, 62);
        currentLine17 = new Line2D.Double(10, 108, 1015, 108);
        currentLine18 = new Line2D.Double(10, 148, 1015, 148);
        currentLine19 = new Line2D.Double(10, 174, 1015, 174);
        currentLine20 = new Line2D.Double(10, 212, 1015, 212);
        currentLine21 = new Line2D.Double(10, 241, 1015, 241);
        currentLine22 = new Line2D.Double(10, 276, 1015, 276);
        currentLine23 = new Line2D.Double(10, 306, 1015, 306);
        currentLine24 = new Line2D.Double(10, 341, 1015, 341);
        currentLine25 = new Line2D.Double(10, 406, 1015, 406);
        currentLine26 = new Line2D.Double(10, 434, 1015, 434);
        currentLine27 = new Line2D.Double(10, 472, 1015, 472);
        currentLine28 = new Line2D.Double(10, 495, 1015, 495);
        currentLine29 = new Line2D.Double(10, 536, 1015, 536);
        currentLine30 = new Line2D.Double(10, 563, 1015, 563);
        currentLine31 = new Line2D.Double(10, 627, 1015, 627);
        currentLine32 = new Line2D.Double(10, 600, 1015, 600);
    }

    public void drawLineCross(Graphics2D lineCross) {

        lineCross.setPaint(Color.white);

        lineCross.draw(currentLine0);
        lineCross.draw(currentLine1);
        lineCross.draw(currentLine2);
        lineCross.draw(currentLine3);
        lineCross.draw(currentLine4);
        lineCross.draw(currentLine5);
        lineCross.draw(currentLine6);
        lineCross.draw(currentLine7);
        lineCross.draw(currentLine8);
        lineCross.draw(currentLine9);
        lineCross.draw(currentLine10);
        lineCross.draw(currentLine11);
        lineCross.draw(currentLine12);
        lineCross.draw(currentLine13);
        lineCross.draw(currentLine14);
        lineCross.draw(currentLine15);

        lineCross.draw(currentLine16);
        lineCross.draw(currentLine17);
        lineCross.draw(currentLine18);
        lineCross.draw(currentLine19);
        lineCross.draw(currentLine20);
        lineCross.draw(currentLine21);
        lineCross.draw(currentLine22);
        lineCross.draw(currentLine23);
        lineCross.draw(currentLine24);
        lineCross.draw(currentLine25);
        lineCross.draw(currentLine26);
        lineCross.draw(currentLine27);
        lineCross.draw(currentLine28);
        lineCross.draw(currentLine29);
        lineCross.draw(currentLine30);
        lineCross.draw(currentLine31);
        lineCross.draw(currentLine32);
    }
}
