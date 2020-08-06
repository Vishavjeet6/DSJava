package dataStructure;

import java.util.*;

public class Heap<T extends Comparable> {
	private ArrayList<T> data;
	boolean isMin;
	
	Heap(){
		this(false);
	}
	
	Heap(boolean isMin){
		this.isMin = isMin;
		this.data = new ArrayList<>();
	}
	
	public T getHP() {
		return this.data.get(0);
	}
	
	
	
	private void swap(int i, int j) {
		T ithitem = this.data.get(i);
		T jthitem = this.data.get(j);
		
		this.data.set(i,  jthitem);
		this.data.set(j,  ithitem);
	}
	
	
	private boolean isLarger(int i, int j) {
		T ithitem = this.data.get(i);
		T jthitem = this.data.get(j);
		
		if(this.isMin) {
			return ithitem.compareTo(jthitem) < 0;
		}else {
			return ithitem.compareTo(jthitem) > 0;
		}
	}
	
	public void add(T element) {
		this.data.add(element);
		this.upheapify(this.data.size()-1);
	}
	
	private void upheapify(int ci) {
		if(ci==0) return;
		int pi = (ci-1)/2;
		if(!this.isLarger(pi, ci)) {
			this.swap(pi, ci);
			this.upheapify(pi);
		}
	}
	public int [] median(){
		int m = this.data.size();
		if(m%2==0){
			int ans[] = new int[2];
			ans[0] = (int)this.data.get((m-1)/2);
			ans[1] = (int)this.data.get(m/2);
			return ans;
		}else{
			int ans[] = new int[1];
			ans[0] = (int)this.data.get((m-1)/2);
			return ans;
		}
	}
	
	
	public void display() {
		this.display(0);
	}
	
	private void display(int i) {
		
		int lci = 2*i+1;
		int rci = 2*i+2;
		
		String str = "";
		if(lci<this.data.size()) {
			T lc = this.data.get(lci);
			str = str + lc + "=>";
		}else {
			str = str + "END=>";
		}
		str = str+this.data.get(i);
		
		if(rci<this.data.size()) {
			T rc = this.data.get(rci);
			str = str +"<="+ rc ;
		}else {
			str = str + "<=END";
		}
		
		System.out.println(str);
		
		if(lci<this.data.size()) {
			this.display(lci);
		}
		if(rci< this.data.size()) {
			this.display(rci);
		}
		
	}
	
	public void remove() {
		this.swap(0, this.data.size()-1);
		this.data.remove(this.data.size()-1);
		this.downheapify(0);
	}
	
	private void downheapify(int pi) {
		int mi = pi;
		int lci = 2*pi+1;
		int rci = 2*pi+2;
		
		if(lci < this.data.size() && this.isLarger(lci, mi)) {
			mi = lci;
		}
		if(rci < this.data.size() && this.isLarger(rci, mi)) {
			mi = rci;
		}
		if(mi != pi) {
			this.swap(mi, pi);
			this.downheapify(mi);
		}
	}
	
	
}