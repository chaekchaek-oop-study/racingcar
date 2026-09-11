package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private static final String CAR_NAME_SPLITER = ",";
    private static final int CAR_NAME_LENGTH = 5;

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
        List<String> carNames = getCarName(inputCarNames);

        String inputTryCount = inputView.inputTryCount();
        int tryCount = getTryCount(inputTryCount);

        List<Car> cars = carService.createCars(carNames);

        outputView.printResult();

        for (int i = 0; i < tryCount; i++) {
            carService.playRound(cars);
            outputView.printRoundResult(List.copyOf(cars));
        }

        List<String> winnerName = carService.getWinner(cars);
        outputView.printWinner(winnerName);
    }

    private List<String> getCarName(String inputCarNames) {
        List<String> carNames =  Arrays.stream(inputCarNames.split(CAR_NAME_SPLITER))
                .map(String::trim)
                .toList();

        for (String carName : carNames) {
            if (carName.isBlank()){
                throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
            }

            if (carName.length() > CAR_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }

        return carNames;
    }

    private int getTryCount(String inputTryCount) {
        int tryCount;

        if (inputTryCount.isBlank()) {
            throw new IllegalArgumentException("시도 횟수는 공백일 수 없습니다.");
        }

        try {
            tryCount = Integer.parseInt(inputTryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력할 수 있습니다.");
        }

        return tryCount;
    }
}
