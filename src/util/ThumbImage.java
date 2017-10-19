package util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.renderable.ParameterBlock;
import java.io.File;

import javax.imageio.ImageIO;
import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;

public class ThumbImage {
	
	/**
	 * 썸네일 이미지 저장
	 * @param imagePath
	 * @param filename
	 * @param w - 가로
	 * @param h - 세로
	 * @throws Exception
	 */
	public static void createThumbImage(String imagePath, String filename, int w, int h)	throws Exception{
		ParameterBlock pb = new ParameterBlock();
		pb.add(imagePath+"/" +filename);
		
		RenderedOp rOp = JAI.create("fileload", pb);//Render
		
		//1. 원본이미지 BufferedImage 생성
		BufferedImage bi= rOp.getAsBufferedImage();
		//int width= bi.getWidth()/2;//가로 1/2
		//int height = bi.getHeight()/2;//세로 1/2
		
		// 2. 섬네일이미지(가로,세로 100) BufferedImage 생성
		BufferedImage thumb=new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
		
		//3. 원본이미지 축소시켜 섬네일이미지(가로,세로 100) BufferedImage 그림
		Graphics2D g=thumb.createGraphics();
		g.drawImage(bi,0,0,w,h,null);
		
		//4. 섬네일이미지를 jpg파일로 저장
		File file=new File(imagePath+"/sm_"+filename);
		ImageIO.write(thumb,"jpg",file);
	}
}
