package ${model.packageName}.service;
import java.util.List;

import ${model.packageName}.util.Attribute;
import ${model.packageName}.util.Pager;
import ${model.packageName}.model.${model.className};

public interface ${model.className}Service {

	${model.className} searchByPrimaryKey(${model.primaryDef});
	
	List<${model.className}> searchByAttributes(List<Attribute> attributes);
	
	Pager search(Pager pager);
	
	int insert(${model.className} ${model.className?uncap_first});

	int update(${model.className} ${model.className?uncap_first});
	
	int delete(${model.primaryDef});
	
	List<${model.className}> searchByKeywords(List<String> list);
}