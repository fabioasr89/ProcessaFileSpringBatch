package com.fabio.batch.reader;

import java.util.List;

import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.fabio.batch.util.Connection;

public class LeggiFileReader implements ItemReader<String>{
private Connection conn;
private static Integer index=0;
private static List<String> listaContent;
private static final String fileName="lecture.txt";
	public LeggiFileReader() {
		
	}
	@BeforeStep
	public void init() {
		conn=Connection.getInstance();
		listaContent=conn.getResourcesFileContent(fileName);
	}
	
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		String text=null;
		if(listaContent!=null && index<listaContent.size()) {
			text=listaContent.get(index);
			index++;
		}
		
		return text;
	}

}
