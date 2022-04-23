package com.mashibing.msbdongbaoportalweb.code;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import lombok.Data;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Random;

/**
 * @Auther: 何水锋
 * @Date: 2022/4/21/021 - 04 - 21 - 21:14
 * @Description: com.mashibing.msbdongbaoportalweb.code
 * @version: 1.0
 */
@Data
public class ImageCode {
    //图形中的内容
    private String code;
    //图片
    private ByteArrayInputStream image;

    private int weight = 400;
    private int height = 100;

    public static ImageCode getInstance() throws IOException {
        return new ImageCode();
    }

    private ImageCode (){
        //图形缓冲区  给个黑板
        BufferedImage image = new BufferedImage(weight,height,BufferedImage.TYPE_INT_RGB);

        //给你支画笔
        Graphics graphics = image.getGraphics();

        //拿笔涂颜色
        graphics.setColor(new Color(255,255,255));
        //画矩形
        graphics.fillRect(0,0,weight,height);
        //字体
        graphics.setFont(new Font("宋体",Font.PLAIN,30));
        Random random = new Random();
        this.code = "";
        //画线，生成6位数字的
//        for (int i = 0; i <6; i++) {
//            String s = String.valueOf(random.nextInt(10));
//            this.code += s;
//            //设置字体颜色
//            graphics.setColor(new Color(0,0,0));
//            //设置字体间隔
//            graphics.drawString(s,(weight/6)*i,40);
//        }
            /**
             * 设置数字相加
             */
            //设置两个随机数
          int num1 = random.nextInt(20);
          int num2 = random.nextInt(20);
          //提供画板
        graphics.setColor(new Color(0,0,100));
        //设置数字的存储位置
        graphics.drawString(num1+"",(weight/6)*0+20,60);
        graphics.drawString("+",(weight/6)*1+20,60);
        graphics.drawString(num2+"",(weight/6)*3+20,60);
        graphics.drawString("=",(weight/6)*4+20,60);
        graphics.drawString("?",(weight/6)*5+20,60);
        //将结果传给code
        int result = num1+num2;
        this.code = result+"";


        //干扰线条
        graphics.setColor(new Color(100,100,100));
        for (int i = 0; i < 100; i++) {
            int x = random.nextInt(weight);
            int y = random.nextInt(weight);
            int x1 = random.nextInt(20);
            int y1 = random.nextInt(20);
            graphics.drawLine(x,y,x+x1,y+y1);
        }
        //收笔
        graphics.dispose();

        ByteArrayInputStream inputStream = null;
        ByteOutputStream outputStream = new ByteOutputStream();

        try {
        //赋值给ByteArrayInputStream
        ImageOutputStream imageOutputStream = ImageIO.createImageOutputStream(outputStream);
        ImageIO.write(image,"jpeg",imageOutputStream);
        inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        }catch (Exception e){
            System.out.println("生成验证码失败");
        }
        this.image = inputStream;
    }
}
