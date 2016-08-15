/* 371. Sum of Two Integers
 * 位运算
 * s = a ^ b 在忽略进位的情况下a与b的和
 * c = a & b 各个位的进位
 * a b的和等于s c<<1 的和
*/
public class Solution {

	public int getSum(int a, int b) {
		int c = a & b;
		int s = a ^ b;
		while (c != 0) {
			c = c << 1;
			a = s;
			b = c;
			s = a ^ b;
			c = a & b;
		}
		return s;
	}
}
