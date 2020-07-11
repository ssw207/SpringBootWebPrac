package com.web.swsong.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                /**
                 * CSRF란 Cross Site Request Forgery의 약자로 사용자가 의도하지 않은요청을 통한 공격을 뜻한다.
                 * 웹사이트에 로그인한 사용자가 https://xxxx.com/logout URL을 호출해 로그아웃을 유도하는 등등..
                 * CSRF를 방어하기위해서 시큐리티는 헤더에 X-XSRF-TOKEN 이름트로 토큰을 넣고 요증시마다 검증한다.
                 */
                .csrf().disable()// 개발의 편의성을 위해 설정을 끈다. TODO 왜 불편할까?
                /**
                 * TODO h2 console 사용 위해 필요하다고 하는데 왜 그럴까?
                 * headers옵션은 시큐리티 http헤더 관련 설정을 해준다 (https://docs.spring.io/spring-security/site/docs/3.2.0.CI-SNAPSHOT/reference/html/headers.html)
                 * frameOptions()는 웹사이트 내부에 frame을 허용하는 옵션이다.
                 * @EnableWebSecurity 설정활성화시 자동으로 응답헤더에 X-Frame-Options:Deny 옵션을 추가해 Frame을 사용하지 못하게 된다.
                 * h2-console을 사용하기 위해서는 프레임을 사용하도록 헤더에 X-Frame-Options:Deny 추가하지 않도록 바꿔야한다.
                 */
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests() // 요청 인가 제어
                    .antMatchers("/", "/h2-console/**").permitAll() // 모든 접근허용
                    .antMatchers("/api/v1/**").hasRole("USER") // user권한이 있는사람만 api호출 가능
                    .anyRequest().authenticated(); // 그외 요청은 모두 인증필요
        super.configure(http);
    }
}
