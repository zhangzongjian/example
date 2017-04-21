package pers.example.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pers.example.model.Attribute;
import pers.example.service.CodeService;


public class CreateCodeTest {
	
	/**
	 * 生成代码
	 * @param args
	 */
	public static void main_(String[] args) {
		//代码输出根路径--当前项目的src/main/webapp/download
		//String rootPath = new File("src/main/webapp/download").getAbsolutePath();
		String rootPath = "I:\\Program Files\\Myeclipse\\Workspaces_02\\example\\src\\main\\webapp\\download";
		String className = "User";
		String packageName = "com.example.sys";
		
		//类属性
		List<Attribute> attrs = new ArrayList<Attribute>();
		String[] attrName = {"id", "name"};
		String[] attrType = {"String", "String"};
		String[] attrPrimary = {"1", "0"};
		String[] attrComment = {"编号", "名字"};
 		for(int i = 0 ; i < attrName.length; i++){
			Attribute attr = new Attribute();
			attr.setAttrName(attrName[i]);
			attr.setAttrPrimary(attrPrimary[i]);
			attr.setAttrType(attrType[i]);
			attr.setAttrComment(attrComment[i]);
			attrs.add(attr);
		}

 		//生成代码，返回文件uuid
 		//执行这步，代码已经生成完毕
 		String uuid = new CodeService().generateCode(rootPath,packageName,className,attrs);
 		System.out.println(uuid);
	}
	
	
	
	
	
	
	
