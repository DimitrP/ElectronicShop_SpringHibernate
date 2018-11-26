package com.pershyn.electronicshop.config;

import com.pershyn.electronicshop.formatter.CategoryFormatter;
import com.pershyn.electronicshop.formatter.RoleFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class MVCConfig extends WebMvcConfigurerAdapter {

    @Autowired
    RoleFormatter roleFormatter;
    @Autowired
    CategoryFormatter categoryFormatter;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!registry.hasMappingForPattern("/webjars/bootstrap/**")) {
            registry.addResourceHandler("/webjars/bootstrap/**")
                    .addResourceLocations("classpath:/META-INF/resources/webjars/bootstrap/4.0.0/");
        }
        if (!registry.hasMappingForPattern("/webjars/tether/**")) {
            registry.addResourceHandler("/webjars/tether/**")
                    .addResourceLocations("classpath:/META-INF/resources/webjars/tether/1.4.0/dist/");
        }
        if (!registry.hasMappingForPattern("/webjars/jquery/**")) {
            registry.addResourceHandler("/webjars/jquery/**")
                    .addResourceLocations("classpath:/META-INF/resources/webjars/jquery/3.2.1/");
        }
        if (!registry.hasMappingForPattern("/resources/**")) {
            registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        }
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(roleFormatter);
        registry.addFormatter(categoryFormatter);
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource rb = new ResourceBundleMessageSource();
        rb.setBasenames(new String[]{"validation/messages"});
        return rb;
    }

    @Controller
    static class FaviconController {
        @RequestMapping("favicon.ico")
        String favicon() {
            return "forward:/resources/favicon.ico";
        }
    }
}
