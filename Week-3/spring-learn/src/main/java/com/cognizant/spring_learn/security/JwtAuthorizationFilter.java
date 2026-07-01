package com.cognizant.spring_learn.security;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(JwtAuthorizationFilter.class);

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws IOException, ServletException {

        LOGGER.info("Start");

        String header = request.getHeader("Authorization");

        LOGGER.debug("Authorization Header : {}", header);

        if (header == null || !header.startsWith("Bearer ")) {

            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authentication =
                getAuthentication(request);

        if (authentication != null) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        chain.doFilter(request, response);

        LOGGER.info("End");
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {

        String token = request.getHeader("Authorization");

        if (token != null) {

            try {

                Jws<Claims> claims = Jwts.parserBuilder()

                        .setSigningKey(
                                com.cognizant.spring_learn.controller.AuthenticationController.SECRET_KEY)

                        .build()

                        .parseClaimsJws(token.replace("Bearer ", ""));

                String user = claims.getBody().getSubject();

                LOGGER.debug("Authenticated User : {}", user);

                if (user != null) {

                    return new UsernamePasswordAuthenticationToken(

                            user,

                            null,

                            List.of(new SimpleGrantedAuthority("ROLE_USER"))

                    );
                }

            } catch (JwtException ex) {

                LOGGER.error("Invalid JWT Token");

                return null;
            }
        }

        return null;
    }
}