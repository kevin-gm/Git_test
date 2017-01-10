package com.kevin.boot.config;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;

/**
 * 容器配置
 * 如果要替换tomcat容器，只需引入其他容器的相关依赖，然后去掉starter-web中的默认tomcat依赖
 * Created by Administrator on 2016/12/27 0027.
 */
//@Configuration
public class ServletContainerConfig {

    /**
     * Tomcat容器特定配置，
     * tomcat通用配置的代码实现，可以通过实现EmbeddedServletContainerCutomizer，重写customimze实现。
     * @return
     */
    //@Bean
    public EmbeddedServletContainerFactory embeddedServletContainerFactory() {
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint securityConstraint = new SecurityConstraint();
                securityConstraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection securityCollection = new SecurityCollection();
                securityCollection.addPattern("/*");
                securityConstraint.addCollection(securityCollection);
                context.addConstraint(securityConstraint);
            }
        };
        //tomcat.addAdditionalTomcatConnectors(httpConnector());
        return tomcat;
    }

    /**
     * 配置Http协议以及连接，将http的请求转发到8443端口，实现http转向https
     * @return
     */
    //@Bean
    public Connector httpConnector() {
        //初始化连接对象
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        //配置协议
        connector.setScheme("http");
        //请求端口
        connector.setPort(8080);
        connector.setSecure(false);
        //请求转发，8443端口为项目配置的https的安全端口，该配置在application.yml中
        connector.setRedirectPort(8443);
        return connector;
    }
}