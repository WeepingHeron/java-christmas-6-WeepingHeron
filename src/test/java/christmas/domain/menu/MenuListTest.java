package christmas.domain.menu;

import christmas.domain.enums.MenuList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuListTest {

    @DisplayName("인자로 들어온 메뉴의 그룹을 리턴한다.")
    @Test
    void getGroupByNameTest() {
        // Given
        String appetizerMenu = "양송이수프";
        String mainMenu = "바비큐립";
        String desertMenu = "아이스크림";
        String beverageMenu = "샴페인";

        // When
        String appetizerGroup = MenuList.getGroupByName(appetizerMenu);
        String mainGroup = MenuList.getGroupByName(mainMenu);
        String desertGroup = MenuList.getGroupByName(desertMenu);
        String beverageGroup = MenuList.getGroupByName(beverageMenu);

        // Then
        Assertions.assertEquals("애피타이저", appetizerGroup);
        Assertions.assertEquals("메인", mainGroup);
        Assertions.assertEquals("디저트", desertGroup);
        Assertions.assertEquals("음료", beverageGroup);
    }

    @DisplayName("인자로 들어온 메뉴의 가격을 리턴한다.")
    @Test
    void getPriceByNameTest() {
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

    @DisplayName("인자로 들어온 메뉴와 그룹이 맞는지 확인한다.")
    @Test
    void isValidNameAndGroupTest() {
        // Given
        String menuName = "양송이수프";
        String appetizerGroup = "애피타이저";
        String desertGroup = "디저트";

        // When
        boolean validResult = MenuList.isExistentNameAndGroup(menuName, appetizerGroup);
        boolean invalidResult = MenuList.isExistentNameAndGroup(menuName, desertGroup);

        // Then
        Assertions.assertEquals(true, validResult);
        Assertions.assertEquals(false, invalidResult);
    }

    @DisplayName("인자로 들어온 메뉴가 존재하는지 확인한다.")
    @Test
    void isValidNameTest() {
        // Given
        String validMenu = "양송이수프";
        String invalidMenu1 = "양송이 수프";
        String invalidMenu2 = "후라이드치킨";

        // When
        boolean validResult = MenuList.isExistentName(validMenu);
        boolean invalidResult1 = MenuList.isExistentName(invalidMenu1);
        boolean invalidResult2 = MenuList.isExistentName(invalidMenu2);

        // Then
        Assertions.assertEquals(true, validResult);
        Assertions.assertEquals(false, invalidResult1);
        Assertions.assertEquals(false, invalidResult2);
    }
}