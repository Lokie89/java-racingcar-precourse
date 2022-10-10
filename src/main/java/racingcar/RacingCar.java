package racingcar;

/**
 * @author SeongRok.Oh
 * @since 2022/10/09
 */
public class RacingCar implements Comparable<RacingCar> {

    private static final int MIN_POWER_FOR_MOVE = 4;

    private final Racer racer;
    private int mileage;

    public RacingCar(String name) {
        this.racer = Racer.from(name);
        this.mileage = 0;
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
        return racer.getName();
    }

    @Override
    public int compareTo(RacingCar other) {
        return this.mileage - other.mileage;
    }

    public void print() {
        System.out.print(racer.getName());
        System.out.print(" : ");
        for (int i = 0; i < mileage; i++) {
            System.out.print("-");
        }
    }
}
