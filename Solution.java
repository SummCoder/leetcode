import java.util.*;

/**
 * @author SummCoder
 * @desc find two nums which sum is target num
 * @date 2024/3/5 18:50
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hashtable = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            List<String> result = hashtable.getOrDefault(sortString(strs[i]), new ArrayList<>());
            result.add(strs[i]);
            hashtable.put(sortString(strs[i]), result);

        }
        return hashtable.values().stream().toList();
    }
    public static String sortString(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}

