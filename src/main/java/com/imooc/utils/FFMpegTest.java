package com.imooc.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FFMpegTest {
	
	private String ffmpegEXE;
	public FFMpegTest(String ffmpegEXE) {
		super();
		this.ffmpegEXE = ffmpegEXE;
	}
	
	public void convertor(String videoInputPath,String videoOutputPath) throws IOException {
		//ffmpeg -i input.mp4 output.avi
		List<String> command = new ArrayList<>();
		command.add(ffmpegEXE);
		command.add("-i");
		command.add(videoInputPath);
		command.add(videoOutputPath);
		ProcessBuilder processBuilder = new ProcessBuilder(command);
		Process process = processBuilder.start();
		
		InputStream errorStream = process.getErrorStream();
		InputStreamReader inputStreamReader = new InputStreamReader(errorStream);
		BufferedReader br = new BufferedReader(inputStreamReader);
		
		
		String line = "";
		while( (line = br.readLine()) != null) {
			
		}
		if(br != null) {
			br.close();
		}
		if(inputStreamReader != null) {
			inputStreamReader.close();
		}
		if(errorStream != null) {
			errorStream.close();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FFMpegTest ffmpeg = new FFMpegTest("D:\\ffmpeg\\bin\\ffmpeg.exe");
		try {
			ffmpeg.convertor("D:\\201809111739201.mp4", "D:\\111201809111739201.avi");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
