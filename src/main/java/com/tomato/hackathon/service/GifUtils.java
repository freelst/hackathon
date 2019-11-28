package com.tomato.hackathon.service;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.Java2DFrameConverter;
import com.madgag.gif.fmsware.AnimatedGifEncoder;

import javax.imageio.ImageIO;


public class GifUtils {

    /**
     * 默认帧频率（默认：10）
     */
    private static final Integer DEFAULT_FRAME_RATE = 10;

    /**
     * 截取视频起始帧 （默认：5）
     */
    private static final Integer DEFAULT_START_FRAME = 5;


    public static String buildGif(String filePath, int frameCount)
            throws IOException {
        // gif存储路径
        String gifPath = filePath.substring(0, filePath.lastIndexOf(".")) + ".gif";
        // 输出文件流
        FileOutputStream targetFile = new FileOutputStream(gifPath);
        // 读取文件
        FFmpegFrameGrabber ff = new FFmpegFrameGrabber(filePath);
        Java2DFrameConverter converter = new Java2DFrameConverter();
        // 无限期的循环下去、注意，此参数设置必须在下面for循环之前，即在添加第一帧数据之前

        ff.start();
        try {
            Integer videoLength = ff.getLengthInFrames();
            // 如果用户上传视频极短,不符合自己定义的帧数取值区间,设置合法区间

            ff.setFrameNumber(DEFAULT_START_FRAME);
            AnimatedGifEncoder en = new AnimatedGifEncoder();
            en.setFrameRate(DEFAULT_FRAME_RATE);
            en.start(targetFile);
            for (int i = 0; i < frameCount && ff.getFrameNumber() < videoLength; i++) {
                Frame frame = ff.grabImage();
                BufferedImage srcImage = converter.getBufferedImage(frame);
                en.addFrame(srcImage);
                ff.setFrameNumber(ff.getFrameNumber() + (int)ff.getFrameRate() + 1);
            }
            en.finish();
        } finally {
            ff.stop();
            ff.close();
        }
        return gifPath;
    }

    public static String buildCover(String filePath) throws IOException{
        FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(filePath);
        grabber.start();
        grabber.setFrameNumber(DEFAULT_START_FRAME);
        Frame frame = grabber.grabImage();
        Java2DFrameConverter converter = new Java2DFrameConverter();
        BufferedImage bi = converter.getBufferedImage(frame);
        String coverPath = filePath.substring(0, filePath.lastIndexOf(".")) + ".jpg";
        ImageIO.write(bi, "jpg", new File(coverPath));
        grabber.stop();
        return coverPath;
    }
}