package com.mycompany.teamproject.common.base;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mycompany.teamproject.goods.vo.ImageFileVO;

public abstract class BaseController {
private static final String CURR_IMAGE_REPO_PATH = "C:\\ladder\\image";
	
	protected List<ImageFileVO> upload(MultipartHttpServletRequest multipartRequest) throws Exception{
		List<ImageFileVO> fileList= new ArrayList<ImageFileVO>();
		Iterator<String> fileNames = multipartRequest.getFileNames();
		while(fileNames.hasNext()){
			ImageFileVO imageFileVO =new ImageFileVO();
			String fileName = fileNames.next();
			imageFileVO.setFileType(fileName);
			MultipartFile mFile = multipartRequest.getFile(fileName);
			String originalFileName=mFile.getOriginalFilename();
			imageFileVO.setFileName(originalFileName);
			fileList.add(imageFileVO);
			
			File file = new File(CURR_IMAGE_REPO_PATH +"\\"+ fileName);
			if(mFile.getSize()!=0){ //File Null Check
				if(! file.exists()){ //경로상에 파일이 존재하지 않을 경우
					if(file.getParentFile().mkdirs()){ //경로에 해당하는 디렉토리들을 생성
							file.createNewFile(); //이후 파일 생성
					}
				}
				mFile.transferTo(new File(CURR_IMAGE_REPO_PATH +"\\"+"temp"+ "\\"+originalFileName)); //임시로 저장된 multipartFile을 실제 파일로 전송
			}
		}
		return fileList;
	}
}
