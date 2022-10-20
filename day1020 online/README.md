# 10/20 Spring MVC & Interceptor & MyBatis(Webex)

# Interceptor

### HandlerInterceptor를 통한 요청 가로채기

- Controller가 요청을 처리하기 전/후 처리
- 로깅, 모니터링 정보 수집, 접근 제어 처리 등의 실제 Business Logic과는 분리되어 처리해야 하는 기능들을 넣고 싶을 때 유용함
- interceptor를 여러 개 설정할 수 있음(순서 주의!!)

### HandlerInterceptor 제공 method

| HandlerInterceptor method |
| --- |
| boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
- false를 반환하면 request를 바로 종료 |
| void postHandle(HttpServletRequest requet, HttpServletResponse response, Object handler, ModelAndView modelAndView)
- Controller 수행 후 호출 |
| void after Completion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
- view를 통해 클라이언트에 응답을 전송한 뒤 실행
- 예외가 발생하여도 실행 |

### HandlerInterceptor를 통한 요청 가로채기

- HandlerInterceptor 인터페이스 구현
- HandlerInterceptorAdaptor 클래스 제공
- Interceptor 설정하기 : servlet-context.xml

![Untitled](10%2020%20Spring%20MVC%20&%20Interceptor%20&%20MyBatis(Webex)%20654f62f26eb34d81a42a3ba6d7db45ea/Untitled.png)

# MyBatis

- MyBatis는 Java Object와 SQL문 사이의 자동 Mapping 기능을 지원하는 ORM Framework
    - https://blog.mybatis.org
    - MyBatis는 SQL을 별도의 파일로 분리해서 관리
    - Object - SQL 사이의 parameter mapping 작업을 자동으로 해줌
    - MyBatis는 Hibernate나 JPA(Java Persistence API)처럼 새로운 DB 프로그래밍 패러다임을 익혀야하는 부담이 없이 익숙한 SQL을 그대로 이용하면서 JDBC 코드 작성의 불편함을 제거해 주고, 도메인 객체나 VO 객체를 중심으로 개발이 가능.

- 고성능의 persistence framework로 다양한 SQL문장과 저장 프로시저나 고급 맵핑 기능을 지원해줌.
- DB관련 환경 설정 부분에서부터 쿼리 실행 결과를 다루는 부분까지 거의 모든 JDBC 코드를 대신함
- 간단한 XML 문서나 Annotation을 이용하여 환경설정이 가능하며 기본형 데이터, Map 그리고 일반 객체를 DB의 레코드와 맵핑 시킬 수 있음.

![MyBatis](10%2020%20Spring%20MVC%20&%20Interceptor%20&%20MyBatis(Webex)%20654f62f26eb34d81a42a3ba6d7db45ea/Untitled%201.png)

MyBatis

![Untitled](10%2020%20Spring%20MVC%20&%20Interceptor%20&%20MyBatis(Webex)%20654f62f26eb34d81a42a3ba6d7db45ea/Untitled%202.png)