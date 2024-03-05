# 字母异位词分组

old:
```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hashtable = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            if (hashtable.containsKey(sortString(strs[i]))) {
                List<String> result = hashtable.get(sortString(strs[i]));
                result.add(strs[i]);
                hashtable.replace(sortString(strs[i]), result);
                continue;
            }
            List<String> result = new ArrayList<>();
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
```

题解：
```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<String, List<String>>();
        for(String str : strs){
            char []array = str.toCharArray();
            //排序后的字母为key进行分组
            Arrays.sort(array);
            String key = new String(array); //eg:键：aet
            //从map中看是否有同样的key，没有就创建一个,并获取key对应的list
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str); //值：["ate","eat","tea"]
            //对哈希表进行更新
            map.put(key,list); //{"aet":["ate","eat","tea"]}
        }
        return new ArrayList<List<String>>(map.values()); //["ate","eat","tea"]
    }
}
```

注：
- 将String转化为char数组，toCharArray方法
- 直接调用字符数组的排序方法，Arrays.sort
- hashmap的getOrDefault方法
- 使用put进行key-value的更新
