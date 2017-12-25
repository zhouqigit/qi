package examples;

import java.io.File;  
import java.io.FileInputStream;  
import java.io.InputStream;
import java.sql.ResultSet;

import jxl.Sheet;  
import jxl.Workbook;  

public class ExcelExample {
	
	public static void main(String[] args) {  
        // 此处为我创建Excel路径：E:/zhanhj/studysrc/jxl下  C:\Users\THINK\Desktop\顺丰全国四级地址库信息.xlsx
        File file = new File("C:/Users/THINK/Desktop/area.xls");  
        readExcel3(file);  
    }  
	
	public static void readExcel3(File file) {  
		JDBCexample jdbCexample=JDBCexample.getJDBCexample();
        try {  
            // 创建输入流，读取Excel  
            InputStream is = new FileInputStream(file.getAbsolutePath());  
            // jxl提供的Workbook类  
            Workbook wb = Workbook.getWorkbook(is);  
            // Excel的页签数量  
            int sheet_size = wb.getNumberOfSheets();  
            for (int index = 0; index < sheet_size; index++) {  
                // 每个页签创建一个Sheet对象  
                Sheet sheet = wb.getSheet(index);  
                // sheet.getRows()返回该页的总行数  
                for (int i = 1; i < sheet.getRows(); i++) {  
                    // sheet.getColumns()返回该页的总列数  
//                    for (int j = 0; j < sheet.getColumns(); j++) {  
//                    }  
                	String s=sheet.getCell(1, i).getContents();
                	String city=sheet.getCell(2, i).getContents();
                	String q=sheet.getCell(4, i).getContents();
                	String z=sheet.getCell(5, i).getContents();
                	String isok=sheet.getCell(6, i).getContents();
                	if(null==isok || "".equals(isok)){
                		isok="1";
                	}else{
                		isok="0";
                	}
//                	/*
                	//获取当前省份
                	String sql = "select * from area where area_name='"+s+"' and grade=1 limit 0,1";
                	ResultSet rs=jdbCexample.select(sql);
                	String area_name = null; 
                	String id = null; 
        			while(rs.next()) {
        				//选择sname这列数据
        				area_name = rs.getString("area_name");
        				id = rs.getString("id");
        			}
        			if(null==area_name){
        				continue;
        			}
        			//获取市
        			String sql1 = "select * from area where area_name='"+city+"' and grade=2 and parent_id="+id+" limit 0,1";
                	ResultSet rs1=jdbCexample.select(sql1);
                	String area_name1 = null; 
                	String id1 = null; 
        			while(rs1.next()) {
        				//选择sname这列数据
        				area_name1 = rs1.getString("area_name");
        				id1 = rs1.getString("id");
        			}
        			if(null==area_name1){
        				continue;
        			}
        			
        			//获取区
        			if(null==q || "".equals(q)){
        				continue;
        			}
        			String sql2 = "select * from area where area_name='"+q+"' and grade=3 and parent_id="+id1+" limit 0,1";
                	ResultSet rs2=jdbCexample.select(sql2);
                	String area_name2 = null; 
                	String parents2 = null; 
                	String id2 = null; 
        			while(rs2.next()) {
        				//选择sname这列数据
        				area_name2 = rs2.getString("area_name");
        				parents2 = rs2.getString("parents");
        				id2 = rs2.getString("id");
        			}
        			
        			if(null==area_name2){
        				continue;
        			}
        			
        			//获取镇/街道
        			if(null==z || "".equals(z)){
        				continue;
        			}
        			String sql3 = "select * from area where area_name='"+z+"' and grade=4 and parent_id="+id2+" limit 0,1";
                	ResultSet rs3=jdbCexample.select(sql3);
                	String area_name3 = null; 
        			while(rs3.next()) {
        				//选择sname这列数据
        				area_name3 = rs3.getString("area_name");
        			}
        			
                	if(null==area_name3 || "".equals(area_name3)){
                		System.out.println(222);
                		jdbCexample.save("insert into area (area_name,parent_id,parents,grade,isok) value('"+z+"',"+id2+",'"+parents2+","+id2+"',4,"+isok+")");
                		continue;
                	}else{
                		
                	}
                	
//                	 */ 
                } 
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }
    }
	
	public static void readExcel2(File file) {  
		JDBCexample jdbCexample=JDBCexample.getJDBCexample();
        try {  
            // 创建输入流，读取Excel  
            InputStream is = new FileInputStream(file.getAbsolutePath());  
            // jxl提供的Workbook类  
            Workbook wb = Workbook.getWorkbook(is);  
            // Excel的页签数量  
            int sheet_size = wb.getNumberOfSheets();  
            for (int index = 0; index < sheet_size; index++) {  
                // 每个页签创建一个Sheet对象  
                Sheet sheet = wb.getSheet(index);  
                // sheet.getRows()返回该页的总行数  
                for (int i = 1; i < sheet.getRows(); i++) {  
                    // sheet.getColumns()返回该页的总列数  
//                    for (int j = 0; j < sheet.getColumns(); j++) {  
//                    }  
                	String s=sheet.getCell(1, i).getContents();
                	String city=sheet.getCell(2, i).getContents();
                	String q=sheet.getCell(4, i).getContents();
                	String isok=sheet.getCell(6, i).getContents();
                	if(null==isok || "".equals(isok)){
                		isok="1";
                	}else{
                		isok="0";
                	}
//                	/*
                	//获取当前省份
                	String sql = "select * from area where area_name='"+s+"' and grade=1 limit 0,1";
                	ResultSet rs=jdbCexample.select(sql);
                	String area_name = null; 
                	String id = null; 
        			while(rs.next()) {
        				//选择sname这列数据
        				area_name = rs.getString("area_name");
        				id = rs.getString("id");
        			}
        			if(null==area_name){
        				continue;
        			}
        			//获取市
        			String sql1 = "select * from area where area_name='"+city+"' and grade=2 and parent_id="+id+" limit 0,1";
                	ResultSet rs1=jdbCexample.select(sql1);
                	String area_name1 = null; 
                	String parents1 = null; 
                	String id1 = null; 
        			while(rs1.next()) {
        				//选择sname这列数据
        				area_name1 = rs1.getString("area_name");
        				parents1 = rs1.getString("parents");
        				id1 = rs1.getString("id");
        			}
        			if(null==area_name1){
        				continue;
        			}
        			
        			//获取区
        			if(null==q || "".equals(q)){
        				continue;
        			}
        			String sql2 = "select * from area where area_name='"+q+"' and grade=3 and parent_id="+id1+" limit 0,1";
                	ResultSet rs2=jdbCexample.select(sql2);
                	String area_name2 = null; 
        			while(rs2.next()) {
        				//选择sname这列数据
        				area_name2 = rs2.getString("area_name");
        			}
        			
                	if(null==area_name2 || "".equals(area_name2)){
                		System.out.println(222);
                		jdbCexample.save("insert into area (area_name,parent_id,parents,grade,isok) value('"+q+"',"+id1+",'"+parents1+","+id1+"',3,"+isok+")");
                		continue;
                	}else{
                		
                	}
                	
//                	 */ 
                } 
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }
    }
	
	public static void readExcel1(File file) {  
		JDBCexample jdbCexample=JDBCexample.getJDBCexample();
        try {  
            // 创建输入流，读取Excel  
            InputStream is = new FileInputStream(file.getAbsolutePath());  
            // jxl提供的Workbook类  
            Workbook wb = Workbook.getWorkbook(is);  
            // Excel的页签数量  
            int sheet_size = wb.getNumberOfSheets();  
            for (int index = 0; index < sheet_size; index++) {  
                // 每个页签创建一个Sheet对象  
                Sheet sheet = wb.getSheet(index);  
                // sheet.getRows()返回该页的总行数  
                for (int i = 1; i < sheet.getRows(); i++) {  
                    // sheet.getColumns()返回该页的总列数  
//                    for (int j = 0; j < sheet.getColumns(); j++) {  
//                    }  
                	String s=sheet.getCell(1, i).getContents();
                	String city=sheet.getCell(2, i).getContents();
                	String isok=sheet.getCell(6, i).getContents();
                	if(null==isok || "".equals(isok)){
                		isok="1";
                	}else{
                		isok="0";
                	}
//                	/*
                	//获取当前省份
                	String sql = "select * from area where area_name='"+s+"' and grade=1 limit 0,1";
                	ResultSet rs=jdbCexample.select(sql);
                	String area_name = null; 
                	String parent_id = null;
                	String id = null; 
        			while(rs.next()) {
        				//选择sname这列数据
        				area_name = rs.getString("area_name");
        				parent_id = rs.getString("parent_id");
        				id = rs.getString("id");
        			}
        			if(null==area_name){
        				continue;
        			}
        			//获取市
        			String sql1 = "select * from area where area_name='"+city+"' and grade=2 and parent_id="+id+" limit 0,1";
                	ResultSet rs1=jdbCexample.select(sql1);
                	String area_name1 = null; 
        			while(rs1.next()) {
        				//选择sname这列数据
        				area_name1 = rs1.getString("area_name");
        			}
        			
                	if(null==area_name1 || "".equals(area_name1)){
                		System.out.println(222);
                		jdbCexample.save("insert into area (area_name,parent_id,parents,grade,isok) value('"+city+"',"+id+",'"+parent_id+","+id+"',2,"+isok+")");
                		continue;
                	}else{
                		
                	}
                	
//                	 */ 
                } 
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }
    } 
	
	public static void readExcel(File file) {  
		JDBCexample jdbCexample=JDBCexample.getJDBCexample();
        try {  
            // 创建输入流，读取Excel  
            InputStream is = new FileInputStream(file.getAbsolutePath());  
            // jxl提供的Workbook类  
            Workbook wb = Workbook.getWorkbook(is);  
            // Excel的页签数量  
            int sheet_size = wb.getNumberOfSheets();  
            for (int index = 0; index < sheet_size; index++) {  
                // 每个页签创建一个Sheet对象  
                Sheet sheet = wb.getSheet(index);  
                // sheet.getRows()返回该页的总行数  
                for (int i = 1; i < sheet.getRows(); i++) {  
                    // sheet.getColumns()返回该页的总列数  
//                    for (int j = 0; j < sheet.getColumns(); j++) {  
//                    }  
                	String s=sheet.getCell(1, i).getContents();
                	String isok=sheet.getCell(6, i).getContents();
                	if(null==isok || "".equals(isok)){
                		isok="1";
                	}else{
                		isok="0";
                	}
//                	/*
                	String sql = "select * from area where area_name='"+s+"' and grade=1 limit 0,1";
                	ResultSet rs=jdbCexample.select(sql);
                	String area_name = null; 
        			while(rs.next()) {
        				//选择sname这列数据
        				area_name = rs.getString("area_name");
        			}
                	if(null==area_name || "".equals(area_name)){
                		System.out.println(222);
                		jdbCexample.save("insert into area (area_name,parent_id,parents,grade,isok) value('"+s+"',7,'7',1,"+isok+")");
                		continue;
                	}else{
                		
                	}
                	
//                	 */ 
                } 
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }
    } 

}
