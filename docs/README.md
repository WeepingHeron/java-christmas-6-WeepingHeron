# 크리스마스 프로모션

## 핵심 기능
* 주문을 받아 금액을 계산한다.
  1. 메뉴 구현
  2. 기본 계산 로직 구현 (할인 제외)
  3. 입출력 로직 구현

## 구현 기능 목록
* 기본 UI를 출력한다
* 방문 날짜를 입력받고 저장한다
* 주문을 입력받고 저장한다
* 저장한 날짜에 따른 문구를 출력한다
* 저장한 주문에 따른 주문 메뉴를 출력한다
* 주문 메뉴의 할인 전 총주문 금액을 출력한다
* 총주문 금액에 따른 증정 메뉴를 출력한다
* 날짜와 메뉴에 해당되는 이벤트의 혜택을 출력한다
* 혜택으로 인해 할인된 총혜택 금액을 출력한다
* 총주문 금액에서 총혜택 금액을 뺀 할인 후 예상 결제 금액을 출력한다
* 총혜택 금액에 따른 이벤트 배지를 출력한다

## 클래스 목록

## domain: 핵심 기능
* PromotionModel: 날짜와 주문 데이터 관리
  * getDate: 방문 날짜 반환
  * setDate: 방문 날짜 설정
  * getOrder: 주문 반환
  * setOrder: 주문 설정
  * takeAddedPrice: 총주문 금액 계산 후 반환
  * takeBenefit: 총혜택 금액 계산 후 반환
  * takeAppliedEvents: 혜택 내역 계산 후 반환
### enum
* Calendar: 12월 달력의 날짜에 담긴 주말, 공휴일의 정보 및 관련 메서드를 enum 형태로 관리
  * isWeekend: 주말 여부를 boolean 형태로 반환
  * isHoliday: 공휴일 여부를 boolean 형태로 반환
  * findByDate: 인자로 들어온 날짜에 해당하는 value를 반환
* MenuList: 메뉴의 정보 및 관련 메서드를 enum 형태로 관리
  * getGroup: Group을 반환
  * getMenuName: MenuName을 반환
  * getGroupByName:인자로 들어온 이름의 Group 반환
  * getPriceByName: 인자로 들어온 이름의 Price 반환
  * isExistentMatchOfNameAndGroup: 인자로 들어온 이름과 그룹의 일치 여부를 반환한다
  * isExistentName: 인자로 들어온 이름이 메뉴 중에 있는지 반환한다
### calculator
* Calculator
  * calculateAddedPrice: 주문을 받아 총주문 금액 산출
  * calculateBenefit: 날짜, 총주문 금액, 주문을 받아 총혜택 금액 산출
  * calculateAppliedEvents: 날짜, 총주문 금액, 주문을 받아 적용된 이벤트 산출
  * checkEvents: 이벤트 정책의 조건을 확인하고 이벤트 적용
  * checkDayOfTheWeekEvent: 평일/주말을 판정하여 요일별 할인 적용
### events
* Gift: 할인 전 총주문 금액이 12만원 이상일 때, 샴페인 1개 증정
  * applyGiftEvent: 증정으로 인해 혜택을 본 가격을 반환
  * checkGiftEvent: 이벤트의 조건을 통과하는지 확인
* ChristmasDiscount: 크리스마스가 다가올수록 할인
  * applyChristmasDiscount: 날짜에 따라 할인된 금액 반환
  * checkChristmasDiscount: 이벤트의 조건을 통과하는지 확인
  * calculateChristmasDiscount: 경과일을 계산하여 할인액 반환
  * calculateDiscountAmount: 경과일을 받아 할인액 계산
* DayOfTheWeekDiscount: 요일에 따라 메뉴 할인
  * applyDayOfTheWeekDiscount: 요일에 따라 다른 메뉴를 할인 받고 할인 금액을 반환
  * calculateDayOfTheWeekDiscount: 인자로 들어온 메뉴의 그룹을 MenuList와 대조하여 할인 금액을 계산
* HolidayDiscount: 공휴일에는 총주문 금액에서 1000원 할인
  * applyHolidayDiscount: 날짜와 달력을 비교하여 할인 금액을 반환

## view: UI 담당
* InputView: 입력 UI를 담당
  * readDate: 방문 날짜 입력 UI
  * readOrder: 주문 입력 UI
* OutputView: 출력 UI를 담당
  * printAll: 모든 출력 UI를 실행
  * printDate: 방문 날짜 출력 UI
  * printMenu: 주문 출력 UI
  * printAddedPrice: 총주문 금액 출력 UI
  * printGift: 증정 메뉴 출력 UI
  * printAppliedEvents: 혜택 내역 출력 UI
  * printBenefit: 총혜택 금액 출력 UI
  * printFinalPrice: 할인 후 예상 결제 금액 출력 UI
  * printBadge: 총혜택 금액에 따른 이벤트 배지 출력 UI
