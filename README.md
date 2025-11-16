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
- UI 컴포넌트 (Components)
    - 각 컴포넌트는 고유 파라미터를 통해 상황에 맞게 변형 가능
    - 모든 컴포넌트는 Preview 기능을 제공하여 디자인-개발 간 피드백을 단축
    - 구성 요소: Badge, Button, Bottom Sheet, Dialog, TopBar, BottomBar 등 앱 개발이 있어 필요한 기초적인 컴포넌트 설계
- 커스텀 어노테이션(Custom Annotation)
    - ViewModel에서 사용되는 코루틴 스코프를 목적에 따라 정의
    - Compose PreView 환경에서 반복되는 설정을 통합하고, 개발 효율성을 높이기 위해 Preview 어노테이션 정의
<br>



<br>
## ✏️ 배운 내용
- Multi-Module 설계 및 의존성 주입
- Room DB 사용시 계정별로 서로 다른 Room Database 파일을 생성하고, 각 계정에 대응되는 DAO 제공하는 방법
- 안드로이드 기본 컴포넌트 분석 후 커스텀하는 방법
- Proto DataStore 설정 및 사용
<br>

## 🛠️ 사용 기술
[![My Skills](https://skillicons.dev/icons?i=androidstudio,kotlin)](https://skillicons.dev)
