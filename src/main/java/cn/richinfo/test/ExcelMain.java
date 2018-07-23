package cn.richinfo.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ExcelMain {
	
	/**
	 * 
	 * 这个是单纯读取EXCEL数据
	 * */
	public  void read() {
		StringBuffer sb = new StringBuffer();  
     Workbook wb = null;   
     try {   
     	File is = new File("test1.xls");
         // 获取工作簿对象   
         wb = Workbook.getWorkbook(is);   
         if (wb != null) {   
             // 获取工作簿对象就可以获取工作簿内的工作表对象   
             Sheet[] sheets = wb.getSheets();   
             if (sheets != null && sheets.length != 0) {   
                 // 遍历工作簿内所有工作表   
                 for (int i=0;i<sheets.length;i++) {   
                     // 获取该工作表内的行数   
                     int rows = sheets[i].getRows();   
                     // 遍历行   
                     for (int j=0;j<rows;j++) {   
                     	String cell ="";
                         // 获取当前行的所有单元格   
                         Cell[] cells = sheets[i].getRow(j);   
                         if (cells != null && cells.length != 0) {   
                             // 遍历单元格   
                             for (int k=0;k<cells.length;k++) {   
                                 // 获取当前单元格的值   
                             	if(!cells[k].getContents().equals("")){
                             		cell += cells[k].getContents();   
                             	}
                                 // 缩进   
                                 sb.append(cell + "\t");   
                             }   
                             System.out.println(cell);
                             sb.append("\t\n");   
                         }   
                     }   
                     sb.append("\t\n");   
                 }   
             }   
             System.out.println("成功读取了：" +is.getName()+ "\n");   
         }   
     } catch (Exception e) {   
         e.printStackTrace();
     } finally {   
     	//关闭
         wb.close();   
     }   
	}
	/**
	 * 
	 * 这是单纯的写EXCEL表格
	 * **/
	private void write(){
		WritableWorkbook wwb = null;   
     Label label = null;   
     String file ="test1.xls";
     try {   
         // 创建可写入的工作簿对象   
         wwb = Workbook.createWorkbook(new File(file));   
         if (wwb != null) {   
             // 在工作簿里创建可写入的工作表，第一个参数为工作表名，第二个参数为该工作表的所在位置 
         	WritableSheet ws = wwb.createSheet("Sheet4", 2);   
             if (ws != null) {   
                 /* 添加表结构 */  
                 // 行   
                 for (int i=0;i<5;i++) {   
                     // 列   
                     for (int j=0;j<5;j++) {   
                         // Label构造器中有三个参数，第一个为列，第二个为行，第三个则为单元格填充的内容   
                         label = new Label(j, i, "第"+(i+1)+"行，" + "第"+(j+1)+"列");   
                         // 将被写入数据的单元格添加到工作表   
                         ws.addCell(label);   
                     }   
                 }   
                 // 从内存中写入到文件   
                 wwb.write();   
             }   
             System.out.println("路径为：" + file + "的工作簿写入数据成功！");   
         }   
     } catch (Exception e) {   
         System.out.println(e.getMessage());   
     } finally {   
         try { 
				wwb.close();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}   
     }   
	}
	
	/**
	 * 
	 * 这个是读取模板写入数据
	 * **/
	private void readWriter(){
		WritableWorkbook wwb=null;
		WritableSheet wws=null;
		FileOutputStream out =null;
		
		//获取要读取的EXCEL表格模板
		File is = new File("E:\\综合管理站点需求（互联网用户管理中心）.xls");
     String filename="E:\\";
     //写入到新的表格里
     File f=new File(filename,"try1.xls");
     try {
     	//创建新文件
     	f.createNewFile();
     	out = new FileOutputStream(f);
     	//获取工作簿对象   
			Workbook wb = Workbook.getWorkbook(is);
			// 创建可写入的工作簿对象  
			wwb = Workbook.createWorkbook(out, wb);
			//根据工作表名获取WritableSheet对象
			wws=wwb.getSheet("固化报表需求");
			//这个是链接数据库的一个对象
			//CopyUser cp=new CopyUser();
			//获取connection
			//conn=cp.getMYConnection();
			//创建Statement
			//st=conn.createStatement();
			WritableCellFormat wcf=new WritableCellFormat(); 
			//设置样式
			wcf.setBorder(jxl.format.Border.ALL,jxl.format.BorderLineStyle.THIN); 
			//mySQLRS=st.executeQuery("select name,officeName from mix_end_user where officeName like '河南%' ");
			Label label=null;
			List<String> list=new ArrayList<String>();
			
			int count_02=0;
			
			for(int i=4;i<6;i++){
				for(int j=1;j<7;j++){
					//创建label对象设置value值j相当于是X轴I是Y轴位置
					label= new Label(j,i,"测试",wcf);
					//添加到工作薄中
					wws.addCell(label);
					count_02++;
				}
			}
			
			//将新建立的工作薄写入到磁盘
			wwb.write();
     } catch (Exception e) {
			e.printStackTrace();
		} finally{
			//关闭流
			try {
				wwb.close();
				out.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new ExcelMain().write();
		new ExcelMain().read();
		//new ExcelMain().readWriter();
	}
}