### tools: 뷰에서 사용하는 서식 관련 로직
* InputTool
  * parseOrder: 입력을 ,와 -로 구분한다
  * putData: Map에 데이터를 집어넣는 과정을 try-catch문에 넣는다
  * checkOrderWhileParsing: 주문을 받아 Map 형태로 파싱하는 과정에서 중복을 검증한다
* OutputTool
  * formatPrice: 인자로 들어온 가격을 포맷에 맞추어 반환

## controller: 뷰와 모델 간의 중개
* PromotionController: 입력을 받아 모델을 업데이트하고, 모델의 변경을 감지하여 뷰를 업데이트
  * runPlanner: 전체 UI 실행
  * runReadDate: 방문 날짜 입력 UI 실행
  * runReadOrder: 주문 입력 UI 실행
  * runOutputView: 출력 UI 실행

## validator: 유효성 검증
* Validator: 유효성 검증 메서드 관리
  * isValidDate: 입력한 날짜의 범위에 대한 유효성을 검증한다
  * isValidOrder: 주문 관련 유효성 검증을 총괄한다
  * isValidMenuNameAndQuantity: 주문을 순회하며 메뉴명, 메뉴당 수량, 전체 수량에 대한 유효성을 검증한다
  * checkMenuName: 메뉴의 이름을 검증한다
  * checkMenuQuantity: 메뉴의 수량을 검증한다
  * checkTotalQuantity: 전체 주문 수량을 검증한다
  * isNotOnlyBeverage: 음료만 주문한 것은 아닌지 확인한다

## 요구 사항
### 기능 요구 사항
* 방문 날짜에 따른 이벤트가 적용되었는가
* 메뉴와 정가가 맞게 책정되었는가
* 주문 메뉴에 따라 할인 전 총주문 금액을 계산하였는가
* 총주문 금액에 따라 증정 메뉴가 고려되었는가
* 이벤트와 증정 메뉴를 고려하여 혜택이 올바르게 계산되었는가
* 총혜택 금액에 따라 알맞은 이벤트 배지가 부여되었는가

### 프로그래밍 요구 사항
* indent depth 유지
* 3항 연산자 쓰지 않기
* 길이 유지하기
* else 쓰지 않기
* 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다
* InputView, OutputView 클래스를 참고하여 입출력 클래스르 구현
  * 입력과 출력을 담당하는 클래스를 별도로 구현

## 공통 피드백
* main()함수를 포함하여 함수를 15라인 이하로 유지
* 예외 상황에 대한 고민
* 비즈니스 로직과 UI 로직을 분리
* 연관성이 있는 상수는 static final 대신 enum을 활용
  * 애피타이저, 메인, 디저트, 음료를 enum으로 만들면 좋을 것 같다
* final 키워드를 사용해 값의 변경을 막는다
* 객체의 상태 접근을 제한한다 - 인스턴스 변수의 접근 제어자는 private으로 구현
* 객체는 객체스럽게 사용한다 - 데이터를 가지는 객체가 일하도록 한다
* 필드(인스턴스 변수)의 수를 줄이기 위해 노력한다
* 성공하는 케이스 뿐만 아니라 예외에 대한 케이스도 테스트한다
* 테스트 코드도 코드다 - 특히 반복적으로 하는 부분을 중복되지 않게 만들어야 한다
* 테스트를 위한 코드는 구현 코드에서 분리되어야 한다
* 단위 테스트하기 어려운 코드를 단위 테스트하기 - 테스트하기 어려운 부분은 분리하고 테스트 가능한 부분을 단위 테스트한다
* private 함수를 테스트하고 싶다면 클래스(객체) 분리를 고려한다 - 가독성 이상의 역할을 하는 경우, 테스트하기 쉽게 구현하기 위해서는 해당 역할을 수행하는 다른 객체를 만들 타이밍이 아닐지 고민해 볼 수 있다

## 사용자 입력 체크리스트
* 방문 날짜로 숫자 이외의 문자나 1미만 31초과의 수를 입력할 수 없다
* 존재하지 않는 메뉴를 주문할 수 없다
* 메뉴의 수량으로 문자를 입력할 수 없다
* 메뉴의 수량이 0개일 수 없다
* 전체 수량 또한 0개일 수 없다
* 전체 수량은 20개를 초과할 수 없다
* 음료수만 주문할 수 없다
* 동일한 메뉴를 중복하여 주문할 수 없다

## 이벤트 체크리스트
* 총주문 금액이 10000원 미만일 때는 이벤트가 적용되지 않는다
* 크리스마스 디데이 할인은 기간이 존재한다
* 증정 이벤트는 혜택 내역과 총혜택 금액에 영향을 주나, 할인 후 예상 결제 금액에는 영향을 주지 않는다