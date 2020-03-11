package algoritmos;


public class Main {
    
    public static void main( String args[] ){
        
        int [][] mapa = new int[10][10];
        int xinicial = 1;
        int yinicial = 0;
        int xfinal   = 9;
        int yfinal   = 7;
        
        labSolucion s = new labSolucion(xinicial, yinicial, xfinal, yfinal);
        s.crearMapa(mapa);
        s.verTablero(mapa);
        s.Buscarsolucion(mapa);
    }   
}
