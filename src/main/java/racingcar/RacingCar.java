package racingcar;

/**
 * @author SeongRok.Oh
 * @since 2022/10/09
 */
public class RacingCar implements Comparable<RacingCar> {

    private static final int NAME_MAX_LENGTH = 5;
    private static final int MIN_POWER_FOR_MOVE = 4;

    private final String name;
    private int mileage;

    public RacingCar(String name) {
        validateName(name);
        this.name = name;
        this.mileage = 0;
    }

    private void validateName(String name) {
        if (isOverLengthName(name)) {
            throw new IllegalArgumentException(PrintMessage.NAME_OUT_OF_LENGTH_ERROR.getMessage());
        }
        if (isEmptyName(name)) {
            throw new IllegalArgumentException(PrintMessage.NAME_EMPTY_ERROR.getMessage());
        }
    }

    private boolean isOverLengthName(String name) {
        return name.length() > NAME_MAX_LENGTH;
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

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(RacingCar other) {
        return this.mileage - other.mileage;
    }

    public void print() {
        System.out.print(name);
        System.out.print(" : ");
        for (int i = 0; i < mileage; i++) {
            System.out.print("-");
        }
    }
}
