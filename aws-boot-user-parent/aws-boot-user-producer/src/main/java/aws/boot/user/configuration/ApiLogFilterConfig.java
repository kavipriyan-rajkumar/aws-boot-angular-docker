package aws.boot.user.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/** log incoming API request and response and push it to centralized 
 * logging system such as Splunk or ELK for debugging. 
 * Also all the logs related to one request 
 * should have some common id to relate them **/

@Component
@ConditionalOnExpression("${app.api.logging.enable:true}")
public class ApiLogFilterConfig {
	@Value("${app.api.logging.url-patterns:*}")
	private String[] urlPatterns;

	@Value("${app.api.logging.requestIdParamName:requestId}")
	private String requestIdParamName;
	
	@Value("${api.logging.requestIdMDCParamName:REQUEST_ID}")
	private String requestIdMDCParamName;
	
	@Bean
	public FilterRegistrationBean<ApiLoggingFilter> loggingFilter() {
	   FilterRegistrationBean<ApiLoggingFilter> registrationBean = new FilterRegistrationBean<ApiLoggingFilter>();
	   registrationBean.setFilter(new ApiLoggingFilter(requestIdParamName,requestIdMDCParamName));
	   registrationBean.addUrlPatterns(urlPatterns);
	   return registrationBean;
	}


}
