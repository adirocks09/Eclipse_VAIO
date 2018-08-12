package vzDatabase.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan({"vzDatabase"})
public class MainConfig {

	@Bean
	public InternalResourceViewResolver viewResolver(){
		
		InternalResourceViewResolver vr=new InternalResourceViewResolver();
//		vr.setPrefix("/WEB-INF/jsp/");
//		vr.setSuffix(".jsp");
		vr.setPrefix("/WEB-INF/html/");
		vr.setSuffix(".html");
		
		return vr;
	}

}
