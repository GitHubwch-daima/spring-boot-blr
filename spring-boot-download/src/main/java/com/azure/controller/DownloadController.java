package com.azure.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Controller
@RequestMapping("file")
public class DownloadController {

    private static final Logger log = LoggerFactory.getLogger(DownloadController.class);
    @Value("${download.file}")
    private String filePath;

    @RequestMapping("download")
    public void downloadFile(String fileName, HttpServletResponse response) throws IOException {
        log.debug("当前文件下载文件名：{}", fileName);
        log.debug("当前文件下载路径为：{}", filePath);

        //去指定目录中读取文件
        File file = new File(filePath, fileName);
        //将文件转换成输入流
        FileInputStream inputStream = new FileInputStream(file);
        //获取响应流之前 一定要以附件的形式下载，attachment：附件
        response.setHeader("content-disposition",
                "attachment;filename" + URLEncoder.encode(fileName, "utf-8"));
        //获取响应输出流
        ServletOutputStream outputStream = response.getOutputStream();

        /*  //输入流复制给输出流
        int len = 0;
        byte[] bytes = new byte[1024];
        while (true) {
            len = inputStream.read();
            if (len == -1) break;
            outputStream.write(bytes, 0, len);
        }        */

        //spring的工具类，将输入流复制给输出流
        FileCopyUtils.copy(inputStream, outputStream);
    }

}
