package com.javahonk.action;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;


public class Struts2XMLDownloadAction{

	@Action(value = "/downloadXMLFileAction")
	public void downloadCSVFileAction() throws Exception {

	    HttpServletResponse response = ServletActionContext.getResponse();
	    response.setContentType("text/xml");
		String reportName = "JavaHonk_Struts2_XML_Report_.xml";
		response.setHeader("Content-disposition", "attachment;filename="+ reportName);
 
		ArrayList<String> rows = new ArrayList<String>();
		rows.add("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		rows.add("<Details>");
		for (int i = 0; i < 4; i++) {
			rows.add("<Person" + (i + 1) + ">");
			rows.add("<FirstName>");
			rows.add("Java");
			rows.add("</FirstName>");
			rows.add("<LastName>");
			rows.add("Honk");
			rows.add("</LastName>");
			rows.add("<Test>");
			rows.add("Success");
			rows.add("</Test>");
			rows.add("</Person" + (i + 1) + ">");
 
		}
		rows.add("</Details>");
 
		Iterator<String> iter = rows.iterator();
		while (iter.hasNext()) {
			String outputString = (String) iter.next();
			response.getOutputStream().print(outputString);
		}
 
		response.getOutputStream().flush();
	}

}
