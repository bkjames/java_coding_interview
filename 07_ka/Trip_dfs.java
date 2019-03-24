package repeat;
import java.util.*;

public class Trip_dfs {
	
	public static void main(String[] args) {
		String[][] strs = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		Trip_dfs a = new Trip_dfs();
		String[] res = a.solution(strs);
		
		for(String s: res) {
			System.out.print(s+" ");
		}
	}

	public String[] solution(String[][] tickets) {
        // 출발지 초기화 //
        List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < tickets.length; i++)
            nodeList.add(new Node(tickets[i][0], tickets[i][1]));
 
        Collections.sort(nodeList, ((o1, o2) -> o1.start.compareTo((o2.start)) != 0
                ? o1.start.compareTo((o2.start)) : o1.destination.compareTo(o2.destination)));
 
        // ICN으로 시작된 출발점 설정 //
        List<Node> starts = new ArrayList<>();
        for (Node node : nodeList)
            if(node.start.equals("ICN"))
                starts.add(node);
 
        // DFS //
        for (Node node : starts) {
            node.index = 0;
            if(dfs(nodeList, node, 1)) break;
        }
 
        return createArray(nodeList);
    }
 
    public String[] createArray(List<Node> nodeList) {
        // index 순차적으로 값을 넣기 위해 //
        Collections.sort(nodeList, (o1, o2) -> o1.index > o2.index ? 1 : -1);
 
        String[] answer = new String[nodeList.size() + 1];
        answer[0] = nodeList.get(0).start;
        answer[1] = nodeList.get(0).destination;
        for (int i = 1; i < nodeList.size(); i++)
            answer[i + 1] = nodeList.get(i).destination;
 
        return answer;
    }
 
    public boolean dfs(List<Node> tickets, Node start, int idx) {
        boolean stop = false;
        if(idx == tickets.size())
            return true;
 
        for (Node ticket : tickets) {
            if(ticket.index < 0 && start.isAdjacent(ticket)) {
                ticket.index = idx;
                if((stop = dfs(tickets, ticket, idx + 1))) break;
            }
        }
 
        // 잘못된 경로 일 경우, 현재 경로는 취소하기 위한 로직 //
        if(!stop)
            start.index = -1;
 
        return stop;
    }
 
    public class Node {
        private String start;
        private String destination;
        private int index = -1;
 
        public Node(String start, String destination) {
            this.start = start;
            this.destination = destination;
        }
 
        public boolean isAdjacent(Node other) {
            return this.destination.equals(other.start);
        }
    }
}

//List<Stack<String>> result;
//String[][] tickets;
//
//public String[] solution(String[][] tickets) {
//    result = new ArrayList<>();
//    this.tickets = tickets;
//
//    boolean[] visited = new boolean[tickets.length];
//    Stack<String> st = new Stack<>();
//    st.push("ICN");
//
//    dfs(visited, st, 0);
//
//    if (result.size() > 1) {
//        Collections.sort(result, new Comparator<Stack<String>>() {
//            @Override
//            public int compare(Stack<String> o1, Stack<String> o2) {
//                for (int i = 0; i < o1.size(); i++) {
//                    String s1 = o1.get(i);
//                    String s2 = o2.get(i);
//
//                    if (!s1.equals(s2)) {
//                        return s1.compareTo(s2);
//                    }
//                }
//
//                return 0;
//            }
//        });
//    }
//
//    Stack<String> res = result.remove(0);
//    String[] answer = new String[res.size()];
//
//    for (int i = 0; i < answer.length; i++) {
//        answer[i] = res.get(i);
//    }
//
//    return answer;
//}
//
//public void dfs(boolean[] visited, Stack<String> st, int len) {
//    if (len == tickets.length) {
//        Stack<String> res = new Stack<>();
//        for (String s : st) {
//            res.push(s);
//        }
//
//        result.add(res);
//        return;
//    }
//
//    String arrive = st.peek();
//
//    for (int i = 0; i < tickets.length; i++) {
//        String[] tic = tickets[i];
//
//        if (!visited[i] && arrive.equals(tic[0])) {
//            st.push(tic[1]);
//            visited[i] = true;
//
//            dfs(visited, st, len + 1);
//
//            visited[i] = false;
//            st.pop();
//        }
//    }
//}
//}
