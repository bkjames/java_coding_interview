package zGoo1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class G006_EvaluateDivision {

	public static void main(String[] args) {
		String[][] equations = {{"a", "b"}, {"b", "c"}};
		double[] values = {2.0, 3.0};
		String[][] 	queries = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
		System.out.println(calcEquation(equations,values ,queries));
	}
	
	  class Edge {
        String numerator; 
        String denominator;
        double value;
        Edge (String numerator, String denominator, double value) {
            this.numerator = numerator;
            this.denominator = denominator;
            this.value = value;
        }
        
        // For debugging
        String printString() {
            return numerator + " - " + denominator + ": " + value;
        }
    }
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        // build adjacency list
        HashMap<String, List<Edge>> map = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            // convert input equation to edge with value
            if (!map.containsKey(equations[i][0])) {
                map.put(equations[i][0], new ArrayList<Edge>());
            }
            map.get(equations[i][0]).add(new Edge(equations[i][0], equations[i][1], values[i]));
            
            // reverse order to store inverse value for edge
            if (!map.containsKey(equations[i][1])) {
                map.put(equations[i][1], new ArrayList<Edge>());
            }
            map.get(equations[i][1]).add(new Edge(equations[i][1], equations[i][0], 1.0 / values[i]));
        }
        
        double[] result = new double[queries.length];
        
        int idx = 0;
        for (String[] query: queries) {
            if (!map.containsKey(query[0])) {
                result[idx] = -1.0;
            } else {
                String n = query[0];
                String d = query[1];
                HashSet<String> visited = new HashSet<>();
                double val = dfs(map, visited, 1.0, n, d);
                result[idx] = val;
            }
            idx++;
        }
        return result;
    }
    
    private double dfs(HashMap<String, List<Edge>> map, HashSet<String> visited, double val, String numerator, String denominator) {
        if (numerator.equals(denominator)) {
            return val;
        }
        
        visited.add(numerator);
        List<Edge> edges = map.get(numerator);
        if (edges != null) {
            for (Edge e: edges) {
                if (visited.contains(e.denominator)) {
                    continue;
                }
                visited.add(e.denominator);
                double value = dfs(map, visited, val * e.value, e.denominator, denominator);
                if (value != -1.0) {
                    return value;
                }
            }
        }
        
        return - 1.0;
    }
    
    // For debugging
    private void printAdjacencyList (HashMap<String, List<Edge>> map) {
        
        for (Map.Entry<String, List<Edge>> entry: map.entrySet()) {
            List<Edge> v = entry.getValue();
            for (Edge e: v) {
                System.out.println(e.printString());
            }
        }
    }
	
	public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, ArrayList<String>> pairs = new HashMap<String, ArrayList<String>>();
        HashMap<String, ArrayList<Double>> valuesPair = new HashMap<String, ArrayList<Double>>();
        for (int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            if (!pairs.containsKey(equation[0])) {
                pairs.put(equation[0], new ArrayList<String>());
                valuesPair.put(equation[0], new ArrayList<Double>());
            }
            if (!pairs.containsKey(equation[1])) {
                pairs.put(equation[1], new ArrayList<String>());
                valuesPair.put(equation[1], new ArrayList<Double>());
            }
            pairs.get(equation[0]).add(equation[1]);
            pairs.get(equation[1]).add(equation[0]);
            valuesPair.get(equation[0]).add(values[i]);
            valuesPair.get(equation[1]).add(1/values[i]);
        }
        
        double[] result = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String[] query = queries[i];
            result[i] = dfs(query[0], query[1], pairs, valuesPair, new HashSet<String>(), 1.0);
            if (result[i] == 0.0) result[i] = -1.0;
        }
        return result;
    }
    
    private static double dfs(String start, String end, HashMap<String, ArrayList<String>> pairs, HashMap<String, ArrayList<Double>> values, HashSet<String> set, double value) {
        if (set.contains(start)) return 0.0;
        if (!pairs.containsKey(start)) return 0.0;
        if (start.equals(end)) return value;
        set.add(start);
        
        ArrayList<String> strList = pairs.get(start);
        ArrayList<Double> valueList = values.get(start);
        double tmp = 0.0;
        for (int i = 0; i < strList.size(); i++) {
            tmp = dfs(strList.get(i), end, pairs, values, set, value*valueList.get(i));
            if (tmp != 0.0) {
                break;
            }
        }
        set.remove(start);
        return tmp;
    }
}
