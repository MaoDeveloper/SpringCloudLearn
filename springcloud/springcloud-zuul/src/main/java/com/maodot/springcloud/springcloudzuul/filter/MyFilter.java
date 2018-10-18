package com.maodot.springcloud.springcloudzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  服务过滤:
 *  zuul不仅只是路由，并且还能过滤，做一些安全验证。继续改造工程
 *
 * @author MAODOT
 */
@Component
public class MyFilter extends ZuulFilter {

    private static final Logger log = LoggerFactory.getLogger(MyFilter.class);

    private RequestContext currentContext;

    /*
    filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
        pre：路由之前
        routing：路由之时
        post： 路由之后
        error：发送错误调用
    filterOrder：过滤的顺序
    shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
    run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
    */

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        log.info(String.format("%s >>> %s" , request.getMethod() , request.getRequestURI()));
        String token = request.getParameter("token");
        if (token == null || token.isEmpty()){
            log.info("token is empty !");
            String errorString = "token is empty !";
            responseUnauthrizedInfo(errorString);
        }else{
            if (token.equals("123")){
                log.info("token ok !");
            }else {
                log.info("token expired or invalid !");
                responseUnauthrizedInfo("token expired or invalid");
            }
        }
        return null;
    }

    private void responseUnauthrizedInfo(String errorString) {
        currentContext.setSendZuulResponse(false);
        currentContext.setResponseStatusCode(HttpServletResponse.SC_UNAUTHORIZED);
        HttpServletResponse response = currentContext.getResponse();
        try {
            response.getWriter().write(errorString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
