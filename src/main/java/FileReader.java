import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;


public class FileReader {
    String currentDir = System.getProperty("user.dir");
    String path = currentDir + "/Resources/tgcl.xlsx";




    public Object[][] excelReader() throws IOException {
        FileInputStream file = new FileInputStream(path);
        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sheet =  wb.getSheetAt(0);
        int rowCount = sheet.getPhysicalNumberOfRows();
        System.out.println("row" +rowCount);
        XSSFRow row = sheet.getRow(0);

        int colNumber = row.getLastCellNum();
        System.out.println("cell number"+colNumber);

        String data[][] = new String[rowCount-1][colNumber];
        for(int i =0; i<rowCount-1; i++){
            row = sheet.getRow(i+1);
            for(int j=0;j<colNumber;j++){
                data[i][j] = String.valueOf(row.getCell(j));
                System.out.println(row.getCell(j));
            }
        }
        return  data;
    }

}
