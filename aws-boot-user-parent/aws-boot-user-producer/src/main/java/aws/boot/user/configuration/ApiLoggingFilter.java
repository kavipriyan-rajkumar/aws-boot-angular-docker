package aws.boot.user.configuration;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import aws.boot.user.logger.BufferedRequestWrapper;
import aws.boot.user.logger.BufferedResponseWrapper;

/**  Servlet Filter. This filter intercepts all api request and response and log them **/
public class ApiLoggingFilter implements Filter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ApiLoggingFilter.class);
	
	private String requestIdParamName;
	private String requestIdMDCParamName;
	
	public ApiLoggingFilter(String requestIdParamName, String requestIdMDCParamName) {
		this.requestIdParamName = requestIdParamName;
		this.requestIdMDCParamName=requestIdMDCParamName;
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		
		BufferedRequestWrapper bufferedRequest = new BufferedRequestWrapper(httpServletRequest);
		BufferedResponseWrapper bufferedResponse = new BufferedResponseWrapper(httpServletResponse);
		/** Log input request **/
		MDC.put(requestIdMDCParamName, getRequestId(httpServletRequest));
		LOGGER.info(getLogRequest(httpServletRequest,bufferedRequest));
		try {
			chain.doFilter(bufferedRequest, bufferedResponse);
		} finally {
			final StringBuilder logResponse = new StringBuilder("HTTP RESPONSE ").append(bufferedResponse.getContent());
			/** Log output response **/
			LOGGER.info(logResponse.toString());
			MDC.clear();
		}
		
	}
	@Override
	public void destroy() {
		
	}
	
	private Map<String, String> getTypesafeRequestMap(HttpServletRequest request) {
		Map<String, String> typesafeRequestMap = new HashMap<String, String>();
		Enumeration<?> requestParamNames = request.getParameterNames();
		while (requestParamNames.hasMoreElements()) {
			String requestParamName = (String) requestParamNames.nextElement();
			String requestParamValue;
			if (requestParamName.equalsIgnoreCase("password")) {
				requestParamValue = "********";
			}else {
				requestParamValue = request.getParameter(requestParamName);
			}
			typesafeRequestMap.put(requestParamName, requestParamValue);
		}
		return typesafeRequestMap;
	}
	
	private String getRequestId(HttpServletRequest httpServletRequest) {
		Map<String, String> requestMap = getTypesafeRequestMap(httpServletRequest);
		String requestId = requestMap.containsKey(requestIdParamName) ? requestMap.get(requestIdParamName) 
				: UUID.randomUUID().toString(); 

		return requestId;
	}
	private String getLogRequest(HttpServletRequest httpServletRequest,BufferedRequestWrapper bufferedRequest) throws IOException {
		final StringBuilder logRequest = new StringBuilder("HTTP ");
		logRequest.append(httpServletRequest.getMethod());
		logRequest.append(" \"");
		logRequest.append(httpServletRequest.getServletPath());
		logRequest.append("\" ");
		logRequest.append(", parameters=");
		logRequest.append(this.getTypesafeRequestMap(httpServletRequest));
		logRequest.append(", body=");
		logRequest.append(bufferedRequest.getRequestBody());
		logRequest.append(", remote_address=");
		logRequest.append(httpServletRequest.getRemoteAddr());
		return logRequest.toString();
	}
	
}
