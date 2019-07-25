package com.yunusb.springboot.config;


import com.yunusb.springboot.security.JwtAuthenticationEntryPoint;
import com.yunusb.springboot.security.JwtAuthenticationFilter;
import com.yunusb.springboot.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/*
prePostEnabled
Determines if Spring Security's pre post annotations should be enabled.
 */
//Customize web security configuration(WebSecurityConfigurerAdapter)
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // checks requests before methods working
public class SecurityConfig extends WebSecurityConfigurerAdapter {


  private final UserDetailsServiceImpl userDetailsService;
  private final JwtAuthenticationEntryPoint unauthorizedHandler; // Spring doesn't give jwt so create custom unauthorizedHandler

  @Autowired
  public SecurityConfig(UserDetailsServiceImpl userDetailsService, JwtAuthenticationEntryPoint unauthorizedHandler) {
    this.userDetailsService = userDetailsService;
    this.unauthorizedHandler = unauthorizedHandler;
  }


  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.cors().and().csrf().disable().
            authorizeRequests()
            .antMatchers("/api/token/register", "/api/token").permitAll()
            .anyRequest().authenticated()
            .and()
            .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
    http.formLogin();

  }

  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  // set BCryptPasswordEncoder()
  @Autowired
  public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
  }

  @Bean // blocks every request from the application / implements OncePerRequestFilter
  public JwtAuthenticationFilter authenticationTokenFilterBean() throws Exception {
    return new JwtAuthenticationFilter();
  }

  @Bean
  public BCryptPasswordEncoder encoder() {
    return new BCryptPasswordEncoder();
  }

  }
