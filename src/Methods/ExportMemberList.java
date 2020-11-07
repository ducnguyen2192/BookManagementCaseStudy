package Methods;

import Entities.Book;
import Entities.Library;
import Entities.Member;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExportMemberList {
    public void exportToMemberList(Library lib){
        String excelFilePath = "C:\\Users\\Thuy Nguyen\\Desktop\\codegym\\Module 2\\module2CaseStudy\\LibManagement.xls";

        try {
            FileInputStream fis = new FileInputStream(new File(excelFilePath));
            HSSFWorkbook wb = (HSSFWorkbook) WorkbookFactory.create(fis);

            Sheet sheet = wb.getSheetAt(1);

            int rowCount = 0;
            for (Member member : lib.getMemberList()) {
                Row row = sheet.createRow(++rowCount);
                for (int columnCount = 0; columnCount < member.getNumberOfAttributes(); columnCount++) {
                    Cell cell = row.createCell(columnCount);
                    switch(columnCount){
                        case 0:
                            cell.setCellValue(member.getName());
                            break;
                        case 1:
                            cell.setCellValue(member.getSSN());
                            break;
                        case 2:
                            cell.setCellValue(member.getUserName());
                            break;
                        case 3:
                            cell.setCellValue(member.getPassword());
                            break;
                        case 4:
                            cell.setCellValue(member.getPermission());
                        default:
                    }
                }
            }
            fis.close();

            FileOutputStream fos = new FileOutputStream(excelFilePath);
            wb.write(fos);
            wb.close();
            fos.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
