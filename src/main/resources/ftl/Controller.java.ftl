package ${model.packageName}.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		request.setAttribute("pager", pager); 
		return "webpages/${model.className?uncap_first}/index";
	}
	
	@RequestMapping("intoAdd")
	public String intoAdd(HttpServletRequest request){
		return "webpages/${model.className?uncap_first}/add";
	}
	
	@RequestMapping("add")
	public String add(HttpServletRequest request, ${model.className} ${model.className?uncap_first}){
		${model.className?uncap_first}Service.insert(${model.className?uncap_first});
		return "redirect:intoAdd";
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, String[] ${model.primaryParamIn}, Pager pager){
		for(int i = 0; i<${model.primaryParamIn}.length; i++) {
			${model.className?uncap_first}Service.delete(Integer.valueOf(${model.primaryParamIn}[i]));
		}
		return "redirect:index?page="+pager.getPage();
	}
	
	@RequestMapping("intoUpdate")
	public String intoUpdate(HttpServletRequest request, Model model, ${model.className} ${model.className?uncap_first}, Pager pager){
		${model.className?uncap_first} = ${model.className?uncap_first}Service.searchByPrimaryKey(${model.primaryMethIn});
		model.addAttribute("${model.className?uncap_first}", ${model.className?uncap_first}); 
		model.addAttribute("pager", pager);
		return "webpages/${model.className?uncap_first}/update";
	}
	
	@RequestMapping("update")
	public String update(HttpServletRequest request, ${model.className} ${model.className?uncap_first}, Pager pager){
		${model.className?uncap_first}Service.update(${model.className?uncap_first});
		return "redirect:index?page="+pager.getPage();
	}
	
	@RequestMapping("detail")
	public String detail(HttpServletRequest request, Model model, ${model.className} ${model.className?uncap_first}, Pager pager){
		${model.className?uncap_first} = ${model.className?uncap_first}Service.searchByPrimaryKey(${model.primaryMethIn});
		model.addAttribute("${model.className?uncap_first}", ${model.className?uncap_first}); 
		model.addAttribute("pager", pager);
		return "webpages/${model.className?uncap_first}/detail";
	}
}
