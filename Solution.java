import java.util.*;

/**
 * @author SummCoder
 * @desc find two nums which sum is target num
 * @date 2024/3/5 18:50
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        // 对数组进行排序
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int cnt = 0;
        hashMap.put(cnt, 1);
        for (int i = 1; i < nums.length; ++i) {
            if(nums[i] == nums[i-1]){

            }
            if (nums[i] - nums[i - 1] == 1){
                int re = hashMap.getOrDefault(cnt, 1);
                re += 1;
                hashMap.put(cnt, re);
            }else {
                cnt += 1;
                hashMap.put(cnt, 1);
            }

        }
        Object[] result = hashMap.values().toArray();
        Arrays.sort(result);
        return (int) result[result.length - 1];
    }
}

