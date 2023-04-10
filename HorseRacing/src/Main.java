import java.util.*;

public class Main {

    // Список лошадей
    private static String[] horses = {"Лошадь 1", "Лошадь 2", "Лошадь 3", "Лошадь 4", "Лошадь 5", "Лошадь 6", "Лошадь 7"};

    // Список пользователей и их ставок
    private static List<Bet> bets = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Прием ставок
        while (true) {
            System.out.print("Введите ваше имя: ");
            String username = scanner.next();

            // Вывод списка лошадей
            System.out.println("Выберите лошадь, на которую хотите сделать ставку:");
            for (int i = 0; i < horses.length; i++) {
                System.out.println((i + 1) + ". " + horses[i]);
            }
            System.out.print("Введите номер лошади: ");
            int horseNumber = scanner.nextInt();

            // Вывод списка видов ставок
            System.out.println("Выберите вид ставки:");
            System.out.println("1. Победа (ставка на первое место)");
            System.out.println("2. Место (ставка на первое, второе или третье место)");
            System.out.println("3. Показать все ставки");
            int betType = scanner.nextInt();

            // Создание объекта ставки и добавление его в список


            Bet bet = new Bet(username, horseNumber, betType);
            bets.add(bet);

            System.out.print("Продолжить прием ставок? (yes/no): ");
            String answer = scanner.next();
            if (answer.equals("no")) {
                break;
            }
        }

        // Запуск заезда
        System.out.println("Заезд начинается!");
        int winner = (int) (Math.random() * horses.length) + 1;
        System.out.println("Победила лошадь №" + winner + " (" + horses[winner - 1] + ")");

        // Расчет выигрышей и вывод результатов
        System.out.println("Результаты ставок:");
        for (Bet bet : bets) {
            int betResult = 0;

            System.out.println(bet.getUsername() + " проиграл свою ставку на лошадь №" + bet.getHorseNumber());
        }
    }
}

