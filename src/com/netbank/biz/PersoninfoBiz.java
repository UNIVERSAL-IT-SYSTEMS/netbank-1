package com.netbank.biz;

import java.util.List;

import com.netbank.entity.Personinfo;
import com.netbank.entity.Status;

public interface PersoninfoBiz {

	public boolean modifyPersoninfo(Personinfo personinfo);
	
	public List searchPersoninfo(Status status);
	
	public List searchPersoninfo(Personinfo personinfo);
	
	public boolean add(Personinfo personinfo);
	
}
