import com.racing.generator.NumberGenerator;
import com.racing.generator.RandomNumberGenerator;
import com.racing.model.Car;
import org.junit.jupiter.api.Test;

import static com.racing.constant.Constant.RANGE_DEFAULT_MAX;
import static com.racing.constant.Constant.RANGE_DEFAULT_MIN;
import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {

    @Test
    public void 자동차_이름은_5글자를_초과할_수_없다 () throws Exception {
        //then
        assertThrows(IllegalArgumentException.class,  () -> Car.createCar("여섯글자이상"));
    }

    @Test
    public void 자동차_이름은_Blank가_아니다 () throws Exception {
        //then
        assertThrows(IllegalArgumentException.class,  () -> Car.createCar(""));
        assertThrows(IllegalArgumentException.class,  () -> Car.createCar(" "));
        assertThrows(IllegalArgumentException.class,  () -> Car.createCar(null));
    }

    @Test
    public void 랜덤으로_0과9사이_임의의_값을_생성한다 () throws Exception {
        //given
        NumberGenerator numberGenerator = new RandomNumberGenerator.Range()
                .max(RANGE_DEFAULT_MAX)
                .min(RANGE_DEFAULT_MIN)
                .setUp();

        //then
        for(int i = 0 ; i < 50 ; i ++) {
            int randomInt = numberGenerator.generate();
            assertAll(
                    () -> assertTrue(randomInt >=0),
                    () -> assertTrue(randomInt <=9)
            );
        }
    }

    @Test
    public void random값이_4_이상일_경우_전진한다() throws Exception {
        //given
        Car car = Car.createCar("test");
        int posBefore = car.currentPosition();

        //when
        car.moveForward();

        //then
        int posAfter = car.currentPosition();
        assertTrue(posAfter == posBefore +1);
    }

    @Test
    public void random값이_4_이상이_아닌_경우_위치_변화_없다() throws Exception {

    }

    @Test
    public void 가장_멀리_움직인_자동차를_우승자로_선정한다() throws Exception {

    }

    @Test
    public void 가장_멀리_움직인_자동차가_여러대일_경우_모두_우승자로_선정한다 () throws Exception {

    }

}