package EDD;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author G. Angelo, S. Estefania y S. Jose
 * @param <T>
 */
//CREACIÓN DE CLASE LISTA
public class Lista<T> {

    //Definicion de atributos de la clase lista
    private Nodo<T> pPrim;
    private int iN;

    //Constructor
    public Lista() {
        this.iN = 0;
        this.pPrim = null;
    }

    //Metodos de la clase Lista
    //Lista esta vacia
    public boolean esVacio() {
        return getpPrim() == null;
    }

    //Primer nodo de la lista
    public Nodo<T> primero() {
        return getpPrim();
    }

    //Busca el proximo nodo
    public void proximo(Nodo<T> pValor) {
        if (pValor != null && pValor.getpSig() != null) {
            pValor = pValor.getpSig();
        }
    }

    //Accede a la informacion del nodo
    public T acceder(Nodo<T> pValor) {
        if (pValor != null) {
            return pValor.gettInfo();
        }
        return null;
    }

    //Inserta un nodo en la lista
    public void insertar(T nuevoElemento) {
        Nodo<T> nuevoNodo = new Nodo<>(nuevoElemento);
        if (this.esVacio()) {
            this.pPrim = nuevoNodo;
        } else {
            Nodo<T> pAux = this.pPrim;
            while (pAux.getpSig() != null) {
                pAux = pAux.getpSig();
            }
            pAux.setpSig(nuevoNodo);
        }
        this.iN++;
    }

    // Eliminar un nodo de la lista
    public void eliminar(T elemento) {
        if (pPrim == null || elemento == null) {
            return;
        }

        if (pPrim.gettInfo().equals(elemento)) {
            pPrim = pPrim.getpSig();
            iN--;
            return;
        }

        Nodo<T> actual = pPrim;
        while (actual.getpSig() != null && !actual.getpSig().gettInfo().equals(elemento)) {
            actual = actual.getpSig();
        }

        if (actual.getpSig() != null) {
            actual.setpSig(actual.getpSig().getpSig());
            iN--;
        }
    }

    //Tamano de la lista
    public int tamano() {
        return getiN();
    }

    //Busqueda de un nodo en la lista
    public Nodo<T> obtenerNodo(Object elem) {
        Nodo<T> actual = this.pPrim;
        while (actual != null) {
            if (actual.gettInfo().equals(elem)) {
                return actual;
            }
            actual = actual.getpSig();
        }
        return null;
    }

    // Gets & Sets
    /**
     * @return the pPrim
     */
    public Nodo<T> getpPrim() {
        return pPrim;
    }

    /**
     * @param pPrim the pPrim to set
     */
    public void setpPrim(Nodo<T> pPrim) {
        this.pPrim = pPrim;
    }

    /**
     * @return the iN
     */
    public int getiN() {
        return iN;
    }

    /**
     * @param iN the iN to set
     */
    public void setiN(int iN) {
        this.iN = iN;
    }

}
