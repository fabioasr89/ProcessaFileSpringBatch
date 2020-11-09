package com.fabio.batch.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Connection {
	
	private static Connection conn;
	private InputStream input;
	private FileInputStream fis;
	private InputStreamReader isr;
	private OutputStreamWriter osw;
	private OutputStream out;
	private FileOutputStream fos;
	private BufferedReader bufferReader;
	private BufferedWriter bufferWriter;
	private Connection() {
		
	}
	
	public static Connection getInstance() {
		if(conn==null) {
			conn=new Connection();
		}
		return conn;
	}
	//metodo che legge e recupera il contenuto di un file di testo in risorse
	public List<String> getResourcesFileContent(String fileName) {
		List<String> fileContent=null;
		String path="C:\\Users\\MBC-AULA03\\Desktop\\javaApp\\spring\\batch\\BatchApp1\\AppBatch\\src\\resources\\";
		try {
			input=new FileInputStream(path+fileName);
			isr=new InputStreamReader(input);
			bufferReader=new BufferedReader(isr);
			String line=(String)bufferReader.readLine();
			fileContent=new ArrayList<String>();
			while(line!=null) {
				fileContent.add(line);
				line=bufferReader.readLine();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(bufferReader!=null) {
					bufferReader.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(isr!=null) {
					isr.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(input!=null) {
					bufferReader.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return fileContent;
		
	}
	
	public void writerFile(String element, String pathFileName) {
		try {
			System.out.println("Scrittura file in corso...");
			out=new FileOutputStream(pathFileName,true);
			osw=new OutputStreamWriter(out);
			bufferWriter=new BufferedWriter(osw);
			bufferWriter.write(element);
			System.out.println("File"+" "+pathFileName+" correttamente scritto");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(bufferWriter!=null) {
				try {
					bufferWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(osw!=null) {
				try {
					osw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(out!=null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
}
