class Solution {
    public:
    void recursion(vector<int>&arr, int index, int sum, vector<int>&res){
        if(index == arr.size()){
            res.push_back(sum);
            return;
        }
        recursion(arr, index+1, sum+arr[index], res);
        recursion(arr, index+1, sum, res);
    }
      vector<int> subsetSums(vector<int>& arr) {
          vector<int>result;
          recursion(arr, 0, 0, result);
          return result;
      }
  };