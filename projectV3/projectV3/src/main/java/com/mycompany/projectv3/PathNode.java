package com.mycompany.projectv3;

import java.util.Collections;
import java.util.Stack;

public class PathNode {
    final PathNode prev;
    final Node current;
    final double gCost;
    final double hCost;

    PathNode(PathNode prev, Node current, double gCost, double hCost){
        this.prev = prev;
        this.current = current;
        this.gCost = gCost;
        this.hCost = hCost;
    }

    public double cost(){
        return gCost + hCost;
    }

    @Override
    public String toString(){
        Stack<String> names = new Stack<>();
        PathNode current = this;
        while (current != null) {
            names.add(current.current.name);
            current = current.prev;
        }
        Collections.reverse(names);
        return String.join(" -> ", names) + ", cost = " + gCost;
    }
}
