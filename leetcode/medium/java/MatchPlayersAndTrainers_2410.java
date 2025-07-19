import java.util.Arrays;

public class MatchPlayersAndTrainers_2410 {
     public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int count = 0;
        players = Arrays.stream(players)
                .boxed()
                .sorted((a, b) -> Integer.compare(b, a))
                .mapToInt(Integer::intValue)
                .toArray();
        trainers = Arrays.stream(trainers)
                .boxed()
                .sorted((a, b) -> Integer.compare(b, a))
                .mapToInt(Integer::intValue)
                .toArray();
        int i = 0, j = 0;
        boolean status = true;
        while (status) {
            if (i >= trainers.length || j >= players.length) {
                status = false;
                break;
            }
            if (trainers[i] >= players[j]) {
                count += 1;
                i += 1;
                j += 1;
            } else {
                j++;
            }

        }
        return count;
    }
}
