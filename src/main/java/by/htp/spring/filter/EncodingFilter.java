package by.htp.spring.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(urlPatterns = {"/login","/admin/getQuestions","/registration"},dispatcherTypes = {DispatcherType.FORWARD,DispatcherType.REQUEST,DispatcherType.ERROR},
        initParams = {@WebInitParam(name = "encoding", value = "UTF-8",
                description = "Encoding Param")})

public class EncodingFilter implements Filter {

    String code;

    @Override
    public void init(FilterConfig filterConfig) {

        code = filterConfig.getInitParameter("encoding");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        String codeRequest = servletRequest.getCharacterEncoding();

        if (code != null && !code.equalsIgnoreCase(codeRequest)) {
            servletRequest.setCharacterEncoding(code);
            servletResponse.setCharacterEncoding(code);
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        code = null;
    }
}
