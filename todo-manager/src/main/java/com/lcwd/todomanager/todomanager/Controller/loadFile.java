package com.lcwd.todomanager.todomanager.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class loadFile {

Logger logger = LoggerFactory.getLogger(loadFile.class);
    @PostMapping("/single")
    public String loadFiles(@RequestParam("image") MultipartFile file){
        logger.info("name {}",file.getContentType());
        logger.info("Size {}",file.getSize());
            return "successfully Created";
    }
//@PostMapping("/multiple")
//    public String multipleFile(@RequestParam("img") MultipartFile[] file){
//        logger.info("name",);
//    }
}
