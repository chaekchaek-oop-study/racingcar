# Racing Car OOP Study

같은 문제를 서로 다른 언어와 설계로 풀고, 함께 리뷰하며 객체지향을 공부하는 저장소입니다.

## 이 스터디를 시작한 이유

우아한테크코스 프리코스의 자동차 경주 미션을 다시 풀어봅니다. 정답을 빠르게 완성하는 것보다 객체에게 어떤 역할과 책임을 맡길지, 객체들이 어떻게 협력하게 할지 고민하는 데 집중합니다.

개인의 포크 저장소에 결과를 남기는 데 그치지 않고, 한곳에 각자의 구현과 리뷰 기록을 모아 우리가 무엇을 고민했고 어떻게 설계를 발전시켰는지 함께 확인하고자 이 스터디를 시작했습니다.

## 우리가 생각하는 객체지향

객체지향은 특정 언어나 문법에 종속된 구현 기법이 아니라, 역할과 책임을 나누고 객체의 협력으로 문제를 해결하려는 프로그래밍의 사고방식이라고 생각합니다.

Java, Kotlin, JavaScript는 표현 방식과 관용구가 다르지만 다음과 같은 질문은 언어의 경계를 넘어 함께 이야기할 수 있습니다.

- 객체의 책임이 명확한가?
- 객체가 알아야 할 것과 하지 않아야 할 일이 적절히 나뉘어 있는가?
- 도메인 규칙을 가장 잘 아는 객체가 그 규칙을 수행하는가?
- 객체 사이의 협력이 의도를 잘 드러내는가?
- 요구사항이 바뀌었을 때 변경의 영향이 한곳에 머무는가?

그래서 이 스터디에서는 사용 언어와 관계없이 모든 구성원이 모든 구현을 상호 리뷰합니다. 익숙하지 않은 언어의 세부 문법보다 객체의 역할, 책임, 협력과 코드가 전달하는 의도에 집중합니다.

## 진행 방식

1. 각 구성원은 자신의 닉네임 디렉터리에서 독립적으로 미션을 구현합니다.
2. 작업 브랜치는 `언어/GitHub아이디/dev` 형식으로 관리합니다.
3. 구현 또는 리팩터링 단위로 `main` 브랜치에 Pull Request를 엽니다.
4. 언어와 관계없이 전원이 서로의 코드를 리뷰합니다.
5. 리뷰에서 나눈 고민과 설계의 변화를 코드와 Pull Request에 남깁니다.

## 참여 시작하기

Git은 디렉터리가 아니라 저장소 단위로 clone합니다. 따라서 전체 저장소를 받은 뒤, 사용할 언어의 `base` 디렉터리 내용을 자신의 닉네임 디렉터리로 복사합니다.

아래 명령의 `{언어}`, `{GitHub아이디}`, `{닉네임}`은 자신에게 맞는 값으로 바꿉니다.

```bash
git clone https://github.com/chaekchaek-oop-study/racingcar.git
cd racingcar

git switch -c {언어}/{GitHub아이디}/dev
# 예시: git switch -c java/rudevico/dev

cp -R base/{언어}/. '{닉네임}/'
# 예시: cp -R base/java/. '루드비코/'

git rm '{닉네임}/.gitkeep'
# 예시: git rm '루드비코/.gitkeep'

git add '{닉네임}'
# 예시: git add '루드비코'

git commit -m "chore: {닉네임} {언어} 베이스 코드 설정"
# 예시: git commit -m "chore: 루드비코 Java 베이스 코드 설정"

git push -u origin {언어}/{GitHub아이디}/dev
# 예시: git push -u origin java/rudevico/dev
```

| 사용 언어 | 복사할 디렉터리 |
| --- | --- |
| Java | `base/java/` |
| Kotlin | `base/kotlin/` |
| JavaScript | `base/javascript/` |

`base/` 아래의 원본 코드는 직접 수정하지 않습니다. 각자의 작업은 닉네임 디렉터리 안에서 진행하고, `main` 브랜치로 Pull Request를 엽니다.

## 디렉터리 구조

`base/`에는 각 언어의 프리코스 원본 코드를 기준 상태로 보존합니다. 이 코드는 직접 수정하지 않으며, 각 구성원은 자신의 닉네임 디렉터리에 필요한 베이스 코드를 가져와 독립적으로 구현합니다.

```text
.
├── base/
│   ├── java/
│   ├── kotlin/
│   └── javascript/
├── 루드비코/
├── 먼지/
├── 소낙눈/
├── 아나키/
└── 아오/
```

## 미션 출처

이 저장소의 자동차 경주 미션 요구사항과 기본 코드는 다음 우아한테크코스 프리코스 저장소를 바탕으로 합니다.

| 언어 | 원본 저장소 | 기준 커밋 |
| --- | --- | --- |
| Java | [java-racingcar-8](https://github.com/woowacourse-precourse/java-racingcar-8) | [`75a4d66`](https://github.com/woowacourse-precourse/java-racingcar-8/commit/75a4d6639cf12324f8fd743a3704527a655b0adf) |
| Kotlin | [kotlin-racingcar-8](https://github.com/woowacourse-precourse/kotlin-racingcar-8) | [`1afacc8`](https://github.com/woowacourse-precourse/kotlin-racingcar-8/commit/1afacc89c42ad547ce318c8c8d7a6035c173b42d) |
| JavaScript | [javascript-racingcar-8](https://github.com/woowacourse-precourse/javascript-racingcar-8) | [`e107b0c`](https://github.com/woowacourse-precourse/javascript-racingcar-8/commit/e107b0c27034fe353560e2f766f79970aa6a271e) |

이 저장소는 해당 미션을 객체지향적으로 다시 탐구하기 위한 독립적인 학습 저장소이며, 우아한테크코스의 공식 제출 저장소가 아닙니다.
