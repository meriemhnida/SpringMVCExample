package config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = SpringStart.class)
public class SpringStart implements WebApplicationInitializer{

	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		System.out.println("Starting....");
		// Init application context
		AnnotationConfigWebApplicationContext webCtx
		= new AnnotationConfigWebApplicationContext();
		webCtx.register(SpringStart.class);
		webCtx.setServletContext(servletContext);
		// Init dispatcher servlet
ServletRegistration.Dynamic servlet= servletContext.addServlet("Servlet", new DispatcherServlet(webCtx));
		servlet.setLoadOnStartup(1);
	
		servlet.addMapping("/app/*");

	}

}
