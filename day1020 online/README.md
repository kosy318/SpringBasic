# Interceptor

### HandlerInterceptor를 통한 요청 가로채기

- Controller가 요청을 처리하기 전/후 처리
- 로깅, 모니터링 정보 수집, 접근 제어 처리 등의 실제 Business Logic과는 분리되어 처리해야 하는 기능들을 넣고 싶을 때 유용함
- interceptor를 여러 개 설정할 수 있음(순서 주의!!)

### HandlerInterceptor 제공 method

| HandlerInterceptor method |
| --- |
| boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)<br>- false를 반환하면 request를 바로 종료 |
| void postHandle(HttpServletRequest requet, HttpServletResponse response, Object handler, ModelAndView modelAndView)<br>- Controller 수행 후 호출 |
| void after Completion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)<br>- view를 통해 클라이언트에 응답을 전송한 뒤 실행<br>- 예외가 발생하여도 실행 |

### HandlerInterceptor를 통한 요청 가로채기

- HandlerInterceptor 인터페이스 구현
- HandlerInterceptorAdaptor 클래스 제공
- Interceptor 설정하기 : servlet-context.xml

![Untitled 1](https://user-images.githubusercontent.com/77595685/197012278-6d8e8748-9d29-4227-bd9a-64851222141a.png)

# MyBatis

- MyBatis는 Java Object와 SQL문 사이의 자동 Mapping 기능을 지원하는 ORM Framework
    - https://blog.mybatis.org
    - MyBatis는 SQL을 별도의 파일로 분리해서 관리
    - Object - SQL 사이의 parameter mapping 작업을 자동으로 해줌
    - MyBatis는 Hibernate나 JPA(Java Persistence API)처럼 새로운 DB 프로그래밍 패러다임을 익혀야하는 부담이 없이 익숙한 SQL을 그대로 이용하면서 JDBC 코드 작성의 불편함을 제거해 주고, 도메인 객체나 VO 객체를 중심으로 개발이 가능.

- 고성능의 persistence framework로 다양한 SQL문장과 저장 프로시저나 고급 맵핑 기능을 지원해줌.
- DB관련 환경 설정 부분에서부터 쿼리 실행 결과를 다루는 부분까지 거의 모든 JDBC 코드를 대신함
- 간단한 XML 문서나 Annotation을 이용하여 환경설정이 가능하며 기본형 데이터, Map 그리고 일반 객체를 DB의 레코드와 맵핑 시킬 수 있음.

![Untitled 2](https://user-images.githubusercontent.com/77595685/197012307-1f6fabc7-511a-44de-9709-72843a3cc6c7.png)

MyBatis

![Untitled](https://user-images.githubusercontent.com/77595685/197012325-7c4eb472-ba33-4ea4-88c8-15a3f4a1c34d.png)
