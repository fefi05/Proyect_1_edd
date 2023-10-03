package EDD;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class Pila <T> {
    
    private Nodo <T> cima;
    
    public Pila(){
        cima = null;
    }
    
    public boolean pilaVacia(){
        return cima == null;
    }
    
    public void insertar(Object tInfo){
        Nodo nuevo = new Nodo(tInfo);
        nuevo.setpSig(cima);
        setCima(nuevo);
    }
    
    public T eliminar(){
        if (pilaVacia()) {
            System.out.println("La pila se encuentra vacia");
        }
        T aux = (T) getCima().gettInfo();
        setCima(getCima().getpSig());
        return aux;
        
    }
    
    public void mostrarPila() {
    if (!this.pilaVacia()) {
        Nodo aux = cima;
        while (aux != null) {
            System.out.println(aux.gettInfo());
            aux = aux.getpSig(); // Avanzar al siguiente nodo
        }
    } else {
        System.out.println("La pila se encuentra vacía");
    }
}


    public Nodo getCima() {
        return cima;
    }

    public void setCima(Nodo cima) {
        this.cima = cima;
    } 
}
