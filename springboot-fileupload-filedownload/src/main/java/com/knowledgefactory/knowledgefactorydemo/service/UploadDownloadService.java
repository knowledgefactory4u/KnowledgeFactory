package com.knowledgefactory.knowledgefactorydemo.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadDownloadService {
	private static final String path = "/home/user/Desktop/files";

	public List<String> uploadFile(MultipartFile file) throws Exception {

		// Save file on system
		if (!file.getOriginalFilename().isEmpty()) {
			BufferedOutputStream outputStream = new BufferedOutputStream(
					new FileOutputStream(new File(path, file.getOriginalFilename())));
			outputStream.write(file.getBytes());
			outputStream.flush();
			outputStream.close();
		} else {
			throw new Exception();
		}

		List<String> list = new ArrayList<String>();
		File files = new File(path);
		String[] fileList = ((File) files).list();
		for (String name : fileList) {
			list.add(name);
		}

		return list;

	}

	public List<String> getListofFiles() throws Exception {

		List<String> list = new ArrayList<String>();
		File files = new File(path);
		String[] fileList = ((File) files).list();
		for (String name : fileList) {
			list.add(name);
		}

		return list;

	}
}
