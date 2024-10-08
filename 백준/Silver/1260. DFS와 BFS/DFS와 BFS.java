import java.util.*;

public class Main {

	static int N, M, V;
	static int[][] arr;
	static boolean[] visited;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 정점의 개수 N
		// 간선의 개수 M
		// 탐색 시작할 정점의 번호 V
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();

		// 배열 생성
		arr = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = 1;
			arr[b][a] = 1;

		}

		// 방문 배열 생성
		visited = new boolean[N + 1];
		DFS();
		visited = new boolean[N + 1];
		BFS();

	}

	static void DFS() {
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		stack.push(V);

		while (!stack.isEmpty()) {
			int a = stack.pop();
			if (!visited[a]) {
				sb.append(a + " ");
				visited[a] = true;
			}

			for (int i = N; i >= 1; i--) {
				if (arr[a][i] == 1 && !visited[i]) {
					stack.push(i);
				}
			}
		}

		System.out.println(sb);
	}

	static void BFS() {
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		queue.add(V);
		visited[V] = true;
		sb.append(V + " ");

		while (!queue.isEmpty()) {
			int a = queue.poll();

			for (int i = 1; i <= N; i++) {
				if (arr[a][i] == 1 && !visited[i]) {
					queue.add(i);
					sb.append(i + " ");
					visited[i] = true;
				}
			}
		}

		System.out.println(sb);
	}
}
