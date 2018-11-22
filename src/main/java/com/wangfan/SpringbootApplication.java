package com.wangfan;

import com.wangfan.spring.springboot.config.JsonObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;


@SpringBootApplication
@ComponentScan("com.wangfan.spring.springboot")
public class SpringbootApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(SpringbootApplication.class, args);
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJacksonHttpMessageConverter() {
        final MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        JsonObjectMapper mapper = new JsonObjectMapper();
        converter.setObjectMapper(mapper);
        return converter;
    }
}
