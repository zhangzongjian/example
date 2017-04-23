<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" 
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${model.packageName}.mapper.${model.className}Mapper" >

  <select id="selectByPrimaryKey" resultType="${model.packageName}.model.${model.className}" >
    select ${model.fieldColumn}  from ${model.className?uncap_first} where  ${model.primaryParam}
  </select>
  
  <select id="searchByAttributes" resultType="${model.packageName}.model.${model.className}" statementType="STATEMENT">
    select ${model.fieldColumn} from ${model.className?uncap_first} where
    <foreach item="attribute" collection="list" separator="and">
    	 ${r'${attribute.name}'} = ${r'${attribute.value}'}
    </foreach> 
  </select>
  
  <select id="searchByKeywords" resultType="${model.packageName}.model.${model.className}" statementType="STATEMENT">
    select ${model.fieldColumn} from ${model.className?uncap_first} where
    <foreach item="keyword" collection="list" separator="or">
    <#list model.fieldColumn?split(",") as column>
    	<#if column_index == 0> 
  		   ${column} like '%${r'${keyword}'}%' 
		</#if>
		<#if column_index != 0> 
  		or ${column} like '%${r'${keyword}'}%' 
		</#if>
	</#list>
    </foreach> 
  </select>
  
  <select id="search" resultType="${model.packageName}.model.${model.className}">
    select ${model.fieldColumn}  from ${model.className?uncap_first} limit ${r'#{offset}'},${r'#{limit}'}	
  </select>
  
  <insert id="insert" parameterType="${model.packageName}.model.${model.className}" useGeneratedKeys="true" >
    insert into ${model.className?uncap_first} (${model.insertColumn}) values (${model.insertParam})
  </insert>
  
  <delete id="deleteByPrimaryKey">
    delete from ${model.className?uncap_first} where  ${model.primaryParam}
  </delete>
  
  <select id="getTotal" resultType="long">
  	select count(`id`) from ${model.className?uncap_first};
  </select>
  
  <update id="updateByPrimaryKey" parameterType="${model.packageName}.model.${model.className}" >
    update ${model.className?uncap_first} set ${model.updateParam} where  ${model.primaryParam}
  </update>
  
</mapper>