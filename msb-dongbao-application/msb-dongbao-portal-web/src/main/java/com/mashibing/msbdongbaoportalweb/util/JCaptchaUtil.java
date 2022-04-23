package com.mashibing.msbdongbaoportalweb.util;

/**
 * @Auther: 何水锋
 * @Date: 2022/4/22/022 - 04 - 22 - 22:01
 * @Description: com.mashibing.msbdongbaoportalweb.util
 * @version: 1.0
 */
//public class JCaptchaUtil {
//    //编写一个单列模式饿汗式
//    private static final ImageCaptchaService service = imageCaptchaService();
//
//    public static ImageCaptchaService getService(){
//        return service;
//    }
//
//    private static ImageCaptchaService imageCaptchaService(){
//        //设置背景并且设置长度和高
//        UniColorBackgroundGenerator backgroundGenerator = new UniColorBackgroundGenerator(100,50);
//        //设置背景颜色
//        RandomRangeColorGenerator textColor = new RandomRangeColorGenerator(new int[]{0,100},new int[]{0,20},new int[]{50,250});
//        //设置随机字数
//        RandomTextPaster randomTextPaster = new RandomTextPaster(4,5,textColor);
//        //设置字体大小最小20最大30
//        RandomFontGenerator randomFontGenerator = new RandomFontGenerator(20,30);
//        //组装图像
//        ComposedWordToImage composedWordToImage = new ComposedWordToImage(randomFontGenerator,backgroundGenerator,randomTextPaster);
//
//        ComposeDictionaryWordGenerator cdwg = new ComposeDictionaryWordGenerator(new FileDictionary("toddlist"));
//
//        GimpyFactory gf = new GimpyFactory(cdwg,composedWordToImage);
//
//        GenericCaptchaEngine gce = new GenericCaptchaEngine(new CaptchaFactory[]{gf});
//
//        return new GenericManageableCaptchaService(gce,20,2000,2000);
//    }
//}
