3점대에서는 지원이 되지 않는 DI가 존재
pom.xml -> springframework 버전 바꾸기 5.2.6 RELEASE<br>
	java-version 바꾸기 1.8<br>
	maven-compiler-plugin 바꾸기 1.8<br>

# Dependency Injection

## Annotation 방법
<a href="https://github.com/kosy318/SpringBasic/tree/main/day1017%20make-up/SpringBasic/src/main/java/com/mycom/myapp/calc/annotation">com.mycom.myapp.calc.annotation</a>
<b>일반적으로 사용하는 방법</b>

project 안 src/main/resources에 src/main/webapp/WEB-INF/spring 의 root-context.xml 복붙

root-context.xml 이름 calc-annotation.xml로 변경

```xml
<!-- Annotation 관련 설정 -->
<!-- base-package에 지정된 package를 모두 살펴서 Annotation이 있으면 처리해라! -->
<context:component-scan base-package="com.mycom.myapp.calc.annotation"></context:component-scan>	
```

xml 파일에서 namespace tab에서 context 체크

필요한 곳에 component annotation 추가
```java
// Spring 객체 생성 요구 => Spring이 객체를 생성해서 넘겨준다.
//  소문자
Calculator calculator = (Calculator)context.getBean("calculator"); // Spring 에게 객체 생성 요구(만들어 줘!)
```

## xml 방법
<a href="https://github.com/kosy318/SpringBasic/tree/main/day1017%20make-up/SpringBasic/src/main/java/com/mycom/myapp/calc/xml">com.mycom.myapp.calc.xml</a>

root-context.xml 이름 calc-xml.xml로 변경
```xml
<!-- XML 관련 설정 -->
<!-- xml로 직접 bean 객체 설정 -->
<bean id="calculator" class="com.mycom.myapp.calc.xml.Calculator"></bean>
```
## Configuration 방법
<a href="https://github.com/kosy318/SpringBasic/tree/main/day1017%20make-up/SpringBasic/src/main/java/com/mycom/myappcalc/configuration">com.mycom.myappcalc.configuration</a>

CalcConfiguration class를 만든 뒤 @Configuration 작성

내부에 @Bean 작성
```java
@Bean
public Calculator calculator() {
  return new Calculator();
}
```
Main.java에
```
AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CalcConfiguration.class);
```

## @Autowired
<b>setter와 생성자 주입 방법을 추천</b>
<a href="https://github.com/kosy318/SpringBasic/tree/main/day1017%20make-up/SpringBasic/src/main/java/com/mycom/myapp/calc/hasa">com.mycom.myapp.calc.hasa</a>
### Interface, @Qualifier
<a href="https://github.com/kosy318/SpringBasic/tree/main/day1017%20make-up/SpringBasic/src/main/java/com/mycom/myapp/calc/all">com.mycom.myapp.calc.all</a>
