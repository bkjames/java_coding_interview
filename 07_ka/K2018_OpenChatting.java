package real;



import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class K2018_OpenChatting {
	
	public static void main(String[] args) {
		String[] strs = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		String[] result =solution(strs);
		for(String s: result) {
			System.out.println(s);
		}
	}
	
  public static String[] solution(String[] record) {
	  Map<String, String> idmap = new HashMap<>();
	  List<String> ansList = new ArrayList<>();
	
	  for (String str : record) {
	      StringTokenizer tokenizer = new StringTokenizer(str);
	      String cmd = tokenizer.nextToken();
	      if (cmd.equals("Enter") || cmd.equals("Change")) {
	          String id = tokenizer.nextToken();
	          String name = tokenizer.nextToken();
	          idmap.put(id, name);
	      }
	  }
	
	  for (String str: record) {
	      StringTokenizer tokenizer = new StringTokenizer(str);
	      String cmd = tokenizer.nextToken();
	      if (cmd.equals("Enter")) {
	          String id = tokenizer.nextToken();
	          ansList.add(idmap.get(id) + "님이 들어왔습니다.");
	      } else if (cmd.equals("Leave")){
	          String id = tokenizer.nextToken();
	          ansList.add(idmap.get(id) + "님이 나갔습니다.");
	      }
	  }
	
	  String[] answer = new String[ansList.size()];
	  ansList.toArray(answer);
  return answer;
}
	
    public String[] solution3(String[] record) {
        HashMap<String, String> codeMap = new HashMap<String, String>();
        codeMap.put("enter","들어왔습니다.");
        codeMap.put("leave","나갔습니다.");

        HashMap<String, String> uidMap = new HashMap<String, String>();
        List<String> list = new ArrayList<String>();
        for(String str:record){
            String[] split = str.split("\\s+");
            String code = split[0];
            String uid = split[1];
            if(split.length > 2) {
                String name = split[2];
                uidMap.put(uid, name);
            }
            if(!"Change".equalsIgnoreCase(code)){
                list.add(code +" "+uid);
            }

        }
        String[] answer = new String[list.size()];
        for(int i=0;i<answer.length;i++){
            String[] split = list.get(i).split("\\s+");
            String name = uidMap.get(split[1]);
            answer[i] = name+"님이 "+ codeMap.get(split[0].toLowerCase());
        }

        return answer;
    }

    
    
    public String[] solution2(String[] record) {
        Map<String , String> map =  new HashMap<>();

        for(String str : record){
            String temp[] = str.split(" ");

            if(temp[0].equals("Enter") || temp[0].equals("Change")){
                map.put(temp[1],temp[2]);
            }
        }
        StringBuilder st = new StringBuilder();
        for(String str : record){
            String temp[] = str.split(" ");

            if(temp[0].equals("Enter") ){
                st.append(map.get(temp[1])+"님이 들어왔습니다.").append("\n");
            }

            if(temp[0].equals("Leave") ){
                st.append(map.get(temp[1])+"님이 나갔습니다.").append("\n");
            }
        }
        String []str = st.toString().split("\n");

        return str;
    }
    


}
