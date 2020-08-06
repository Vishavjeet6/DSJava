package dataStructure;

public class HeapClient {
	public static void main(String[] args) {
		Heap<Integer> heap = new Heap<>(false);
		heap.add(35);
		heap.add(45);
		heap.add(55);
		heap.add(15);
		heap.add(5);
		heap.add(30);
		
		heap.display();
		System.out.println("************************");
		heap.add(45);
		heap.display();
		heap.remove();
		System.out.println("*********************");
		heap.display();
		int[] a=heap.median();
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");

		}
	}

}
