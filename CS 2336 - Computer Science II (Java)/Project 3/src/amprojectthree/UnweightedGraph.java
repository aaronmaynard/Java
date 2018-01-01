/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amprojectthree;
import java.util.*;

public class UnweightedGraph<V> extends AbstractGraph<V> {
  public UnweightedGraph() {
  }
    
  public UnweightedGraph(V[] vertices, int[][] edges) {
    super(vertices, edges);
  }

  public UnweightedGraph(List<V> vertices, List<Edge> edges) {
    super(vertices, edges);
  }

  public UnweightedGraph(List<Edge> edges, int numberOfVertices) {
    super(edges, numberOfVertices);
  }
  
  public UnweightedGraph(int[][] edges, int numberOfVertices) {
    super(edges, numberOfVertices);
  }
}