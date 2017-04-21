package ${model.packageName}.mapper;

import java.util.List;
import ${model.packageName}.util.Pager;
import org.apache.ibatis.annotations.Param;
import ${model.packageName}.model.${model.className};

public interface ${model.className}Mapper {
	
    int deleteByPrimaryKey(${model.mapperParam});

    int insert(${model.className} ${model.className?uncap_first});

    ${model.className} selectByPrimaryKey(${model.mapperParam});

    int updateByPrimaryKey(${model.className} ${model.className?uncap_first});

	List<${model.className}> search(Pager pager);
	
}