package com.example.grpcserver.web.controller;


import com.example.grpcserver.Util.QRCodeUtil;
import com.google.zxing.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QrcodeController {

    @RequestMapping("/productcode")
    public void productcode() {

        QRCodeUtil.zxingCodeCreate("http://www.runoob.com/html/html-images.html", "D:\\pictures\\logo\\123.jpg",500,"D:\\pictures\\123.jpg");
    }

    @RequestMapping("/analysiscode")
    public void analysiscode() {

        Result result = QRCodeUtil.zxingCodeAnalyze("D:\\pictures\\logo\\123.jpg");
        System.err.println("二维码解析内容："+result.toString());
    }
}
