package com.netbank.dao;

import java.util.List;

import com.netbank.entity.Personinfo;
import com.netbank.entity.Status;

public interface PersoninfoDao {

	public void modifyPersoninfo(Personinfo personinfo);
	
	public List getAllPersoninfo();
	
	public List searchPersoninfo(Status status);
	
	public List searchPersoninfo(Personinfo personinfo);
	
	public boolean add(Personinfo personinfo);
	
}
