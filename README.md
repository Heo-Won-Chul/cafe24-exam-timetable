# 시간표 자동 생성 서비스

- [간단요약](#간단요약)
- [진행방향](#진행방향)

## 간단요약

- 스펙: pom.xml 참고
- 테이블 정의와 데이터 삽입은 별도의 sql 파일 활용(schema-h2.sql, data-h2.sql)
- 대략적인 프로세스
	1. 학과 입력 필드에 `컴퓨터공학과` 입력(typehead 적용)
	2. `학과 (학점)` 형태의 리스트가 나열
	3. 범위 내(18~21) 학점 선택시 생성 버튼 활성화 (이외에는 비활성화)
	4. 생성 클릭 시, 첫번째 경우의 시간표가 FullCalendar에 표기
	5. `이전`,`다음` 버튼으로 여러가지 경우의 시간표 표기 


## 진행방향

1. 문제에 대한 방향성
2. 데이터 모델링
3. 애플리케이션 아키텍처 구성
4. 개발 및 테스트 케이스 작성
5. 배포

#### 진행방향 - 1. 문제에 대한 방향성

1. 주어진 조건에 따라 시간표 생성하기 위한 최적의 알고리즘은 무엇인가?
	- 백트래킹 알고리즘?
	- 유전 알고리즘?
	- __알파-베타 가지치기 알고리즘(선택)__

2. 생산성을 고려했을 때, 어떤 방향으로 가야하는가?
	- JQuery와 BootStrap을 활용
	- 학과 입력: typehead를 활용
	- 시간표: FullCalendar를 활용

3. 데이터베이스는 어떻게 활용할 것 인가?
	- 내장 데이터베이스(H2)를 활용

#### 진행방향 - 2. 데이터 모델링

1. 한 학교에 학년 구분없이 수업을 듣는 것을 가정

#### 진행방향 - 3. 애플리케이션 아키텍처 구성

1. 리소스별 MVC 구현

#### 진행방향 - 4. 개발 및 테스트 케이스 작성

1. validation 작성
2. tc 작성

#### 진행방향 - 5. 배포

1. NCLOUD 활용(X)

#### 진행방향 - 다른 이슈들

1. 최소 학점으로 인해 경우의 수가 너무 많다. (output 크기가 너무 크다)
2. sql injection 처리