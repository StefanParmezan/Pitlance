package com.example.Pitlance.JWT;

import jakarta.servlet.http.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;


public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        System.out.println("JwtFilter вызван для: " + request.getRequestURI());
        String token = getTokenFromRequest(request);

        System.out.println("Валиден ли токен для " + request.getRequestURI() + " " +  jwtService.validateToken(token));

        if (token != null && jwtService.validateToken(token)) {
            String username = jwtService.extractUsername(token);
            System.out.println(username);
            UsernamePasswordAuthenticationToken auth =
                    new UsernamePasswordAuthenticationToken(username, null,
                            Collections.singletonList(new SimpleGrantedAuthority("USER")));
            SecurityContextHolder.getContext().setAuthentication(auth);
            System.out.println(auth);
        }

        chain.doFilter(request, response);
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            System.out.println("GetTokenFromRequest " + bearerToken.substring(7));
            return bearerToken.substring(7);
        }
        return null;
    }

    private String getTokenFromCookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("jwtToken")){
                return cookie.getValue();
            }
        }
        return null;
    }
}