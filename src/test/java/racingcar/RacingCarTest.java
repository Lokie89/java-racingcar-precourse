package racingcar;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
}
