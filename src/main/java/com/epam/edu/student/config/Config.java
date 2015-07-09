package com.epam.edu.student.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ImportResource({ "classpath*:/META-INF/spring/batch/servlet/resources/*.xml",
		"classpath*:/META-INF/spring/batch/servlet/manager/*.xml",
		"classpath*:/META-INF/spring/batch/servlet/override/*.xml",
		"classpath*:/META-INF/spring/batch/bootstrap/**/*.xml",
		"classpath*:/META-INF/spring/batch/override/**/*.xml"
// , "classpath:base-menu-config.xml"
})
@EnableAutoConfiguration(exclude = { BatchAutoConfiguration.class, DataSourceAutoConfiguration.class,
		WebMvcAutoConfiguration.class })
public class Config extends WebMvcConfigurerAdapter {

	
@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations(
				"classpath:/META-INF/");
	}

	/*@Bean
	public RequestMappingHandlerMapping requestMappingHandlerMapping() {
	RequestMappingHandlerMapping handlerMapping = new RequestMappingHandlerMapping();
		handlerMapping.setUseSuffixPatternMatch(false);
		handlerMapping.setUseTrailingSlashMatch(false);
		return handlerMapping;

	}*/

	/*
	 * @Bean public SimpleControllerHandlerAdapter
	 * simpleControllerHandlerAdapter() { return new
	 * SimpleControllerHandlerAdapter(); }
	 * 
	 * @Bean public BeanNameUrlHandlerMapping beanNameUrlHandlerMapping() {
	 * return new BeanNameUrlHandlerMapping(); }
	 * 
	 * @Bean public BeanNameViewResolver beanNameViewResolver() { return new
	 * BeanNameViewResolver(); }
	 * 
	 * @Bean(name = "defaultResources") public PropertiesFactoryBean
	 * defaultResources() { return new PropertiesFactoryBean(); }
	 */

	// @Bean
	// public UrlBasedViewResolver setupViewResolver() {
	// UrlBasedViewResolver resolver = new UrlBasedViewResolver();
	// resolver.setPrefix("/WEB-INF/views/");
	// resolver.setSuffix(".jsp");
	// resolver.setViewClass(JstlView.class);
	// return resolver;
	// }
	//
	// @Override
	// public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	// registry.addResourceHandler("resources/**")
	// .addResourceLocations("/resources/")
	// .addResourceLocations("/resources");
	// }

}
