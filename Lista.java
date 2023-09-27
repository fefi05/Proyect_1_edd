/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author joses
 */
//CREACIÓN DE CLASE LISTA
public class Lista<T> {

    //Definicion de atributos de la clase lista
    private Nodo<T> pFirst;
    private Nodo<T> pLast;
    private int iN;

    //Constructor
    public Lista() {
        this.iN = 0;
        this.pFirst = null;
        this.pLast = null;
    }

    //Destruir lista
    public void destruirLista() {
        while (pFirst != null) {
            Nodo<T> pTemp = pLast;
            pLast = pLast.pPrev;
            if (pLast != null) {
                pLast.pNext = null;
            }
            pTemp.pPrev = null;
            pTemp = null;
        }
    }

    //Lista esta vacia
    public boolean esVacio() {
        return pFirst == null;
    }

    //Primer nodo de la lista
    public Nodo<T> primero() {
        return pFirst;
    }

    //Ultimo nodo de la lista
    public Nodo<T> ultimo() {
        return pLast;
    }

    //Busca el proximo nodo
    public void proximo(Nodo<T> pValor) {
        if (pValor != null && pValor.pNext != null) {
            pValor = pValor.pNext;
        }
    }

    //Busca el nodo anterior
    public void anterior(Nodo<T> pValor) {
        if (pValor != null && pValor.pPrev != null) {
            pValor = pValor.pPrev;
        }
    }

    //Accede a la informacion del nodo
    public T acceder(Nodo<T> pValor) {
        if (pValor != null) {
            return pValor.tInfo;
        }
        return null;
    }

    //Inserta un nodo en la lista
    public void insertar(T valor, boolean alInicio) {
        Nodo<T> nodo = new Nodo<>(valor);
        if (pFirst == null) {
            pFirst = nodo;
            pLast = nodo;
        } else {
            if (alInicio) {
                // Si es alInicio es true, entonces preInsertar.
                nodo.pNext = pFirst;
                pFirst.pPrev = nodo;
                pFirst = nodo;
            } else {
                // Si es alInicio es false, entonces postInsertar.
                nodo.pPrev = pLast;
                pLast.pNext = nodo;
                pLast = nodo;
            }
        }
        iN++;
    }

    public void eliminar(Nodo<T> pValor) {
        if (pValor != null) {
            if (pValor.pPrev != null) {
                pValor.pPrev.pNext = pValor.pNext;
            } else {
                pFirst = pValor.pNext;
            }

            if (pValor.pNext != null) {
                pValor.pNext.pPrev = pValor.pPrev;
            } else {
                pLast = pValor.pPrev;
            }

            pValor.pNext = null;
            pValor.pPrev = null;
            pValor = null;
            iN--;
        }
    }

    public int tamano() {
        return iN;
    }
}
