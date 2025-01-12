package com.jit.management.service;

import com.jit.management.pojo.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    private String path = "";
    @Autowired
    private EmployeeService employeeService;

    /**
     * 创建入职员工excel表
     * @param reportDTO
     * @return
     */
    public int createEnrollExcel(ReportDTO reportDTO) {
        List<EnrollEmployeeVO> EnrollEmployeeVOS = employeeService.getByEnrollDate(reportDTO);
        String[] columns = {"员工号", "员工姓名", "性别", "出生日期", "身份证号", "部门号","部门名称", "岗位号", "岗位名称", "入职日期", "参加工作日期",
                "用工形式", "人员来源", "政治面貌", "民族", "籍贯", "联系电话", "电子邮件", "身高", "血型",
                "婚姻状况", "出生地", "户口所在地", "最高学历", "最高学位", "毕业院校", "所学专业", "毕业日期"};
        SimpleDateFormat df = new SimpleDateFormat("yyyy_MM_dd_HH_MM_SS");
        SimpleDateFormat dfTime = new SimpleDateFormat("yyyy-MM-dd:HH:MM:SS  ");
        String fileName="Enroll_"+df.format(new Date())+".xlsx";

        String path = "C:\\Users\\123456\\Desktop\\报表\\"+fileName;

        try (Workbook workbook = new HSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("New Enroll Employee Data");

            // 创建表头
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
            }

            // 写入数据
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            int rowNum = 1;
            for (EnrollEmployeeVO employee : EnrollEmployeeVOS) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(employee.getEmployeeId());
                row.createCell(1).setCellValue(employee.getEmployeeName());

                int gender = employee.getGender();
                if(gender == 1) row.createCell(2).setCellValue("男");
                else if(gender == 2) row.createCell(2).setCellValue("女");

                row.createCell(3).setCellValue(formatter.format(employee.getBirth()));
                row.createCell(4).setCellValue(employee.getIdentityCard());
                row.createCell(5).setCellValue(employee.getDepartmentId());
                row.createCell(6).setCellValue(employee.getDepartmentName());
                row.createCell(7).setCellValue(employee.getPositionId());
                row.createCell(8).setCellValue(employee.getPositionName());
                row.createCell(9).setCellValue(formatter.format(employee.getEnrollDate()));
                row.createCell(10).setCellValue(formatter.format(employee.getWorkDate()));

                int employeeForm = employee.getEmployeeForm();
                if(employeeForm == 1) row.createCell(11).setCellValue("正式员工");
                else if(employeeForm == 2) row.createCell(11).setCellValue("临时员工");

                int personnelSource = employee.getPersonnelSource();
                if(personnelSource == 1) row.createCell(12).setCellValue("校园招聘");
                else if(personnelSource == 2) row.createCell(12).setCellValue("社会招聘");
                else if(personnelSource == 3) row.createCell(12).setCellValue("其它");

                int politicalOutlook = employee.getPoliticalOutlook();
                if(politicalOutlook == 1) row.createCell(13).setCellValue("党员");
                else if(politicalOutlook == 2) row.createCell(13).setCellValue("预备党员");
                else if(politicalOutlook == 3) row.createCell(13).setCellValue("团员");
                else if(politicalOutlook == 3) row.createCell(13).setCellValue("其他");

                row.createCell(14).setCellValue(employee.getNation());
                row.createCell(15).setCellValue(employee.getOrigin());
                row.createCell(16).setCellValue(employee.getPhone());
                row.createCell(17).setCellValue(employee.getEmail());
                row.createCell(18).setCellValue(employee.getHeight());

                int bloodType = employee.getBloodType();
                if(bloodType == 1) row.createCell(19).setCellValue("A 型");
                else if(bloodType == 2) row.createCell(19).setCellValue("B 型");
                else if(bloodType == 3) row.createCell(19).setCellValue("AB 型");
                else if(bloodType == 4) row.createCell(19).setCellValue("0 型");
                else if(bloodType == 5) row.createCell(19).setCellValue("其他血型");

                int maritalStatus = employee.getMaritalStatus();
                if(maritalStatus == 1) row.createCell(20).setCellValue("未婚");
                else if(maritalStatus == 2) row.createCell(20).setCellValue("已婚");
                else if(maritalStatus == 3) row.createCell(20).setCellValue("丧偶");
                else if(maritalStatus == 4) row.createCell(20).setCellValue("离婚");
                else if(maritalStatus == 5) row.createCell(20).setCellValue("其他");

                row.createCell(21).setCellValue(employee.getBirthPlace());
                row.createCell(22).setCellValue(employee.getHouseholdRegistrationLocation());

                int qualification = employee.getQualification();
                if(qualification == 1) row.createCell(23).setCellValue("高中及以下");
                else if(qualification == 2) row.createCell(23).setCellValue("大专");
                else if(qualification == 3) row.createCell(23).setCellValue("本科");
                else if(qualification == 4) row.createCell(23).setCellValue("研究生");

                int degree = employee.getDegree();
                if(degree == 1) row.createCell(24).setCellValue("无学位");
                else if(degree == 2) row.createCell(24).setCellValue("学士");
                else if(degree == 3) row.createCell(24).setCellValue("双学士");
                else if(degree == 4) row.createCell(24).setCellValue("硕士");
                else if(degree == 5) row.createCell(24).setCellValue("博士");
                else if(degree == 6) row.createCell(24).setCellValue("博士后");

                row.createCell(25).setCellValue(employee.getGraduateSchool());
                row.createCell(26).setCellValue(employee.getMajor());
                if(employee.getGraduateDate()!=null) row.createCell(27).setCellValue(formatter.format(employee.getGraduateDate()));
            }

            // 将数据写入文件
            try (FileOutputStream fileOut = new FileOutputStream(path)) {
                workbook.write(fileOut);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }

        return 1;
    }

    /**
     * 创建辞退员工excel表
     * @param reportDTO
     * @return
     */
    public int createDismissExcel(ReportDTO reportDTO) {
        List<DimissionVO> dismisses = employeeService.getByDismissDate(reportDTO);
        String[] columns = {"员工号", "员工姓名", "离职日期", "离职类型", "离职去向", "备注"};

        SimpleDateFormat df = new SimpleDateFormat("yyyy_MM_dd_HH_MM_SS");
        SimpleDateFormat dfTime = new SimpleDateFormat("yyyy-MM-dd:HH:MM:SS  ");
        String fileName="Dismiss_"+df.format(new Date())+".xlsx";

        String path = "C:\\Users\\123456\\Desktop\\报表\\"+fileName;

        try (Workbook workbook = new HSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("New Dismiss Employee Data");

            // 创建表头
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
            }

            // 写入数据
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            int rowNum = 1;
            for (DimissionVO dismiss : dismisses) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(dismiss.getEmployeeId());
                row.createCell(1).setCellValue(dismiss.getEmployeeName());
                row.createCell(2).setCellValue(formatter.format(dismiss.getDimissionDate()));
                row.createCell(3).setCellValue(dismiss.getDimissionType());
                row.createCell(4).setCellValue(dismiss.getDimissionGo());
                row.createCell(5).setCellValue(dismiss.getNote());
            }

            // 将数据写入文件
            try (FileOutputStream fileOut = new FileOutputStream(path)) {
                workbook.write(fileOut);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    /**
     * 创建部门调转excel表
     * @param reportDTO
     * @return
     */
    public int createDepartmentExcel(ReportDTO reportDTO) {
        List<DepartmentTransferVO> departmentTransferVOS = employeeService.getByDepartmentTransferDate(reportDTO);
        String[] columns = {"员工号", "员工姓名", "调转后的部门号",
                "调转后的部门名称","调转类型", "调转原因", "调动日期", "备注"};

        SimpleDateFormat df = new SimpleDateFormat("yyyy_MM_dd_HH_MM_SS");
        String fileName="DepartmentTransfer_"+df.format(new Date())+".xlsx";

        String path = "C:\\Users\\123456\\Desktop\\报表\\"+fileName;

        try (Workbook workbook = new HSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("New DepartmentTransfer Employee Data");

            // 创建表头
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
            }

            // 写入数据
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            int rowNum = 1;
            for (DepartmentTransferVO departmentTransfer : departmentTransferVOS) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(departmentTransfer.getEmployeeId());
                row.createCell(1).setCellValue(departmentTransfer.getEmployeeName());
                row.createCell(2).setCellValue(departmentTransfer.getTransferDepartmentId());
                row.createCell(3).setCellValue(departmentTransfer.getDepartmentName());
                row.createCell(4).setCellValue(departmentTransfer.getTransferType());
                row.createCell(5).setCellValue(departmentTransfer.getTransferReason());
                row.createCell(6).setCellValue(formatter.format(departmentTransfer.getTransferDate()));
                row.createCell(7).setCellValue(departmentTransfer.getNote());
            }

            // 将数据写入文件
            try (FileOutputStream fileOut = new FileOutputStream(path)) {
                workbook.write(fileOut);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    /**
     * 创建岗位调转excel表
     * @param reportDTO
     * @return
     */
    @Override
    public int createPositionExcel(ReportDTO reportDTO) {
        List<PositionTransferVO>  positionTransferVOS = employeeService.getByPositionTransferDate(reportDTO);
        String[] columns = {"员工号", "员工姓名", "调转后的岗位号",
                "调转后的岗位名称","调转类型", "调转原因", "调动日期", "备注"};

        SimpleDateFormat df = new SimpleDateFormat("yyyy_MM_dd_HH_MM_SS");
        SimpleDateFormat dfTime = new SimpleDateFormat("yyyy-MM-dd:HH:MM:SS  ");
        String fileName="PositionTransfer_"+df.format(new Date())+".xlsx";

        String path = "C:\\Users\\123456\\Desktop\\报表\\"+fileName;

        try (Workbook workbook = new HSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("New DepartmentTransfer Employee Data");

            // 创建表头
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
            }

            // 写入数据
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            int rowNum = 1;
            for (PositionTransferVO positionTransfer : positionTransferVOS) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(positionTransfer.getEmployeeId());
                row.createCell(1).setCellValue(positionTransfer.getEmployeeName());
                row.createCell(2).setCellValue(positionTransfer.getTransferPositionId());
                row.createCell(3).setCellValue(positionTransfer.getPositionName());
                row.createCell(4).setCellValue(positionTransfer.getTransferType());
                row.createCell(5).setCellValue(positionTransfer.getTransferReason());
                row.createCell(6).setCellValue(formatter.format(positionTransfer.getTransferDate()));
                row.createCell(7).setCellValue(positionTransfer.getNote());
            }

            // 将数据写入文件
            try (FileOutputStream fileOut = new FileOutputStream(path)) {
                workbook.write(fileOut);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    /**
     * 读取人才数据文件，并添加到数据库
     * @param file
     * @return
     */
    @Override
    public int addByFile(MultipartFile file) {
        try{
            InputStream inputStream = file.getInputStream();
            Workbook workbook = new HSSFWorkbook(inputStream); // 使用 XSSFWorkbook 读取 XLSX 文件，如果是 XLS 文件，可以使用 HSSFWorkbook

            Sheet sheet = workbook.getSheetAt(0); // 获取第一个工作表
            int i=0;
            for (Row row : sheet) {
                if(i==0) {
                    i++;
                    continue;
                }

                Cell cell;
                Employee employee = new Employee();
                employee.setStatus(0);
                employee.setEmployeeId((int) row.getCell(0).getNumericCellValue());
                employee.setEmployeeName(row.getCell(1).getStringCellValue());
                employee.setGender(row.getCell(2).getStringCellValue() == "男"?1:2);
                employee.setBirth(row.getCell(3).getLocalDateTimeCellValue());
                employee.setIdentityCard(row.getCell(4).getStringCellValue());
                employee.setDepartmentId((int) row.getCell(5).getNumericCellValue());
                employee.setPositionId((int)row.getCell(7).getNumericCellValue());
                employee.setEnrollDate(row.getCell(9).getLocalDateTimeCellValue());
                employee.setWorkDate(row.getCell(10).getLocalDateTimeCellValue());

                switch (row.getCell(11).getStringCellValue()){
                    case "正式员工" : employee.setEmployeeForm(1);
                    case "临时员工" : employee.setEmployeeForm(2);
                }

                switch (row.getCell(12).getStringCellValue()){
                    case "校园招聘" : employee.setPersonnelSource(1);
                    case "社会招聘" : employee.setPersonnelSource(2);
                    case "其它" : employee.setPersonnelSource(3);
                }

                switch (row.getCell(13).getStringCellValue()){
                    case "党员" : employee.setPoliticalOutlook(1);
                    case "预备党员" : employee.setPoliticalOutlook(2);
                    case "团员" : employee.setPoliticalOutlook(3);
                    case "其他" : employee.setPoliticalOutlook(4);
                }

                employee.setNation(row.getCell(14).getStringCellValue());
                employee.setOrigin(row.getCell(15).getStringCellValue());
                employee.setPhone(row.getCell(16).getStringCellValue());
                employee.setEmail(row.getCell(17).getStringCellValue());
                employee.setHeight(row.getCell(18).getNumericCellValue());

                switch (row.getCell(19).getStringCellValue()){
                    case "A 型" : employee.setBloodType(1);
                    case "B 型" : employee.setBloodType(2);
                    case "AB 型" : employee.setBloodType(3);
                    case "0 型" : employee.setBloodType(4);
                    case "其他血型" : employee.setBloodType(4);
                }
                System.out.println(employee);
//                private int maritalStatus; //婚姻状况 1：未婚,2：已婚,3：丧偶,4：离婚,5：其他
//                private int qualification; //最高学历 1：高中及以下,2：大专,3：本科,4：研究生
//                private int degree; //最高学位 1：无学位,2：学士,3：双学士,4：硕士,5：博士,6：博士后
//


                System.out.println();
            }

            workbook.close(); // 关闭 Workbook，释放资源
        } catch (IOException e) {
            e.printStackTrace();
            // 处理异常
        }
        return 1;
    }

}
