package com.kirb.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kirb.dao.ChvmotorMapper;
import com.kirb.pojo.Chvmotor;
import com.kirb.service.ChvmotorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("chvmotorserviceimpl")
public class ChvmotorServiceImpl implements ChvmotorService {

	@Autowired
	private ChvmotorMapper chvmotorMapper;

	@Override
	public int addChvmotor(Chvmotor chvmotor) {
		return chvmotorMapper.addChvmotor(chvmotor);
	}

	@Override
	public List<Chvmotor> findmoterName(String motername, int currPage, int pageSize) {
		return chvmotorMapper.findmoterName(motername,currPage,pageSize);
	}

	@Override
	public int findmoterNameCount(String motername) {
		return chvmotorMapper.findmoterNameCount(motername);
	}

	@Override
	public int delChvmotorById(int id) {
		return chvmotorMapper.delChvmotorById(id);
	}

	@Override
	public Chvmotor findChvmotorById(int id) {
		return chvmotorMapper.findChvmotorById(id);
	}

	@Override
	public int updChvmotor(Chvmotor chvmotor) {
		return chvmotorMapper.updChvmotor(chvmotor);
	}

	@Override
	public List<Chvmotor> getInfoByName(Map map) {
		return chvmotorMapper.getInfoByName(map);
	}

	public PageInfo<Chvmotor> getInfoByName(int currentPageNo, String motername){
		PageHelper.startPage(currentPageNo,5);
		Map<String,Object> map=new HashMap<>();
		if (motername != null) {
			map.put("motername",motername);
		}
		List<Chvmotor> list=chvmotorMapper.getInfoByName(map);
		PageInfo<Chvmotor> page = new PageInfo<Chvmotor>(list);
		return page;
	}
}
