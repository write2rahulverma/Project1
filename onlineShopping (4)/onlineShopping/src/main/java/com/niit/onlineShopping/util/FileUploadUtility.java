package com.niit.onlineShopping.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {
	
	private static final String ABS_PATH = "C:\\Users\\ASUS\\workspace-ecllipse-new\\onlineShopping\\onlineShopping\\src\\main\\webapp\\WEB-INF\\resources\\images\\";
	private static String REAL_PATH = null;
	public static boolean uploadFile(HttpServletRequest request, MultipartFile file, String string) 
	{				
		// get the real server path
		REAL_PATH = request.getSession().getServletContext().getRealPath("/resources/images/");
		
				
		// create the directories if it does not exist
		
		if(!new File(REAL_PATH).exists()) {
			new File(REAL_PATH).mkdirs();
		}
		
		if(!new File(ABS_PATH).exists()) {
			new File(ABS_PATH).mkdirs();
		}
		
		try {
			//transfer the file to both the location
			file.transferTo(new File(REAL_PATH + string + ".jpg"));
			file.transferTo(new File(ABS_PATH + string + ".jpg"));
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		return true;
	}
	

}
