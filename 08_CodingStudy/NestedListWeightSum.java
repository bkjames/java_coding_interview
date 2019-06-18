package Top50_test;

//public class NestedListWeightSum {
//
//}
import java.util.*;

public class NestedListWeightSum {

public static int depthSum(List<NestedInteger> input) {
   if (null == input) {
       return 0;
   } else {
       int sum = 0;
       for (NestedInteger current : input) {
           sum += depthSumNestedInteger(current, 1);
       }
       return sum;
   }

}

private static int depthSumNestedInteger(NestedInteger current, int level) {
   System.out.println("current: " + current + " level: " + level);
   if (null == current) {
       return 0;
   } else {
       if (current.isInteger()) {
           return current.getInteger() * level;
       } else {
           int tempSum = 0;
           if (current.getInteger() != null) {
               tempSum = current.getInteger() * level;
           }
           for (NestedInteger nestedCurrent : current.getList()) {
               tempSum += depthSumNestedInteger(nestedCurrent, level + 1);
           }
       return tempSum;
       }
   }
}

	public static void main(String[] args) {
	
	List<NestedInteger> list1 = new ArrayList<>();
	List<NestedInteger> list2 = new ArrayList<>();
	
	NestedInteger nestedInteger1 = new MyNestedIneteger(1, list1);
	NestedInteger nestedInteger2 = new MyNestedIneteger(4, list2);
	NestedInteger nestedInteger3 = new MyNestedIneteger(6, null);
	
	list1.add(nestedInteger2);
	list2.add(nestedInteger3);
	
	List<NestedInteger> input = new ArrayList<>();
	input.add(nestedInteger1);
	
	System.out.println(input);
	System.out.println(depthSum(input));
	}

}   

/**
 * This is the interface that represents nested lists. You should not implement
 * it, or speculate about its implementation.
 */
interface NestedInteger {
    /**
     * @return true if this NestedInteger holds a single integer, rather than a
     *         nested list
     */
    boolean isInteger();
 
    /**
     * @return the single integer that this NestedInteger holds, if it holds a
     *         single integer Return null if this NestedInteger holds a nested
     *         list
     */
    Integer getInteger();
 
    /**
     * @return the nested list that this NestedInteger holds, if it holds a
     *         nested list Return null if this NestedInteger holds a single
     *         integer
     */
    List<NestedInteger> getList();
}
 
class MyNestedIneteger implements NestedInteger {
 
    private Integer theSingleInteger;
    private List<NestedInteger> theList;
 
    public MyNestedIneteger(Integer theSingleInteger, List<NestedInteger> theList) {
        this.theSingleInteger = theSingleInteger;
        this.theList = theList;
    }
 
    @Override
    public boolean isInteger() {
        return null == theList && null != theSingleInteger;
    }
 
    @Override
    public Integer getInteger() {
        return theSingleInteger;
    }
 
    @Override
    public List<NestedInteger> getList() {
        return theList;
    }
 
    @Override
    public String toString() {
 
        StringBuilder string = new StringBuilder();
 
        string.append("{");
        if (null != theSingleInteger) {
            string.append(theSingleInteger);
        }
        if (null != theList) {
            for (NestedInteger current : theList) {
                string.append(", " + current.toString());
            }
        }
        string.append("}");
        return string.toString();
    }
 
}

