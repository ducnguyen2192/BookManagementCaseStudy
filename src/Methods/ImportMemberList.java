package Methods;

import Entities.Book;
import Entities.Library;
import Entities.Member;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ImportMemberList {
    public ArrayList<Member> importMemberList(Library lib) throws IOException {
        FileInputStream fis = new FileInputStream(new File("C:\\Users\\Thuy Nguyen\\Desktop\\codegym\\Module 2\\module2CaseStudy\\LibManagement.xls"));
        HSSFWorkbook wb = new HSSFWorkbook(fis);
        HSSFSheet sheet = wb.getSheetAt(1);
        for (Row row : sheet)
        {
            Member member = new Member();
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
                            member.setSSN(cell.getNumericCellValue());
                            break;
                        case 2:
                            member.setUserName(cell.getStringCellValue());
                            break;
                        case 3:
                            member.setPassword(cell.getStringCellValue());
                            break;
                        case 4:
                            member.setPermission(cell.getNumericCellValue());
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
