/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author G. Angelo, S. Estefania y S. Jose
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
    public void insertar(T elem) {
        Nodo<T> nuevoNodo = new Nodo<>(elem);
        if (this.esVacio() == true) {
            this.setpPrim(nuevoNodo);
        } else {
            Nodo<T> pAux = this.getpPrim();
            while (pAux.getpSig() != null) {
                pAux = pAux.getpSig();
            }
            pAux.setpSig(nuevoNodo);
        }
        this.setiN(this.getiN() + 1);
    }

    // Eliminar un nodo de la lista
    public void eliminar(T elem) {
        if (this.esVacio() == true) {
            // Imprimir un mensaje y salir del método
            System.out.println("La lista está vacía");
            return;
        }

        // Si el elemento a eliminar está en el primer nodo
        if (this.getpPrim().gettInfo().equals(elem)) {
            this.setpPrim(this.getpPrim().getpSig());
            this.setiN(this.getiN() - 1);
            return;
        }

        Nodo<T> actual = this.getpPrim();
        Nodo<T> anterior = null;

        while (actual != null && !actual.gettInfo().equals(elem)) {
            anterior = actual;
            actual = actual.getpSig();
        }

        if (actual == null) {
            // Opción 1: Imprimir un mensaje y salir del método
            System.out.println("El elemento no está en la lista");
            return;
        }

        anterior.setpSig(actual.getpSig());
        this.setiN(this.getiN() - 1);
    }

    //Tamano de la lista
    public int tamano() {
        return getiN();
    }

    //Busqueda en la lista
    public boolean busqueda(T elem) {
        Nodo<T> actual = this.pPrim;
        while (actual != null) {
            if (actual.gettInfo().equals(elem)) {
                return true; // Elemento encontrado
            }
            actual = actual.getpSig();
        }
        return false; // Elemento no encontrado
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
