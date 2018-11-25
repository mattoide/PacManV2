package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ghost extends Thread {

    private final int DX = 1;
    private final int SX = 2;
    private final int SU = 3;
    private final int GIU = 4;

    private static final int RIGA = 22;
    private static final int COLONNA = 30;

    private final int TRANQUILLO = 5;

    Rectangle rect;
    Rectangle megaRect;
    Rectangle rectIniziale;

    BufferedImage image;

    private int velocita;

    private boolean attivo;

    private boolean collisione = false;

    private Line2D.Double[] lines;
    private Arc2D.Double[] arches;

    private int movimentoCorrente;

    private int umore;

    private int stato = 0;

    int riga;
    int colonna;
    int ghostdim = 35;
    Matriciana matriciana;
    Cella[][] mat;

    public Ghost(BufferedImage img, int px, int py, Arc2D.Double[] parches, Line2D.Double[] plines) {

        this.matriciana = new Matriciana();

        this.mat = matriciana.getMatrix();

        this.image = img;
        // this.rect = new Rectangle(px, py, image.getWidth(null), image.getHeight(null));
        this.rect = new Rectangle(px, py, ghostdim, ghostdim);

        this.megaRect = new Rectangle(rect.x - 200, rect.y - 200, image.getWidth() + 400, image.getHeight() + 400);

        this.rectIniziale = new Rectangle(500, 310, 40, 40);

        this.velocita = 1;

        this.lines = plines;
        this.arches = parches;

        movimentoCorrente = SU;

        umore = TRANQUILLO;

        this.riga = 1;
        this.colonna = 1;
        this.start();
    }

    public void setRiga(int riga) {
        this.riga = riga;
    }

    public void setColonna(int colonna) {
        this.colonna = colonna;
    }

    public BufferedImage getRed() {
        return image;
    }

    public void setAttivo(BufferedImage pImage) {
        stato = 0;
        this.image = pImage;
    }

    public void setInattivo(BufferedImage pImage) {
        stato = 1;
        this.image = pImage;
    }

    public void setOcchi(BufferedImage pImage) {
        stato = 2;
        this.image = pImage;
    }

    public void draw(Graphics g) {
         g.drawImage(image, rect.x, rect.y, image.getWidth(), image.getHeight(), null);

        g.setColor(Color.blue);
        g.drawRect(megaRect.x, megaRect.y, megaRect.width, megaRect.height);
       // g.fillRect(rect.x, rect.y, rect.width, rect.height);

        // g.fillRect(rectIniziale.x, rectIniziale.y, rectIniziale.width, rectIniziale.height);
    }

    public Rectangle getRect() {
        return rect;
    }

    public Rectangle getMegaRect() {
        return megaRect;
    }

    public Rectangle getRectIniziale() {
        return rectIniziale;
    }

    public void movimentoDx() {

        this.rect.x += this.velocita;
        this.megaRect.x += this.velocita;
    }

    public void movimentoSx() {
        this.rect.x -= this.velocita;
        this.megaRect.x -= this.velocita;
    }

    public void movimentoSu() {
        this.rect.y -= this.velocita;
        this.megaRect.y -= this.velocita;
    }

    public void movimentoGiu() {
        this.rect.y += this.velocita;
        this.megaRect.y += this.velocita;
    }

    public void movi(int px, int py) {
        this.rect.x = px;
        this.rect.y = py;
    }

    @Override
    public void run() {
        this.attivo = true;
        while (this.attivo) {

            // collisioni();
            // movimentoIncrocio(this.riga, this.colonna);
            switch (movimentoCorrente) {
                case SU:
                    movimentoSu();
                    break;

                case GIU:
                    movimentoGiu();
                    break;

                case SX:
                    movimentoSx();
                    break;

                case DX:
                    movimentoDx();
                    break;
            }

            try {
                Thread.sleep(30);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ghost.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /* public void movimento() {
int riga = 22;
            int colonna = 30;
            
            Point centrocella, centrofanstasma;
        
        //scortti mat per vdere dove stp
          for (int i = 0; i < riga; i++) {

                for (int j = 0; j < colonna; j++) {

                   centrocella = new Point((int)mat[i][j].getRectCella().getCenterX(),(int)mat[i][j].getRectCella().getCenterY()); 
                   centrofanstasma = new Point((int)this.getRect().getCenterX(),(int)this.getRect().getCenterY());
                   
                    if (mat[i][j].getRectCella().intersects(this.getRect())) {
                                           System.out.println(centrocella + " " + centrofanstasma);

                    }
                }

            }
        int randomNum = ThreadLocalRandom.current().nextInt(0, 1000);

        if (randomNum >= 0 && randomNum < 250) {
            movimentoCorrente = DX;
            movimentoDx();
        } else if (randomNum >= 250 && randomNum < 500) {
            movimentoCorrente = SU;
            movimentoSu();
        } else if (randomNum >= 500 && randomNum < 750) {
            movimentoCorrente = SX;
            movimentoSx();
        } else if (randomNum >= 750 && randomNum <= 1000) {
            movimentoCorrente = GIU;
            movimentoGiu();
        }
    }*/
    public void movimento() {

        int randomNum = ThreadLocalRandom.current().nextInt(0, 1000);

        if (randomNum >= 0 && randomNum < 250) {
            movimentoCorrente = DX;
            movimentoDx();
        } else if (randomNum >= 250 && randomNum < 500) {
            movimentoCorrente = SU;
            movimentoSu();
        } else if (randomNum >= 500 && randomNum < 750) {
            movimentoCorrente = SX;
            movimentoSx();
        } else if (randomNum >= 750 && randomNum <= 1000) {
            movimentoCorrente = GIU;
            movimentoGiu();
        }
    }

    public void movimentoNormale(int pi, int pj) {
        int i = pi;
        int j = pj;

       // System.out.println("Movimento normale verso: " + movimentoCorrente);

        switch (movimentoCorrente) {

            case SU:

                if (i > 0) {
                    if ((mat[i - 1][j].eUn() == 0)||(mat[i - 1][j].eUn()==2)) {

                    } else {
                        movimentoIncrocio(i, j);

                    }
                }
                break;

            case GIU:
                if (i < RIGA) {

                    if ((mat[i + 1][j].eUn() == 0)||(mat[i + 1][j].eUn() == 2)) {
                    } else {
                        movimentoIncrocio(i, j);

                    }
                }
                break;

            case SX:

                if (j > 0) {

                    if ((mat[i][j - 1].eUn() == 0)||(mat[i][j - 1].eUn() == 2)) {
                    } else {
                        movimentoIncrocio(i, j);
                    }
                }
                break;

            case DX:
                if (i < COLONNA) {

                    if ((mat[i][j + 1].eUn() == 0)||(mat[i][j + 1].eUn() == 2)) {
                        movimentoDx();
                    } else {
                        movimentoIncrocio(i, j);
                    }
                }

                break;

        }
    }

    /*public void movimentoIncrocio(int pi, int pj) {

        int i = pi;
        int j = pj;
        int randomNum = ThreadLocalRandom.current().nextInt(0, 1000);

        if (randomNum >= 0 && randomNum < 250) {
            if (j < COLONNA) {
                System.out.println("A destra ce un= " + mat[i][j + 1].getMuroString());

                if (mat[i][j + 1].eUn() == 1) {
                    movimentoIncrocio(i, j);
                    //  System.out.println("caso dx e muro");
                } else {
                    // System.out.println("caso dx non e muro");
                    movimentoCorrente = DX;
                    movimentoDx();
//                 movi((int) mat[i][j+1].getRectCella().getX(), (int)mat[i][j+1].getRectCella().getY());
                }
            }

        } else if (randomNum >= 250 && randomNum < 500) {

            if (i > 0) {
                System.out.println("Su ce un= " + mat[i - 1][j].getMuroString());

                if (mat[i - 1][j].eUn() == 1) {
                    movimentoIncrocio(i, j);
                    //  System.out.println("caso su e muro");
                } else {
                    //  System.out.println("caso su non  e muro");
                    movimentoCorrente = SU;
                    movimentoSu();
//                            movi((int) mat[i-1][j].getRectCella().getX(), (int)mat[i-1][j].getRectCella().getY());

                }
            }

        } else if (randomNum >= 500 && randomNum < 750) {

            if (j > 0) {
                System.out.println("A sinistra ce un= " + mat[i][j - 1].getMuroString());

                if (mat[i][j - 1].eUn() == 1) {
                    movimentoIncrocio(i, j);
                    //  System.out.println("caso sx e muro");
                } else {
                    //   System.out.println("caso sx non  e muro");
                    movimentoCorrente = SX;
                    movimentoSx();
                    //       movi((int) mat[i][j-1].getRectCella().getX(), (int)mat[i][j-1].getRectCella().getY());

                }
            }

        } else if (randomNum >= 750 && randomNum <= 1000) {
            if (i < RIGA) {
                System.out.println("Giu ce un= " + mat[i + 1][j].getMuroString());

                if (mat[i + 1][j].eUn() == 1) {
                    movimentoIncrocio(i, j);
                    //   System.out.println("caso giu e muro");
                } else {
                    //   System.out.println("caso giu non e muro");
                    movimentoCorrente = GIU;
                    movimentoGiu();
                    //        movi((int) mat[i+1][j].getRectCella().getX(), (int)mat[i+1][j].getRectCella().getY());

                }
            }

        }

    }*/
    public void movimentoIncrocio(int pi, int pj) {

        int i = pi;
        int j = pj;
        int randomNum = ThreadLocalRandom.current().nextInt(0, 1000);

        if (randomNum >= 0 && randomNum < 250) {
            if (j < COLONNA) {
                System.out.println("A destra ce un= " + mat[i][j + 1].getMuroString());

                if (mat[i][j + 1].eUn() == 1) {
                    movimentoIncrocio(i, j);
                } else {
                    movimentoCorrente = DX;
                    movimentoDx();
                }
            }

        } else if (randomNum >= 250 && randomNum < 500) {

            if (i > 0) {
                System.out.println("Su ce un= " + mat[i - 1][j].getMuroString());

                if (mat[i - 1][j].eUn() == 1) {
                    movimentoIncrocio(i, j);
                } else {
                    movimentoCorrente = SU;
                    movimentoSu();

                }
            }

        } else if (randomNum >= 500 && randomNum < 750) {

            if (j > 0) {
                System.out.println("A sinistra ce un= " + mat[i][j - 1].getMuroString());

                if (mat[i][j - 1].eUn() == 1) {
                    movimentoIncrocio(i, j);
                } else {
                    movimentoCorrente = SX;
                    movimentoSx();

                }
            }

        } else if (randomNum >= 750 && randomNum <= 1000) {
            if (i < RIGA) {
                System.out.println("Giu ce un= " + mat[i + 1][j].getMuroString());

                if (mat[i + 1][j].eUn() == 1) {
                    movimentoIncrocio(i, j);
                } else {
                    movimentoCorrente = GIU;
                    movimentoGiu();

                }
            }

        }

    }

    /* public void movimentoIncrocioOld() {

        int randomNum = ThreadLocalRandom.current().nextInt(0, 900);

        switch (movimentoCorrente) {

            case DX:
                if (randomNum >= 0 && randomNum < 300) {
                    movimentoCorrente = DX;
                    movimentoDx();
                } else if (randomNum >= 300 && randomNum < 600) {
                    movimentoCorrente = SU;
                    movimentoSu();

                } else if (randomNum >= 600 && randomNum <= 900) {
                    movimentoCorrente = GIU;
                    movimentoGiu();
                }
                break;

            case SX:
                if (randomNum >= 0 && randomNum < 300) {
                    movimentoCorrente = SX;
                    movimentoSx();
                } else if (randomNum >= 300 && randomNum < 600) {
                    movimentoCorrente = SU;
                    movimentoSu();

                } else if (randomNum >= 600 && randomNum <= 900) {
                    movimentoCorrente = GIU;
                    movimentoGiu();
                }
                break;

            case SU:
                if (randomNum >= 0 && randomNum < 300) {
                    movimentoCorrente = DX;
                    movimentoDx();
                } else if (randomNum >= 300 && randomNum < 600) {
                    movimentoCorrente = SX;
                    movimentoSx();

                } else if (randomNum >= 600 && randomNum <= 900) {
                    movimentoCorrente = SU;
                    movimentoSu();
                }
                break;

            case GIU:
                if (randomNum >= 0 && randomNum < 300) {
                    movimentoCorrente = DX;
                    movimentoDx();
                } else if (randomNum >= 300 && randomNum < 600) {
                    movimentoCorrente = SX;
                    movimentoSx();

                } else if (randomNum >= 600 && randomNum <= 900) {
                    movimentoCorrente = GIU;
                    movimentoGiu();
                }
        }
    }*/
    public void collisioni() {

        /*   for (int i = 0; i < lines.length; i++) {
            if (this.getRect().intersectsLine(lines[i])) {
                collisione = true;
                //System.out.println("boooom");
            }
        }

        for (int j = 0; j < arches.length; j++) {
            if (arches[j].intersects(this.getRect())) {
                collisione = true;
                //System.out.println("tocco");
            }
        }*/
        //  collisione = false;
        if (collisione == false) {

            switch (movimentoCorrente) {

                case DX:
                    movimentoDx();
                    collisione = false;
                    //System.out.println("DESTRA");
                    break;

                case SX:
                    movimentoSx();
                    collisione = false;
                    //System.out.println("SX");
                    break;

                case SU:
                    movimentoSu();
                    collisione = false;
                    //System.out.println("SU");
                    break;

                case GIU:
                    movimentoGiu();
                    collisione = false;
                    //System.out.println("GIU");
                    break;
            }
        } else {
            collisione = false;

            switch (movimentoCorrente) {

                case DX:
                    movimentoSx();
                    break;

                case SX:
                    movimentoDx();
                    //System.out.println("non posso sxa");
                    break;

                case SU:
                    movimentoGiu();
                    //System.out.println("non posso su");
                    break;

                case GIU:
                    movimentoSu();
                    //System.out.println("non posso giu");
                    break;
            }
            movimento();
        }
    }

    public void changeState(int pUmore) {
        umore = pUmore;
    }

    public int getUmore() {
        return this.umore;
    }

    public int getStato() {
        return this.stato;
    }

    public void movimentoIncrocioAttacco(Rectangle pPac) {

        System.out.println("movimento attacco");
        int differenzaX = Math.abs((int) this.getRect().getX() - (int) pPac.getX());
        int differenzaY = Math.abs((int) this.getRect().getY() - (int) pPac.getY());

        System.out.println(differenzaX);
        System.out.println(differenzaY);

        if (differenzaX < differenzaY) {
            if (this.getRect().getY() > pPac.getY()) {
                movimentoCorrente = SU;
                movimentoSu();
            } else {
                movimentoCorrente = GIU;
                movimentoGiu();
            }
        } else {
            if (this.getRect().getX() > pPac.getX()) {
                movimentoCorrente = SX;
                movimentoSx();
            } else {
                movimentoCorrente = DX;
                movimentoDx();
            }
        }
    }

    public void movimentoScappa(Rectangle pPac) {

        this.velocita = 3;

        System.out.println("scappaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        int differenzaX = Math.abs((int) this.getRect().getX() - (int) pPac.getX());
        int differenzaY = Math.abs((int) this.getRect().getY() - (int) pPac.getY());

        System.out.println(differenzaX);
        System.out.println(differenzaY);

        if (differenzaX > differenzaY) {
            if (this.getRect().getY() < pPac.getY()) {
                movimentoCorrente = SU;
                movimentoSu();
            } else {
                movimentoCorrente = GIU;
                movimentoGiu();
            }
        } else {
            if (this.getRect().getX() < pPac.getX()) {
                movimentoCorrente = SX;
                movimentoSx();
            } else {
                movimentoCorrente = DX;
                movimentoDx();
            }
        }
    }

    public void movimentoTornaInizio() {

        System.out.println("iniziooooooooooooooooooooooo");
        int differenzaX = Math.abs((int) this.getRect().getX() - (int) this.getRectIniziale().getX());
        int differenzaY = Math.abs((int) this.getRect().getY() - (int) this.getRectIniziale().getY());

        System.out.println(getRectIniziale());

        System.out.println(differenzaX);
        System.out.println(differenzaY);

        if (differenzaX < differenzaY) {
            if (this.getRect().getY() > this.getRectIniziale().getY()) {
                movimentoCorrente = SU;
                movimentoSu();
            } else {
                movimentoCorrente = GIU;
                movimentoGiu();
            }
        } else {
            if (this.getRect().getX() > this.getRectIniziale().getX()) {
                movimentoCorrente = SX;
                movimentoSx();
            } else {
                movimentoCorrente = DX;
                movimentoDx();
            }
        }
    }
}
