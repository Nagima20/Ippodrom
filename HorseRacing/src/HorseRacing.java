import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class HorseRacing {

    // Количество лошадей на ипподроме
    private static final int NUM_HORSES = 7;

    // Список лошадей на ипподроме
    private static List<String> horses;

    // Словарь ставок пользователей
    private static Map<String, Bet> bets;

    // Генератор случайных чисел
    private static Random random = new Random();

    // Список видов ставок
    private static final String[] BET_TYPES = {"First", "Second", "Third", "Fourth", "Fifth", "Sixth", "Last"};

    public static void main(String[] args) {

        // Чтение списка лошадей из файла
        try {
            horses = readHorsesFromFile("horses.txt");
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла с лошадями: " + e.getMessage());
            return;
        }

        // Инициализация словаря ставок
        bets = new HashMap<>();

        // Бесконечный цикл приема ставок и запуска заезда
        while (true) {

            // Вывод списка лошадей
            System.out.println("Список лошадей:");
            for (int i = 0; i < horses.size(); i++) {
                System.out.printf("%d. %s\n", i+1, horses.get(i));
            }

            // Вывод списка видов ставок
            System.out.println("Список видов ставок:");
            for (String betType : BET_TYPES) {
                System.out.println(betType);
            }

            // Чтение имени пользователя и номера лошади, на которую он делает ставку
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите свое имя: ");
            String username = scanner.nextLine();
            System.out.print("Введите номер лошади, на которую делаете ставку (1-" + NUM_HORSES + "): ");
            int horseNumber = scanner.nextInt();
            System.out.print("Введите тип ставки (First, Second, Third, Fourth, Fifth, Sixth, Last): ");
            String betType = scanner.next();
            System.out.print("Введите сумму ставки: ");
            int betAmount = scanner.nextInt();

            // Создание объекта ставки и добавление его в словарь ставок
            Bet bet = new Bet(username, horseNumber,betAmount);
            bets.put(username, bet);

            // Запрос на продолжение или завершение программы
            System.out.print("Продолжить прием ставок? (yes/no): ");
            String answer = scanner.next();
            if (answer.equals("no")) {
                break;
            }
        }

        // Запуск заезда
        System.out.println("Заезд начинается!");
        // Генерация случайных результатов заезда
        int[] results = new int[NUM_HORSES];
        for (int i = 0; i < NUM_HORSES; i++) {
            results[i] = random.nextInt(100);
        }

        // Сортировка результатов
        List<Integer> sortedResults = new ArrayList<>();
        for (int i = 0; i < NUM_HORSES; i++) {
            sortedResults.add(results[i]);
        }
        Collections.sort(sortedResults);

        // Вывод результатов заезда
        System.out.println("Результаты заезда:");
        for (int i = 0; i < NUM_HORSES; i++) {
            int horseNumber = i + 1;
            String horseName = horses.get(i);
            int result = results[i];
            System.out.printf("%d. %s: %d\n", horseNumber, horseName, result);
        }

        // Расчет выигрышей
        for (String username : bets.keySet()) {
            Bet bet = bets.get(username);
            int horseNumber = bet.getHorseNumber();
            int betAmount = bet.getBetAmount();
            String betType = bet.getBetType();
            int result = results[horseNumber-1];
            boolean win = false;
            switch (betType) {
                case "First":
                    if (horseNumber == sortedResults.get(0) + 1) {
                        win = true;
                    }
                    break;
                case "Second":
                    if (horseNumber == sortedResults.get(1) + 1) {
                        win = true;
                    }
                    break;
                case "Third":
                    if (horseNumber == sortedResults.get(2) + 1) {
                        win = true;
                    }
                    break;
                case "Fourth":
                    if (horseNumber == sortedResults.get(3) + 1) {
                        win = true;
                    }
                    break;
                case "Fifth":
                    if (horseNumber == sortedResults.get(4) + 1) {
                        win = true;
                    }
                    break;
                case "Sixth":
                    if (horseNumber == sortedResults.get(5) + 1) {
                        win = true;
                    }
                    break;
                case "Last":
                    if (horseNumber == sortedResults.get(NUM_HORSES-1) + 1) {
                        win = true;
                    }
                    break;
                default:
                    System.err.println("Некорректный тип ставки: " + betType);
                    break;
            }
            if (win) {
                int winnings = (int) (betAmount * 1.5);
                System.out.printf("%s выиграл %d монет\n", username, winnings);
            } else {
                System.out.printf("%s проиграл %d монет\n", username, betAmount);
            }
        }
    }

    /**
     * Чтение списка лошадей из файла.
     */
    private static List<String> readHorsesFromFile(String filename) throws IOException {
        List<String> horses = new ArrayList<>();
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String horseName = scanner.nextLine();
            horses.add(horseName);
        }
        scanner.close();
        return horses;
    }

    /**
     * Класс, представляющий ставку пользователя.
     */

}

