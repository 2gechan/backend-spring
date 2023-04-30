package gechan.core;

import gechan.core.repository.JdbcMemberRepository;
import gechan.core.repository.MemberRepository;
import gechan.core.repository.MemoryMemberRepository;
import gechan.core.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/*
 * 정형화된 컨트롤러, 서비스, 리포지토리 같은 코드는 컴포넌트 스캔을 사용
 * 정형화 되지 않거나, 상황에 따라 구현 클래스를 변경해야 하면 설정(스피링 빈 수동 등록)을 통해 스프링 빈으로 등록
 */
@Configuration
public class SpringConfig {

    private DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean // 자바 코드로 직접 스프링 빈을 등록
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean // 자바 코드로 직접 스프링 빈을 등록
    public MemberRepository memberRepository() {

//        return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
}
