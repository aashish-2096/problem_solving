class Solution {
public:
    bool convertToDecimalBase3(int n){
        string res = "";
        bool isTwoAbsent = true;
        while(n>0){
            if(n%3 == 0){
                res+=1;
                n = n/3;
            } else {
                int mod = n%3;
                n = n/3;
                if(mod == 2){
                    isTwoAbsent = false;
                    break;
                }
            }
        }
        return isTwoAbsent;
    }
    bool checkPowersOfThree(int n) {
        if(n%3 == 0){
            return convertToDecimalBase3(n/3);
        }
        return convertToDecimalBase3(n);
    }
};