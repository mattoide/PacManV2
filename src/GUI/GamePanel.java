package GUI;

import GameLogic.Giocatore;
import GameLogic.Punteggio;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import utils.Resources;

//giochi adattivi
public class GamePanel extends JPanel {

    private final Image sfondoGamePanel;
    private final int LIMITE_DX_FRAME = 6400;
    private final int LIMITE_SX_FRAME = 6000;
    private final int LIMITE_GIU_FRAME = 6000;
    private final int LIMITE_SU_FRAME = 6000;

    private final int DX = 1;
    private final int SX = 2;
    private final int SU = 3;
    private final int GIU = 4;

    private final int TRANQUILLO = 5;
    private final int ATTACCO = 6;

    private final BufferedImage imgArancione;
    private final BufferedImage imgCeleste;
    private final BufferedImage imgRosa;
    private final BufferedImage imgRosso;
    private final BufferedImage imgInattivo;
    private final BufferedImage imgOcchi;

    private Giocatore player;
    private BufferedImage viteGiocatore;

    private Thread threadCollisioni;
    private Thread threadIncroci;
    private Thread threadGhostInattivo;

    public int movimentoCorrente;
    public boolean collisione = false;

    private Labirinto labirinto;

    private Line2D.Double[] lines;
    private Arc2D.Double[] arches;

    private Ghost rosso;
    private Ghost rosa;
    private Ghost celeste;
    private Ghost arancione;

    private LinePoint lineePunti; //per fare i pallini in linea
    private Line2D.Double[] linesV;
    private Line2D.Double[] linesO;

    private Pallino point;
    private ArrayList<Pallino> pallini;

    private PallinoSuper pointSuper;
    private ArrayList<Rectangle> palliniSuper;

    private Incrocio incrocio;
    private Rectangle[] incroci;

    private LineCross lineeIncroci;

    private Punteggio labelPunteggio;

    private Map mappa;

    Matriciana matriciana;
    Cella[][] mat;

    public GamePanel(Giocatore pGiocatore) {
        this.setLayout(null);
        this.setSize(MainFrame.DIM_FRAME);

        this.sfondoGamePanel = Resources.getImage("/img/gamePanel.png");
        this.imgArancione = Resources.getImage("/img/arancione.png");
        this.imgCeleste = Resources.getImage("/img/celeste.png");
        this.imgRosa = Resources.getImage("/img/rosa.png");
        this.imgRosso = Resources.getImage("/img/rosso.png");
        this.imgInattivo = Resources.getImage("/img/inattivo.png");
        this.imgOcchi = Resources.getImage("/img/occhi.png");

        this.player = pGiocatore;

      //  this.labirinto = new Labirinto();

     //   lines = labirinto.getLines();
       // arches = labirinto.getArches();

        //   this.rosso = new Ghost(imgRosso, 240, 260, arches, lines);
        this.rosso = new Ghost(imgRosso, 210, 140, arches, lines);
        this.rosa = new Ghost(imgRosa, 423, 342, arches, lines);
        this.celeste = new Ghost(imgCeleste, 474, 341, arches, lines);
        this.arancione = new Ghost(imgArancione, 535, 341, arches, lines);

      //  this.lineePunti = new LinePoint();
      //  linesV = lineePunti.getLinesV();
       // linesO = lineePunti.getLinesO();

      //  this.point = new Pallino(100, 100);
      //  pallini = new ArrayList<>();

      //  this.pointSuper = new PallinoSuper();
       // palliniSuper = this.pointSuper.getPointsSuper();

       // this.lineeIncroci = new LineCross();

       // this.incrocio = new Incrocio();
       // incroci = incrocio.getCross();
        this.threadIncroci = new Thread(new ThreadIncroci());

      //  this.threadCollisioni = new Thread(new ThreadCollisioni());

       // this.threadGhostInattivo = new Thread(new ThreadGhostInattivo());

       // this.labelPunteggio = new Punteggio();
      //  this.labelPunteggio.setBounds(876, 312, 150, 25);
        //this.add(this.labelPunteggio);

        this.addKeyListener(new KeyListener());

        this.addMouseListener(new MouseListener());

        //generaPallini();
        //this.startThread();
        this.matriciana = new Matriciana();

        this.mat = matriciana.getMatrix();
//        mappa.init();
        //    mappa.Stampa();
       
        this.threadIncroci.start();

    }

    @Override
    protected void paintComponent(Graphics g) {
        this.update(g);

        // g.drawImage(sfondoGamePanel, 0, 0, this.getParent());
        matriciana.drawMatrix(g);

        //disegnaPallini(g);
        //player.drawPac(g);
        rosso.draw(g);

        //this.labirinto.drawMaze((Graphics2D) g);
        //pointSuper.draw(g);
        //incrocio.drawCross((Graphics2D) g);
        //lineeIncroci.drawLineCross((Graphics2D) g);
        //this.viteGiocatore = returnVita(player);
        //g.drawImage(viteGiocatore, 75, 365, this.getParent());
    }

