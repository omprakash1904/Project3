package com.prakash.automation.utilities;

import com.prakash.automation.supporters.ConfigPropertiesReusables;
import com.prakash.automation.supporters.ExcelPropertiesReusables;
import com.prakash.automation.supporters.OrPropertiesReusables;
import com.prakash.automation.supporters.TxtFileReusables;

public class PojoUtility {
	static ConfigPropertiesReusables conf;
	static OrPropertiesReusables or;
	static ExcelPropertiesReusables excel;
	static TxtFileReusables txt;
	public static OrPropertiesReusables getOrfileObj()
	{
		or=new OrPropertiesReusables(Filepaths.getOrconffilepath());
		return or;
	}
	public static ConfigPropertiesReusables getConfObj()
	{
		conf=new ConfigPropertiesReusables(Filepaths.getConfigfilepath());
		return conf;
	}
	public static ExcelPropertiesReusables getExcelObj()
	{
		excel=new ExcelPropertiesReusables(Filepaths.getExcelfilepath());
		return excel;
	}
	public static TxtFileReusables getTxtFileObj()
	{
		txt=new TxtFileReusables(Filepaths.getTxtfilepath());
		return txt;
	}
	

}
