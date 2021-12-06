package com.gymmanagement;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class TrainerService {
	
	private String name;
	private String email;
	private String phone;
	private String joindate;
	
	
	Connection con = null;
	PreparedStatement ps_tins=null ,ps_del=null,ps_upd=null,ps_sel=null,ps_ser=null;
	ResultSet rs = null;
	
	Scanner sc3= new Scanner(System.in);
	Scanner sc4= new Scanner(System.in);
	Scanner sc1= new Scanner(System.in);
	
	public void trainerMenu() {
		System.out.println("Please Select your prefered option"); // operation for trainer
		System.out.println();
		System.out.println("1.Add Trainer");
		System.out.println("2.Delete Trainer");									
		System.out.println("3.Update Trainer");
		System.out.println("4.Display Trainers");
		System.out.println("5.Search Trainer");
		System.out.println();
		int opt = sc1.nextInt();

		switch (opt) {

		case 1:
			addTrainer();
		
			break;

		case 2:
			removeTrainer();
			
			break;
			

		case 3:
			
			updateTrainer();

			break;

		case 4:
			displayTrainers();
			
				break;
		
			
		case 5:
			
			searchTrainer();
		
			break;

		}	
		

	}
	public void addTrainer() {
		
		
		try {
			con=JDBCHelper.getConnection();
			if(con!=null) {
			ps_tins = con.prepareStatement("insert into trainer(phone,trainername,email,joindate) values(?,?,?,?)");
			System.out.println();
			System.out.println("Enter the name");
			String sname = sc3.nextLine();
			System.out.println("Please enter the email");								//no Error
			String semail = sc3.nextLine();
			System.out.println("Enter the Phone number");
			String sphone = sc3.nextLine();
			System.out.println("Enter the Joining date, (dd/mm/yyyy) ");
			joindate = sc4.nextLine();

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date dt = sdf.parse(joindate);
			java.sql.Date dbDt = new java.sql.Date(dt.getTime());			//converting the java date format to SQL date format,so parse is used

			ps_tins.setString(1, sphone);
			ps_tins.setString(2,sname);
			ps_tins.setString(3,semail);
			ps_tins.setDate(4,dbDt);
			ps_tins.execute();
			System.out.println("Details saved successfully.........");
			}
		} catch (SQLException | ParseException e) {
			// TODO Auto-generated catch block
			try {
				con.rollback();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			JDBCHelper.close(ps_tins);
		}
		
	}
	public void removeTrainer() {
		
		
		try {
			con=JDBCHelper.getConnection();
			if(con!=null) {
			System.out.println("Enter the Trainer name which you want to delete");
			String dname = sc3.nextLine();														//instead of deleting make the trainer as inactive
			ps_del = con.prepareStatement("update Trainer set email=? where trainername=?");
			String state="Inactive";
			ps_del.setString(1, state);
			ps_del.setString(2, dname);
			ps_del.execute();
			System.out.println("Trainer deleted successfully.........");
			System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				con.rollback();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			e.printStackTrace();
		}	finally {
			JDBCHelper.close(ps_del);
		}
		
	}
	
	public void updateTrainer()  {
		
		
		try {
			con=JDBCHelper.getConnection();
			if(con!=null) {
			System.out.println("Enter the trainer name which you want to update");
			String uname = sc4.nextLine();													//update the trainer details
			
			System.out.println("Enter the updated name");
			String nwname = sc4.nextLine();
			System.out.println("enter the updated email");
			String nwemail = sc3.nextLine();
			ps_upd = con.prepareStatement("update Trainer set trainername=?, email=? where trainername=?");
			ps_upd.setString(1, nwname);
			
			ps_upd.setString(2, nwemail);
			ps_upd.setString(3, uname);

			ps_upd.execute();
			System.out.println("Trainer details updated successfully.........");
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				con.rollback();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			JDBCHelper.close(ps_upd);
		}
		
		}
	
	public void displayTrainers() {
			
			try {
				con=JDBCHelper.getConnection();
				if(con!=null) {
				System.out.println();
				System.out.println("choose from the options");									
				System.out.println();
				System.out.println("1.Sort by Name");
				System.out.println("2.Sort by Joining Date");
				int ct = sc1.nextInt(); 

				switch (ct) {
				
				
				case 1:
				ps_sel = con.prepareStatement(
						"select trainername,email,phone,joindate from Trainer order by trainername ASC");
				
				
				System.out.println("--------------------TRAINER DETAILS--------------------");
				System.out.println();															//no Error
				ps_sel.execute();
				rs = ps_sel.getResultSet();
				
				while (rs.next()) {
			
					name = rs.getString("trainername");
					email = rs.getString("email");
					phone = rs.getString("phone");
					joindate = rs.getString("joindate");

					System.out.println("|Name : " + name + "|\temail : " + email + "|\tphone: " + phone
							+ "|\tTrainer Joining date " + joindate+"|");

				}

				break;
			
			case 2:
				
				ps_sel = con.prepareStatement(
						"select trainername,email,phone,joindate from Trainer order by joindate");
				System.out.println("--------------------TRAINER DETAILS--------------------");					
				System.out.println();
				ps_sel.execute();								//void method cannot return the result so to get result rs is used
				rs = ps_sel.getResultSet();
				
				while (rs.next()) {
					name = rs.getString("trainername");
					email = rs.getString("email");
					phone = rs.getString("phone");
					joindate = rs.getString("joindate");

					System.out.println("|Name : " + name + "|\temail : " + email + "|\tphone: " + phone
							+ "|\tTrainer Joining date " + joindate+"|");
				}
				
				break;
				}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				try {
					con.rollback();
				} catch (SQLException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				e.printStackTrace();
			}finally {
				JDBCHelper.close(ps_sel);
			}
	}
	
	public  void searchTrainer()  {
		
		
			
			try {
				
				con=JDBCHelper.getConnection();
				if(con!=null) {
				System.out.println("Enter your preferred option");	
				System.out.println();
				
				System.out.println("1.Search by name\n2.Searching the name");
				int dat=sc3.nextInt();	
				switch(dat) {	
				
			case 1:
				
				ps_ser=con.prepareStatement("SELECT * FROM Trainer WHERE trainername=?");
				System.out.println("Enter the name you want to search");
				name=sc4.nextLine();
				ps_ser.setString(1,name);
				ps_ser.execute();
				
				rs=ps_ser.getResultSet();
			
				while(rs.next()) {
					name = rs.getString("trainername");						//No Error
					email = rs.getString("email");
					phone = rs.getString("phone");
					joindate = rs.getString("joindate");

					System.out.println("Name : " + name + "\temail : " + email + "\tphone: " + phone
							+ "\tTrainer joiningdate " + joindate);
				}
				break;
				
			case 2:
				
					try {
						searchusingdata();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						try {
							con.rollback();
						} catch (SQLException e2) {
							// TODO: handle exception
							e2.printStackTrace();
						}
						e.printStackTrace();
					}
				break;
				}
			
		}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				try {
					con.rollback();
				} catch (SQLException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				e.printStackTrace();
			}
			

}
	public void searchusingdata() throws Exception {
		ps_sel = con.prepareStatement(
				"select trainername,email,phone,joindate from Trainer ");
							//no Error
		System.out.println();
		ps_sel.execute();
		rs = ps_sel.getResultSet();
		System.out.println("Enter the name you want to search");
		String Search=sc4.nextLine();
		
		ArrayList<String> nameList = new ArrayList<String>();

		while (rs.next()) {
			name = rs.getString("trainername");
			email = rs.getString("email");
			phone = rs.getString("phone");
			joindate = rs.getString("joindate");
			
			nameList.add(name);
			nameList.add(email);
			nameList.add(phone);
			nameList.add(joindate);
			
			}
				
	        for (String element:nameList) {
	        	if(element.contains(Search)) {
	        		System.out.println(element+" founded in the repository.......");
	        	}
	        }		
	}
}
