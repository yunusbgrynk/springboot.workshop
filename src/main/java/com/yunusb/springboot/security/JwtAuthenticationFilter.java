package com.yunusb.springboot.security;

import com.yunusb.springboot.service.impl.UserDetailsServiceImpl;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
//customize control token
@Service
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  // (Header(Authorization(Bearer)))
  public static final String TOKEN_PREFIX = "Bearer";
  public static final String HEADER_STRING = "Authorization";

  @Autowired
  private UserDetailsServiceImpl userDetailsServiceImpl;
  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @Override
  protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

    String header = httpServletRequest.getHeader(HEADER_STRING);
    String username = null;
    String authToken = null;
    if (header != null && header.startsWith(TOKEN_PREFIX)) {
      authToken = header.replace(TOKEN_PREFIX, "");
      try {
        username = jwtTokenUtil.getUsernameFromToken(authToken);
      } catch (IllegalArgumentException e) {
        log.error("Error relate getting username", e);
      } catch (ExpiredJwtException e) {
        log.warn("Token is expired", e);
      } catch (SignatureException e) {
        log.error("Authentication Error");
      }
    } else {
      log.warn("Couldn't find header");
    }
    if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

      UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(username);

      if (jwtTokenUtil.validateToken(authToken, userDetails)) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
        log.info("Authenticated User " + username );
        SecurityContextHolder.getContext().setAuthentication(authentication);
      }
    }

    filterChain.doFilter(httpServletRequest, httpServletResponse);
  }

}
