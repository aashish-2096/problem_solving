class Solution {
public:
    long long coloredCells(int n) {
        /*
        brute force
        long long prev = 1;
        long long sum = 0;
        for(int i = 1;i<=n;i++){
            sum = (prev + 4*(i-1));
            prev = sum;
        }
        */
        // O(1)
        long long val = pow(n, 2) + pow(n - 1, 2);
        return val;
    }
};