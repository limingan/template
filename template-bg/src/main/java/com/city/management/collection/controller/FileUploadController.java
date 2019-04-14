package com.city.management.collection.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by cp on 2019-03-31.
 */
@Controller
public class FileUploadController {

    public String fileUpload(@RequestParam("file") MultipartFile file){
        if(file.isEmpty()){
            return "false upload";
        }
        return null;
    }
}
