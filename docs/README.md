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
* Calculator
  * addPrice: Map 형태의 주문을 받아 총주문 금액을 계산
* MenuList: 메뉴의 정보 및 관련 메서드를 enum 형태로 관리
  * getMenuName: MenuName을 반환
  * getPriceByName: 인자로 들어온 이름을 enum을 순회 및 대조하여 해당 메뉴의 가격 반환
  * isGroupByName: 인자로 들어온 이름과 그룹의 일치 여부를 반환한다
* PromotionModel: 내부 로직을 처리하는 역할, 입/출력할 데이터를 관리
  * getDate: 방문 날짜 반환
  * setDate: 방문 날짜 설정
  * getAddedPrice: 총주문 금액 반환
  * setAddedPrice: 총주문 금액 설정
  * getOrder: 주문 반환
  * setOrder: 주문 설정
  * getAppliedEvents: 적용된 혜택 반환
  * setAppliedEvents: 적용된 혜택 설정
  * getDiscountedAmount: 총혜택 금액 반환
  * setDiscountedAmount: 총혜택 금액 설정
* Calendar: 12월 달력의 날짜에 담긴 주말, 공휴일의 정보 및 관련 메서드를 enum 형태로 관리
  * isWeekend: 주말 여부를 boolean 형태로 반환
  * isHoliday: 공휴일 여부를 boolean 형태로 반환
* Applier: 할인 정책의 로직을 모아 model의 데이터를 업데이트
  * applyDiscounts: 총혜택 금액을 모델에 전달
  * applyEvents: 적용된 이벤트를 모델에 전달
  * applyDayOfTheWeekEvent: applyEvents에서 분리된 로직, 요일에 따라 다른 이벤트를 모델에 전달
* Gift: 할인 전 총주문 금액이 12만원 이상일 때, 샴페인 1개 증정
  * applyGiftEvent: 증정으로 인해 혜택을 본 가격을 반환
  * checkGiftEvent: 이벤트의 조건을 통과하는지 확인
* ChristmasDiscount: 크리스마스가 다가올수록 할인
  * applyChristmasDiscount: 날짜에 따라 할인된 금액 반환
  * checkChristmasDiscount: 이벤트의 조건을 통과하는지 확인
  * calculateChristmasDiscount: 날짜를 받아 할인율 계산
* DayOfTheWeekDiscount: 요일에 따라 메뉴 할인
  * applyDayOfTheWeekDiscount: 요일에 따라 다른 메뉴를 할인 받고 할인 금액을 반환
  * calculateDayOfTheWeekDiscount: 인자로 들어온 메뉴의 그룹을 MenuList와 대조하여 할인 금액을 계산
* HolidayDiscount: 공휴일에는 총주문 금액에서 1000원 할인
  * applyHolidayDiscount: 날짜와 달력을 비교하여 할인 금액을 반환

## util: 뷰와 모델 양쪽에서 사용
* PriceFormatterUtil
  * getFormattedPrice: 인자로 들어온 가격을 포맷에 맞추어 반환

## view: UI 담당
* InputView: 입력 UI를 담당
  * readDate: 방문 날짜 입력 UI
  * readOrder: 주문 입력 UI
  * parseOrderInput: 입력받은 주문을 Map 형태로 가공
* OutputView: 출력 UI를 담당
  * printDate: 방문 날짜 출력 UI
  * printMenu: 주문 출력 UI
  * printAddedPrice: 총주문 금액 출력 UI
  * printGift: 증정 메뉴 출력 UI
  * printAppliedEvents: 혜택 내역 출력 UI
  * printDiscountedAmount: 총혜택 금액 출력 UI
  * printFinalPrice: 할인 후 예상 결제 금액 출력 UI
  * printBadge: 총혜택 금액에 따른 이벤트 배지 출력 UI

## controller: 뷰와 모델 간의 중개
* PromotionController: 입력을 받아 모델을 업데이트하고, 모델의 변경을 감지하여 뷰를 업데이트
  * updateView: UI 실행 및 모델에 데이터 업데이트
  * runInputView: 입력 UI 실행
  * runOutputView: 출력 UI 실행

## 요구 사항
### 사전 기능 정리
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