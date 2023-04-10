public class Bet {

    private String username;
    private int horseNumber;
    private int amount;
    private String betType;

    public Bet(String username, int horseNumber, int amount) {
        this.username = username;
        this.horseNumber = horseNumber;
        this.amount = amount;
        this.betType = betType;
    }

    public String getUsername() {
        return username;
    }

    public int getHorseNumber() {
        return horseNumber;
    }

    public int getAmount() {
        return amount;
    }

    public String getBetType() {
        return betType;
    }

    public int getBetAmount() {
        return amount;
    }
}
