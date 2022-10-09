package racingcar;

/**
 * @author SeongRok.Oh
 * @since 2022/10/09
 */
public class RacingCar {

    private static final int NAME_MAX_LENGTH = 5;
    private static final String SPLIT_REGEX = ",";
    private static final int MIN_POWER_FOR_MOVE = 4;

    private final String name;
    private int mileage;

    public RacingCar(String name) {
        validateName(name);
        this.name = name;
        this.mileage = 0;
    }

    private void validateName(String name) {
        if (isOverLengthName(name)
                || hasSplitThing(name)
                || isEmptyName(name)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 이름 입니다.");
        }
    }

    private boolean isOverLengthName(String name) {
        return name.length() > NAME_MAX_LENGTH;
    }

    private boolean hasSplitThing(String name) {
        return name.contains(SPLIT_REGEX);
    }

    private boolean isEmptyName(String name) {
        return name.isEmpty();
    }

    public void move(int power) {
        if (isMovable(power)) {
            mileage++;
        }
    }

    private boolean isMovable(int power) {
        return power >= MIN_POWER_FOR_MOVE;
    }

    public int getMileage() {
        return mileage;
    }
}
