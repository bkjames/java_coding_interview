import java.util.*;
class Solution {
    static class Node {
            private int data;
            private List<Node> adjacent = new ArrayList<Node>();
            public Node(int data) {
                this.data = data;
            }
            public void addAdjacent(Node node) {
                adjacent.add(node);
            }
        }
   public int solution(int n, int[][] computers) {
        int answer = 0;
        Queue<Node> queue = new LinkedList<Node>();
        List<Node> list = new ArrayList<Node>();
        boolean[] visited = new boolean[computers.length];

        for (int i = 0; i < computers.length; i++)
            list.add(new Node(i));

        for (int i = 0; i < computers.length; i++)
            for (int j = 0; j < computers[0].length; j++)
                if(computers[i][j] == 1 && i != j)
                    list.get(i).addAdjacent(list.get(j));

        for (int i = 0; i < list.size(); i++) {
            if(!visited[i]) {
                queue.add(list.get(i));
                visited[i] = true;
                answer++;
            }

            while(!queue.isEmpty()) {
                Node pop = queue.poll();
                List<Node> nodes = pop.adjacent;
                for (Node node : nodes) {
                    if(!visited[node.data]) {
                        visited[node.data] = true;
                        queue.add(node);
                    }
                }
            }
        }

        return answer;
    }
}
