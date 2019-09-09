package com.nwrb.eqbe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * @创建人 胡满意
 * @创建时间 2019/6/26
 * @描述
 */
@RestController
@EnableAutoConfiguration
public class upload {
    @Autowired
    private importProblemController importProblemController;

    @RequestMapping(value = "/admin/upload",method = {RequestMethod.GET,RequestMethod.POST})
    public Map<String,Object> upLoad(@RequestParam("file") MultipartFile file) throws FileNotFoundException {
        Map<String,Object> result = new HashMap<>();
        if (file.isEmpty()) {
            result.put("error","上传失败");
            return result;
        }
        String filename=file.getOriginalFilename();
        String filePath = "templates/upload";
        ClassPathResource file2 = new ClassPathResource(filePath+"/"+filename);
        int random = (int)(1+Math.random()*(999999-1+1000000));
        filePath=file2.getClassLoader().getResource("").getPath()+filePath+"/"+random+filename;
        File dest = new File(filePath);
        System.out.println(dest);
        try {
            file.transferTo(dest);
            if (!importProblemController.importProblem(String.valueOf(dest))){
                dest.delete();
                result.put("error","文件读取失败，请检查文件后重试");
                return result;
            }
            dest.delete();
            result.put("success","上传成功");
            return result;
        }catch (Exception e){
            e.printStackTrace();
            result.put("error","上传失败");
            return result;
        }
    }
}
