package com.mashibing.msbdongbaoportalweb.controller;

/**
 * @Auther: 何水锋
 * @Date: 2022/4/21/021 - 04 - 21 - 21:12
 * @Description: com.mashibing.msbdongbaoportalweb.controller
 * @version: 1.0
 *            控制器
 */
//@RestController
//@RequestMapping("/jcaptcha")
//public class JCaptchaController {
//
//    String attrName="verifyCode";
//
//    @GetMapping("/generator")
//    @TokenCheck(required = false)//在拦截器里直接放行
//    public void generatorCode(HttpServletRequest request,HttpServletResponse response) throws NoSuchFieldException {
//        try {
//        String id = request.getSession().getId();
//        BufferedImage bufferedImage = JCaptchaUtil.getService().getImageChallengeForID(id);
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        JPEGImageEncoder jpegImageEncoder =  JPEGCodec.createJPEGEncoder(byteArrayOutputStream);
//
//        jpegImageEncoder.encode(bufferedImage);
//
//        byte[] bytes = byteArrayOutputStream.toByteArray();
//        response.setHeader("Cache-Control","no-stoe");
//        response.setContentType("image/jpeg");
//            ServletOutputStream servletOutputStream = response.getOutputStream();
//            servletOutputStream.write(bytes);
//            servletOutputStream.flush();
//            servletOutputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    /**
//     * 校验验证码
//     * @param verifyCode
//     * @param request
//     * @return
//     */
//    @GetMapping("/verify")
//    @TokenCheck(required = false)
//    public String verify(String verifyCode, HttpServletRequest request) {
//        Boolean aboolean = JCaptchaUtil.getService().validateResponseForID(request.getSession().getId(), verifyCode);
//        if (aboolean){
//            return "验证码校验通过";
//        }
//        return "验证码校验不通过";
//    }
//}
