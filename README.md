# webSetting

> [1주차](#1주차-) - 스프링 프레임워크와 Maria DB 설정 후 테스트 화면 출력 </br>
[2주차](#2주차-) - HTTP와 REST API, API 초안 작성

</br>

---

### 1주차 </br>
스프링 프레임워크와 Maria DB 설정 후 테스트 화면 출력 </br>
**1. 개발환경 셋팅** </br>
- JDK: 11.0.14
- IDE: Eclipse 2019-06
- spring: 5.3.23
- tomcat: 9.06.68
- DB
  - MariaDB: 10.2.14
    - [이슈] 기존 설치한 MySQL과 충돌
      - 포트: 3307로 변경
  - myBatis: 3.4.4

</br>

**2. mariaDB 예제 추가** </br>
- 데이터베이스 만들기(완료)
- movie 테이블 생성(완료)
- movie 테이블 예제 데이터 추가(완료)

<img src="https://user-images.githubusercontent.com/74169420/202148295-6575904b-55f2-4561-9e84-f8d1326bdad2.jpg" width="500" height="">

</br>

**3. spring, MriaDB, MyBatis 연동 및 데이터 조회** </br>
- [이슈] 한글로 인한 xml 파싱 오류
  - pom.xml에 파싱 디펜던시 추가
  - 참고: https://beautifulkim.tistory.com/480
- [이슈] XmlBeanDefinitionStoreException
  - root-context.xml에 spring-context 스키마 추가
  - 참고: https://bears25.tistory.com/99
- MVC 패턴으로 MariaDB 데이터 조회 후 웹 출력 테스트(완료)

<img src="https://user-images.githubusercontent.com/74169420/202148374-76deccc2-e284-445c-b75f-3376c558dd30.jpg" width="500" height="">


</br>

---

### 2주차 </br>
**1. 개념 학습** </br>
> 개념 정리하여 pdf 파일 작성하여 document 브랜치에 업로드
- HTTP에 대하여
- 브라우저에서 HTTP 요청 흐름
- REST API와 HTTP 메서드, HTTP 상태코드

</br>

**2. API 초안 작성해보기** </br>
> API 작성은 직무부트캠프의 전체적인 내용으로 추후에 계속 수정할 것!

>document 브랜치에 API 초안.pdf로 업로드

- 5개 통계 API 구축
  - 월별 접속자 수
  - 일자별 접속자 수
  - 평균 하루 로그인 수
  - 휴일을 제외한 로그인 수
  - 부서별 월별 로그인 수

</br>
