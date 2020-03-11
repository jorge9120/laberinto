package algoritmos;


public class Movimientos {
    
    public Punto irDerecha (int xactual, int yactual){
        
        Punto p = new Punto (xactual, yactual);
        p.x = p.x+1;
        return p;
    }
    public Punto irIzquierda    (int xactual, int yactual){
        Punto p = new Punto (xactual, yactual);
        p.x = p.x-1;      
        return p;
    }
    public Punto irAbajo    (int xactual, int yactual){
        Punto p = new Punto (xactual, yactual);
        p.y = p.y+1;       
        return p;
    }
    public Punto irArriba   (int xactual, int yactual){
        Punto p = new Punto (xactual, yactual);
        p.y = p.y-1; 
        return p;
    }
            
}
