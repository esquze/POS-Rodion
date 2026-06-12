package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Graph {

    boolean[][] graph;
    int n; // Anzahl Knoten

    public void importFromCSV() throws GraphException {
        String filepath = "src/main/resources/graph.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line = br.readLine();
            String[] lineParts = line.trim().split(";");
            n = lineParts.length;
            graph = new boolean[n][n];

            int row = 0;
            while (line != null && !line.isBlank()) {
                lineParts = line.trim().split(";");
                for (int col = 0; col < n; col++) {
                    if (lineParts[col].equals("0")) {
                        graph[row][col] = false;
                    }
                    if (lineParts[col].equals("1")) {
                        graph[row][col] = true;
                    }
                }
                row++;
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new GraphException("File ist nicht gefunden: " + e.getMessage());
        } catch (IOException e) {
            throw new GraphException("I/O Fehler mit Datei: " + e.getMessage());
        }
    }

    public int[] bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        int[] distances = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(distances, -1);

        queue.add(start);
        distances[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 0; i < graph.length; i++) {
                if (graph[current][i] && !visited[i]) {
                    visited[i] = true;
                    distances[i] = distances[current] + 1;
                    queue.add(i);
                }
            }
        }
        return distances;
    }

    public int eccentricity(int node) {
        int[] distances = bfs(node);
        int max = 0;
        for (int i = 0; i < distances.length; i++) {
            if (distances[i] > max) {
                max = distances[i];
            }
        }
        return max;
    }

    public int radius() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int ecc = eccentricity(i);
            if (ecc < min) {
                min = ecc;
            }
        }
        return min;
    }

    public int durchmesser() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int ecc = eccentricity(i);
            if (ecc > max) {
                max = ecc;
            }
        }
        return max;
    }

    public List<Integer> zentrum() {
        List<Integer> result = new ArrayList<>();
        int r = radius();
        for (int i = 0; i < n; i++) {
            if (eccentricity(i) == r) {
                result.add(i);
            }
        }
        return result;
    }

    public void dfs(int node, boolean[] visited) {
        visited[node] = true;
        for (int i = 0; i < n; i++) {
            if (graph[node][i] && !visited[i]) {
                dfs(i, visited);
            }
        }
    }

    public int components() {
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited);
                count++;
            }
        }
        return count;
    }

    void dfsIgnore(int node, boolean[] visited, int ignore) {
        visited[node] = true;
        for (int i = 0; i < n; i++) {
            if (i != ignore && graph[node][i] && !visited[i]) {
                dfsIgnore(i, visited, ignore);
            }
        }
    }

}