    @Override
    public void update(Graphics g) {

        repaint();
    }

//    public void generaPallini() {
//
//        int distanzaPallini = 30;
//        int aggiustaPosizione = distanzaPallini + 20;
//
//        for (int j = 0; j < linesV.length; j++) {
//
//            for (int i = (int) linesV[j].getY1() - aggiustaPosizione; i < (int) linesV[j].getY2() - aggiustaPosizione; i = i + distanzaPallini) {
//                pallini.add(new Pallino((int) linesV[j].getX1(), (int) linesV[j].getY1() + (i)));
//            }
//        }
//
//        for (int j = 0; j < linesO.length; j++) {
//
//            for (int i = (int) linesO[j].getX1() - aggiustaPosizione; i < (int) linesO[j].getX2() - aggiustaPosizione; i = i + distanzaPallini) {
//                pallini.add(new Pallino((int) linesO[j].getX1() + (i), (int) linesO[j].getY1()));
//            }
//        }
//    }

//    public void disegnaPallini(Graphics g) {
//
//        for (int i = 0; i < pallini.size(); i++) {
//            g.drawImage(point.getPoint(), pallini.get(i).getX(), pallini.get(i).getY(), point.getPoint().getWidth(), point.getPoint().getHeight(), null);
//        }
//    }

//    public void mangiaPalline() {
//
//        for (int i = 0; i < pallini.size(); i++) {
//            if (player.getPacRect().intersects(pallini.get(i).getRect())) {
//                pallini.remove(i);
//                labelPunteggio.addPoint();
//
//            }
//        }
//    }

//    public void mangiaPalliniSuper() {
//
//        for (int i = 0; i < palliniSuper.size(); i++) {
//            if (player.getPacRect().intersects(palliniSuper.get(i))) {
//                palliniSuper.remove(i);
//
//                labelPunteggio.addPointSuper();
//
//                rosso.setInattivo(imgInattivo);
//            }
//        }
//    }

    public void pensaDoveAndare() {

        int riga = 22;
        int colonna = 30;

        for (int i = 0; i < riga; i++) {

            for (int j = 0; j < colonna; j++) {

               // if ((mat[i][j].getRectCella().getX() == this.rosso.getRect().getX()) && (mat[i][j].getRectCella().getY() == this.rosso.getRect().getY())) {
             //   if (mat[i][j].getRectCella().getX() == this.rosso.getRect().getX()) {
               if ((mat[i][j].eUn()==2) &&(mat[i][j].getRectCella().contains(this.rosso.getRect()))) {

                    System.out.println("incrocio");
                   // this.rosso.setRiga(i);
                   // this.rosso.setColonna(j);
                    rosso.movimentoIncrocio(i, j);

                }
               
               // if ((mat[i][j].getRectCella().contains(this.rosso.getRect())&&((mat[i][j].eUn()==0)))) {
                if (mat[i][j].getRectCella().contains(this.rosso.getRect())) {

                   // this.rosso.setRiga(i);
                   // this.rosso.setColonna(j);
                    rosso.movimentoNormale(i, j);

                }
                 /* if (mat[i][j].getRectCella().getY() == this.rosso.getRect().getY()) {

                    System.out.println("DIOOOèORCOOOOO \n bòò");
                   // this.rosso.setRiga(i);
                   // this.rosso.setColonna(j);
                    rosso.movimentoIncrocio(i, j);

                }*/

            }

        }

        //  System.out.println("Cella= " +centrocella);
    }

    /*public boolean pensaDoveAndare() {

        for (int i = 0; i < incroci.length; i++) {

            if (incroci[i].contains(rosso.getRect())) {

                if (rosso.getUmore() == TRANQUILLO) {
                    rosso.movimentoIncrocio();
                } else if (rosso.getUmore() == ATTACCO) {
                    rosso.movimentoIncrocioAttacco(player.getPacRect());
                }
                //System.out.println(rosso.getUmore());
                return true;
            }

        }
        return false;
    }*/
//    public void PacIntersectGhost() {
//
//        if (player.getPacRect().intersects(rosso.getRect()) && (rosso.getStato() == 0)) {
//            this.returnVita(player);
//            player.togliVita();
//            player.restart();
//
//        }
//        if (player.getPacRect().intersects(rosso.getRect()) && (rosso.getStato() == 1)) {
//
//            rosso.setOcchi(imgOcchi);
//
//        }
//    }

//    public void stateGhost() {
//
//        if (rosso.getMegaRect().contains(player.getPacRect())) {
//            //System.out.println("dentro");
//            rosso.changeState(ATTACCO);
//        } else {
//            rosso.changeState(TRANQUILLO);
//        }
//    }

