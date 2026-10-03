package com.foundation.springsecurity.wecom;

import com.foundation.springcontext.bean.BeanContext;
import com.foundation.springsecurity.secure.process.SecureLoginSuccessHandler;
import com.foundation.springsecurity.secure.process.SecureLogoutSuccessHandler;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.Assert;

/**
 * Processes an authentication form submission. Called
 * {@code AuthenticationProcessingFilter} prior to Spring Security 3.0.
 * <p>
 * Login forms must present two parameters to this filter: a username and password. The
 * default parameter names to use are contained in the static fields
 * setting the {@code usernameParameter} and {@code passwordParameter} properties.
 * <p>
 * This filter by default responds to the URL {@code /login}.
 *
 * @author Ben Alex
 * @author Colin Sampaleanu
 * @author Luke Taylor
 * @since 3.0
 */
public class WecomCodeFilter extends AbstractAuthenticationProcessingFilter {

    private static final AntPathRequestMatcher DEFAULT_ANT_PATH_REQUEST_MATCHER = new AntPathRequestMatcher("/api/wecomLogin");
    public WecomCodeFilter() {
        super(DEFAULT_ANT_PATH_REQUEST_MATCHER);
        super.setAuthenticationSuccessHandler(new SecureLoginSuccessHandler());
    }

    public WecomCodeFilter(AuthenticationManager authenticationManager) {
        super(DEFAULT_ANT_PATH_REQUEST_MATCHER, authenticationManager);
    }
    private boolean postOnly = true;
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
//        if (this.postOnly && !request.getMethod().equals("POST")) {
//            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
//        }
        String code = request.getParameter("code");
        WecomAuth wecomAuth = new WecomAuth();
//        String username = wecomAuth.getUserId(WecomConstant.CORP_ID, WecomConstant.AGENT_SECRET, code);
        String username = "superAdmin";

//        String username = "root";
        UserDetailsService userDetailsService = BeanContext.getBean(UserDetailsService.class);
        //userDetails is secureUser
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, username, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        return usernamePasswordAuthenticationToken;
    }
}
