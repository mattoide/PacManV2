package GUI;

public class Map {

    int lineLength = 15;
    int columnLength = 20;
    Cella[][] matrix = new Cella[lineLength][columnLength];

    public Map(){
        
    }
    
  /*  public void init(){
        int x, y = 0;
        for (int i = 0; i < lineLength; i++) {
            for (int j = 0; j < columnLength; j++) {

                if ((i == 0) && (j == 0)) {
                    matrix[i][j] = new Cella(0, 0);
                } else if (j == 0) {
                    y = matrix[i - 1][j].getY() + 80;
                    matrix[i][j] = new Cella(0, y);
                } else {
                    x = matrix[i][j - 1].getX() + 80;
                    matrix[i][j] = new Cella(x, y);
                }
            }
        }
    }
*/
    public void Stampa(){
        for (int i = 0; i < lineLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                System.out.println(matrix[i][j].toString());
            }
        }
    }
}
