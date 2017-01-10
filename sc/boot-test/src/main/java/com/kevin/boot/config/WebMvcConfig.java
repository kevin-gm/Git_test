package com.kevin.boot.config;

import com.kevin.boot.config.custom.CustomInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * SpringMVC 自定义配置
 * Created by Administrator on 2016/12/23 0023.
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 快捷的ViewControllers配置，此配置意味着请求"/test/test"将会通过视图解析器，跳转到“fisrt”页面
     * 可以将减少页面跳转的代码，并且集中管理
     * 此处重写的addViewControllers方法不会覆盖WebMvcAutoConfiguration中的addViewControllers
     * 意味着自己配置的跟spring boot配置的同时生效
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/test/test1").setViewName("/first");
        registry.addViewController("/ws/view").setViewName("/ws");
        registry.addViewController("/ws/chat").setViewName("/chat");
    }



    /**
     * 重写默认的资源文件处理器
     * addResourceLocations ： 指定文件存放目录
     * addResourceHandler   ： 指定对外暴露的访问路径
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/web/static/**").addResourceLocations("classpath:/web/static/");
     }

    /**
     * 配置拦截器的Bean为自定义的拦截器
     * @return
     */
    @Bean
    public CustomInterceptor customInterceptor() {
        return new CustomInterceptor();
    }

    /**
     * 重写addInterceptors方法，注册拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(customInterceptor());
    }

    /**
     * 路径匹配参数配置，比如“/xx.yy”，默认只能解析到xx
     * @param configurer
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
    }

    /**
     * 文件上传相关配置，
     * 注：此配置需要依赖于commons-fileupload包
     * @return
     */
    /*@Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(100000);
        return multipartResolver;
    }*/

    /**
     * 可以通过继承abstractMessageConverter来实现自定义的转换器
     * @param converters
     */
    /*@Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
    }*/
}