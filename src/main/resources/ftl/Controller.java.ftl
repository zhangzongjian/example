package ${model.packageName}.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ${model.packageName}.model.${model.className};
import ${model.packageName}.service.${model.className}Service;
import ${model.packageName}.util.Pager;

@Controller
@RequestMapping("${model.className?uncap_first}")
public class ${model.className}Controller {
	
	@Autowired
	private ${model.className}Service ${model.className?uncap_first}Service;
	
	@RequestMapping("index")
	public String index(HttpServletRequest request, Pager pager){
		pager = ${model.className?uncap_first}Service.search(pager);
		return "";
	}
	
	@RequestMapping("add")
	public String add(HttpServletRequest request, ${model.className} ${model.className?uncap_first}){
		${model.className?uncap_first}Service.insert(${model.className?uncap_first});
		return "";
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, ${model.className} ${model.className?uncap_first}){
		${model.className?uncap_first}Service.delete(${model.primaryMethIn});
		return "";
	}
	
	@RequestMapping("intoUpdate")
	public String intoUpdate(HttpServletRequest request, ${model.className} ${model.className?uncap_first}){
		${model.className?uncap_first} = ${model.className?uncap_first}Service.searchById(${model.primaryMethIn});
		return "";
	}
	
	@RequestMapping("update")
	public String update(HttpServletRequest request, ${model.className} ${model.className?uncap_first}){
		${model.className?uncap_first}Service.update(${model.className?uncap_first});
		return "";
	}
}
