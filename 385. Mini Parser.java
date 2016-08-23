/**
 * 385. Mini Parser
 * 栈
 */


/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

public class Solution {
	Stack<NestedInteger> sk = new Stack<>();

	public NestedInteger deserialize(String s) {
		StringBuilder num = new StringBuilder();
		if(s.charAt(0)!='['){
			int number = Integer.valueOf(s);
			return new NestedInteger(number);
		}
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch >= '0' && ch <= '9'|| ch=='-') {
				num = num.append(ch);
			} else {
				if (num.length() > 0) {
					sk.push(new NestedInteger(Integer.valueOf(num.toString())));
					num.delete(0, num.length());
				}
	
				if (ch == '[') {
					sk.push(null);
				} else if (ch == ']') {
					List<NestedInteger> li = new ArrayList<>();
					NestedInteger top = sk.pop();
					while (top!=null) {
						li.add(top);
						top = sk.pop();
					}
					top = new NestedInteger();
					for (int j = li.size()-1;j>=0;j--) {
						top.add(li.get(j));
					}
					sk.push(top);
				}
			}
		}
		return sk.pop();
	}
}
