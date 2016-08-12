/* 374. Guess Number Higher or Lower
 * 二分法 
 * m = (l + r) / 2 可能会溢出，这里先转换成long型
 * 也可以写成 m = l + (r - l) / 2 保证不会溢出
 */

/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
		if (guess(n) == 0) {
			return n;
		}
		int l = 1, r = n;
		int m = (l + r) / 2;

		while (guess(m) != 0) {
			if (guess(m) == 1) {
				l = m;
				m = (int) (((long)l + (long)r)/2);
			} else if (guess(m) == -1) {
				r = m;
				m = (int) (((long)l + (long)r)/2);
			}
		}
		return m;
	}
}