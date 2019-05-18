package DSandAL.DP;

import java.util.*;

/***********************************
 * ali笔试题，多重二维费用背包问题
 */

public class Main {

    static class Node{
        public int v;
        public int w;
        public int p;

        public Node(int v,int w,int p){
            this.v = v;
            this.w = w;
            this.p = p;
        }

    }

/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    private static int totalPrice(int categoryCount, int totalVolume, int totalWeight, int[] volume, int[] weight,
                                  int[] stock, int[] price, int[] itemType) {
         final int N = 52;
         int[][] dp = new int[N][N];
         List<Node>list = new ArrayList<>();

         for (int i = 0; i < categoryCount; ++i) {
             //计算二进制
             for(int k = 1;k <= stock[i];k = k*2){
                 stock[i] -= k;
                 list.add(new Node(volume[i]*k, weight[i]*k, price[i] * k));
             }
             if(stock[i] > 0)  list.add(new Node(volume[i]*stock[i], weight[i]*stock[i], price[i] * stock[i] ));
             for(Node node1 : list){
                 for(int p1 = totalVolume; p1 >= node1.v;p1--)
                     for(int p2 = totalWeight;p2 >= node1.w;p2--)
                         if(!(i == 0 && i == 2))
                           dp[p1][p2] = Math.max(dp[p1][p2],dp[p1 - node1.v][p2-node1.w] + node1.p);
             }

        }

        return dp[totalVolume][totalWeight];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(",");
        //总共商品种类
        int categoryCount = Integer.valueOf(line[0]);
        //快递体积
        int totalVolume = Integer.valueOf(line[1]);
        //快递重量
        int totalWeight = Integer.valueOf(line[2]);

        //物品体积
        int[] volume = new int[50];
        //重量
        int[] weight = new int[50];
        //件数
        int[] stock = new int[50];
        //价格
        int[] price = new int[50];
        //类型
        int[] itemType = new int[50];

        for (int i = 1; i <= categoryCount; i++) {
            line = in.nextLine().split(",");
            volume[i] = Integer.valueOf(line[0]);
            weight[i] = Integer.valueOf(line[1]);
            stock[i] = Integer.valueOf(line[2]);
            price[i] = Integer.valueOf(line[3]);
            itemType[i] = Integer.valueOf(line[4]);
        }

        in.close();

        System.out.println(totalPrice(categoryCount, totalVolume, totalWeight, volume, weight, stock, price, itemType));

    }
}