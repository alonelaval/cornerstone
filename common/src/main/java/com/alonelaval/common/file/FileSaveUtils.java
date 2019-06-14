package com.alonelaval.common.file;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author huawei
 * @create 2018-07-23
 **/
public class FileSaveUtils {

    public static   String savaFile(MultipartFile file ,String savaPath) {
        if(file == null){
            return  null;
        }
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyyMMdd");
        String originalFilename = file.getOriginalFilename();
        String postfix =  originalFilename.substring(originalFilename.lastIndexOf("."),originalFilename.length());

        String dicPath =savaPath+"/"+localDate.format(formatters);
        File dic = new File(dicPath);
        if(!dic.exists()){
            dic.mkdir();
        }

        String fileName = dicPath.concat("/").concat(RandomStringUtils.random(18,"zxcvbnmasdfghjkqwertyupZXCVBNMASDFGHJKLQWERTYUP0123456789")).concat(postfix);
        try {
            file.transferTo(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  fileName;
    }
}
