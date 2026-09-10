package racingcar.controller;

import racingcar.service.CarService;
import racingcar.view.InputView;

public class CarController {

    private final InputView inputView;
    private final CarService carService;

    public CarController(InputView inputView, CarService carService) {
        this.inputView = inputView;
        this.carService = carService;
    }

    public void run() {
        String carNames = inputView.inputCarNames();
    }
}
