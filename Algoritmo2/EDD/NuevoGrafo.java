/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author joses
 * @param <T>
 */
public class NuevoGrafo<T> {

    private Lista<T> listaNodos; // Lista principal de nodos
    private int numVertices;

    //Constructor
    public NuevoGrafo() {
        this.numVertices = 0;
        this.listaNodos = new Lista<>();
    }

    public int getNumVertices() {
        return numVertices;
    }

    public Lista<T> getListaNodos() {
        return listaNodos;
    }

    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    //Metodos
    // Método para agregar un nodo al grafo
    public void agregarNodo(T info) {
        Nodo<T> nodoExistente = listaNodos.obtenerNodo((String) info);
        if (nodoExistente != null) {
            System.out.println("Ya existe un nodo bajo el usuario: " + info + ". No se puede agregar otro.");
            return;
        } else {
            listaNodos.insertar(info);
            setNumVertices(getNumVertices() + 1);
        }
    }

    // Método para eliminar un nodo al grafo
    public void eliminarNodo(T info) {
        Nodo<T> nodoAEliminar = listaNodos.obtenerNodo(info);

        if (nodoAEliminar == null) {
            System.out.println("El nodo a eliminar no existe en el grafo");
            return;
        }

        // Desconectar el nodo a eliminar de todos los otros nodos
        Nodo<T> actual = listaNodos.getpPrim();
        while (actual != null) {
            desconectarNodos(actual.gettInfo(), info);
            actual = actual.getpSig();
        }

        // Eliminar el nodo de la lista principal de nodos
        listaNodos.eliminar(info);
        setNumVertices(getNumVertices() - 1);
    }

    // Método para conectar dos nodos en el grafo (agregar arista entre dos nodos)
    public void conectarNodos(T infoOrigen, T infoDestino) {

        if (infoOrigen.equals(infoDestino)) {
            System.out.println("El usuario " + infoOrigen + " no se puede conectar a sí mismo");
            return;
        }
        Nodo<T> nodoOrigen = listaNodos.obtenerNodo(infoOrigen);
        Nodo<T> nodoDestino = listaNodos.obtenerNodo(infoDestino);

        if (nodoOrigen == null || nodoDestino == null) {
            System.out.println("Uno o ambos nodos no existen en el grafo");
            return;
        }

        Nodo<T> adyacente = nodoOrigen.getAdyacentes().obtenerNodo(infoDestino);
        if (adyacente != null) {
            System.out.println("Los nodos " + infoOrigen + " y " + infoDestino + " ya están conectados");
            return;
        }

        nodoOrigen.getAdyacentes().insertar(infoDestino);
    }

    // Método para desconectar dos nodos en el grafo (eliminar arista entre dos nodos)
    public void desconectarNodos(T infoOrigen, T infoDestino) {
        Nodo<T> nodoOrigen = listaNodos.obtenerNodo(infoOrigen);
        Nodo<T> nodoDestino = listaNodos.obtenerNodo(infoDestino);

        if (nodoOrigen == null || nodoDestino == null) {
            System.out.println("Uno o ambos nodos no existen en el grafo");
            return;
        }

        Nodo<T> adyacente = nodoOrigen.getAdyacentes().obtenerNodo(infoDestino);
        if (adyacente == null) {
            System.out.println("Los nodos " + infoOrigen + " y " + infoDestino + " no están conectados");
            return;
        }

        nodoOrigen.getAdyacentes().eliminar(infoDestino);
    }

    //Metodo que imprime el grafo
    public void imprimirGrafo() {
        System.out.println("El grafo contiene " + getNumVertices() + " vértices: \n");

        Nodo<T> actual = listaNodos.getpPrim();
        while (actual != null) {
            System.out.print("Vértice " + actual.gettInfo() + ": ");
            escribir(actual.getAdyacentes());
            actual = actual.getpSig();
        }
    }

    //Metodo auxiliar
    public void escribir(Lista<T> lista) {
        Nodo<T> pAux = lista.getpPrim();
        while (pAux != null) {
            System.out.print(pAux.gettInfo() + ", ");
            pAux = pAux.getpSig();
        }
        System.out.println("FIN");
    }

    //Kosaraju + fuerte y poderoso.
    
