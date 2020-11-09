package Methods;

import Entities.Library;
import Entities.User;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ImportMemberList {
    public ArrayList<User> importMemberList(Library lib) throws IOException {
        FileInputStream fis = new FileInputStream(new File("C:\\Users\\Thuy Nguyen\\Desktop\\codegym\\Module 2\\module2CaseStudy\\LibManagement.xls"));
        HSSFWorkbook wb = new HSSFWorkbook(fis);
        HSSFSheet sheet = wb.getSheetAt(1);
        lib.getMemberList().clear();

        for (Row row : sheet)
        {
            User member = new User();
            int cellIndex = 0;
            if(row.getRowNum() == 0){
                continue;
            } else {
                for (Cell cell : row)
                {
                    switch (cellIndex) {
                        case 0:
                            member.setName(cell.getStringCellValue());
                            break;
                        case 1:
                            member.setSSN((int) cell.getNumericCellValue());
                            break;
                        case 2:
                            member.setUserName(cell.getStringCellValue());
                            break;
                        case 3:
                            member.setPassword(cell.getStringCellValue());
                            break;
                        case 4:
                            member.setPermission((int) cell.getNumericCellValue());
                            break;
                        default:
                            break;
                    }
                    cellIndex += 1;
                }
            }
            lib.getMemberList().add(member);
        }
        fis.close();
        return lib.getMemberList();
    }
}
