package algoritmos;
import java.util.ArrayList;


public class labSolucion {
    
    int xinicial ;
    int yinicial ;
    int xfinal   ;
    int yfinal   ;
    int tiempo = 0;
    int [][] mapa2 ;
    
    ArrayList <Punto> puntosVisitados = new ArrayList();
    ArrayList <Punto> puntosValidos   = new ArrayList();
    
    public labSolucion(int xinicial, int yinicial, int xfinal, int yfinal){
        
        this.xinicial = xinicial;
        this.yinicial = yinicial;
        this.xfinal = xfinal;
        this.yfinal = yfinal;
    }
    
    
    public int[][] crearMapa(int[][] mapa){
        for(int i=0; i<10;i++){
            mapa[0][i] = 1;
        }
        for(int i=0; i<10;i++){
            if(i!=9){
                mapa[1][i] = 0;
            }else{
                mapa[1][i] = 1; 
            }
        }
        for(int i=0; i<10;i++){
            if(i==2||i==8){
                mapa[2][i] = 0;
            }else{
                mapa[2][i] = 1; 
            }
        }
        for(int i=0; i<10;i++){
            if(i==0||i==1||i==3||i==4||i==9){
                mapa[3][i] = 1;
            }else{
            mapa[3][i] = 0; 
            }
        }
        for(int i=0; i<10;i++){
            if(i==2||i==3||i==4||i==5){
                mapa[4][i] = 0;
            }else{
                mapa[4][i] = 1; 
            }
        }
        for(int i=0; i<10;i++){
            if(i==2||i==5){
                mapa[5][i] = 0;
            }else{
                mapa[5][i] = 1; 
            }
        }
        for(int i=0; i<10;i++){
            if(i==5||i==6||i==7||i==8){
                mapa[6][i] = 0;
            }else{
                mapa[6][i] = 1; 
            }
        }
        for(int i=0; i<10;i++){
            if(i==8){
                mapa[7][i] = 0;
            }else{
                mapa[7][i] = 1; 
            }
        }
        for(int i=0; i<10;i++){
            if(i==0||i==1||i==9){
                mapa[8][i] = 1;
            }else{
                mapa[8][i] = 0; 
            }
        }
        for(int i=0; i<10;i++){
            if(i==7){
                mapa[9][7] = 0;
            }else{
                mapa[9][i] = 1; 
            }
        }
        return mapa;
    }
    

    public void mostrarRecorrido (int x, int y){
        mapa2[x][y] = 5;
    }
    
    public void verTablero(int[][] mapa){
        
        int j=0;
        for(int i=0; i<=9;i++){
            for(j=0; j<10; j++){
                System.out.print(mapa[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
    public void Buscarsolucion(int[][] mapa ){
        
        Punto pa = new Punto(xinicial, yinicial);
        Punto pf = new Punto(xfinal, yfinal);

        Punto[] paux;
        mapa2 = mapa;
        puntosValidos.add(pa);
        System.out.println("\nruta valida: "+puntosValidos.get(0).x+","+puntosValidos.get(0).y);
        
        while(true){
            for(int k=0; k < puntosValidos.size(); k++){
                
                pa = puntosValidos.get(0);
                puntosVisitados.add(pa);
                mostrarRecorrido(pa.x, pa.y);
                System.out.println("\n-------------------------------\n");

                if(pa.x != pf.x || pa.y != pf.y){
                    paux = calcularMovimientos(pa.x, pa.y);
                    validarMovimientos(paux, mapa);
                }
                
                if(pa.x == pf.x && pa.y == pf.y){
                    System.out.println("¡Se ha encontrado la salida exitosamente!\n\n");
                    System.exit(0);
                }
                puntosValidos.remove(0);
            }
        }
        
    }
    

    public Punto[] calcularMovimientos(int x, int y){
        Punto aux = new Punto(x,y);
        Punto puntos[] = new Punto[5];
        Movimientos mov = new Movimientos();
        
        if(x==0){
            if(y==0){
                puntos[0] = mov.irDerecha(x, y);
                puntos[1] = mov.irAbajo(x, y);
                puntos[2] = null;
                return puntos;
            }
            if(y==9){
                puntos[0] = mov.irDerecha(x, y);
                puntos[1] = mov.irArriba(x, y);
                puntos[2] = null;
                return puntos;
            }
            if((y<10) && (y>0)){
                puntos[0] = mov.irDerecha(x, y);
                puntos[1] = mov.irArriba(x, y);                
                puntos[2] = mov.irAbajo(x, y);
                puntos[3] = null;
                return puntos;
            }
        }else{
            if(y==0){
                if(x==9){
                    puntos[0] = mov.irIzquierda(x, y);
                    puntos[1] = mov.irAbajo(x, y);
                    puntos[2] = null;
                    return puntos;
                }
                if(x<10 && x>0){
                    puntos[0] = mov.irIzquierda(x, y);
                    puntos[1] = mov.irDerecha(x, y);                
                    puntos[2] = mov.irAbajo(x, y);
                    puntos[3] = null;
                    return puntos;
                }
            
            }else{
                if(x==9){
                    if(y==9){
                        puntos[0] = mov.irIzquierda(x, y);
                        puntos[1] = mov.irArriba(x, y);
                        puntos[2] = null;
                        return puntos;
                    }
                    if(y<9 &&y>0){
                        puntos[0] = mov.irIzquierda(x, y);
                        puntos[1] = mov.irArriba(x, y);                
                        puntos[2] = mov.irAbajo(x, y);
                        puntos[3] = null;
                        return puntos;
                    }
                } else{
                    if(y==9 && (x<9) && (x>0)){
                        puntos[0] = mov.irIzquierda(x, y);
                        puntos[1] = mov.irArriba(x, y);                
                        puntos[2] = mov.irDerecha(x, y);
                        puntos[3] = null;
                        return puntos;
                    }
                }
            }
        }
        puntos[0] = mov.irIzquierda(x, y);
        puntos[1] = mov.irArriba(x, y);                
        puntos[2] = mov.irDerecha(x, y);
        puntos[3] = mov.irAbajo(x, y);
        puntos[4] = null;
        return puntos;

    }
    
  
    public void validarMovimientos(Punto[] paux, int[][] mapa){
        
        int i=0;
        while (paux[i]!=null){
           
            if( mapa[paux[i].x][paux[i].y]==0){
                if (!comprobarExistencia(paux[i].x, paux[i].y)){
                    puntosValidos.add(paux[i]);
                    System.out.println("ruta valida: "+puntosValidos.get(1).x+","+puntosValidos.get(1).y);
                }
            }
            i++;
        }
    }

    public boolean comprobarExistencia(int x, int y){
        
        int indice = 0;
        while(puntosVisitados.size()>indice){
            if(puntosVisitados.get(indice).x==x){
                if(puntosVisitados.get(indice).y==y){
                    return true;
                }
            }
            indice++;
        }
        return false;
    }
}

