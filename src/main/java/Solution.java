/**
 * @author yujun
 * @since 2020/3/23
 */
class Solution {
    public int findTheLongestSubstring(String s) {
        int n = s.length();
        if(n==0){
            return 0;
        }

        // 二维数组，第一个标识前i个字符中的最长子字符串的长度，第二个标识前面的元音奇偶数，1是奇数
        int[][] a = new int[n][2];
        if(isVowel(s.charAt(0))){
            a[0][0]=0;
            a[0][1]=1;
        }else{
            a[0][0]=1;
            a[0][1]=0;
        }
        for(int i=1;i<n;i++){
            if(!isVowel(s.charAt(i))){
                a[i][0]=a[i-1][0]+1;
                a[i][1]=a[i-1][1];
            }else{
                if(a[i-1][1]==0){
                    a[i][0]=a[i-1][0]+1;
                    a[i][1]=1;
                }else{
                    a[i][0]=a[i-1][0];
                    a[i][1]=0;
                }
            }
        }
        return a[n-1][0];
    }
    public boolean isVowel(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }
}