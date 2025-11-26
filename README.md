<p align="center">
  <img src="https://github.com/user-attachments/assets/6196bd0d-c528-4158-8859-cc1516ac9c78" width="50%">
</p>

## 🖥️ DesignSystem
Jetpack Compose 기반으로 구축한 Design System 프로젝트입니다. 앱 전반에서 사용되는 UI 컴포넌트, 스타일 가이드, 인터랙션 원칙을 체계적으로 정의하여 일관된 디자인 적용과 개발 효율성 향상을 목표로 합니다. 반복적으로 사용되던 버튼, 다이얼로그, 입력 필드 등의 UI 요소를 컴포넌트화하고, 색상·타이포그래피·간격 규칙을 표준화함으로써 신규 앱 개발 시 디자인 설계와 UI 아키텍처 구성에 필요한 시간을 크게 단축했습니다. 또한 지속적인 개선을 통해 개발 생산성과 유지보수성을 강화하며, 공통된 UI 언어를 기반으로 안정적으로 기능을 확장할 수 있는 환경을 제공합니다.

<br>

## 🧑‍💻 참여 인원
|  <img src="https://github.com/user-attachments/assets/9bbe9e79-04b6-44b1-a68c-eae5a049c2ad" width="100" height="100">  |
|:---:|
| 김태훈 |
| Android|

<br>

## 🗓️ 개발 기간
2025.01 ~ 진행 중

<br>

## 📁 프로젝트 상세 설명
- 패턴 & 아키텍처 (Patterns & Architecture)
    - Multi-Module 구조 기반 설계
    - MVVM 패턴 적용으로 UI와 데이터 로직을 분리
    - Room, DataStore (Preferences / Proto) 등을 활용한 데이터 관리
- 기초 스타일 (Theme)
    - ColorSet: 브랜드 톤과 대비 기준을 정의
    - Typography: 서체 크기, 두께, 계층 구조 표준화
    - Space: 컴포넌트 간 여백 표준화
    - Shape: 컴포넌트의 모서리 처리 구조
- 커스텀 어노테이션(Custom Annotation)
    - ViewModel에서 사용되는 코루틴 스코프를 목적에 따라 정의
    - Compose PreView 환경에서 반복되는 설정을 통합하고, 개발 효율성을 높이기 위해 Preview 어노테이션 정의
- UI 컴포넌트 (Components)
    1. Badge : 항목의 상태를 빠르게 인식할 수 있도록 강조하는데 사용
      - variant : Badge의 기본 디자인 형태(FILL, WEAK)
      - size : Badge의 크기(XSMALL, SMALL, MEDIUM, LARGE)
    2. BottomSheet : 하단에 올라오는 화면으로 추가 정보 제공 혹은 사용자 선택을 제공하는데 사용
      - variant : BottomSheet의 하단에 제공되는 버튼의 갯수 및 형태(CTA, DOUBLE_CTA)
    3. Button : 사용자가 어떤 액션을 트리거하거나 이벤트를 실행할 때 사용
      - variant : Button의 기본 디자인 형태(FILL, WEAK)
      - size : Button의 크기(SMALL, MEDIUM, LARGE, XLARGE)
    4. Dialog : 사용자에게 중요한 정보를 전달하거나 선택을 요구할 때 사용
      - variant : Dialog의 하단에 제공되는 버튼의 갯수 및 형태(ALERT, CONFIRM)
      - title : Dialog의 상단에 위치한 메인 제목
      - description : title 밑에 제공되는 설명 텍스트
      - animation : Dialog가 좌우로 진동하는 애니메이션 효과 사용 여부
    5. Icon : 항목을 빠르게 이미지 형태로 인식할 수 있도록 사용
      - ariaLabel : 해당 IconButton이 어떤 기능인지 알려주는 텍스트 (노출되는 UI X)
    6. IconButton : 항목을 빠르게 인식 후 사용자가 어떤 액션을 트리거하거나 이벤트를 실행할 때 사용
      - variant : IconButton의 기본 디자인 형태(CLEAR, FILL, BORDER) 
      - ariaLabel : 해당 Icon이 어떤 의미인지 알려주는 텍스트 (노출되는 UI X)
    7. NavigationBar : 화면 하단에서 서비스의 주요 기능에 빠르게 접근할 수 있도록하는 UI
      - variant : NavigationBar의 기본 디자인 형태(DEFAULT, ROUND)
    8. Screen : 기본적인 화면의 기초 레이아웃
    9. Text : 기본 텍스트
      - selectable : 텍스트의 복사 가능 여부
    10. TextField : 사용자가 텍스트를 입력하는데 사용
      - variant : TextField의 기본 디자인 및 키보드, icon 등을 결정
    11. TopBar : 화면에 대한 정보 및 기타 기능 버튼을 제공
      - title : TopBar의 메인 제목
      - titleContent : TopBar의 메인 콘텐츠로 title과 함께 사용할 수 없음
      - centeredTitle : title 혹은 titleContent를 중앙에 배치 여부
      - navigationIcon : TopBar 좌측에 배치하는 버튼
      - actions : TopBar 우측에 배치하는 버튼
<br>



<br>

## ✏️ 배운 내용
- Multi-Module 설계 및 의존성 주입
- Room DB 사용시 계정별로 서로 다른 Room Database를 생성하고, Factory를 사용해 각 계정에 대응되는 DAO 제공하는 방법
- 안드로이드 기본 컴포넌트 분석 후 커스텀하는 방법
- Proto DataStore 설정 및 사용

<br>

## 🛠️ 사용 기술
[![My Skills](https://skillicons.dev/icons?i=androidstudio,kotlin)](https://skillicons.dev)
