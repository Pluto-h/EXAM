package com.nwrb.eqbe.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


import com.nwrb.eqbe.mapper.chooseMapper;
import com.nwrb.eqbe.mapper.discussMapper;
import com.nwrb.eqbe.mapper.judgmentMapper;
import com.nwrb.eqbe.mapper.vacancyMapper;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class importProblemController {

    @Autowired
    private chooseMapper chooseMapper;
    @Autowired
    private judgmentMapper judgmentMapper;
    @Autowired
    private vacancyMapper vacancyMapper;
    @Autowired
    private discussMapper discussMapper;

    @Transactional(rollbackFor = Exception.class)
    public boolean importProblem(String filePath) {
        try {
            Workbook wb =null;
            Sheet sheet = null;
            Row row = null;
            Object cellData = null;
            wb = readExcel(filePath);
            if(wb != null){
                for (int x=2;x<6;x++){
                    //用来存放表中数据
                    //获取sheet
                    sheet = wb.getSheetAt(x);
                    //获取最大行数
                    if(sheet.getPhysicalNumberOfRows()==0){
                        System.out.println(1);
                        return false;
                    }
                    int rownum = sheet.getPhysicalNumberOfRows();
                    //获取第一行
                    row = sheet.getRow(0);
                    if (row.getPhysicalNumberOfCells()==0){
                        System.out.println(2);
                        return false;
                    }
                    //获取最大列数
                    int colnum = row.getPhysicalNumberOfCells();
                    for (int i = 1; i<rownum; i++) {
                        row = sheet.getRow(i);
                        if(row !=null){
                            List<Object> list = new ArrayList();
                            for (int j=0;j<colnum;j++){
                                cellData = (Object) getCellFormatValue(row.getCell(j));
                                list.add(cellData);
                            }
                            if (sheet.getSheetName().equals("选择题")){
                                chooseMapper.insertChoose((String) list.get(0),(String)list.get(1),(String)list.get(2),(String)list.get(3),
                                        (String)list.get(4),(String)list.get(5),(String)list.get(6),(String)list.get(7),(String)list.get(8),(String)list.get(9),Integer.parseInt((String)list.get(10)),Integer.parseInt((String)list.get(11)));
                            }else if (sheet.getSheetName().equals("判断题")){
                                judgmentMapper.insertJudgment((String) list.get(0),(String)list.get(1),(String)list.get(2),Integer.parseInt((String)list.get(3)),Integer.parseInt((String)list.get(4)));
                            }else if (sheet.getSheetName().equals("填空题")){
                                vacancyMapper.insertVacancy((String) list.get(0),(String)list.get(1),(String)list.get(2),Integer.parseInt((String)list.get(3)),Integer.parseInt((String)list.get(4)));
                            }else if (sheet.getSheetName().equals("简答题")){
                                discussMapper.insertDiscuss((String) list.get(0),(String)list.get(1),(String)list.get(2),Integer.parseInt((String)list.get(3)),Integer.parseInt((String)list.get(4)));
                            }
                        }else{
                            break;
                        }
                    }
                }
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
        }

    //读取excel
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

    //格式
    public static Object getCellFormatValue(Cell cell){
        if(cell!=null){
            CellType cellType = cell.getCellTypeEnum();
            switch (cellType) {
                case NUMERIC:
                    return new DecimalFormat("0").format(cell.getNumericCellValue());
                case STRING:
                    return cell.getStringCellValue();
                case BOOLEAN:
                    return String.valueOf(cell.getBooleanCellValue());
                case FORMULA:
                    return cell.getCellFormula();
                case BLANK:
                    return "";
                case ERROR:
                    return String.valueOf(cell.getErrorCellValue());
                default:
                    return "";
            }
        }
        return "";
    }
}
