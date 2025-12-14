public class BulbSwitch_319 {
    public int bulbSwitch(int n) {
        /*int[] switches = new int[n];
        Arrays.fill(switches, 1);
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                switches[j - 1] = Math.abs(switches[j - 1] - 1);
            }
        }
        int sum = Arrays.stream(switches).sum();
        return sum;*/
        return (int)Math.sqrt(n);
    }
}
