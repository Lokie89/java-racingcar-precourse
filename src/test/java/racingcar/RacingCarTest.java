package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * @author SeongRok.Oh
 * @since 2022/10/09
 */
public class RacingCarTest {

    @DisplayName("RacingCar 이름 생성")
    @ValueSource(strings = {"홍길동", "우승자", "장동건", "원빈", "생성자"})
    @ParameterizedTest
    void createTest(String name) {
        RacingCar car = new RacingCar(name);
    }

    @DisplayName("잘못된 RacingCar 이름 생성")
    @ValueSource(strings = {"다섯자이상이다아", "콤마추가,", ""})
    @ParameterizedTest
    void createErrorTest(String name) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new RacingCar(name))
                .withMessageContaining("[ERROR] 잘못된 이름 입니다.");
    }

    @DisplayName("RacingCar 전진 기능 테스트")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @ParameterizedTest
    void move(int value) {
        String name = "원빈";
        RacingCar car = new RacingCar(name);
        car.move(value);
        assertThat(car.getMileage()).isEqualTo(1);
    }

    @DisplayName("RacingCar 전진 기능 테스트")
    @ValueSource(ints = {0, 1, 2, 3})
    @ParameterizedTest
    void notMove(int value) {
        String name = "원빈";
        RacingCar car = new RacingCar(name);
        car.move(value);
        assertThat(car.getMileage()).isEqualTo(0);
    }
}
