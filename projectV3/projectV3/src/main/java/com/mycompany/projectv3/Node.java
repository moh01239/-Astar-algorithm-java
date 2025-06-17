/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectv3;

/**
 *
 * @author DELL
 */

import java.util.Objects;

    public class Node {
        final String name;
        final double x, y;

        public Node(String name, double x, double y) {
            this.name = name;
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Node other)) {
                return false;
            }
            return this.name.equals(other.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }
