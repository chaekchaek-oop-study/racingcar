package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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
        String inputCarNames = inputView.inputCarNames();
        List<String> carNames =  Arrays.stream(inputCarNames.split(","))
                .map(String::trim)
                .toList();
    }
}
