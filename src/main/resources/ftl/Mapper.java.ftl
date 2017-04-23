package ${model.packageName}.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ${model.packageName}.model.${model.className};
import ${model.packageName}.util.Attribute;
import ${model.packageName}.util.Pager;

public interface ${model.className}Mapper {
	
    int deleteByPrimaryKey(${model.mapperParam});

    int insert(${model.className} ${model.className?uncap_first});

    ${model.className} selectByPrimaryKey(${model.mapperParam});

    int updateByPrimaryKey(${model.className} ${model.className?uncap_first});

	List<${model.className}> search(Pager pager);
	
	/**
	 * 按属性查询
	 * @param attributes
	 * @return
	 */
	List<${model.className}> searchByAttributes(List<Attribute> attributes);
	
	/**
	 * 模糊查询
	 * @param attributes
	 * @return
	 */
	List<${model.className}> searchByKeywords(List<String> keywords);
	
	long getTotal();
	
}