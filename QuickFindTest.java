public class QuickFindTest{
	public static void main(String[] args) {
		QuickFind q = new QuickFind(10);

		q.union(4,3);
		q.union(3,8);

		System.out.println("Is 4 and 8 connected? " + q.isConnected(4,8));
	}
}

class QuickFind {
	private int[] id;

	public QuickFind(int size){
		id = new int[size];
		for (int i=0;i<size ;i++ ) {
			id[i] = i;
		}
	}

	public void union(int startpt, int endpt){
		int startptRoot = id[startpt];
		int endptRoot = id[endpt];
		for (int i=0;i<id.length ;i++ ) {
			if (id[i]== startptRoot) {
				id[i] = endptRoot;
			}
		}
	}

	public boolean isConnected(int x,int y){
		return id[x]==id[y];
	}
}