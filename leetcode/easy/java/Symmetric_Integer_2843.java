package leetcode.easy.java;

public class Symmetric_Integer_2843 {
        public int countSymmetricIntegers(int low, int high) {
            int count = 0;
            for(int i = low; i<=high;i++){
                String s = Integer.toString(i);
                if(s.length()%2 == 0){
                    int l = 0, h = s.length()-1;
                    int lVal = 0, hVal = 0;
                    while(l<h){
                        lVal += s.charAt(l++) - '0';
                        hVal += s.charAt(h--) - '0';
                    }
                    if(lVal == hVal){
                        count+=1;
                    }
                }
            }
            return count;
        }
    }
