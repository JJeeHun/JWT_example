package com.example.tutorial.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity //기본적인 웹 보안을 활성화
//TODO 추가 적인 설정을 위해서 WebSecurityConfigurer 를 implements 하거나 WebSecurityConfigurerAdapter 를 extends 해야함.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()//TODO HttpServletRequest 를 사용하는 요청들에 대한 접근을 제한하는 설정
            .antMatchers("/api/hello").permitAll() //TODO /api/hello 에 대한 요청을 허용
            .anyRequest().authenticated(); //TODO 나머지 요청은 전부 인증을 받아야 함.
  }
}
