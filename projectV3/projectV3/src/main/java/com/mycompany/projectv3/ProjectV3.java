/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projectv3;

/**
 *
 * @author DELL
 */
public class ProjectV3 {

    
    public static void main(String[] args) {
        Graph g = new Graph();
        Node A = new Node("A", 0, 0);
        Node B = new Node("B", 2, 1);
        Node C = new Node("C", 2, -1);
        Node D = new Node("D", 4,  1);
        Node E = new Node("E", 4, -1);
        Node F = new Node("F", 6,  0);
        Node H = new Node("H", 2,  10);

        g.addUniEdge(A, B, 3);
        g.addUniEdge(A, C, 2);
        g.addEdge(B, D, 4);
        g.addUniEdge(C, E, 5);
        g.addUniEdge(D, F, 2);
        g.addUniEdge(E, F, 1);

        g.addUniEdge(B, C, 1);
        g.addUniEdge(D, E, 2);

        System.out.println("Test 1: Expected A -> C -> E -> F, cost = 8.0");
        g.printAStarShortestPath(A, F);

        System.out.println("\nTest 2: Expected Start Node is the same as Goal Node");
        g.printAStarShortestPath(A, A);

        System.out.println("\nTest 3: Expected No path exists between A and H");
        g.printAStarShortestPath(A, H);

    }
}
