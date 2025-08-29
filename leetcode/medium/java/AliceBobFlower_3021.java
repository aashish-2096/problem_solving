public class AliceBobFlower_3021 {
    long getOddCount(int x) {
        if (x % 2 != 0) {
            return (x / 2) + 1;
        }
        return x / 2;
    }

    long getEvenCount(int x) {
        if (x % 2 == 0) {
            return x / 2;
        }
        return (x - 1) / 2;
    }

    public long flowerGame(int n, int m) {
        long count = 0;
        count += (getOddCount(n) * getEvenCount(m));
        count += (getOddCount(m) * getEvenCount(n));
        return count;
    }
}
