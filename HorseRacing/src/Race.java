import java.util.Random;

public class Race {

    private Horse[] horses;
    private int[] results;
    private boolean finished;

    public Race(Horse[] horses) {
        this.horses = horses;
        this.results = new int[horses.length];
        this.finished = false;
    }

    public void start() {
        if (finished) {
            System.out.println("Забег уже завершен.");
            return;
        }

        System.out.println("Забег начинается!");
        Random random = new Random();
        for (int i = 0; i < results.length; i++) {
            results[i] = random.nextInt(100) + 1;
        }
        finished = true;
    }

    public boolean isFinished() {
        return finished;
    }

    public int[] getResults() {
        return results;
    }

    public Horse[] getHorses() {
        return horses;
    }
}
