/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfsanddfs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author pushg
 */
public class BFSandDFS {
        static class BFS {

        private int vertices; // 頂點的數量
        private LinkedList<Integer>[] adjList; // 存放相鄰节點

        // 構造函數
        public BFS(int vertices) {
            this.vertices = vertices;
            adjList = new LinkedList[vertices];
            // 創建linked list為每個頂點的鄰居
            for (int i = 0; i < vertices; i++) {
                adjList[i] = new LinkedList<>();
            }
        }

        // 添加邊
        public void addEdge(int source, int destination) {
            adjList[source].addLast(destination);

            // 對於無向圖，不必再添加另外一條
//        adjList[destination].addLast(source);
        }

        // 完整BFS函數
        public void bfs(int startVertex) {
            boolean[] visited = new boolean[vertices];

            LinkedList<Integer> queue = new LinkedList<>();

            visited[startVertex] = true;
            queue.add(startVertex);

            while (queue.size() != 0) {
                // 獲取頭部頂點並刪除頭部節點
                startVertex = queue.poll();
                System.out.print(startVertex + " ");

                // 尋找與startVertex相鄰的所有節點
                Iterator<Integer> iterator = adjList[startVertex].listIterator();
                while (iterator.hasNext()) {
                    int nextVertex = iterator.next();
                    // 若沒有被訪問，則將其加入佇列
                    if (!visited[nextVertex]) {
                        visited[nextVertex] = true;
                        queue.add(nextVertex);
                    }
                }
            }
        }
    }

    static class DFS {

        private int V;   // No. of vertices

        // Array  of lists for Adjacency List Representation
        private LinkedList<Integer> adj[];

        // Constructor
        DFS(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i) {
                adj[i] = new LinkedList();
            }
        }

        //Function to add an edge into the graph
        void addEdge(int v, int w) {
            adj[v].add(w);  // Add w to v's list.
        }

        // A function used by DFS
        void DFSUtil(int v, boolean visited[]) {
            // Mark the current node as visited and print it
            visited[v] = true;
            System.out.print(v + " ");

            // Recur for all the vertices adjacent to this vertex
            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    DFSUtil(n, visited);
                }
            }
        }

        // The function to do DFS traversal. It uses recursive DFSUtil()
        void DFS(int v) {
            // Mark all the vertices as not visited(set as
            // false by default in java)
            boolean visited[] = new boolean[V];

            // Call the recursive helper function to print DFS traversal
            DFSUtil(v, visited);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BFS b = new BFS(4);

        b.addEdge(0, 1);
        b.addEdge(0, 2);
        b.addEdge(1, 2);
        b.addEdge(2, 0);
        b.addEdge(2, 3);
        b.addEdge(3, 3);

        b.bfs(0);

        DFS g = new DFS(4);
        System.out.println();
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.DFS(0);
    }
}
