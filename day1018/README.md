# 10/18 DI & AOP

# DI(Dependency Injection)

- DI는 "Dependency Injection"의 약어로 의존성 주입을 의미
- 객체 사이의 의존 관계가 자기 자신이 아닌 외부(스프링)에 의해서 설정
- 스프링은 각 클래스 간의 의존 관계를 관리하기 위한 2가지 방법을 제공
    - Constructor Injection
        - 의존하는 빈 객체를 컨테이너로부터 생성자의 파라미터를 통해서 전달하는 방식
        - 클래스를 초기화 할 때 컨테이너로부터 의존 관계에 있는 특저어 리소스인 빈 객체를 생성자를 통해서 할당 받는 방법
    - 
    

# AOP(Aspect-Oriented Programming)

- 전체 어플리케이션 구현 기능을 두 가지로 구분
    - 핵심 업무(Core concern)
        - biz logic
        - ex) 은행 업무 처리 시스템에서 계좌이체, 대출승인, 이자계산
    - 공통 업무(Cross-cutting concern)
        - 핵심 업무를 도와주는 반복적이고 부가적인 업무
        - ex) 로깅, 보안, 트렌젝션

## Aspect 지향과 횡단 관점 분리

- Aspect 지향의 중요 개념
    - Separation of Cross-Cutting Concern → 핵심 업무에만 집중

- AOP에서는 분리한 기능의 호출도 포함하여 관점으로 취급
- 횡단 관점: 핵심 모듈에 산재한 관점
- AOP에서는 이러한 “횡단 관점”까지 분리
    - 각 핵심 모듈로터 관점에 관한 코드 완전 제거

## 스프링 AOP에서의 용어

AOP 프레임워크의 기증 중 일부를 가져옴

- Joinpoint - “클래스의 인스턴스 생성 시점”, “메소드 호출 시점” 및 “예외 발생 시점”과 같이 애플리케이션을 실행할 때 특정 작업이 시작되는 시점(~때; when)
- Advice - Joinpoint에 삽입되어져 동작할 수 있는 코드(Weaving; Method; 공통 업무 내용을 가지고있음; what)
- Pointcut - 여러 개의 Joinpoint를 하나로 결합한(묶은) 것
- Weaving - Advice를 핵심 로직 코드에 삽입하는 것
- Target - 핵심 로직을 구현하는 클래스
- Aspect - 여러 객체에 공통으로 적용되는 공통 관점 사항(Class; Advice가 들어있다; when + what : 언제 뭐할거니?)

### Weaving 시점(Target에 Aspect의 Advice가 삽입되는 시점, Target과 Aspect가 섞이는 시점)

1. compile time
    - 실행파일이 만들어지는 시점(빠름)
2. loading time
    - 메모리에 로딩하려는 시점
3. **runtime**
    - 프록시가 결정

### Advice Type

| Advice Type | Remark |
| --- | --- |
| Before |  |
| After |  |
| AfterReturning |  |
| Around |  |
|  |  |
|  |  |

### Pointcut 표현식

designator(execution), return type, method, params 는 적어야함

## Spring AOP 구현 방식

1. XML 기반의 AOP : POJO 형태의 Advice 구현
2. Annotation 기반의 AOP :@Annotation 사용해서 Advice 구현

## Spring AOP 특징

Proxy 기반의 AOP : Target 객체에 대한 proxy를 만들어 제공

Proxy : Target을 감싸는 구조로 runtime에 생성; Advice를 Target에 적용

```java
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-aop</artifactId>
    <version>3.0.7.RELEASE</version>
</dependency>

<!-- https://mvnrepository.com/artifact/org.aspectj/aspectjrt -->
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjrt</artifactId>
    <version>1.7.3</version>
</dependency>

<!-- https://mvnrepository.com/artifact/org.aspectj/aspectjweaver -->
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
    <version>1.6.7</version>
</dependency>
```