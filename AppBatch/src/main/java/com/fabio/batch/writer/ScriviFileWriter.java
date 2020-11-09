package com.fabio.batch.writer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.fabio.batch.util.Connection;

public class ScriviFileWriter implements ItemWriter<String>{
private static final String fileWriter="scrittura.txt";
private Connection conn;
	public ScriviFileWriter() {
		// TODO Auto-generated constructor stub
	}

	public void write(List<? extends String> items) throws Exception {
		try {
			List<String> lista=new ArrayList<String>();
			lista.add(items.get(0));
			conn=Connection.getInstance();
			String path="C:\\Users\\MBC-AULA03\\Desktop\\";
			conn.writerFile(lista.get(0),path+fileWriter);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
