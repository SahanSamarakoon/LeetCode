package com.tempdecal.ieeextreme;

import java.util.*;

public class TravelService {

    public static int s;
    public static int c;

    public static class Vertex implements Comparable<Vertex> {
        int inBetween;
        int price;
        long distance = Long.MAX_VALUE;
        boolean visited;
        List<Edge> adjacentEdge = new ArrayList<>();
        Vertex predecessor = null;

        public Vertex(int inBetween, int price) {
            this.inBetween = inBetween;
            this.price = price;
        }

        public void addadjacentEdge(Edge e) {
            adjacentEdge.add(e);
        }

        @Override
        public int compareTo(Vertex b) {
            return (int) (this.distance - b.distance);
        }

        @Override
        public String toString() {
            return String.valueOf(this.inBetween);
        }
    }

    public static class Edge {
        Vertex from;
        Vertex to;
        long weight;

        public Edge(Vertex from, Vertex to, long weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static class Dijkstra {
        Vertex source;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<>();

        public Dijkstra(Vertex source) {
            this.source = source;
        }

        void computePath() {
            source.distance = 0;

            vertexQueue.add(source);

            while (!vertexQueue.isEmpty()) {
                Vertex actualVertex = vertexQueue.peek();

                for (Edge edge : actualVertex.adjacentEdge) {
                    Vertex v = edge.to;

                    if (!v.visited) {
                        if (actualVertex.distance + edge.weight < v.distance) {
                            v.distance = actualVertex.distance + edge.weight;
                            v.predecessor = actualVertex;
                            vertexQueue.add(v);
                        }
                    }
                }
                vertexQueue.poll();
                actualVertex.visited = true;
            }
        }

        List<Vertex> shortestPath(Vertex v) {
            List<Vertex> shortPath = new ArrayList<>();

            shortPath.add(v);
            while (v.predecessor != null) {
                shortPath.add(v.predecessor);
                v = v.predecessor;
            }

            Collections.reverse(shortPath);

            return shortPath;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            solve(in);
        }
        in.close();
    }

    public static void solve(Scanner in) {
        s = in.nextInt();
        c = in.nextInt();
        int r0 = in.nextInt();
        List<Vertex> vertexList = new ArrayList<>();
        Vertex rootVertex = new Vertex(c, r0);
        vertexList.add(rootVertex);
        for (int i = 0; i < s; i++) {
            int di = in.nextInt();
            int ri = in.nextInt();
            Vertex vertex = new Vertex(di, ri);
            vertexList.add(vertex);
        }
        for (int i = 0; i < vertexList.size() - 1; i++) {
            int dis = 0;
            int j = i;
            while (true) {
                if (j < vertexList.size() - 1 && dis + vertexList.get(j + 1).inBetween <= c) {
                    long weight = ((long)vertexList.get(j + 1).price * (long) vertexList.get(j + 1).inBetween) + 500L;
                    Edge edge = new Edge(vertexList.get(i), vertexList.get(j + 1), weight);
                    vertexList.get(i).addadjacentEdge(edge);
                    dis += vertexList.get(j + 1).inBetween;
                    j += 1;
                } else break;
            }
        }
        Dijkstra dijkstra = new Dijkstra(vertexList.get(0));
        dijkstra.computePath();
        List<Vertex> path = dijkstra.shortestPath(vertexList.get(vertexList.size() - 1));

        long cost = 0L;
        long localDistance = 0L;
        Vertex localVertex;
        for (int i = 0; i < vertexList.size() - 1; i++) {
            localVertex = vertexList.get(i);
            localDistance += localVertex.inBetween;
            if (path.contains(localVertex)) {
                if (i != 0) cost += 500L;
                cost += localVertex.price * localDistance;
                localDistance = 0;
            }
        }
        if (c == (path.get(path.size() - 1).inBetween + localDistance))
            cost += 500L + ( c * (long) vertexList.get(vertexList.size() - 1).price);
        System.out.println(cost);
    }
}
