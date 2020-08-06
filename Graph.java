package dataStructure;

import java.util.*;
public class Graph {
    class Vertex{
        String name;
        HashMap<Vertex, Integer> nbrs;

 

        Vertex(String name){
            this.name = name;
            this.nbrs = new HashMap<Vertex, Integer>();
        }
        
        public boolean equlas(Object other){
            Vertex ov = (Vertex)other;
            return this.name.equals(ov.name);
        }
        
        public void display(){
            String str = this.name + "=>";
            Set<Vertex> nbrs = this.nbrs.keySet();
            for(Vertex nbr: nbrs){
                str += nbr.name + "(" + this.nbrs.get(nbr) + ")";
            }
            str += "END";
            System.out.println(str);
        }
    }
    
    HashMap<String, Vertex> vtces;
    
    Graph(){
        this.vtces = new HashMap<String, Vertex>();
    }
    public int numVtces(){
        return this.vtces.size();
    }
    
    public void addVertex(String name){
        if(this.vtces.containsKey(name)){
            return;
        }
        
        Vertex vtx = new Vertex(name);
        this.vtces.put(name, vtx);
    }
    
    public int numEdges(){
        int rv=0;
        Collection<Vertex> vtces = this.vtces.values();
        
        for(Vertex vtx: vtces){
            rv += vtx.nbrs.size();
        }
        
        rv = rv/2;
        return rv;
    }
    
    public void addEdge(String name1, String name2, int cost){
        Vertex v1 = this.vtces.get(name1);
        Vertex v2 = this.vtces.get(name2);
        if(v1==null || v2==null || v1.nbrs.containsKey(v2)){
            return;
        }
        
        v1.nbrs.put(v2, cost);
        v2.nbrs.put(v1, cost);
    }
    
    public void removeEdge(String name1, String name2){
        Vertex v1 = this.vtces.get(name1);
        Vertex v2 = this.vtces.get(name2);
        if(v1==null || v2==null || !v1.nbrs.containsKey(v2)){
            return;
        }
        
        v1.nbrs.remove(v2);
        v2.nbrs.remove(v1);
    }
    
    public void display(){
        Collection<Vertex> vtces = this.vtces.values();
        for(Vertex vtx: vtces){
            vtx.display();
        }
        System.out.println("**************");
    }
    
    public void removeVertex(String name){
        if(!this.vtces.containsKey(name)){
            return;
        }
        
        Vertex vtx = this.vtces.get(name);
        Set<Vertex> nbrs = vtx.nbrs.keySet();
        for(Vertex nbr: nbrs){
            nbr.nbrs.remove(vtx);
        }
        
        this.vtces.remove(name);
    }
    
    
    public void hasPath(String name1, String name2) {
    	if(!vtces.containsKey(name1) || !vtces.containsKey(name2)) {
    		System.out.println("No");
    	}
    	Vertex v1 = this.vtces.get(name1);
        Vertex v2 = this.vtces.get(name2);
        if(this.hasPathIterative(v1, v2)) {
    		System.out.println("Yes Path Exist");
    	}else {
    		System.out.println("No");
    	}        
        

        HashMap<Vertex, Boolean> visited = new HashMap<Vertex, Boolean>();
        Collection<Vertex> virteces = this.vtces.values();
        for(Vertex x: virteces){
        	visited.put(x, false);
        	}
        
      	if(this.hasPathRecursive(v1, v2, visited)) {
    		System.out.println("Yes Path Exist");
    	}else {
    		System.out.println("No");
    	}
    }
    
    
    private boolean hasPathIterative(Vertex v1, Vertex v2) {
    	HashMap<Vertex, Boolean> map = new HashMap<>();
    	Queue<Vertex> q = new LinkedList<>();
    	q.add(v1);
    	
    	while(!q.isEmpty()) {
    		Vertex rv = q.poll();
    		
    		if(!map.containsKey(rv)) {
    			map.put(rv, true);
    		
	    		if(rv.nbrs.containsKey(v2)) {
	    			return true;
	    		}
	    		Set<Vertex> nbrs = rv.nbrs.keySet();
	            for(Vertex nbr: nbrs){
	            	if(!map.containsKey(nbr)) {
	            		q.add(nbr);
	            	}
	            }
	    	}
    	}
    	return true;
    }

    
 
    
    private boolean hasPathRecursive(Vertex v1, Vertex v2, HashMap<Vertex, Boolean> visited) {
    	if(visited.get(v1)) {
    		return false;
    	}else {
    		visited.put(v1, true);
    	}
    	
    	if(v1.nbrs.containsKey(v2)) {
			return true;
		}
    	
    	Set<Vertex> nbrs = v1.nbrs.keySet();
        for(Vertex nbr: nbrs){
        	if(this.hasPathRecursive(nbr, v2, visited)) {
        		return true;
        	}
        }
        return false;
    }
    
    
    public void isConnected() {
    	HashMap<Vertex, Boolean> map = new HashMap<>();
    	Collection<Vertex> virteces = this.vtces.values();
    	Queue<Vertex> q = new LinkedList<>();
    	for(Vertex x: virteces){
        	q.add(x);
        	}
    	
    	while(!q.isEmpty()) {
    		Vertex rv = q.poll();
    		
    		if(!map.containsKey(rv)) {
    			map.put(rv, true);
	    		Set<Vertex> nbrs = rv.nbrs.keySet();
	            for(Vertex nbr: nbrs){
	            	if(!map.containsKey(nbr)) {
	            		q.add(nbr);
	            	}
	            }
	    	}
    	}
    	if(map.size() == this.numVtces()) {
    		System.out.println("Yes");
    	}else {
    		System.out.println("No");
    	}
    }
    
//    
//    public void isBipartite() {
//    	if(this.isBipartite(this.vtces)) {
//    		System.out.println("Yes");
//    	}else {
//    		System.out.println("No");
//    	}
//    }
//    
//    private boolean isBipartite(HashMap<String, Vertex> map) {
//    	return true;
//    }
//    
//    isConnected
//    connectedComponent
   
    
    
    
    
}