	public static void main1(String[] args) {
//		String url = "http://www.autojcode.com/front/code_generate.action?packageName=com.team.sys&className=User&attrName=id&attrType=Integer&attrPrimary=1&attrComment=ID&attrName=name&attrType=String&attrPrimary=0&attrComment=名字";
		String url = "http://www.autojcode.com/front/code_generate.action?packageName=pers.flights&className=Administrator&attrName=id&attrType=Integer&attrPrimary=1&attrComment=编号&attrName=username&attrType=String&attrPrimary=0&attrComment=账号&attrName=password&attrType=String&attrPrimary=0&attrComment=密码&attrName=realName&attrType=String&attrPrimary=0&attrComment=姓名&attrName=position&attrType=String&attrPrimary=0&attrComment=职位&attrName=lastLoginTime&attrType=String&attrPrimary=0&attrComment=最后登录时间&attrName=createTime&attrType=String&attrPrimary=0&attrComment=创建时间&attrName=authority&attrType=String&attrPrimary=0&attrComment=权限";
		url = args[0];
		String[] param = url.split("&");
		List<String> params= Arrays.asList(param);
		
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		
		ArrayList<String> list = null;
		for(String p : params) {
			for(String key : new String[]{"packageName","className","attrName","attrType","attrPrimary","attrComment"}) {
				if(p.contains(key)) {
					if(map.get(key) == null) {
						list = new ArrayList<String>();
						list.add(p.split("=")[1]);
						map.put(key, list);
					} else {
						list = map.get(key);
						list.add(p.split("=")[1]);
					}
				}
			}
		}
		
		//////////////////////////////////////////////
		String rootPath = "I:\\Program Files\\Myeclipse\\Workspaces_02\\example\\src\\main\\webapp\\download";
		String className = map.get("className").get(0);
		String packageName = map.get("packageName").get(0);
		
		List<Attribute> attrs = new ArrayList<Attribute>();
		Object[] attrName = map.get("attrName").toArray();
		Object[] attrType = map.get("attrType").toArray();
		Object[] attrPrimary = map.get("attrPrimary").toArray();
		Object[] attrComment = map.get("attrComment").toArray();
		for(int i = 0 ; i < attrName.length; i++){
			Attribute attr = new Attribute();
			attr.setAttrName((String) attrName[i]);
			attr.setAttrPrimary((String) attrPrimary[i]);
			attr.setAttrType((String) attrType[i]);
			attr.setAttrComment((String) attrComment[i]);
			attrs.add(attr);
		}
		
		//生成代码，返回文件uuid
 		//执行这步，代码已经生成完毕
 		String uuid = new CodeService().generateCode(rootPath,packageName,className,attrs);
 		System.out.println(uuid);
	}
	
	
	public static void main(String[] args) {
		String administrator = "http://www.autojcode.com/front/code_generate.action?packageName=pers.flights&className=Administrator&attrName=id&attrType=Integer&attrPrimary=1&attrComment=编号&attrName=username&attrType=String&attrPrimary=0&attrComment=账号&attrName=password&attrType=String&attrPrimary=0&attrComment=密码&attrName=realName&attrType=String&attrPrimary=0&attrComment=姓名&attrName=position&attrType=String&attrPrimary=0&attrComment=职位&attrName=lastLoginTime&attrType=String&attrPrimary=0&attrComment=最后登录时间&attrName=createTime&attrType=String&attrPrimary=0&attrComment=创建时间&attrName=authority&attrType=String&attrPrimary=0&attrComment=权限";
		String customer = "http://www.autojcode.com/front/code_generate.action?packageName=pers.flights&className=Customer&attrName=id&attrType=Integer&attrPrimary=1&attrComment=编号&attrName=email&attrType=String&attrPrimary=0&attrComment=邮箱&attrName=mobilePhone&attrType=String&attrPrimary=0&attrComment=手机号码&attrName=accountType&attrType=String&attrPrimary=0&attrComment=账号类型&attrName=nickName&attrType=String&attrPrimary=0&attrComment=昵称&attrName=realName&attrType=String&attrPrimary=0&attrComment=姓名&attrName=password&attrType=String&attrPrimary=0&attrComment=密码&attrName=birthday&attrType=String&attrPrimary=0&attrComment=出生日期&attrName=sex&attrType=String&attrPrimary=0&attrComment=性别&attrName=phone&attrType=String&attrPrimary=0&attrComment=联系固话&attrName=createTime&attrType=String&attrPrimary=0&attrComment=创建时间";
		String plane = "http://www.autojcode.com/front/code_generate.action?packageName=pers.flights&className=Plane&attrName=id&attrType=Integer&attrPrimary=1&attrComment=编号&attrName=planeVersion&attrType=String&attrPrimary=0&attrComment=型号&attrName=planeType&attrType=String&attrPrimary=0&attrComment=类型&attrName=planeAge&attrType=Integer&attrPrimary=0&attrComment=机龄&attrName=businessClassAmount&attrType=Integer&attrPrimary=0&attrComment=公务舱座位数量&attrName=firstClassAmount&attrType=Integer&attrPrimary=0&attrComment=头等舱座位数量&attrName=economyClassAmount&attrType=Integer&attrPrimary=0&attrComment=经济舱座位数量&attrName=createTime&attrType=String&attrPrimary=0&attrComment=创建时间";
		String flight = "http://www.autojcode.com/front/code_generate.action?packageName=pers.flights&className=Flight&attrName=id&attrType=Integer&attrPrimary=1&attrComment=编号&attrName=flightNo&attrType=String&attrPrimary=0&attrComment=航班号&attrName=startTime&attrType=String&attrPrimary=0&attrComment=出发时间&attrName=startAirportId&attrType=Integer&attrPrimary=0&attrComment=出发机场&attrName=arrivalTime&attrType=String&attrPrimary=0&attrComment=抵达时间&attrName=endAirportId&attrType=Integer&attrPrimary=0&attrComment=目的机场&attrName=planeId&attrType=Integer&attrPrimary=0&attrComment=飞机&attrName=startRealTime&attrType=String&attrPrimary=0&attrComment=实际出发时间&attrName=arrivalRealTIme&attrType=String&attrPrimary=0&attrComment=实际抵达时间&attrName=status&attrType=String&attrPrimary=0&attrComment=状态&attrName=createTime&attrType=String&attrPrimary=0&attrComment=创建时间";
		String discount = "http://www.autojcode.com/front/code_generate.action?packageName=pers.flights&className=Discount&attrName=id&attrType=Integer&attrPrimary=1&attrComment=编号&attrName=discountType&attrType=String&attrPrimary=0&attrComment=折扣类型&attrName=discountRate&attrType=Float&attrPrimary=0&attrComment=折扣率&attrName=createTime&attrType=String&attrPrimary=0&attrComment=创建时间";
		String company = "http://www.autojcode.com/front/code_generate.action?packageName=pers.flights&className=Company&attrName=id&attrType=Integer&attrPrimary=1&attrComment=编号&attrName=companyCode&attrType=String&attrPrimary=0&attrComment=公司代码&attrName=information&attrType=String&attrPrimary=0&attrComment=公司信息&attrName=companyName&attrType=String&attrPrimary=0&attrComment=公司名称&attrName=mobilePhone&attrType=String&attrPrimary=0&attrComment=联系电话&attrName=companyPhone&attrType=String&attrPrimary=0&attrComment=固定电话&attrName=companyUrl&attrType=String&attrPrimary=0&attrComment=公司网址&attrName=createTime&attrType=String&attrPrimary=0&attrComment=创建时间";
		String ticketprice = "http://www.autojcode.com/front/code_generate.action?packageName=pers.flights&className=TicketPrice&attrName=id&attrType=Integer&attrPrimary=1&attrComment=编号&attrName=classType&attrType=String&attrPrimary=0&attrComment=舱位类型&attrName=classAmount&attrType=String&attrPrimary=0&attrComment=舱位数量&attrName=price&attrType=Float&attrPrimary=0&attrComment=价格&attrName=flightId&attrType=Integer&attrPrimary=0&attrComment=航班编号&attrName=discountId&attrType=Integer&attrPrimary=0&attrComment=折扣类型&attrName=dprice&attrType=Float&attrPrimary=0&attrComment=优惠价&attrName=createTime&attrType=String&attrPrimary=0&attrComment=创建时间";
		String order = "http://www.autojcode.com/front/code_generate.action?packageName=pers.flights&className=Order&attrName=id&attrType=Integer&attrPrimary=1&attrComment=编号&attrName=orderNo&attrType=String&attrPrimary=0&attrComment=订单号&attrName=flightId&attrType=Integer&attrPrimary=0&attrComment=航班编号&attrName=ticketPriceId&attrType=Integer&attrPrimary=0&attrComment=票价编号&attrName=orderTime&attrType=String&attrPrimary=0&attrComment=预定时间&attrName=person&attrType=String&attrPrimary=0&attrComment=联系人&attrName=phone&attrType=String&attrPrimary=0&attrComment=联系电话&attrName=orderStatus&attrType=String&attrPrimary=0&attrComment=订单状态&attrName=customerId&attrType=Integer&attrPrimary=0&attrComment=客户编号&attrName=createTime&attrType=String&attrPrimary=0&attrComment=创建时间";
		String passenger = "http://www.autojcode.com/front/code_generate.action?packageName=pers.flights&className=Passenger&attrName=id&attrType=Integer&attrPrimary=1&attrComment=编号&attrName=passengerName&attrType=String&attrPrimary=0&attrComment=乘客姓名&attrName=passengerCard&attrType=String&attrPrimary=0&attrComment=身份证号&attrName=passengerType&attrType=String&attrPrimary=0&attrComment=乘客类型&attrName=mobilePhone&attrType=String&attrPrimary=0&attrComment=手机号码&attrName=customerId&attrType=Integer&attrPrimary=0&attrComment=客户编号";
		String airport = "http://www.autojcode.com/front/code_generate.action?packageName=pers.flights&className=Airport&attrName=id&attrType=Integer&attrPrimary=1&attrComment=编号&attrName=airportName&attrType=String&attrPrimary=0&attrComment=机场名称&attrName=airportCity&attrType=String&attrPrimary=0&attrComment=所属城市&attrName=createTime&attrType=String&attrPrimary=0&attrComment=创建时间";
		
		String s[] = {administrator, customer, plane, 
					  flight, discount, company, ticketprice,
					  order, passenger, airport};
		for(String m : s) {
			main1(new String[]{m});
		}
	}
}


