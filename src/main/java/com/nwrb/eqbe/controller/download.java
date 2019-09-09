package com.nwrb.eqbe.controller;

import com.nwrb.eqbe.entity.category;
import com.nwrb.eqbe.entity.subject;
import com.nwrb.eqbe.mapper.categoryMapper;
import com.nwrb.eqbe.mapper.subjectMapper;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

/**
 * @创建人 胡满意
 * @创建时间 2019/6/25
 * @描述
 */
@RestController
@EnableAutoConfiguration
public class download {

    @Autowired
    private subjectMapper subjectMapper;
    @Autowired
    private categoryMapper categoryMapper;

    @GetMapping("/admin/download")
    public Map<String,Object> downLoad(HttpServletResponse response, HttpSession session) {
        Map<String,Object> result = new HashMap<>();
        if (session.getAttribute("adminAccountId") == null) {
            result.put("code", 401);
            result.put("error", "权限不足，无法下载模板！");
            return result;
        }else {
            Workbook wb =null;
            int subject=0;
            int category=0;
            Sheet sheet = null;
            Row row = null;
            List<subject> subjectList = subjectMapper.selectSubjectList();
            List<category> categoryList = categoryMapper.selectAllCategory();
            subject=subjectMapper.selectSubjectCount();
            category=categoryMapper.selectCategoryCount();
            String filename="problem.xls";
            String filePath = "templates/download";
            ClassPathResource file = new ClassPathResource(filePath+"/"+filename);
            filePath=file.getClass().getResource("/").getPath()+filePath+"/"+filename;
            wb = readExcel(filePath);
            if(wb != null){
                for(int x = 0;x<3;x++){
                    //用来存放表中数据
                    //获取第一个sheet
                    sheet = wb.getSheetAt(x);
                    //获取最大行数
                    int rownum = sheet.getPhysicalNumberOfRows();
                    //获取第一行
                    for(int i=1;i<rownum;i++){
                        row = sheet.getRow(i);
                        sheet.removeRow(row);
                    }
                    try {
                        FileOutputStream os = new FileOutputStream(filePath);
                        wb.write(os);
                        os.close();
                    } catch (FileNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        result.put("error","无法找到路径");
                        return result;
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        result.put("error","错误");
                        return result;
                    }
                    if (x==0){
                        System.out.println("----------file updating");
                        for(int i=1;i<=subject;i++){
                            row = sheet.createRow(i);
                            for(int j=0;j<2;j++){
                                if (j==0){
                                    row.createCell(j).setCellValue(subjectList.get(i-1).getSubjectId());
                                }else if(j==1){
                                    row.createCell(j).setCellValue(subjectList.get(i-1).getSubjectName());
                                }
                            }
                        }
                    }else if(x==1){
                        for(int i=1;i<=category;i++){
                            row = sheet.createRow(i);
                            for(int j=0;j<3;j++){
                                if (j==0){
                                    row.createCell(j).setCellValue(categoryList.get(i-1).getCategoryId());
                                }else if (j==1){
                                    row.createCell(j).setCellValue(categoryList.get(i-1).getCategoryName());
                                }else if (j==2){
                                    row.createCell(j).setCellValue(categoryList.get(i-1).getCategorySubject());
                                }
                            }
                        }
                        System.out.println("----------file update completed");
                    }
                }
            }else {
                result.put("error","错误");
                return result;
            }
            if(file.exists()){ //判断文件父目录是否存在
                response.setContentType("application/force-download");
                response.setHeader("Content-Disposition", "attachment;fileName=" + filename);

                byte[] buffer = new byte[1024];
                FileInputStream fis = null; //文件输入流
                BufferedInputStream bis = null;

                OutputStream os = null; //输出流
                try {
                    os = response.getOutputStream();
                    fis = new FileInputStream(filePath);
                    bis = new BufferedInputStream(fis);
                    int i = bis.read(buffer);
                    while(i != -1){
                        os.write(buffer);
                        i = bis.read(buffer);
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    result.put("error","错误");
                    return result;
                }
                System.out.println("----------file download：" + filename);
                try {
                    bis.close();
                    fis.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    result.put("error","错误");
                    return result;
                }
            }
            System.out.println("----------file download completed");
            return null;
        }
    }

    public static Workbook readExcel(String filePath){
        Workbook wb = null;
        if(filePath==null){
            return null;
        }
        String extString = filePath.substring(filePath.lastIndexOf("."));
        InputStream is = null;
        try {
            is = new FileInputStream(filePath);
            if(".xls".equals(extString)){
                return wb = new HSSFWorkbook(is);
            }else if(".xlsx".equals(extString)){
                return wb = new XSSFWorkbook(is);
            }else{
                return wb = null;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }
}
