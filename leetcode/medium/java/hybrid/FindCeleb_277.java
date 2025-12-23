package hybrid;

public class FindCeleb_277 {
    /* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
    private boolean knows(int i, int j){
        return i == j;
    }
    private boolean isCeleb(int i, int n) {
        for (int j = 0; j < n; j++) {
            if (i == j)
                continue;
            boolean knowsM = knows(i, j);
            boolean knowN = knows(j, i);
            if (knowsM || !knowN) {
                return false;
            }
        }
        return true;
    }

    /* 
    public int findCelebrity(int n) {
        int mapped = 0;
        for (int i = 0; i < n; i++) {
            if (isCeleb(i, n)) {
                return i;
            }
        }
        return -1;
    }
    */
    public int findCelebrity(int n) {
        int celebrity = 0;
        for (int i = 0; i < n; i++) {
            if (knows(celebrity, i)) {
                celebrity = i;
            }
        }
        if (isCeleb(celebrity, n)) {
            return celebrity;
        }
        return -1;
    }
}
