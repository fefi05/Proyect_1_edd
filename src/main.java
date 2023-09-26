/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author PC
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(1, 3);
        g.addEdge(3, 4);

        System.out.println("Componentes fuertemente conexos:");
        g.printSCCs();
    }
}
    
    

