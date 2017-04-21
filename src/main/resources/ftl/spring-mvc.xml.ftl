<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans" 
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xmlns:mvc="http://www.springframework.org/schema/mvc"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans 
        http://www.springframework.org/schema/beans/spring-beans-4.0.xsd
        http://www.springframework.org/schema/context 
        http://www.springframework.org/schema/context/spring-context-4.0.xsd
        http://www.springframework.org/schema/mvc
        http://www.springframework.org/schema/mvc/spring-mvc-4.0.xsd">

	<!-- Scans the classpath of this application for @Components to deploy as beans -->
    <context:component-scan base-package="${model.packageName}.controller"/>
    
	<mvc:annotation-driven/>

	<!-- Resolves view names to protected .jsp resources within the /WEB-INF/pages directory -->   
    <bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    	<property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
    	<property name="prefix" value="/" />
    	<property name="suffix" value=".jsp" />
	</bean>
	
	<!-- Handles HTTP GET requests for /resources/** by efficiently serving up static resources in the ${webappRoot}/resources/ directory -->
	<mvc:resources mapping="/plug-in/**" location="/plug-in/"/>
</beans>