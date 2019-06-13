package test;


import java.util.*;

public class Trip_dfs {
	
	public static void main(String[] args) {
//		String[][] strs = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		String[][] strs = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		Trip_dfs a = new Trip_dfs();
		String[] res = a.solution2(strs);
		
		for(String s: res) {
			System.out.print(s+" ");
		}
	}
	
	ArrayList<String[]> answers;
	public String[] solution2(String[][] tickets) {
        answers = new ArrayList<>();
        String[] answer = new String[tickets.length+1];
        boolean[] isUsed = new boolean[tickets.length];

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals("ICN")) {
                answer[0] = tickets[i][0];
                dfs(tickets, isUsed, 1, answer, i);
            }
        }

        String[][] array = new String[answers.size()][];
        answers.toArray(array);
        Arrays.sort(answers.toArray(array), new Comparator<String[]>() {
                    @Override
                    public int compare(String[] o1, String[] o2) {
                        for (int i = 0; i < o1.length; i++) {
                            for (int j = 0; j < 3; j++) {
                                if (o1[i].charAt(j) < o2[i].charAt(j)) {
                                    return -1;
                                }

                                if (o1[i].charAt(j) > o2[i].charAt(j)) {
                                    return 1;
                                }
                            }
                        }
                        return 0;
                    }
                });

        return array[0];
    }

    public void dfs(String[][] tickets, boolean[] isUsed, int depth, String[] answer, int index) {
        isUsed[index] = true;
        answer[depth] = tickets[index][1];
        if (depth == tickets.length) {
            answers.add(answer.clone());
            isUsed[index] = false;
            answer[depth] = null;
            return; //answer 을 찾았다는 의미
        }
        for (int i = 0; i < tickets.length; i++) {

            if (!isUsed[i] && tickets[i][0].equals(tickets[index][1])) {
                dfs(tickets, isUsed, depth + 1, answer, i);
            }
        }
        isUsed[index] = false;
        answer[depth] = null;
    }




	public String[] solution(String[][] tickets) {
        // 출발지 초기화 //
        List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < tickets.length; i++)
            nodeList.add(new Node(tickets[i][0], tickets[i][1]));
 
        Collections.sort(nodeList, ((o1, o2) -> o1.start.compareTo((o2.start)) != 0
                ? o1.start.compareTo((o2.start)) : o1.destination.compareTo(o2.destination)));
        
//        Collections.sort(nodeList, Comp);
 
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
	
	Comparator<Node> Comp = new Comparator<Node>() {

		@Override
		public int compare(Node o1, Node o2) {
			if(o1.start.compareTo((o2.start)) > 0) {
				return 1;
			}else if(o1.start.compareTo((o2.start)) < 0) {
				return -1;
			}else {
				if(o1.destination.compareTo(o2.destination) >0) {
					return 1;
				}else if(o1.destination.compareTo(o2.destination) <0) {
					return -1;
				}else {
					return 0;
				}
			}
			
		}
		
	};

 
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
