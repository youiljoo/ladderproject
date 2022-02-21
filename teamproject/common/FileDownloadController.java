package com.mycompany.teamproject.common.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.coobird.thumbnailator.Thumbnails;


@Controller
public class FileDownloadController {
	private static String CURR_IMAGE_REPO_PATH = "C:\\ladder\\image";
	private static final String BOARD_IMAGE_REPO = "C:\\board\\as_image";
	private static final String REVIEW_IMAGE_REPO = "C:\\review\\image";
	
	@RequestMapping("/download")
	protected void download(@RequestParam("originoriginFileName") String originFileName,
		                 	@RequestParam("productNum") String productNum,
			                 HttpServletResponse response) throws Exception {
		OutputStream out = response.getOutputStream();
		String filePath=CURR_IMAGE_REPO_PATH+"\\"+productNum+"\\"+originFileName;
		File image=new File(filePath);

		response.setHeader("Cache-Control","no-cache");
		response.addHeader("Content-disposition", "attachment; originFileName="+originFileName);
		FileInputStream in=new FileInputStream(image); 
		byte[] buffer=new byte[1024*8];
		while(true){
			int count=in.read(buffer); //버퍼에 읽어들인 문자개수
			if(count==-1)  //버퍼의 마지막에 도달했는지 체크
				break;
			out.write(buffer,0,count);
		}
		in.close();
		out.close();
	}
	
	
	@RequestMapping("/thumbnails.do")
	protected void thumbnails(@RequestParam("fileName") String fileName,@RequestParam("productNum")String productNum,
                            	@RequestParam("category") String category,
			                 HttpServletResponse response) throws Exception {
		OutputStream out = response.getOutputStream();
		String filePath=CURR_IMAGE_REPO_PATH+"\\"+category+"\\"+productNum+"\\"+fileName;
		File image=new File(filePath);
		
		if (image.exists()) { 
			Thumbnails.of(image).size(2000,400).outputFormat("jpg").toOutputStream(out);
		}
		byte[] buffer = new byte[1024 * 8];
		out.write(buffer);
		out.close();
	}
	
	// A/S 게시판 파일 첨부
	@RequestMapping("/download.do")
	protected void download2(@RequestParam("imageFileName")String imageFileName,@RequestParam("as_no")String as_no,HttpServletResponse response)throws Exception{
		OutputStream out=response.getOutputStream();
		String downFile=BOARD_IMAGE_REPO+"\\"+as_no+"\\"+imageFileName;
		File file=new File(downFile);
		
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment:fileName="+imageFileName);
		FileInputStream in = new FileInputStream(file);
		byte[] buffer=new byte[1024*8];
		while (true) {
			int count= in.read(buffer);
			if (count==-1)
				break;
			out.write(buffer,0,count);
		}
		System.out.println("파일 다운로드 완료");
		in.close();
		out.close();
	}
	
	// 마이페이지 내 상품 후기 작성
		@RequestMapping("/re_download.do")
		protected void re_download(@RequestParam("imageFileName")String imageFileName,@RequestParam("re_num")String re_num,HttpServletResponse response)throws Exception{
			OutputStream out=response.getOutputStream();
			String downFile=REVIEW_IMAGE_REPO+"\\"+re_num+"\\"+imageFileName;
			File file=new File(downFile);
			
			response.setHeader("Cache-Control", "no-cache");
			response.addHeader("Content-disposition", "attachment:fileName="+imageFileName);
			FileInputStream in = new FileInputStream(file);
			byte[] buffer=new byte[1024*8];
			while (true) {
				int count= in.read(buffer);
				if (count==-1)
					break;
				out.write(buffer,0,count);
			}
			System.out.println("파일 다운로드 완료");
			in.close();
			out.close();
		}
	
}

