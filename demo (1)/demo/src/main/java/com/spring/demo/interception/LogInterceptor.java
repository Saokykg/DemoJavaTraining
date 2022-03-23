package com.spring.demo.interception;

import io.jsonwebtoken.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.function.Function;

public class LogInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        long startTime = System.currentTimeMillis();
        System.out.println("\n-------- LogInterception.preHandle --- ");
        System.out.println("Request URL: " + request.getRequestURL());
        if (request.getRequestURL().toString().contains("login"))
            return true;
        String requestToken = request.getHeader("authorization");
        try {
            System.out.println(Jwts.parser().setSigningKey("123456").parseClaimsJws(requestToken).getBody().toString());
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }response.setStatus(401);
        response.setHeader("Error","unauthorized");
        return false;
    }

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    //retrieve expiration date from jwt token
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }
    //for retrieveing any information from token we will need the secret key
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey("123456").parseClaimsJws(token).getBody();
    }
//    private boolean validateToken(String authToken) {
//        try {
//            Jwts.parser().setSigningKey(SecretToken).parseClaimsJws(authToken);
//            return true;
//        } catch (MalformedJwtException ex) {
//            log.error("Invalid JWT token");
//        } catch (ExpiredJwtException ex) {
//            log.error("Expired JWT token");
//        } catch (UnsupportedJwtException ex) {
//            log.error("Unsupported JWT token");
//        } catch (IllegalArgumentException ex) {
//            log.error("JWT claims string is empty.");
//        }
//        return false;
//    }

//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, //
//                           Object handler, ModelAndView modelAndView) throws Exception {
//
//        System.out.println("\n-------- LogInterception.postHandle --- ");
//        System.out.println("Request URL: " + request.getRequestURL());
//
//        // Ở đây, bạn có thể add các attribute vào modelAndView
//        // Và sử dụng nó trong các View (jsp,..)
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, //
//                                Object handler, Exception ex) throws Exception {
//        System.out.println("\n-------- LogInterception.afterCompletion --- ");
//
//        long startTime = (Long) request.getAttribute("startTime");
//        long endTime = System.currentTimeMillis();
//        System.out.println("Request URL: " + request.getRequestURL());
//        System.out.println("End Time: " + endTime);
//
//        System.out.println("Time Taken: " + (endTime - startTime));
//    }

}