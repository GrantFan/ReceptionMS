package com.reception.operate_log.util;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.reception.operate_log.dao.Operate_logMapper;
import com.reception.operate_log.entity.Operate_log;
import com.reception.system.model.User;

@Aspect
@Component
public class LogAopAction {

	@Autowired
    private  Operate_logMapper operate_logMapper;
	
	@Autowired    
	private HttpSession session;  

//    @Pointcut("execution(public * com.reception.guest.controller..*(..))")
	@Pointcut("@annotation(com.reception.operate_log.util.LogAnnotation)")  
    private void pointCutMethod(){}

    /**
     * 记录操作日志
     */
    @After("pointCutMethod()")  // 使用上面定义的切入点
    public void recordLog(JoinPoint joinPoint){
        Operate_log operate_log =  getLogMark(joinPoint);
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String time = dateFormat.format(new Date()); 
        User  user = (User) session.getAttribute("user");
       // String ip = getIpAddress(request);
        if(null != user){
        	operate_log.setTime(time);
	        operate_log.setCompuer_ip(user.getLastLoginComputer());
	        operate_log.setOperator(user.getUserName());
	        operate_logMapper.InsertLog(operate_log);
        }
       //插入日志
    }

    // throws ClassNotFoundException
    private Operate_log getLogMark(JoinPoint joinPoint) {
    	Operate_log log = new Operate_log();
        String methodName = joinPoint.getSignature().getName();
        String targetName = joinPoint.getTarget().getClass().getName();
        Class targetClass = null;
		try {
			targetClass = Class.forName(targetName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        Method[] methods = targetClass.getMethods();
        for (Method method : methods){
            if(method.getName().equals(methodName)){
                LogAnnotation logAnnotation = method.getAnnotation(LogAnnotation.class);
                log.setModule(logAnnotation.module());
                log.setRemark(logAnnotation.remark());
            }
        }
        return log;
    }
    
    
    /** 
     * 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址; 
     *  
     * @param request 
     * @return 
     * @throws IOException 
     */  
    public String getIpAddress(HttpServletRequest request){  
        // 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址  
  
        String ip = request.getHeader("X-Forwarded-For");  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
                ip = request.getHeader("Proxy-Client-IP");  
            }  
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
                ip = request.getHeader("WL-Proxy-Client-IP");  
            }  
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
                ip = request.getHeader("HTTP_CLIENT_IP");  
            }  
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
            }  
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
                ip = request.getRemoteAddr();  
            }  
        } else if (ip.length() > 15) {  
            String[] ips = ip.split(",");  
            for (int index = 0; index < ips.length; index++) {  
                String strIp = (String) ips[index];  
                if (!("unknown".equalsIgnoreCase(strIp))) {  
                    ip = strIp;  
                    break;  
                }  
            }  
        }  
        return ip;  
    }  
}