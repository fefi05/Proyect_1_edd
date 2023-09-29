/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Graph_1{

    private int V; // Número de vértices
    private List<List<Integer>> adj; // Lista de adyacencia

    Graph_1(int vertices) {
        V = vertices;
        adj = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Agrega una arista al grafo dirigido
    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    // Realiza un recorrido DFS desde un vértice dado y llena el stack
    void fillOrder(int v, boolean visited[], Stack<Integer> stack) {
        visited[v] = true;
        for (Integer neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                fillOrder(neighbor, visited, stack);
            }
        }
        stack.push(v);
    }

    // Obtiene el grafo transpuesto (todas las aristas invertidas)
    Graph_1 getTranspose() {
        Graph_1 transposed = new Graph_1(V);
        for (int v = 0; v < V; v++) {
            for (Integer neighbor : adj.get(v)) {
                transposed.addEdge(neighbor, v);
            }
        }
        return transposed;
    }

    // Encuentra los componentes fuertemente conexos del grafo
    void printSCCs() {
        Stack<Integer> stack = new Stack<>();

        // Marca todos los vértices como no visitados
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        // Llena el stack en el orden en el que se terminan los vértices
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                fillOrder(i, visited, stack);
            }
        }

        // Obtiene el grafo transpuesto
        Graph_1 transposed = getTranspose();

        // Marca todos los vértices como no visitados nuevamente
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        // Procesa los vértices en el orden dado por el stack
        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {
                transposed.DFSUtil(v, visited);
                System.out.println();
            }
        }
    }

    // Realiza un recorrido DFS desde un vértice dado
    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");

        for (Integer neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited);
            }
        }
    }

}
