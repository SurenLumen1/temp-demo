package com.lumen.dssh.orchestrator.common;

import com.lumen.dssh.orchestrator.component.SecurityContextComponent;
import com.lumen.dssh.orchestrator.model.UnAuthFlowsValidationResponse;
import com.lumen.dssh.orchestrator.util.ValidationHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class DhApiInterceptorHandler implements HandlerInterceptor {

    @Autowired
    SecurityContextComponent securityContextComponent;

    @Autowired
    ValidationHelper validationHelper;

    private Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {

        logger.info("DhApiInterceptorHandler preHandle entry");

        if(request.getServletPath().contains("/getRateIncreaseData") || request.getServletPath().contains("dho/nba")) {
            Boolean userAuth = false;
            String remoteUser = request.getHeader(CommonStrings.CT_REMOTE_USER);
            if(remoteUser!=null){
                userAuth=true;
                return userAuth;
            }
            else{
                logger.info("DhApiInterceptorHandler preHandle Unauthorized User" );
                response.getWriter().write(CommonStrings.REMOTE_USER_NOT_POPULATED);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.setStatus(401);
                return false;
            }
        }
        return true;
    }


    public SecurityContextComponent getSecurityContextComponent() {
        return securityContextComponent;
    }

    public void setSecurityContextComponent(SecurityContextComponent securityContextComponent) {
        this.securityContextComponent = securityContextComponent;
    }
}
