package edu.akdeniz.softeng.surveyrest.util.helper;

import com.maemresen.jutils.collections.NotNullList;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author maemresen
 * <p>
 * Helper class to handle Spring Security stuff
 */
public class SecurityHelper {


    /* Authentication */
    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * @return principals of the user
     */
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

    /**
     * @return user name info of the authenticated user
     */
    public static String getUserName() {
        UserDetails userDetails = getPrincipal();
        if (userDetails == null) {
            return "";
        }
        return userDetails.getUsername();
    }

    /**
     * @return is user authenticated or not
     */
    public static boolean isAuthenticated() {
        Authentication authentication = getAuthentication();
        if (authentication == null) {
            return false;
        }
        return !(authentication instanceof AnonymousAuthenticationToken) && authentication.isAuthenticated();
    }

    /* Authorization */

    /**
     * Check if user has any of authorities given as parameter
     *
     * @param auths authorities will be check
     * @return user has any of them or not
     */
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

    /**
     * @return authorities of the user
     */
    public static Collection<? extends GrantedAuthority> getAuthorities() {
        UserDetails userDetails = getPrincipal();
        if (userDetails == null) {
            return new NotNullList<>();
        }
        return userDetails.getAuthorities();
    }

    /**
     * Generates UID for authenticated user
     *
     * @return generated uid of authenticated user
     */
    public static String generateUID() {
        if (!isAuthenticated()) {
            return "-1";
        }
        // TODO : generate UID from authenticated user
        return getUserName();
    }
}
