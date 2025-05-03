// random POTD
class Solution {
    public:
        int countSymmetricIntegers(int low, int high) {
            int count = 0;
            for(int i = low;i<=high;i++){
                string s = to_string(i);
                if(s.size()%2 == 0){
                    int l = 0, h = s.size()-1;
                    int lowVal = 0, hVal = 0;
                    while(l<h){
                        lowVal += s[l++] - '0';
                        hVal += s[h--] - '0';
                    }
                    if(lowVal == hVal){
                        count+=1;
                    }
                }
            }
            return count;
        }
    };