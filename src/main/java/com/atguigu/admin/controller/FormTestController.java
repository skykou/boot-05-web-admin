package com.atguigu.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * 文件上传测试
 */
@Slf4j
@Controller
public class FormTestController {
    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "form/form_layouts";
    }

    /**
     * MultipartFile 自动封装上传过来的文件
     * @param email
     * @param userName
     * @param headerImg
     * @param photos
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("userName")String userName,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {
        log.info("上传的信息：email={},userName={},headerImg={},photos={}",email,userName,headerImg.getSize(),photos.length);
        if(!headerImg.isEmpty()){
            //保存到文件服务器,OSS服务器
            String originalFilename = headerImg.getOriginalFilename();
            originalFilename=new Date().getTime()+originalFilename.substring(originalFilename.indexOf("."));
            headerImg.transferTo(new File("E:\\img\\"+originalFilename));
        }

        if(photos.length>0){
            for (MultipartFile photo : photos) {
                if(!photo.isEmpty()){
                    String originalFilename = photo.getOriginalFilename();
                    originalFilename=new Date().getTime()+originalFilename.substring(originalFilename.indexOf("."));
                    photo.transferTo(new File("E:\\img\\"+originalFilename));
                }
            }
        }
        return "index";
    }
}
