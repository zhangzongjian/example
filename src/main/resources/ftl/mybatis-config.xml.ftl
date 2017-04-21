<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" 
"http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

	<typeAliases>
	   <!-- 在mapper文件中，可以使用类的别名进行编写，这样可以减少配置代码 -->
	   <!-- <typeAlias alias="${model.className}" type="${model.packageName}.model.${model.className}" /> -->
		<package name="${model.packageName}.model"/>
	</typeAliases>
	
	<#assign s = '${model.packageName}'>
	<mappers>
		<mapper resource="${s?replace('.', '/')}/mapper/${model.className}Mapper.xml" />
	</mappers>
	
</configuration>  