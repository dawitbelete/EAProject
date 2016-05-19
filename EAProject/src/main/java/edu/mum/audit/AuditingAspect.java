package edu.mum.audit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditingAspect {

	private static final Logger logger = LogManager.getLogger(AuditingAspect.class);
	
	@Pointcut("within(edu.mum.service..*)")
	public void applicationMethod() {}
	
	@Before("applicationMethod()")
	public void audit(JoinPoint joinPoint) {
		String info = "User "+getPrincipal() + " executed " +
				joinPoint.getSignature().getDeclaringTypeName() + "." +
				joinPoint.getSignature().getName();
		logger.info(info);
	}
	
	private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}