public class WeightedQuickUnionTest {
	public static void main(String[] args) {
		WeightedQuickUnion q = new WeightedQuickUnion(10);

		q.union(4,3);
		q.union(3,8);
		q.union(5,6);
		q.union(7,8);
		q.union(5,3);
		System.out.println("Is 4 and 8 connected? " + q.isConnected(4,8));

		for (int i=0;i<q.id.length ;i++ ) {
			System.out.println(q.id[i] + " "+ q.weight[i]);	
		}
		
	}
}

class WeightedQuickUnion {
	int [] id;
	int [] weight;

	WeightedQuickUnion (int n){
		this.id = new int[n];
		this.weight = new int[n];
		for (int i=0;i<n ;i++ ) {
			this.id[i] = i;
		}
		for (int i=0;i<n ;i++ ) {
			this.weight[i] = 1;
		}
	}

	private int root(int i){
		while(i!=id[i]) i = id[i];
		return i;
	}

	public boolean isConnected(int p,int q){
		return root(p)==root(q);
	}

	public void union(int p, int q){
		int proot = root(p);
		int qroot = root(q);
		int psize = weight[p];
		int qsize = weight[q];

		if (psize>qsize) {
			id[q] = proot;
			weight[p]+=weight[q];
		} else {
			id[p] = qroot;
			weight[q]+=weight[p];
		}
	}
}