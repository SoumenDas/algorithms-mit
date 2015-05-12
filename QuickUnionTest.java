public class QuickUnionTest {
	public static void main(String[] args) {
		QuickUnion q = new QuickUnion(10);

		q.union(4,3);
		q.union(3,8);

		System.out.println("Is 4 and 8 connected? " + q.isConnected(4,8));
	}
}

class QuickUnion {
	private int[] id;

	QuickUnion (int size){
		this.id = new int[size];
		for (int i=0;i<size ;i++ ) {
			id[i] = i;
		}
	}

	private int root(int i){
		while(i!=id[i]) i = id[i];
		return i;
	}

	public boolean isConnected(int p, int q){
		return root(p)==root(q);
	}

	public void union(int p, int q){
		int proot = root(p);
		int qroot = root(q);

		id[qroot] = proot;
	}
}