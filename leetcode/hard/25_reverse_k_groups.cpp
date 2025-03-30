/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
 class Solution {
    public:
        void swapInBatch(vector<int>& arr, int index, int k) {
            if ((index + k) <= arr.size()) {
                int low = index, high = index + k - 1;
                while (low < high) {
                    swap(arr[low], arr[high]);
                    low++;
                    high--;
                }
            }
        }
        ListNode* reverseKGroup(ListNode* head, int k) {
            vector<int> arr;
            ListNode* temp = head;
            while (temp != nullptr) {
                arr.push_back(temp->val);
                temp = temp->next;
            }
            int batches = arr.size() / k;
            int index = 0;
            cout << "BatchSize" << batches << endl;
            for (int i = 0; i < batches; i++) {
                swapInBatch(arr, index, k);
                index += k;
            }
            temp = head;
            for (auto i : arr) {
                temp->val = i;
                temp = temp->next;
            }
            return head;
        }
    };