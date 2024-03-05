/**
 * @author SummCoder
 * @desc find two nums which sum is target num
 * @date 2024/3/5 18:50
 */
class Code01 {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; ++i){
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
