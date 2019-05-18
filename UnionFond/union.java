package DSandAL.UnionFond;
/*
****************并查集模板*****************
2. 按字典序排列最小的等效字符串  显示英文描述
用户通过次数 194
用户尝试次数 281
通过次数 196
提交次数 530
题目难度 Medium
给出长度相同的两个字符串：A 和 B，其中 A[i] 和 B[i] 是一组等价字符。举个例子，如果 A = "abc" 且 B = "cde"，那么就有 'a' == 'c', 'b' == 'd', 'c' == 'e'。

等价字符遵循任何等价关系的一般规则：

自反性：'a' == 'a'
对称性：'a' == 'b' 则必定有 'b' == 'a'
传递性：'a' == 'b' 且 'b' == 'c' 就表明 'a' == 'c'
例如，A 和 B 的等价信息和之前的例子一样，那么 S = "eed", "acd" 或 "aab"，这三个字符串都是等价的，而 "aab" 是 S 的按字典序最小的等价字符串

利用 A 和 B 的等价信息，找出并返回 S 的按字典序排列最小的等价字符串。

    int f[26];
    int get(int x)
    {
        if(f[x]==x)return x;
        return f[x]=get(f[x]);
    }
    void merge(int x,int y)
    {
        x=get(x);
        y=get(y);
        if(x<y)swap(x,y);
        f[x]=y;
    }
    string smallestEquivalentString(string A, string B, string S) {
        int n=A.size(),m=S.size(),i;
        string ans;
        ans="";
        for(i=0;i<26;i++)f[i]=i;  //初始化
        for(i=0;i<n;i++)merge(A[i]-'a',B[i]-'a');
        for(i=0;i<m;i++)ans+='a'+get(S[i]-'a');
        return ans;
    }
 */

public class union {
    public static void main(String[] args) {
        String A= "leetcode", B = "programs", S = "sourcecode";
        System.out.println(smallestEquivalentString(A, B,S ));
    }
    public static int[] parent;
    public static int find(int x){
        while(x != parent[x])
            x = parent[x];//一直找到根为止，没根就返回本身
        return x;
    }

    public static void union(int a,int b){
        int x = find(a);  //找到各自的根
        int y = find(b);
        //本题必须是一个祖先指向另一更小的祖先，别的题目不一定
        int min = Math.min(x,y);
        int max = Math.max(x,y);

        parent[max] = min;

    }
    public static String smallestEquivalentString(String A, String B, String S) {
        parent = new int[26];
        for(int i = 0;i < parent.length;i++) parent[i] = i;  //初始化，都指向自己；
        for(int i = 0;i < A.length();i++)  union(A.charAt(i) - 'a',B.charAt(i)-'a' );

        for(int i = 0;i < parent.length;i++) {
            System.out.print((char)(97 + i) + "指向" + (char)(parent[i] + 97) + "   ");
            if(i == 9 || i == 19)
                System.out.println();
        }
        System.out.println();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ;i < S.length();i++)   sb.append((char)(find(S.charAt(i)-'a') + 97));
        return sb.toString();
    }
}
