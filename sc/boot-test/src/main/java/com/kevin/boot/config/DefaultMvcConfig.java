package com.kevin.boot.config;

import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafView;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

/**
 * 默认Spring Mvc配置，留作参考.
 * Created by Administrator on 2016/12/25 0025.
 */
//@Configuration
public class DefaultMvcConfig {

    /**
     * 定义SpringMVC视图解析器配置
     * 当前配置为前缀后缀规则
     * 当前配置适用JSP文件，如果需要返回HTML页面，需要修改WEB配置
     * <servlet-mapping>
            <servlet-name>jsp</servlet-name>
            <url-pattern>*.html</url-pattern>
       </servlet-mapping>
        viewResolver.setSuffix(".html");
     * @return
     */
    //@Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/web/views");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    /**
     * 普通SpringMVC结合Thymleaf模板配置，
     * 需定义三个配置Bean：TemplateResolver，SpringTemplateEngine，ThymeleafViewResolver
     * @return
     */
    //@Bean
    public TemplateResolver templateResolver() {
        TemplateResolver templateResolver = new ServletContextTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/web/static/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        return templateResolver;
    }
    //@Bean
    public SpringTemplateEngine springTemplateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }
    //@Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
        thymeleafViewResolver.setTemplateEngine(springTemplateEngine());
        thymeleafViewResolver.setViewClass(ThymeleafView.class);
        return thymeleafViewResolver;
    }


}