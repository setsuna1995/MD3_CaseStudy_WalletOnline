package codegym.c0623k1.md3_casestudy_walletonline.util;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {
    static SessionUtil sessionUtil;

    public SessionUtil() {
    }

    public static SessionUtil getInstance() {
        if (sessionUtil == null) {
            sessionUtil = new SessionUtil();
        }
        return sessionUtil;
    }

    public void putValue(HttpServletRequest request, String key, Object value) {
        request.getSession().setAttribute(key, value);
    }

    public Object getValue(HttpServletRequest request, String key) {
        return request.getSession().getAttribute(key);
    }

    public void removeValue(HttpServletRequest request, String key) {
        request.getSession().removeAttribute(key);
    }
}
