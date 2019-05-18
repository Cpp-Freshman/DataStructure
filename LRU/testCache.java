package DSandAL.LRU;

public class testCache {
    public static void main(String[] args) {
        LRUCacheF<String,Integer>  cache = new LRUCacheF<>(2);
        cache.put("fe", 1);
        cache.put("jia", 2);
        System.out.println(cache.get("fe"));      // 返回  1
        cache.put("bo", 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get("jia"));       // 返回 -1 (未找到)
        cache.put("ai", 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get("fe"));       // 返回 -1 (未找到)
        System.out.println(cache.get("bo"));       // 返回  3
        System.out.println(cache.get("ai"));       // 返回  4
        cache.put("ai", 5);
        System.out.println(cache.get("bo"));
        cache.put("ni", 5);
        System.out.println(cache.get("ai"));
    }
}
