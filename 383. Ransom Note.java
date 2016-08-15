/* 383. Ransom Note
 * Hash
 * 小写字母的ASCII：97-122
 */
public class Solution {

	public boolean canConstruct(String ransomNote, String magazine) {
		int[] letter_count = new int[123];
		for (int i = 0; i < magazine.length(); i++) {
			letter_count[magazine.charAt(i)]++;
		}
		for (int i = 0; i < ransomNote.length(); i++) {
			if (letter_count[ransomNote.charAt(i)] > 0) {
				letter_count[ransomNote.charAt(i)]--;
			} else {
				return false;
			}
		}
		return true;
	}
}
