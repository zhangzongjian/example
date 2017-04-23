<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
   String contextPath = request.getContextPath(); 
   request.setAttribute("contextPath", contextPath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${model.className} detail</title>
<link href="${r"${contextPath}"}/css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">表单</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>数据详情</span></div>
    
    <form action="${r"${contextPath}"}/${model.className?lower_case}/update">
	    <ul class="forminfo">
	    <#list model.attrs as attr>
	    <#if attr_index != 0>
	  	<li><label>${attr.attrComment}</label><input name="${attr.attrName}" type="text" class="dfinput" value="${'$'}{${model.className?lower_case}.${attr.attrName} }" readonly="readonly"/></li>
	  	</#if>
		</#list>
	    <li><label>&nbsp;</label><input name="" type="button" class="btn" value="返回" onclick="javascript:history.go(-1);"/></li>
	    </ul>
	    <input name="page" type="hidden" class="dfinput" value="${r"${pager.page }"}"/>
    </form>
    
    
    </div>
</body>
</html>