    public void startThread() {

        this.threadCollisioni.start();
        this.threadIncroci.start();
        this.threadGhostInattivo.start();
    }

//    public class ThreadCollisioni implements Runnable {
//
//        @Override
//        public void run() {
//            while (player.isVivo()) {
//
//                collisioni();
//                mangiaPalline();
//                PacIntersectGhost();
//                player.movimentoContinuo();
//                mangiaPalliniSuper();
//
//            }
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }

    public class ThreadIncroci implements Runnable {

        @Override
        public void run() {
            while (player.isVivo()) {

               // stateGhost();

              /*  if (rosso.getStato() == 2) {
                    rosso.movimentoTornaInizio();

                } else if (rosso.getStato() == 1) {
                    rosso.movimentoScappa(player.getPacRect());
                } else {
                    /* if (pensaDoveAndare() == true) {
                        //System.out.println("TRUE");
                    } else {
                        //System.out.println("FALSE");

                    }
                    pensaDoveAndare();
                }*/
                    pensaDoveAndare();

                try {
                    Thread.sleep(20);
                } catch (InterruptedException ex) {
                    Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

//    public class ThreadGhostInattivo implements Runnable {
//
//        @Override
//        public void run() {
//            while (true) {
//                try {
//                    Thread.sleep(250000);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(Ghost.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                for (int i = 0; i < palliniSuper.size(); i++) {
//                    if (player.getPacRect().intersects(palliniSuper.get(i))) {
//                        rosso.setAttivo(imgRosso);
//                    }
//                }
//                if ((player.getPacRect().intersects(rosso.getRect()) && rosso.getStato() == 2)) {
//                    rosso.setOcchi(imgRosa);
//                }
//            }
//        }
//    }

    public void collisioni() {

        for (int i = 0; i < lines.length; i++) {

            if (player.getPacRect().intersectsLine(lines[i])) {
                collisione = true;
                //System.out.println("boooom");
            }

            for (int j = 0; j < arches.length; j++) {
                if (arches[j].intersects(player.getPacRect())) {
                    collisione = true;
                    //System.out.println("tocco");
                }
            }
            if ((collisione == true) && (movimentoCorrente == SX)) {

                player.movimentoDx();
                //System.out.println("non posso sxa");
                collisione = false;

            } else if ((collisione == true) && (movimentoCorrente == DX)) {

                player.movimentoSx();
                //System.out.println("non posso dx");
                collisione = false;

            } else if ((collisione == true) && (movimentoCorrente == SU)) {

                player.movimentoGiu();
                //System.out.println("non posso su");
                collisione = false;

            } else if ((collisione == true) && (movimentoCorrente == GIU)) {

                player.movimentoSu();
                //System.out.println("non posso giu");
                collisione = false;
            }
        }
    }

    private BufferedImage returnVita(Giocatore pPlayer) {

        BufferedImage vitePlayer = null;

        if (pPlayer.getVita() == 3) {
            vitePlayer = Resources.getImage("/img/3Vite.png");
        }
        if (pPlayer.getVita() == 2) {
            vitePlayer = Resources.getImage("/img/2Vite.png");
        }
        if (pPlayer.getVita() == 1) {
            vitePlayer = Resources.getImage("/img/1Vita.png");
        }
        return vitePlayer;
    }

    public class KeyListener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent ke) {

            switch (ke.getKeyCode()) {

                case KeyEvent.VK_RIGHT:

                    if (player.getPacRect().x <= LIMITE_DX_FRAME) {

                        player.PacDx();
                        player.movimentoDx();
                        movimentoCorrente = DX;

                    } else {
                    }

                    collisione = false;
                    break;

                case KeyEvent.VK_LEFT:

                    if (player.getPacRect().x <= LIMITE_SX_FRAME) {

                        player.PacSx();
                        player.movimentoSx();
                        movimentoCorrente = SX;

                    } else {
                    }
                    collisione = false;
                    break;

                case KeyEvent.VK_UP:

                    if (player.getPacRect().y <= LIMITE_SU_FRAME) {

                        player.PacSu();
                        player.movimentoSu();
                        movimentoCorrente = SU;

                    } else {
                    }
                    collisione = false;

                    break;

                case KeyEvent.VK_DOWN:

                    if (player.getPacRect().y <= LIMITE_GIU_FRAME) {

                        player.PacGiu();
                        player.movimentoGiu();
                        movimentoCorrente = GIU;

                    } else {
                    }

                    collisione = false;
                    break;
            }
        }
    }

    public class MouseListener extends MouseAdapter {

        @Override
        public void mouseReleased(MouseEvent e) {

            int riga = 22;
            int colonna = 30;
            // riga = 6;
            // colonna = 6;
            for (int i = 0; i < riga; i++) {

                for (int j = 0; j < colonna; j++) {

                    if (mat[i][j].getRectCella().contains(e.getPoint())) {
                        System.out.println("riga= " + i + "colonna= " + j);

                        System.out.println(mat[i][j].getRectCella().getX() + " " + mat[i][j].getRectCella().getY());

                    }
                }

            }

            // Point p = e.getPoint();
            //  System.out.println(p);
        }

    }
}
