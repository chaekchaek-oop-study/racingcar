package racingcar;

public class Car {

    private final CarName name;
    private int position = 0;

    public Car(String name) {
        this.name = new CarName(name);
    }

    // 추가 기능 구현
}
