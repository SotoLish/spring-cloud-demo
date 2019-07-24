package com.hand.demo.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.UUID;


/**
 * 授权过滤器
 *
 * @author liuqixin
 * @date 2019/7/24 11:08
 */
@Component
public class AuthorizeFilter extends ZuulFilter {

    /**
     * 日志对象
     */
    private static final Logger logger = LoggerFactory.getLogger(AuthorizeFilter.class);

    /**
     * 权限认证
     */
    private static String accessToken;

    public AuthorizeFilter() {
        accessToken = UUID.randomUUID().toString();
        logger.info("Access Token ：{} ", accessToken);
    }

    /**
     * 外部请求 -> zuul -(pre)> 选择路由的服务 -(routing)-> 请求服务 -(post)-> zuul
     * pre: 在选择路由之前执行
     * routing:在请求路由之后执行
     * post:在请求路由到服务之后执行
     * error: 在其他阶段发生错误执行
     *
     * @return 过滤器的类型
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * @return 过滤器执行的顺序
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否执行过滤器
     * true会执行 run() 方法
     *
     * @return 是否需要执行过滤器的布尔值
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤逻辑
     *
     * @return 返回值一般是会被忽略的
     * @throws ZuulException
     */
    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String accessToken = request.getParameter("access_token");
        // 模拟授权验证
        if (Objects.equals(accessToken, AuthorizeFilter.accessToken)) {
            requestContext.setResponseStatusCode(HttpStatus.OK.value());
            requestContext.setResponseBody("Authorized.");
            requestContext.setSendZuulResponse(false);
        } else {
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            requestContext.setResponseBody(HttpStatus.UNAUTHORIZED.getReasonPhrase());
            // 验证过后，过滤器会继续路由，路由后的过滤器会覆盖上面的设置，因此设置停止向Zuul继续转发
            requestContext.setSendZuulResponse(false);
        }
        return null;
    }
}
