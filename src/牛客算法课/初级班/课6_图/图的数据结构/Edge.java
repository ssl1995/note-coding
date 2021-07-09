package 牛客算法课.初级班.课6_图.图的数据结构;

public class Edge {
	// 默认是有向边
	public int weight;
	public Node from;
	public Node to;

	public Edge(int weight, Node from, Node to) {
		this.weight = weight;
		this.from = from;
		this.to = to;
	}

}
