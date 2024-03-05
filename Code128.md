# 最长连续序列

hashmap：
```java
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
```
使用hashmap存储每一个长度的序列，并从中挑选出最大的那一个。


其实完全没必要：
```java
class Solution {
    public int longestConsecutive(int[] nums) {
        // 对数组进行排序
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int max = 1;
        int cnt = 1;
        for (int i = 1; i < nums.length; ++i) {
            if(nums[i] == nums[i-1]){
            }
            else if (nums[i] - nums[i - 1] == 1){
                cnt += 1;
                if (cnt > max) {
                    max = cnt;
                }
            }else {
                cnt = 1;
            }

        }
        return max;
    }
}
```

排好序之后直接一个一个去看，统计一个最大长度即可。