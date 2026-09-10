package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCarService carService;

    public RacingCarController(InputView inputView, OutputView outputView, RacingCarService carService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carService = carService;
    }

    public void run() {
        String inputCarNames = inputView.inputCarNames();
        List<String> carNames =  Arrays.stream(inputCarNames.split(","))
                .map(String::trim)
                .toList();
        for (String carName : carNames) {
            if (carName.isBlank()){
                throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
            }
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }
        List<Car> cars = carService.createCars(carNames);

        String inputTryCount = inputView.inputTryCount();
        if (inputTryCount.isBlank()) {
            throw new IllegalArgumentException("시도 횟수는 공백일 수 없습니다.");
        }
        int tryCount;
        try {
            tryCount = Integer.parseInt(inputTryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력할 수 있습니다.");
        }

        outputView.printResult();

        for (int i = 0; i < tryCount; i++) {
            carService.playRound(cars);
            outputView.printRoundResult(List.copyOf(cars));
        }
    }
}
