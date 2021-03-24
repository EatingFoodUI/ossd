package com.lyl.springboot.ossd.utils;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

public class updateFile {

    public void update(MultipartFile multipartFile,String filePath){
        try {
            // 保存图片
            File file = new File(filePath + multipartFile.getOriginalFilename());
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
