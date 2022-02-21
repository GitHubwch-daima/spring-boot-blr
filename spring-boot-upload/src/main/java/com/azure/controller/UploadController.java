package com.azure.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("file")
public class UploadController {

    private static final Logger log = LoggerFactory.getLogger(UploadController.class);

    @Value("${upload.file.images}")
    private String path;

    /**
     * 推荐使用这种方法撒上传文件，这里的upload文件夹一定得是先建好的
     *
     * @param filename MultipartFile，接受文件对象
     * @return
     * @throws IOException
     */
    @RequestMapping("upload2")
    public String uploadImages(MultipartFile filename) throws IOException {
        String originalFilename = filename.getOriginalFilename();
        log.debug("文件名：{}", originalFilename);
        log.debug("文件大小：{}", filename.getSize());
        log.debug("文件类型：{}", filename.getContentType());
        log.debug("获取绝对路径：{}", path);
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFileName = new SimpleDateFormat("yyyyMMddHHmmssSS").format(new Date()) + substring;
        filename.transferTo(new File(path, newFileName));
        return "redirect:/page";
    }


    @RequestMapping("upload1")
    public String upload1(MultipartFile filename, HttpServletRequest request) throws IOException {
        String originalFilename = filename.getOriginalFilename();
        log.debug("文件名：{}", originalFilename);
        log.debug("文件大小：{}", filename.getSize());
        log.debug("文件类型：{}", filename.getContentType());
        String realPath = request.getSession().getServletContext().getRealPath("/upload");//tomcat请求路径，这个有问题
        log.debug("获取绝对路径：{}", realPath);
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFileName = new SimpleDateFormat("yyyyMMddHHmmssSS").format(new Date()) + substring;
        filename.transferTo(new File(realPath, newFileName));
        return "redirect:/page";
    }

    @RequestMapping("upload")
    public String upload(MultipartFile filename) throws IOException {
        String realPath = "D:\\environment\\idea\\workspace\\spring-boot-blr\\spring-boot-upload\\src\\main\\resources\\templates\\upload\\" + filename.getOriginalFilename();
        File saveDir = new File(realPath);
        filename.transferTo(saveDir);
        return "redirect:/page";
    }
}
