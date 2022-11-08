# webSetting
### 1주차 </br>
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

</br>

**3. spring, MriaDB, MyBatis 연동 및 데이터 조회** </br>
- [이슈] 한글로 인한 xml 파싱 오류
  - pom.xml에 파싱 디펜던시 추가
  - 참고: https://beautifulkim.tistory.com/480
- [이슈] XmlBeanDefinitionStoreException
  - root-context.xml에 spring-context 스키마 추가
  - 참고: https://bears25.tistory.com/99
- MVC 패턴으로 MariaDB 데이터 조회 후 웹 출력 테스트(완료)
