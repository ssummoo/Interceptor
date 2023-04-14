package kr.co.softsoldesk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.softsoldesk.interceptor.TestInterceptor1;
import kr.co.softsoldesk.interceptor.TestInterceptor2;
import kr.co.softsoldesk.interceptor.TestInterceptor3;
import kr.co.softsoldesk.interceptor.TestInterceptor4;
import kr.co.softsoldesk.interceptor.TestInterceptor5;
import kr.co.softsoldesk.interceptor.TestInterceptor6;
import kr.co.softsoldesk.interceptor.TestInterceptor7;
import kr.co.softsoldesk.interceptor.TestInterceptor8;
//WebMvcConfigurer : servlet-context.xml 역할
@ComponentScan("kr.co.softsoldesk.controller")  //스캔할 패키지 지정
@ComponentScan("kr.co.softsoldesk.beans")  //스캔할 패키지 지정
@ComponentScan("kr.co.softsoldesk.validator")  //스캔할 패키지 지정
@EnableWebMvc //Controller로 등록되어 있는 클래스 세팅
@Configuration
public class ServletAppContext implements WebMvcConfigurer {

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		//view경로와 확장자 세팅
		WebMvcConfigurer.super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/views/",".jsp");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 이미지, 영상, 소리 등 정적파일 경로 매핑
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/**").addResourceLocations("/resources/");
	}
	@Bean
	ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource res=new ReloadableResourceBundleMessageSource();
		
		//res.setBasename("/WEB-INF/properties/data1");
		res.setBasenames("/WEB-INF/properties/error_message");
		
		return res;
	}
	//Interceptor 등록
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		WebMvcConfigurer.super.addInterceptors(registry);
		//인터셉터 객체 생성
		TestInterceptor1 interc1=new TestInterceptor1();
		TestInterceptor2 interc2=new TestInterceptor2();
		TestInterceptor3 interc3=new TestInterceptor3();
		TestInterceptor4 interc4=new TestInterceptor4();
		TestInterceptor5 interc5=new TestInterceptor5();
		TestInterceptor6 interc6=new TestInterceptor6();
		TestInterceptor7 interc7=new TestInterceptor7();
		TestInterceptor8 interc8=new TestInterceptor8();
		//레지스트리에 등록
		InterceptorRegistration reg1=registry.addInterceptor(interc1);
		InterceptorRegistration reg2=registry.addInterceptor(interc2);
		InterceptorRegistration reg3=registry.addInterceptor(interc3);
		InterceptorRegistration reg4=registry.addInterceptor(interc4);
		InterceptorRegistration reg5=registry.addInterceptor(interc5);
		InterceptorRegistration reg6=registry.addInterceptor(interc6);
		InterceptorRegistration reg7=registry.addInterceptor(interc7);
		InterceptorRegistration reg8=registry.addInterceptor(interc8);
		//주소만들기(관심사등록)
		reg1.addPathPatterns("/test1");
		reg2.addPathPatterns("/test1");
		
		reg3.addPathPatterns("/test2");

		reg4.addPathPatterns("/test1","/test2");

		reg5.addPathPatterns("sub1/test3","sub1/test4");
		
		reg6.addPathPatterns("/*"); //경로 1개짜리 모든 요청에 대하여
		
		reg7.addPathPatterns("/sub1/*"); //경로 1개짜리 모든 요청에 대하여

		reg8.addPathPatterns("/**"); //경로 두개이상의 모든 요청에 대하여
		reg8.excludePathPatterns("/*"); //하나짜리 경로 모은 요청 제외

	}
	
}
