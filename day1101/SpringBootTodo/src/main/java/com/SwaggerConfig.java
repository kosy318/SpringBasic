package com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// swagger: 컨트롤러에 명시된 어노테이션을 해석해서 api 문서를 자동으로 생성해줌
// ver 2 : localhost/swagger-ui.html 로 문서 확인하기 
// ver 3 : localhost/swagger-ui/index.html 로 문서 확인하기 

@Configuration
@EnableSwagger2 // Swagger2 쓰겠다.
public class SwaggerConfig {

	@Bean
	public Docket makeDocket() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2); // swagger 핵심 클래스
		ApiSelectorBuilder builder = docket.select(); // 문서 작성을 위한 내부 초기화 작업

		// 문서를 만들 대상 컨트롤러가 있는 패키지 지정
		builder = builder.apis(RequestHandlerSelectors.basePackage("com.todo.controller"));

		// api()로 선택된 api중 특정 path 조건에 맞는 api를 다시 필터링하여 문서화 작업을 함
		builder = builder.paths(PathSelectors.regex("/todo/*.*"));

		docket = builder.build();
		
		docket = docket.apiInfo(apiInfo());
		return docket;
	}

	private ApiInfo apiInfo() {
		ApiInfoBuilder b = new ApiInfoBuilder();
		b = b.title("Todo API입니다");
		b = b.description("<h3>Todo</h3>Swagger를 이용한 Customer API<br>");
		b = b.version("3.0");
		ApiInfo ai = b.build();
		return ai;
	}

}
