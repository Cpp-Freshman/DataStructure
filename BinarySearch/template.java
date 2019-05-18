package DSandAL.BinarySearch;
/*
二分查找法，别以为你会了
 */

import java.util.*;

public class template {
    public static void main(String[] args) {
        int[] a = {1,3,4,5,7,8};
        //找到最you边的
        System.out.println(Arrays.binarySearch(a, 6));
        System.out.println(5 == 'x');
        String s = "sfdaf";


        //System.out.println(Zuo(a));
        //System.out.println(You(a));
    }
    public static int You(int[] a){
        int l = 0,r = a.length - 1;
        while(l < r){
            int mid = (l + r + 1)>>1;
            if(a[mid] <= 5) l = mid;
            else r = mid - 1;
        }
        return l;

    }
    private static boolean Zuo(int[] a){
        int l = 0,r = a.length;
        while(l < r){
            int mid = (l + r)>>1;
            if(a[mid] <= 5)  r = mid;
            else    l = mid + 1;
        }
        return a[l] == 5 ? true:false;
    }
}
