package com.kirb.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.kirb.pojo.Chvmotor;
import com.kirb.service.ChvmotorService;
import com.kirb.service.impl.ChvmotorServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("cc")
public class CriController {

	@Resource
	private ChvmotorServiceImpl chvmotorservice;

	@RequestMapping("show")
	public String getshow() {

		return "show";
	}
	@RequestMapping("findCriName")
	@ResponseBody
	public Object findmoterName(
			@RequestParam(value="motername",required=false)String motername,
			@RequestParam(value="page",required=false)Integer currPage,
			@RequestParam(value="limit",required=false)Integer pageSize){
		System.out.print("进入查询方法...");
		if(currPage==null){//如果当前页为空，则默认为第1页
			currPage=1;
		}
		if(pageSize==null){//如果每页条数为空，则默认为每页10条
			pageSize=5;
		}
		int limitOne  = (currPage - 1) * pageSize;//计算出从哪一条开始显示
		//记录集合
		List<Chvmotor> list=chvmotorservice.findmoterName(motername, limitOne, pageSize);
		//总条数
		int count=chvmotorservice.findmoterNameCount(motername);
		System.out.println("记录数："+count);
		String strJson = JSON.toJSONString(list);
		//layui json 格式
		String json="{\"code\":0,\"msg\":\"\",\"count\":"+count+",\"data\":"+strJson+"}";
		System.out.println(json);
		return json;
	}

	@RequestMapping("findCriShow")
	public String findCriShow(){
		return "findCri";
	}

	@RequestMapping("editCriShow")
	public String editCriShow(){
		return "editCri";
	}

	@RequestMapping("editCri")
	@ResponseBody
	public Object editCri(Chvmotor chvmotor){ //添加犯人信息
		int count=chvmotorservice.addChvmotor(chvmotor);
		return count;
	}


	@RequestMapping("delCri")//删除犯人信息
	@ResponseBody
	public Object delCri(@RequestParam(value="id",required=false)Integer id){
		int count=chvmotorservice.delChvmotorById(id);
		return count;
	}

	@RequestMapping("findCriById")//根据ID查询数据
	@ResponseBody
	public Object findCriById(@RequestParam(value="id",required=false)Integer id){
		Chvmotor objCri=chvmotorservice.findChvmotorById(id);
		return JSON.toJSON(objCri);
	}

	@RequestMapping("updCri")
	@ResponseBody
	public Object updCri(Chvmotor chvmotor){ //修改犯人信息
		int count=chvmotorservice.updChvmotor(chvmotor);
		return count;
	}
	@RequestMapping("findlike")
	@ResponseBody
	public Object likeselect(@RequestParam(value="motername",required=false)String motername){
		//记录集合
		List<Chvmotor> list=chvmotorservice.findmoterName(motername,0,0);
		return JSON.toJSON(list);
	}
	@RequestMapping("getInfo")
	@ResponseBody
	public String getInfo(@RequestParam(value = "motername",required = false) String motername,
						  @RequestParam(defaultValue="1") int pageIndex){
		PageInfo<Chvmotor> list=chvmotorservice.getInfoByName(pageIndex,motername);
		String json=JSON.toJSONString(list);
		return json;
	}
}
