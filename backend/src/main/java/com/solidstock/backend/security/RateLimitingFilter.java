package com.solidstock.backend.security;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Buckets;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

@Component
public class RateLimitingFilter extends OncePerRequestFilter {

    private static final int MAX_REQUESTS = 100;  // Max requests allowed
    private static final int TIME_WINDOW = 60;  // Time window in seconds

    private final Bucket bucket;

    public RateLimitingFilter() {
        // Initialize the bucket for rate limiting (5 requests per 60 seconds)
        this.bucket = Bucket4j.builder()
                .addLimit(Buckets.simple(MAX_REQUESTS, TIME_WINDOW))
                .build();
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // If the bucket allows the request, continue, otherwise return a 429 (Too Many Requests)
        if (bucket.tryConsume(1)) {
            filterChain.doFilter(request, response);
        } else {
            response.setStatus(HttpServletResponse.SC_TOO_MANY_REQUESTS);  // 429
            response.getWriter().write("Rate limit exceeded. Please try again later.");
        }
    }
}