    //Devuelve el grafo con las aristas invertidas
    public NuevoGrafo transpuesto() {
        NuevoGrafo grafoTranspuesto = new NuevoGrafo();
        
        //Recorre la lista de vertices
        Nodo <T> aux = listaNodos.getpPrim();

        // Crear los nodos en el grafo transpuesto
        while (aux != null) {
            grafoTranspuesto.agregarNodo(aux.gettInfo());
            aux = aux.getpSig();
        }
        
        aux = listaNodos.getpPrim();

        // Conectar los nodos en el grafo transpuesto inversamente
        while (aux != null) {
            //Inicializamos un nodo que apunta al primer nodo de la lista adyacente (Lista de relaciones)
            Nodo <T> adyacente = aux.getAdyacentes().getpPrim();
            while (adyacente != null) {
                // Conectar el nodo adyacente en sentido inverso
                grafoTranspuesto.conectarNodos(adyacente.gettInfo(), aux.gettInfo());
                adyacente = adyacente.getpSig();
            }
            //El nodo auxiliar toma la lista adyacente del siguiente vertice
            aux = aux.getpSig();
        }

        return grafoTranspuesto;
    }

    // lo use como guia para ver como se hace el dfs
    public void recorrerGrafo() {
        // Lista para rastrear nodos visitados, OJO: Es posible mejorarlo
        Lista <T> visitados = new Lista <>();

        // Stack para el orden topológico
        Pila <T> pilaOrden = new Pila<>();

        // Recorre todos los nodos en el grafo
        Nodo <T> nodoActual = listaNodos.getpPrim();
        while (nodoActual != null) {
            if (!contiene(visitados, nodoActual.gettInfo())) {
                System.out.println("Nodo actual: " + nodoActual.gettInfo());
                recorrerDFS(nodoActual, visitados, pilaOrden);
            }
            nodoActual = nodoActual.getpSig();
        }

        // Procesa el Stack con el orden topológico pero NO SE EJECUTA EN KOSARAJU
        while (!pilaOrden.pilaVacia()) {
            T nodo = pilaOrden.eliminar();
            System.out.println("Nodo en orden topológico: " + nodo);
        }
    }

    public boolean contiene(Lista<T> lista, T elemento) {
        Nodo <T> actual = lista.getpPrim();
        while (actual != null) {
            if (actual.gettInfo().equals(elemento)) {
                return true;
            }
            actual = actual.getpSig();
        }
        return false;
    }

    public void recorrerDFS(Nodo<T> nodo, Lista<T> visitados, Pila<T> pilaOrden) {
        //Con esto evitamos que los nodos no se visiten mas de una vez
        visitados.insertar(nodo.gettInfo());

        // Recorre los nodos adyacentes
        Nodo <T> adyacente = nodo.getAdyacentes().primero();
        while (adyacente != null) {
            if (!contiene(visitados, adyacente.gettInfo())) {
                //Si entra aqui, es porque hay nodos que no se ha realizado el DFS.
                recorrerDFS(adyacente, visitados, pilaOrden);
            }
            adyacente = adyacente.getpSig();
        }

        // Después de procesar todos los adyacentes, agrega este nodo al Stack
        pilaOrden.insertar(nodo.gettInfo());
        // Imprime el nodo en el componente fuertemente conexo
        System.out.print(nodo.gettInfo() + " ");
    }

    public void kosaraju() {
        //Realizar un recorrido DFS en el grafo original y almacenar los nodos visitados en un Stack
        Pila <T> pilaOrden = new Pila<>();
        Lista<T> visitados = new Lista<>();
        Nodo <T> nodoActual = listaNodos.getpPrim();
        
        
        while (nodoActual != null) {
            if (!contiene(visitados, nodoActual.gettInfo())) {
                recorrerDFS(nodoActual, visitados, pilaOrden);
            }
            nodoActual = nodoActual.getpSig();
        }

        //Calcular el grafo transpuesto
        NuevoGrafo<T> grafoTranspuesto = transpuesto();

        // Paso 3: Realizar un segundo recorrido DFS en el grafo transpuesto usando el orden topológico del Stack
        visitados = new Lista<>();

        while (!pilaOrden.pilaVacia()) {
            
            // EL PROBLEMA ES LA PILA
            T nodo = pilaOrden.eliminar();

            if (!contiene(visitados, nodo)) {
                System.out.print("Componente fuertemente conexa: ");
                recorrerDFS(grafoTranspuesto.listaNodos.obtenerNodo(nodo), visitados, pilaOrden);
                System.out.println();
            }
        }
    }
}
