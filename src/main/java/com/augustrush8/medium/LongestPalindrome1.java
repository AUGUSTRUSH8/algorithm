package com.augustrush8.medium;

/**
 * 摘要：回文是一个正读和反读都相同的字符串，
 * 例如，{“aba”}是回文，而 {“abc”} 不是。
 * 中心扩展算法
 * 回文中心的两侧互为镜像。因此，回文可以从它的中心展开，并且只有 2n - 1个这样的中心。
 * 你可能会问，为什么会是 2n - 1 个，而不是 n个中心？原因在于所含字母数为偶数的回文的中心
 * 可以处于两字母之间（例如 {“abba”}“abba” 的中心在两个 {‘b’}之间）。
 *
 */
public class LongestPalindrome1 {
    int start=0,end=0;//用来记录回文子串的开始结束下标
    public String longestPalindrome(String s){
        if(s==null||s.length()==0){return "";}
        for(int i=0;i<s.length();i++){
            int len1=findlongestPalindrome(i,i,s);
            int len2=findlongestPalindrome(i,i+1,s);
            int len=Math.max(len1,len2);
            //更新开始结束下标
            if(len>end-start){
                start=i-(len-1)/2;
                end=i+len/2;
            }
        }
        return s.substring(start,end+1);//beginIndex -- 起始索引（包括）, 索引从 0 开始。
        //endIndex -- 结束索引（不包括）。
    }
    private int findlongestPalindrome(int left,int right,String s){
        while(left>=0&&right<=s.length()-1&&s.charAt(left)==s.charAt(right)){//向两边扩展
            left--;
            right++;
        }
        //单个位置的返回的就是2，连续两个位置的话返回的就是3
        return right-left-1;
    }

    //测试用例
    public static void main(String[] args) {
        LongestPalindrome1 instance=new LongestPalindrome1();
        System.out.println(instance.longestPalindrome("abbbs"));
    }
}
