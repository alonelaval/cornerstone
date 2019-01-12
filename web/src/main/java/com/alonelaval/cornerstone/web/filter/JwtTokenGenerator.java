package com.alonelaval.cornerstone.web.filter;

import com.alonelaval.cornerstone.web.config.ApplicationConfig;
import com.alonelaval.cornerstone.entity.base.UserAdapter;
import com.alonelaval.cornerstone.web.config.ApplicationConfig;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.time.Instant;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * @author huawei
 * @create 2018-07-15
 **/
@Slf4j
public class JwtTokenGenerator {
    public String generate(Authentication auth, ApplicationConfig config){
            UserAdapter userAdapter = (UserAdapter) auth.getPrincipal();
            Instant now = Instant.now();
            return   Jwts.builder()
                    .setSubject(auth.getName())
                    .claim("authorities", auth.getAuthorities().stream()
                            .map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                    .setIssuedAt(Date.from(now))
                    .setExpiration(Date.from(now.plusSeconds(config.getExpiration())))
                    .signWith(SignatureAlgorithm.HS256, config.getJwtSecret().getBytes())
                    .compact();
        }
    }

