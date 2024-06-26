package quest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@EnableWebMvc
@Import(AppConfig.class)
@ComponentScan("quest.controller")
public class WebConfig implements WebMvcConfigurer
{

	public void addResourceHandlers(ResourceHandlerRegistry registry ) 
	{
		//Pour ajouter des pages "statiques" il faut preciser le "nouveau" chemin à utiliser
		//Puis le chemin reel
		registry.addResourceHandler ("/assets/**").addResourceLocations("/WEB-INF/assets/");
		registry.addResourceHandler ("/style.css").addResourceLocations("/style.css");
		registry.addResourceHandler ("/output.css").addResourceLocations("/output.css");
		registry.addResourceHandler ("/index.html").addResourceLocations("/index.html");
	}


	@Bean
	public UrlBasedViewResolver viewResolver() {
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}
	
	 public void addFormatters(FormatterRegistry registry) {
	        DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
	        registrar.setUseIsoFormat(true);
	        registrar.registerFormatters(registry);
	    }
	

}
