package racingcar;

import camp.nextstep.edu.missionutils.Console;

/**
 * @author SeongRok.Oh
 * @since 2022/10/09
 */
public class RaceStarter {

    private RaceStarter() {
    }

    public static void start() {
        Race race;

        while (true) {
            System.out.println("경주 할 자동차 이름 (이름은 쉼표(,) 기준으로 구분)");
            String names = Console.readLine();
            try {
                race = Race.from(names);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            System.out.println("시도할 회수");
            String tryCount = Console.readLine();
            try {
                race.start(Integer.parseInt(tryCount));
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
            }
        }
    }
}
