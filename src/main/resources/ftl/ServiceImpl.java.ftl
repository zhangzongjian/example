package ${model.packageName}.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${model.packageName}.util.Attribute;
import ${model.packageName}.util.Pager;
import ${model.packageName}.model.${model.className};
import ${model.packageName}.mapper.${model.className}Mapper;
import ${model.packageName}.service.${model.className}Service;

@Service
public class ${model.className}ServiceImpl implements ${model.className}Service {

	@Resource
	private ${model.className}Mapper ${model.className?uncap_first}Mapper;
	
	public ${model.className} searchByPrimaryKey(${model.primaryDef}){
		return ${model.className?uncap_first}Mapper.selectByPrimaryKey(${model.primaryParamIn});
	}
	
	@Transactional
	public int insert(${model.className} ${model.className?uncap_first}) {
		return ${model.className?uncap_first}Mapper.insert(${model.className?uncap_first});
	}
	
	@Transactional
	public int update(${model.className} ${model.className?uncap_first}) {
		return ${model.className?uncap_first}Mapper.updateByPrimaryKey(${model.className?uncap_first});
	}
	
	@Transactional
	public int delete(${model.primaryDef}){
		return ${model.className?uncap_first}Mapper.deleteByPrimaryKey(${model.primaryParamIn});
	}
	
	public Pager search(Pager pager) {
		if(pager == null){
		  pager = new Pager();
		}
		List<${model.className}> items = ${model.className?uncap_first}Mapper.search(pager);
		long total = ${model.className?uncap_first}Mapper.getTotal();
		pager.setTotal(total);
		pager.setDatas(items);	  
		return pager;
	}

	/**
	 * 模糊查询
	 * @param attributes
	 * @return
	 */
	public List<${model.className}> searchByKeywords(List<String> keywords) {
		return ${model.className?uncap_first}Mapper.searchByKeywords(keywords);
	}

	/**
	 * 按属性查询
	 * @param attributes
	 * @return
	 */
	public List<${model.className}> searchByAttributes(List<Attribute> attributes) {
		return ${model.className?uncap_first}Mapper.searchByAttributes(attributes);
	}
}