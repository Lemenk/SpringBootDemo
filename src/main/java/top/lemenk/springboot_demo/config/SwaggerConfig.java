package top.lemenk.springboot_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @BelongsProject: springboot_demo
 * @BelongsPackage: top.lemenk.springboot_demo.config
 * @Author: Lemenk
 * @Blog: www.lemenk.top
 * @Date: Created in 2020/3/2 20:15
 * @Description: swagger配置类
 */

@Configuration  //声明配置类
@EnableSwagger2 //开启Swagger2
public class SwaggerConfig {

    //配置Swagger的Docket的bean实例
    @Bean
    public Docket docket(){

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("Lemenk")
                .select()
                .apis(RequestHandlerSelectors.basePackage("top.lemenk.springboot_demo.controller"))
                .build();
    }

    //配置Swagger信息：apiInfo
    private ApiInfo apiInfo(){

        //作者信息
        Contact contact = new Contact("Lemenk", "https://www.lemenk.top", "Lemenk@163.com");

        return new ApiInfo(
                "Lemenk的SwaggerAPI文档",
                "用于对学生表进行CURD操作",
                "v1.0",
                "https://www.lemenk.top",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>()
        );
    }
}
