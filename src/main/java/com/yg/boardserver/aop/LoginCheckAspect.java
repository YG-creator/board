package com.yg.boardserver.aop;

import com.yg.boardserver.utils.SessionUtil;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;



@Component
@Aspect
@Order()
@Log4j2
public class LoginCheckAspect {
    @Around("@annotation(com.fastcampus.boardserver.aop.LoginCheck) && @ annotation(loginCheck)")
    public Object adminLoginCheck(ProceedingJoinPoint proceedingJoinPoint, LoginCheck loginCheck) throws Throwable {
        HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest().getSession();
        String id = null;
        int idIndex = 0;


        String userType = loginCheck.type().toString();
        switch (userType) {
            case "ADMIN" -> id = SessionUtil.getLoginAdminId(session);
            case "USER" -> id = SessionUtil.getLoginMemberId(session);
        }
        if (id == null) {
            log.debug(proceedingJoinPoint.toString()+ "accountName :" + null);
            throw new HttpStatusCodeException(HttpStatus.UNAUTHORIZED, "로그인한 id값을 확인해주세요.") {};
        }

        Object[] modifiedArgs = proceedingJoinPoint.getArgs();

        if(proceedingJoinPoint.getArgs()!=null)
            modifiedArgs[idIndex] = id;

        return proceedingJoinPoint.proceed(modifiedArgs);
    }

}