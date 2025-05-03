class Solution {
    public:
        typedef long long ll;
        ll modPow(ll base, ll exp, ll mod) {
            ll result = 1;
            base %= mod;
            while (exp > 0) {
                if (exp % 2 == 1) {
                    result = (result * base) % mod;
                }
                base = (base * base) % mod;
                exp /= 2;
            }
    
            return result;
        }
        int countGoodNumbers(long long n) {
            long long MOD = 1e9 + 7;
            ll even = n / 2;
            ll odd = even;
            if (n % 2 != 0) {
                even += 1;
                odd = even - 1;
            }
            ll five = (ll)modPow(5, even, MOD);
            ll four = (ll)modPow(4, odd, MOD);
            ll res = (five * four) % MOD;
            return res;
        }
    };