package com.javalines.spring.soap.api.config;

import java.util.Properties;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
public class SoapWebserviceConfig {

	private static final String NAMESPACE = "http://www.javalines.com/spring/soap/api/customerService";

	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(context);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<>(servlet, "/ws/*");
	}

//	@Bean(name = "loanEligibility")
//	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema schema) {
//		DefaultWsdl11Definition defWsdlLoc = new DefaultWsdl11Definition();
//		defWsdlLoc.setPortTypeName("LoanEligibilityIndicator");
//		defWsdlLoc.setLocationUri("/ws");
//		defWsdlLoc.setTargetNamespace(NAMESPACE);
//		defWsdlLoc.setSchema(schema);
//		return defWsdlLoc;
//	}

	@Bean(name = "customers")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema schema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("CustomerPort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace(NAMESPACE);
		wsdl11Definition.setSchema(schema);
		Properties props = new Properties();
		props.put("getCustomer", NAMESPACE + "/GetCustomerRequest");
		props.put("loadCustomers", NAMESPACE + "/GetAllCustomersRequest");
		wsdl11Definition.setSoapActions(props);

		return wsdl11Definition;
	}

	@Bean
	public XsdSchema schema() {
		return new SimpleXsdSchema(new ClassPathResource("customer-service.xsd"));
	}
}
