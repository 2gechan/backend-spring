package gechan.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 해당 애너테이션이 붙은 패키지부터 하위 패키지까지 컴포넌트 스캔을 한다
// 그렇기 때문에 포함되지 않는 패키지에 컴포넌트 애너테이션이 있더라도 스프링 빈에 등록하지 않는다
// 스프링은 스프링 컨테이너에 스프링 빈을 등록할 때, 기본으로 싱글톤으로 등록한다(객체를 하나만 등록해서 공유)
public class CoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}

}
