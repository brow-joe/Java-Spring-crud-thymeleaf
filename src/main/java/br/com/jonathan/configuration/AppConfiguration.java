package br.com.jonathan.configuration;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.web.filter.GenericFilterBean;

@Configuration
public class AppConfiguration {

	@Bean
	public GenericFilterBean filterRequest() {
		return new GenericFilterBean() {
			@Override
			public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
					throws IOException, ServletException {
				if (StringUtils.equals(UrlUtils.buildRequestUrl((HttpServletRequest) request), "/")) {
					((HttpServletResponse) response).sendRedirect("/product/");
					return;
				} else {
					chain.doFilter(request, response);
					return;
				}
			}
		};
	}

}
