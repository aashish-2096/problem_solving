public class CountAndSay_38 {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        if (n == 2)
            return "11";
        String prev = "11";
        for (int i = 2; i < n; i++) {
            char[] arr = prev.toCharArray();
            StringBuilder strBuild = new StringBuilder();
            char curr = arr[0];
            int count = 1;
            for (int j = 1; j < arr.length; j++) {
                if (arr[j] == curr) {
                    count++;
                } else {
                    strBuild.append(count);
                    strBuild.append(curr);
                    count = 1;
                    curr = arr[j];
                }
                if (j == arr.length - 1) {
                    strBuild.append(count);
                    strBuild.append(curr);
                    prev = strBuild.toString();
                }
            }
        }
        return prev;
    }
}
