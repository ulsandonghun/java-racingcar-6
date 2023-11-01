package racingcar.Service;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Domain.Car;

public class OutputServiceTest {

    OutputService outputService ;

    @BeforeEach
    public void init() {
        InputService inputService = new InputService();
        Car car = new Car();
        outputService=new OutputService(car,inputService);
        inputService = outputService.getInputService();

        String inputCarname = "pobi,woni,jun";
        inputService.inputCarname(inputCarname);
        inputService.SplitCarname(inputCarname);
    }
    @Test
    @DisplayName("자동차 이름 질문 문구 출력기능 ")
    public void output1() {
        assertThat(outputService.printCarnameQuestion()).
                isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    @DisplayName("시도할 횟수 질문 문구 출력기능")
    public void output2() {
        assertThat(outputService.printTryNumQuestion()).
                isEqualTo("시도할 회수는 몇회인가요?");
    }

    @Test
    @DisplayName("자동차 이름별로 출력 기능")
    public void output3() {


        assertThat(outputService.printCar()).
                isEqualTo("pobi :\n"
                        + "woni :\n"
                        + "jun :\n");
    }
}
