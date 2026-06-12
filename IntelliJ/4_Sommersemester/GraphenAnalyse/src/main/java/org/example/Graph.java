package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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
    }

}
