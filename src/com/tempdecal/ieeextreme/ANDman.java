package com.tempdecal.ieeextreme;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ANDman {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            solve(in);
        }
        in.close();
    }

    public static void solve(Scanner in) {
        List<Vertex> nodes;
        nodes = new ArrayList<Vertex>();

        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int val = in.nextInt();
            Vertex node = new Vertex("Node" + (i + 1), val);
            nodes.add(node);
        }
        for (int i = 0; i < n - 1; i++) {
            int parentPlace = in.nextInt() - 1;
            int childPlace = in.nextInt() - 1;
            Vertex parentNode = nodes.get(parentPlace);
            Vertex childNode = nodes.get(childPlace);
            parentNode.add_neighbor(childNode);
        }

        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            int t = in.nextInt();
            int u = in.nextInt();
            long v = in.nextLong();
            if (t == 1) {
                nodes.get(u - 1).val = v;
            }
            if (t == 2) {
                long ans = 1L;
                Vertex parentNode = nodes.get(u - 1);
                Vertex childNode = nodes.get((int) v - 1);
                List<Vertex> path = new ShortestPath(parentNode, childNode).findPath();
                for (Vertex node : path) {
                    if (node.val != 0) ans = ans * node.val;
                }
                nodes.stream().parallel().forEach(node -> node.visited = false);
                nodes.stream().parallel().forEach(node -> node.prev = null);
                System.out.println(ans % 1000000007L);
            }
        }
    }

    static class Vertex {
        String name;
        long val;
        List<Vertex> neighbors;
        boolean visited = false;
        Vertex prev = null;

        Vertex(String name, long val) {
            this.name = name;
            this.val = val;
            this.neighbors = new ArrayList<>();
        }

        void add_neighbor(Vertex vertex) {
            this.neighbors.add(vertex);
            vertex.neighbors.add(this);
        }

        public String toString() {
            return this.name;
        }
    }

    static class ShortestPath {
        Vertex start, end;

        ShortestPath(Vertex start, Vertex end) {
            this.start = start;
            this.end = end;
        }

        List<Vertex> findPath() {
            dfs(start);
            return trace_route();
        }

        private void dfs(Vertex vertex) {
            if (vertex.equals(end)) {
                return;
            }
            vertex.visited = true;
            for (Vertex nbr : vertex.neighbors) {
                if (!nbr.visited) {
                    nbr.prev = vertex;
                    dfs(nbr);
                }
            }
        }

        private List<Vertex> trace_route() {
            Vertex vertex = end;
            List<Vertex> route = new ArrayList<>();
            while (vertex != null) {
                route.add(vertex);
                vertex = vertex.prev;
            }
            return route;
        }
    }
}
