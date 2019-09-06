package randomgener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Random;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class randomGen {
	static int noOfRows=0;
	static int order_id; 
	String order_category;
	static int quantity;
	String order_type;
	String all_none;
	double price;	
	public randomGen() {	
		Random r =new Random();
		double marketPrice=250;	
		++ order_id;
		boolean b = r.nextBoolean();
		if(b){
			this.order_category = "buy";
		}	
		else {
			this.order_category = "sell";
		}
		
		int maxq =500;
		int minq =5;
		this.quantity = (int) (Math.floor(Math.random() * (maxq - minq + 1)) + minq);
		
		int maxt = 11;
		int mint =1;
		int type = (int) (Math.floor(Math.random() * (maxt - mint + 1)) + mint);
		if(type < 11){
			this.order_type = "limit";
			if((int) (Math.floor(Math.random() * (maxt - mint + 1)) + mint)<11){
				this.all_none = "full";
			}	
			else {
				this.all_none = "partial";
			}
			
			}	
		else {
			this.order_type = "market";
		}
		
		if(order_type.equals("market"))
		{
			price =0;
		}
		else {
			
			if(order_category.equals("buy")) {
				double low = 0.90 * marketPrice;
				double high = 1.02 * marketPrice;
				double range = (high - low) + 1;     
				price=(int)((Math.random() * range) + low);  
				high=20;
				low=1;
				double tick = price+(((int)(Math.random()*(high - low) + 1) +low) * 0.05);
				price = tick;
			}
			else if(order_category.equals("sell")) {
				double low = 0.98 * marketPrice;
				double high = 1.10 * marketPrice;
				double range = (high - low) + 1;     
				price=(int)((Math.random() * range) + low);  
				high=20;
				low=1;
				double tick = price+(((int)(Math.random()*(high - low) + 1) +low) * 0.05);
				price = tick;
			}
		}
	}
	public static void setOrder_no(int order_id) {
		randomGen.order_id = order_id;
	}
	
	public String getOrder_category() {
		return order_category;
	}
	
	public String getOrder_type() {
		return order_type;
	}

	public String getAll_none() {
		return all_none;
	}
	public double getPrice() {
		return price;
	}
	public String getBuy_sell() {
		return order_category;
	}

	public static int getQty() {
		return quantity;
	}

	public static int getOrder_id() {
		return order_id;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Workbook wb = null; 
		Sheet sh = null;
		FileInputStream fis = null;
			Connection con;
			try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loaded successfully");
			con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","abcd123");
            System.out.println("Connection done");
            FileOutputStream out = new FileOutputStream("./orders.xlsx");
            out.close();
		fis= new FileInputStream("./orders.xlsx");
			System.out.println(fis.getFD());
			wb = WorkbookFactory.create(fis);
			fis.close();
			fis=null;
			 Row row;
			 Cell cell;
			sh = wb.getSheet("Sheet1");
		PreparedStatement ps1 =con.prepareStatement("delete from orders");
	    ps1.executeUpdate();
	        row = sh.createRow(0);
	        cell= row.createCell(0);
	        cell.setCellValue("order_id");
	        cell=row.createCell(1);
	   		cell.setCellValue("Qty");
	   		cell=row.createCell(2);
	   		cell.setCellValue("Order_type");
	   		cell=row.createCell(3);
	   		cell.setCellValue("Buy_sell");
	   		cell=row.createCell(4);
	   		cell.setCellValue("All_none");
	   		cell=row.createCell(5);
	   		cell.setCellValue("Price");
	   		cell=row.createCell(6);	
	   		cell.setCellValue("Time");

for(int i=0;i<3000;i++) {
		
	randomGen rg = new randomGen();	
	row = sh.createRow(++noOfRows);
	cell=row.createCell(0);
	cell.setCellValue(rg.getOrder_id());
	cell=row.createCell(1);
	cell.setCellValue(rg.getQty());
	cell=row.createCell(2);
	cell.setCellValue(rg.getOrder_type());
	cell=row.createCell(3);
	cell.setCellValue(rg.getBuy_sell());
	cell=row.createCell(4);
	cell.setCellValue(rg.getAll_none());
	cell=row.createCell(5);
	cell.setCellValue(rg.getPrice());
	cell=row.createCell(6);
	cell.setCellValue((new Timestamp(System.currentTimeMillis())).toString());
		
	FileOutputStream fos = new FileOutputStream("./orders.xlsx");
	wb.write(fos);
	fos.flush();
	fos.close();
	fos=null; 
	System.out.println(i);

	if (i%15 == 0)
		Thread.sleep(2000);
	
		}
			}catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (EncryptedDocumentException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

}
	}
