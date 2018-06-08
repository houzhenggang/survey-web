package edu.akdeniz.softeng.surveyrest.util;

import com.maemresen.jutils.collections.NotNullList;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class SecurityHelper {


    /* Authentication */
    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static UserDetails getPrincipal() {
        Authentication authentication = getAuthentication();
        if (authentication == null) {
            return null;
        }
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal);
        }
        return null;
    }

    public static String getUserName() {
        UserDetails userDetails = getPrincipal();
        if (userDetails == null) {
            return "";
        }
        return userDetails.getUsername();
    }

    public static boolean isAuthenticated() {
        Authentication authentication = getAuthentication();
        if (authentication == null) {
            return false;
        }
        return !(authentication instanceof AnonymousAuthenticationToken) && authentication.isAuthenticated();
    }

    /* Authorization */
    public static boolean hasAuthority(String... auths) {
        Collection<? extends GrantedAuthority> authorities = getAuthorities();
        for (GrantedAuthority authority : authorities) {
            for (String auth : auths) {
                if (authority.getAuthority().equalsIgnoreCase(auth)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Collection<? extends GrantedAuthority> getAuthorities() {
        UserDetails userDetails = getPrincipal();
        if (userDetails == null) {
            return new NotNullList<>();
        }
        return userDetails.getAuthorities();
    }

}
