package christmas.domain.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuListTest {

    @DisplayName("인자로 들어온 메뉴의 가격을 리턴한다.")
    @Test
    void getPriceByName() {
        // Given
        String validName = "양송이수프";
        String invalidName = "양송이 수프";

        // When
        Integer validResult = MenuList.getPriceByName(validName);
        Integer invalidResult = MenuList.getPriceByName(invalidName);

        // Then
        Assertions.assertEquals(6000, validResult);
        Assertions.assertEquals(null, invalidResult);
    }
}