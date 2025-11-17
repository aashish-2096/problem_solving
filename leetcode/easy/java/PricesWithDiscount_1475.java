package leetcode.easy.java;

import java.util.Stack;

public class PricesWithDiscount_1475 {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> st = new Stack<>();
        int len = prices.length;
        int[] result = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            if (i == len - 1) {
                result[i] = prices[i];
                st.push(prices[i]);
            } else {
                int cost = prices[i];
                if (!st.isEmpty()) {
                    if (st.peek() < cost)
                        cost -= st.peek();
                    else {
                        Stack<Integer> temp = new Stack();
                        while (!st.isEmpty() && st.peek() > cost) {
                            temp.push(st.pop());
                        }
                        if (!st.isEmpty()) {
                            cost -= st.peek();
                            if (!temp.isEmpty()) {
                                while (!temp.isEmpty()) {
                                    st.push(temp.pop());
                                }
                            }
                        }
                    }
                }
                st.push(prices[i]);
                result[i] = cost;
            }
        }
        return result;
    }
}