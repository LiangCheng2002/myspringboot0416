package com.work.lc.config;



import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import springfox.documentation.builders.*;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class SwaggerConfig {

    /**
     * 构建 API 文档时配置 Docket 的方法 openApi()
     * @return swagger config
     */
    @Bean
    public Docket openApi() {
        return new Docket( DocumentationType.OAS_30)
                .groupName("Test group")
                .apiInfo(apiInfo())
                .select()
                .apis( RequestHandlerSelectors.withMethodAnnotation( ApiOperation.class))
                .paths( PathSelectors.any())
                .build()
                .globalResponses(HttpMethod.GET,responseMessages.stream().map(responseMessage ->
                        new ResponseBuilder().code(String.valueOf(responseMessage.getCode()))
                                .description(responseMessage.getMessage())
                                .build()).collect(Collectors.toList()));
    }
    List<ResponseMessage> responseMessages = Arrays.asList(
            new ResponseMessageBuilder()
                    .code(200)
                    .message("Success")
                    .responseModel(new ModelRef("ResponseResult"))
                    .build(),
            new ResponseMessageBuilder()
                    .code(401)
                    .message("Unauthorized????????????")
                    .responseModel(new ModelRef("ResponseResult"))
                    .build(),
            new ResponseMessageBuilder()
                    .code(403)
                    .message("Forbidden")
                    .responseModel(new ModelRef("ResponseResult"))
                    .build(),
            new ResponseMessageBuilder()
                    .code(404)
                    .message("NOT FOUND")
                    .responseModel(new ModelRef("ResponseResult"))
                    .build()
    );



    /**
     * 设置文档的信息
     * @return api info
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger API")
                .description("test api")
                .contact(new Contact("飞畅","https://www.futuretel.com.cn","1843106176@qq.com"))
                .termsOfServiceUrl("http://xxxxxx.com/")
                .version("1.0")
                .build();
    }
}