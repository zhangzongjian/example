package pers.example.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import pers.example.model.JavaModel;
import pers.example.model.Attribute;;

public class GenMainWeb {
	//代码模板位置
    private String templatePath;
    //代码文件输出位置
    private String codePath;
    //一个实体类对应一个uuid
    public String uuid;
    
    public GenMainWeb() throws IOException{
    }
    
    public GenMainWeb(String realPath) throws IOException{
    	uuid = PrimaryKeyFactory.generatePrimaryKey("");
//    	codePath = realPath+"/code/"+uuid+"/";
    	codePath = realPath+"/code/";
    	templatePath = "I:\\Program Files\\Myeclipse\\Workspaces_02\\example\\src\\main\\resources\\ftl";
    }

    public void setCodePath(String codePath) {
        this.codePath = codePath;
    }

    /*****
     * 根据Model类生成所有代码到指定目录
     * @param className Model类的名字，如：User
     * @param packageName 模块包的名字，如：com.sys
     */
    public void autoGenerate(String className,String packageName,List<Attribute> attrs) throws Exception {
    	
    	File source = new File(templatePath);
        File destination = new File(codePath);
        if (!destination.exists())
        {
            destination.mkdirs();
        }
        //复制模板到代码目录
        //FileUtils.copyDirectoryToDirectory(source, destination);
    	
//    	generateJava(className,packageName,"Controller",attrs);
//    	generateJavaClass(className,packageName,attrs);
//    	generateJava(className,packageName,"Mapper",attrs);
//    	generateMapperXml(className,packageName,attrs);
//    	generateJava(className,packageName,"Service",attrs);
//        generateJava(className,packageName,"ServiceImpl",attrs);
//        System.out.println("Java代码已生成，位置:"+codePath + "src/");
        generateJsp(className,packageName,"index.jsp",attrs);
        generateJsp(className,packageName,"add.jsp",attrs);
        generateJsp(className,packageName,"update.jsp",attrs);
        generateJsp(className,packageName,"detail.jsp",attrs);
//        generateJsp(className,packageName,"result.jsp",attrs);
//        generateJsp(className,packageName,"welcome.jsp",attrs);
//        System.out.println("Jsp代码已生成，位置:"+codePath + "WebContent/");
//        generateConfigXml(className,packageName,"struts.xml");
//        generateConfigXml(className,packageName,"app-bean.xml");
//        generateConfigXml(className,packageName,"mybatis-config.xml");
        generateSql(className,packageName,attrs);
    }
    
    
    public void generateConfigXml(String className,String packageName,String filename) throws IOException{
    	String classpath = packageName.replace(".", "/");
    	classpath = this.codePath + "src/";

    	JavaModel model=new JavaModel();
    	model.setClassName(className);
    	model.setPackageName(packageName);
    	model.setWeb(true);
        // Build the data-model
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("model", model);
        
        FileUtils.forceMkdir(new File(classpath));
        FreemarkerUtil.getInstance().fprint(filename + ".ftl", data, classpath+filename);
    }


    public void generateJava(String className,String packageName,String type,List<Attribute> attrs) throws IOException{
    	String classpath = packageName.replace(".", "/");
    	if("Service".equals(type)){
    		classpath = this.codePath + "src/" + classpath + "/service/";
    	}else if("ServiceImpl".equals(type)){
    		classpath = this.codePath + "src/" + classpath + "/service/impl/";
    	}else if("Controller".equals(type)){
    		classpath = this.codePath + "src/" + classpath + "/controller/";
    	}else if("Mapper".equals(type)){
    		classpath = this.codePath + "src/" + classpath + "/mapper/";
    	}
    	JavaModel model=new JavaModel();
    	model.setClassName(className);
    	model.setPackageName(packageName);
    	model.setWeb(true);
    	model.setAttrs(attrs);
        // Build the data-model
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("model", model);
        
        FileUtils.forceMkdir(new File(classpath));
        FreemarkerUtil.getInstance().fprint(type + ".java.ftl", data,classpath + className + type +".java");
        
    }
    
    
    public void generateMapperXml(String className,String packageName,List<Attribute> attrs) throws Exception{
    	String classpath = packageName.replace(".", "/");
    	classpath = this.codePath + "src/" + classpath + "/mapper/";
    	
    	JavaModel model=new JavaModel();
    	model.setClassName(className);
    	model.setPackageName(packageName);
    	model.setAttrs(attrs);
    	model.setWeb(true);
        // Build the data-model
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("model", model);
        
        FileUtils.forceMkdir(new File(classpath));
        FreemarkerUtil.getInstance().fprint("Mapper.xml.ftl", data, classpath+className +"Mapper.xml");
    }


    public void generateJsp(String className,String packageName,String type,List<Attribute> attrs) throws Exception{
    	String classpath  = "";
    	if(type.equals("welcome.jsp")){
    		classpath = this.codePath + "WebContent/";
    	}else{
    		classpath = this.codePath + "WebContent/" + StringUtils.lowerCase(className) + "/";
    	}
    	
    	JavaModel model=new JavaModel();
    	model.setClassName(className);
    	model.setAttrs(attrs);
    	model.setWeb(true);
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("model", model);
        data.put("el", "$");
        // Get the templat object
        FileUtils.forceMkdir(new File(classpath));
        String filename = "";
        if(type.equals("welcome.jsp")){
        	filename = "index.jsp";
        }else{
        	filename = type;
        }
        FreemarkerUtil.getInstance().fprint(type + ".ftl", data, classpath+filename);
    }
    
    
	private void generateSql(String className, String packageName,
			List<Attribute> attrs) throws Exception {
		String classpath = packageName.replace(".", "/");
		classpath = this.codePath + "db/";
  
    	JavaModel model=new JavaModel();
    	model.setClassName(className);
    	model.setPackageName(packageName);
    	model.setAttrs(attrs);
    	model.setWeb(true);
        // Build the data-model
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("model", model);
        
        FileUtils.forceMkdir(new File(classpath));
        FreemarkerUtil.getInstance().fprint("sql.ftl", data, classpath + className +".sql");
	}

	public void generateJavaClass(String className, String packageName,
			List<Attribute> attrs) throws Exception {
		String classpath = packageName.replace(".", "/");
		classpath = this.codePath + "src/" + classpath + "/model/";
  
    	JavaModel model=new JavaModel();
    	model.setClassName(className);
    	model.setPackageName(packageName);
    	model.setAttrs(attrs);
    	model.setWeb(true);
        // Build the data-model
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("model", model);
        
        FileUtils.forceMkdir(new File(classpath));
        FreemarkerUtil.getInstance().fprint("Model.java.ftl", data, classpath + className +".java");
	}
	
}
