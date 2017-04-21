package pers.example.service;

import java.util.List;

import pers.example.model.Attribute;
import pers.example.util.GenMainWeb;
import pers.example.util.ZipCompressor;

public class CodeService {
	
	public String generateCode(String rootPath,String packageName, String className,
			List<Attribute> attrs) {
		try {
			GenMainWeb genMain = new GenMainWeb(rootPath);
			genMain.autoGenerate(className,packageName,attrs);
//			ZipCompressor zc = new ZipCompressor(rootPath+"download/code/"+genMain.uuid+".zip"); 
//			zc.compress(rootPath+"download/code/"+genMain.uuid); 
			return genMain.uuid;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}