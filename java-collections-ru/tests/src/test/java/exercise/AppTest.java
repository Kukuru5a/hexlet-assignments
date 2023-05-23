package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN

            List<Integer> intList = List.of(1,2,3,4,5,6);

            var expression = App.take(intList, 5);

            assertThat(intList.get(0)).isEqualTo(1);
            assertThat(intList.get(1)).isEqualTo(2);
            assertThat(intList.get(2)).isEqualTo(3);
            assertThat(intList.get(3)).isEqualTo(4);
            assertThat(intList.get(4)).isEqualTo(5);
            assertThat(intList.get(5)).isEqualTo(6);

            if (intList.isEmpty()) {
                assertThat(intList.size() == 0);
            }

        // END
    }
}
