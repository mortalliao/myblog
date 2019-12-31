package abc.mortalliao.server.web.security;

import abc.mortalliao.server.web.security.properties.SecurityProperties;
import abc.mortalliao.server.web.validate.code.ValidateCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

/**
 * @author Jim
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private AuthenticationSuccessHandler myBlogAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler myBlogAuthenticationFailureHandler;

    @Autowired
    private ValidateCodeFilter validateCodeFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(validateCodeFilter,  AbstractPreAuthenticatedProcessingFilter.class)
                .formLogin()
//                .loginPage("/blog-signIn.html")
                .loginPage("/authentication/require")
                .loginProcessingUrl("/authentication/form")
                .successHandler(myBlogAuthenticationSuccessHandler)
                .failureHandler(myBlogAuthenticationFailureHandler)
//      http.httpBasic()
                .and()
                .authorizeRequests()
                    .antMatchers("/authentication/require",
                            "/code/*",
                            securityProperties.getBrowser().getLoginPage())
                    .permitAll()
                .anyRequest()
                    .authenticated()
                .and()
                .csrf().disable();
    }
}
