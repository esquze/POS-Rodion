package at.bal;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] {0, 7, 4, -2, 17, 1}, 11)));
    }
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int ii = i + 1; ii < nums.length; ii++) {
                if (nums[i] + nums[ii] == target) {
                    return new int[] {i, ii};
                }
            }
        }
        return null;
    }
}