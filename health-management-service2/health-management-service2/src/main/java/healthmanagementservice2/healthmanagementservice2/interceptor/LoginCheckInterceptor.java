package healthmanagementservice2.healthmanagementservice2.interceptor;

import healthmanagementservice2.healthmanagementservice2.Login.SessionConst;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURL= request.getRequestURI();
        HttpSession session= request.getSession(false);
        if(session == null || session.getAttribute(SessionConst.LOGIN_MEMBER)==null){
            response.sendRedirect("/login?redirectURL="+requestURL);
            return false;
        }
        return true;
    }
}
