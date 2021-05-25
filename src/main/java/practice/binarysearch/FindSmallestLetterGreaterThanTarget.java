package practice.binarysearch;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/20 18:24
 */
public class FindSmallestLetterGreaterThanTarget {
    public static char nextGreatestLetter(char[] letters, char target) {
        int l = 0, h = letters.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (letters[mid] <= target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return l < letters.length ? letters[l] : letters[0];
    }

    public static char nextGreatestLetter2(char[] letters, char target) {
        int l = 0, h = letters.length;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (letters[mid] >= target) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l < letters.length ? letters[l] : letters[0];
    }

    public static void main(String[] args) {
        char[] letters = new char[] {'c', 'f', 'j'};
        System.out.println(nextGreatestLetter(letters, 'a'));
        System.out.println(nextGreatestLetter2(letters, 'k'));
    }
}