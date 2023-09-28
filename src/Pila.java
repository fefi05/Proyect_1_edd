/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class Pila {
    
    private NodoPila cima;
    
    public Pila(){
        cima = null;
    }
    
    public boolean pilaVacia(){
        return cima == null;
    }
    
    public void insertar(Object tInfo){
        NodoPila nuevo = new NodoPila(tInfo);
        nuevo.setpSig(cima);
        setCima(nuevo);
    }
    
    public Object eliminar(){
        if (pilaVacia()) {
            System.out.println("La pila se encuentra vacia");
        }
        Object aux = getCima().gettInfo();
        setCima(getCima().getpSig());
        return aux;
        
    }
    
    public void mostrarPila(){
        if (!this.pilaVacia()) {
            NodoPila aux = cima;
            while (cima != null) {                
                System.out.println(cima.gettInfo());
            }
        }
    }

    public NodoPila getCima() {
        return cima;
    }

    public void setCima(NodoPila cima) {
        this.cima = cima;
    }
    
    
    
}
