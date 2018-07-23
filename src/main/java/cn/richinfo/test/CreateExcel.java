package cn.richinfo.test;

//生成Excel的类
import java.io.File;
import java.util.Date;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class CreateExcel {
    public static void main(String args[]) {
        try {
            System.out.println(new Date().getTime());
            // 打开文件
            WritableWorkbook book = Workbook.createWorkbook(new File("test.xls"));
            // 生成名为“第一页”的工作表，参数0表示这是第一页
            WritableSheet sheet = book.createSheet("第一页", 0);
            WritableSheet sheet1 = book.createSheet("第二页", 1);
            // 在Label对象的构造子中指名单元格位置是第一列第一行(0,0)
            // 以及单元格内容为test
            Label label = new Label(0, 0, "test");
            Label label1 = new Label(0, 0, "test2");
            sheet1.addCell(label1);
            // 将定义好的单元格添加到工作表中
            sheet.addCell(label);
            /*
             * 生成一个保存数字的单元格 必须使用Number的完整包路径，否则有语法歧义 单元格位置是第二列，第一行，值为789.123
             */
            jxl.write.Number number = new jxl.write.Number(1, 0, 555.12541);
            Number number1 = new Number(1, 0, 222.1121);
            sheet1.addCell(number1);
            sheet.addCell(number);

            // 写入数据并关闭文件
            book.write();
            book.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}