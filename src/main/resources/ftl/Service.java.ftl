package ${model.packageName}.service;
import ${model.packageName}.util.Pager;
import ${model.packageName}.model.${model.className};

public interface ${model.className}Service {

	${model.className} searchById(${model.primaryDef});
	
	Pager search(Pager pager);
	
	int insert(${model.className} ${model.className?uncap_first});

	int update(${model.className} ${model.className?uncap_first});
	
	int delete(${model.primaryDef});
	
}