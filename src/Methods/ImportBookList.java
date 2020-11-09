package Methods;

import Entities.Book;
import Entities.Library;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ImportBookList {
    public ArrayList<Book> importBook(Library lib) throws IOException {
        FileInputStream fis = new FileInputStream(new File("C:\\Users\\Thuy Nguyen\\Desktop\\codegym\\Module 2\\module2CaseStudy\\LibManagement.xls"));
        HSSFWorkbook wb = new HSSFWorkbook(fis);
        HSSFSheet sheet = wb.getSheetAt(0);
        lib.getBookList().clear();
        for (Row row : sheet)
        {
            Book b = new Book();
            int cellIndex = 0;
            if(row.getRowNum() == 0){
                continue;
            } else {
                for (Cell cell : row)
                {
                    switch (cellIndex) {
                        case 0:
                            b.setBookName(cell.getStringCellValue());
                            break;
                        case 1:
                            b.setBookId((int) cell.getNumericCellValue());
                            break;
                        case 2:
                            b.setBookQuantity((int) cell.getNumericCellValue());
                            break;
                        case 3:
                            b.setBookEdition((int) cell.getNumericCellValue());
                            break;
                        case 4:
                            b.setBookAuthor(cell.getStringCellValue());
                        default:
                            break;
                    }
                    cellIndex += 1;
                }
            }
            lib.getBookList().add(b);
        }
        fis.close();
        return lib.getBookList();
    }
}
