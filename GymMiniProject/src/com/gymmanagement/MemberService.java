package com.gymmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MemberService {
	
	private String name;
	private String course;
	private String dob;
	private String email;
	private String creationDate;
	private String age;
	private String phone;
	private String weight;
	private String trainer;
	
	Scanner sc2=new Scanner(System.in);
	Scanner sc3=new Scanner(System.in);
	Scanner sc4=new Scanner(System.in);
	Scanner sc1=new Scanner(System.in);
	Scanner sc5=new Scanner(System.in);
	Scanner sc6=new Scanner(System.in);
	
	PreparedStatement ps_mins=null,ps_del=null,ps_upd=null,ps_sel=null,ps_ser=null,ps_btw=null,ps_lins,ps_delm=null;
	Connection con = null;
	ResultSet rs = null;
	//add members
	//delete member
	//update members
	//display members
	public void memberMenu() {
		
		System.out.println();
		System.out.println("Please Select your prefered option"); // operation for Members
		System.out.println();
		System.out.println("1.Add Members");
		System.out.println("2.Delete member");
		System.out.println("3.Update Memeber");
		System.out.println("4.Display Member");
		System.out.println("5.Search Member");												//no Error
		System.out.println("6.Filter Members");
		System.out.println("7.Log Members Workout");
		System.out.println();
		int choice = sc2.nextInt();

		switch (choice) {
		case 1:
			
			addMembers();
			

			break;

		case 2:
			
			removeMembers();
			break;

		case 3:
			updateMembers();
			
			break;

		case 4:

			displayMembers();
				break;
		
		case 5:
			
			searchMember();
			
				break;
						
		case 6:
			
			filterMember();
			break;
			
		case 7:
			workoutHistory();
					break;
				}
	}
	
	public void addMembers()  {
		
		
			try {
				
				con=JDBCHelper.getConnection();
				if(con!=null) {
				ps_mins = con.prepareStatement(
							"insert into member(Phone,Name,Email,dob,CreatedDate,Age,Weight,Course,Trainer) values(?,?,?,?,?,?,?,?,?)");
					
				System.out.println("Enter the name");
				String name = sc3.nextLine();
				System.out.println("Please enter the email  of " + name);
				String email = sc3.nextLine();
				System.out.println("enter the date of birth of (dd/mm/yyyy) " + name);
				String dob = sc3.nextLine();

				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				java.util.Date dt = sdf.parse(dob);																//no Error
				java.sql.Date dbDt = new java.sql.Date(dt.getTime());

				System.out.println("Enter the Registration date, (dd/mm/yyyy) " + name);
				String creationDate = sc3.nextLine();
				java.util.Date crtdt = sdf.parse(creationDate);
				java.sql.Date dbcrtDate = new java.sql.Date(crtdt.getTime());

				System.out.println("Enter your Age");
				String age = sc3.nextLine();

				System.out.println("Enter your Weight");
				String weight = sc3.nextLine();
				

				System.out.println("Enter your Phone Number");
				String phone = sc4.nextLine();
				
				System.out.println("Enter your Trainer Phone Number");
				String trainer = sc4.nextLine();

				System.out.println("Courses Available");
				System.out.println("\n1.Weight Training\n2.Zumba Dance\n3.Full Body Workouts\n4.Cardio");
				System.out.println("Choose your Workout Plan");
				int coursevalue = sc4.nextInt();
				
				switch(coursevalue) {
				
				case 1:
				course="Weight Training";
				ps_mins.setString(1,phone);
				ps_mins.setString(2,name);
				ps_mins.setString(3,email);
				ps_mins.setDate(4, dbDt);
				ps_mins.setDate(5, dbcrtDate);
				ps_mins.setString(6, age);
				ps_mins.setString(7, weight);
				ps_mins.setString(8, course);
				ps_mins.setString(9, trainer);
				ps_mins.execute();
				System.out.println("Details saved successfully.........");
				break;
			case 2:
				course="Zumba Dance";
				ps_mins.setString(1,phone);
				ps_mins.setString(2,name);
				ps_mins.setString(3,email);
				ps_mins.setDate(4, dbDt);
				ps_mins.setDate(5, dbcrtDate);
				ps_mins.setString(6, age);
				ps_mins.setString(7, weight);
				ps_mins.setString(8, course);
				ps_mins.setString(9, trainer);
				ps_mins.execute();
				System.out.println("Details saved successfully.........");
				break;
			case 3:
				course="Full Body Workouts";
				ps_mins.setString(1,phone);
				ps_mins.setString(2,name);
				ps_mins.setString(3,email);
				ps_mins.setDate(4, dbDt);
				ps_mins.setDate(5, dbcrtDate);
				ps_mins.setString(6, age);
				ps_mins.setString(7, weight);
				ps_mins.setString(8, course);
				ps_mins.setString(9, trainer);
				ps_mins.execute();
				System.out.println("Details saved successfully.........");
				break;
			case 4:
				course="Cardio";
				ps_mins.setString(1,phone);
				ps_mins.setString(2,name);
				ps_mins.setString(3,email);
				ps_mins.setDate(4, dbDt);
				ps_mins.setDate(5, dbcrtDate);
				ps_mins.setString(6, age);
				ps_mins.setString(7, weight);
				ps_mins.setString(8, course);
				ps_mins.setString(9, trainer);
				ps_mins.execute();
				System.out.println("Details saved successfully.........");
				break;
				}
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
			}
			
	}
	
	public void removeMembers() {
																			//no Error
		
		try {
			
			con=JDBCHelper.getConnection();
			if(con!=null) {
			System.out.println("Enter the member number which you want to delete");
			String number = sc3.nextLine();
			ps_delm = con.prepareStatement("delete from Workout where phone=?");
			ps_delm.setString(1, number);
			ps_delm.execute();
			ps_del = con.prepareStatement("delete from Member where phone=?");
			System.out.println("Confirm the member number which you want to delete");
			String tnumber = sc3.nextLine();
			ps_del.setString(1, tnumber);
			ps_del.execute();
			System.out.println("Member deleted successfully.........");
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
	
	public void updateMembers() {
		try {
			
			con=JDBCHelper.getConnection();
			if(con!=null) {
			ps_upd = con
					.prepareStatement("update member set name=?, email=? where name=?");
			System.out.println("Enter the member name which you want to update");
			String name = sc4.nextLine();
																								// No Error
			System.out.println("Enter the new name");
			String nwname = sc3.nextLine();
			System.out.println("enter the type of new email ");
			String nwemail = sc3.nextLine();
			ps_upd.setString(1, nwname);
			ps_upd.setString(2, nwemail);
			ps_upd.setString(3, name);
			
			ps_upd.execute();
			System.out.println("Member updated successfully.........");
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
	
	public void displayMembers() {
		
			try {
				
				con=JDBCHelper.getConnection();
				if(con!=null) {
				System.out.println();
				System.out.println("choose from the options");
				System.out.println();
				System.out.println("1.Sort by Name");
				System.out.println("2.Sort by Date of Birth");								//no Error
				System.out.println("3.Sort by Registration date");
				System.out.println("4.Sort by Age(Data-Structure)");
				int c = sc1.nextInt();

				switch (c) {

				case 1:
					
				ps_sel = con.prepareStatement(
						"select * from Member inner join Trainer on Member.trainer= Trainer.phone order by name");
				System.out.println("--------------------MEMBERS DETAILS--------------------");
				System.out.println();
				ps_sel.execute();
				rs = ps_sel.getResultSet();
				

				while (rs.next()) {
					name = rs.getString("name");
					email = rs.getString("email");										//no Error
					dob = rs.getString("dob");
					creationDate = rs.getString("createdDate");
					age = rs.getString("age");
					weight = rs.getString("weight");
					course = rs.getString("course");
					phone = rs.getString("phone");
					trainer=rs.getString("trainername");

					
					System.out.println();
					System.out.println("Name : " + name + "\temail : " + email + "\tdob: " + dob
							+ "\tcontact creationDate " + creationDate + "\tage: " + age + "\tweight: "+weight+"\tCourse:"+course
							+"\tPhone:"+phone+"\tTrainer Name:"+trainer
							);
				}
				break;

			case 2:
				ps_sel = con.prepareStatement(
						"select * from Member inner join Trainer on Member.trainer= Trainer.phone order by name");
				
				System.out.println("--------------------MEMBERS DETAILS--------------------");
				System.out.println();
				ps_sel.execute();
				rs = ps_sel.getResultSet();
				

				while (rs.next()) {
					name = rs.getString("name");
					email = rs.getString("email");
					dob = rs.getString("dob");
					creationDate = rs.getString("createdDate");
					age = rs.getString("age");
					weight = rs.getString("weight");									//no Error
					course = rs.getString("course");
					phone = rs.getString("phone");
					trainer=rs.getString("trainername");

					
					System.out.println();
					System.out.println("Name : " + name + "\temail : " + email + "\tdob: " + dob
							+ "\tcontact creationDate " + creationDate + "\tage: " + age + "\tweight: "+weight+"\tCourse:"+course
							+"\tPhone:"+phone+"\tTrainer Name:"+trainer
							);
				}
				break;
				
			case 3:

				ps_sel = con.prepareStatement(
						"select * from Member inner join Trainer on Member.trainer= Trainer.phone order by name");
				
				System.out.println("--------------------MEMBERS DETAILS--------------------");
				System.out.println();
				
				ps_sel.execute();
				rs = ps_sel.getResultSet();
				
				
				while (rs.next()) {
					name = rs.getString("name");
					email = rs.getString("email");
					dob = rs.getString("dob");
					creationDate = rs.getString("createdDate");
					age = rs.getString("age");
					weight = rs.getString("weight");								//no Error
					course = rs.getString("course");
					phone = rs.getString("phone");
					trainer=rs.getString("trainername");

					
					System.out.println();
					System.out.println("Name : " + name + "\temail : " + email + "\tdob: " + dob
							+ "\tcontact creationDate " + creationDate + "\tage: " + age + "\tweight: "+weight+"\tCourse:"+course
							+"\tPhone:"+phone+"\tTraine namer:"+trainer
							);
				}
				break;
				
			case 4:
				
				ps_sel = con.prepareStatement(
						"select age from Member ");
									//no Error
			
				ps_sel.execute();
				rs = ps_sel.getResultSet();
				ArrayList<String> ages = new ArrayList<String>();
				
				
				

				while (rs.next()) {
					age = rs.getString("age");
					ages.add(age);
					}
				
				Collections.sort(ages);
				
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
				JDBCHelper.close(ps_ser);
			}
			
	}
	
	public void searchMember() {
		
		try {
			
			con=JDBCHelper.getConnection();
			if(con!=null) {
			ps_ser=con.prepareStatement("SELECT * FROM Member WHERE name=?");
			System.out.println("Enter the name you want to search");
			name=sc4.nextLine();
			ps_ser.setString(1,name);
			ps_ser.execute();
			
			rs=ps_ser.getResultSet();
			while (rs.next()) {
				name = rs.getString("name");
				email = rs.getString("email");
				dob = rs.getString("dob");
				creationDate = rs.getString("createdDate");
				age = rs.getString("age");
				weight = rs.getString("weight");								//no Error
				course = rs.getString("course");
				phone = rs.getString("phone");
				trainer=rs.getString("trainer");
				

				System.out.println();
				System.out.println("Name : " + name + "\temail : " + email + "\tdob: " + dob
						+ "\tcontact creationDate " + creationDate + "\tage: " + age + "\tweight: "+weight+"\tCourse:"+course
						+"\tPhone:"+phone+"\tTrainer:"+trainer
						);
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
			JDBCHelper.close(ps_ser);
		}
		
	}
	public void filterMember()  {
		try {
			
			con=JDBCHelper.getConnection();
			if(con!=null) {
			ps_btw=con.prepareStatement("SELECT * FROM Member WHERE age BETWEEN ? AND ?");
			System.out.println("Enter the ages you want to filter");
			String from=sc4.nextLine();
			String to=sc3.nextLine();
			ps_btw.setString(1,from);
			ps_btw.setString(2,to);
			
			ps_btw.execute();
			
			rs=ps_btw.getResultSet();
			while (rs.next()) {
				name = rs.getString("name");
				email = rs.getString("email");
				dob = rs.getString("dob");
				creationDate = rs.getString("createdDate");
				age = rs.getString("age");
				weight = rs.getString("weight");								//no Error
				course = rs.getString("course");
				phone = rs.getString("phone");
				trainer=rs.getString("trainer");

				System.out.println();
				System.out.println("Name : " + name + "\temail : " + email + "\tdob: " + dob
						+ "\tcontact creationDate " + creationDate + "\tage: " + age + "\tweight: "+weight+"\tCourse:"+course
						+"\tPhone:"+phone+"\tTrainer:"+trainer
						);
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
	public void workoutHistory() {
		

			try {
				
				con=JDBCHelper.getConnection();
				if(con!=null) {
				System.out.println("Please select your preferred your option");
				System.out.println();
				System.out.println("1.Add Daily Workout");
				System.out.println("2.Display Logger details");
				int log=sc4.nextInt();
				
				switch(log) {
				case 1:
				ps_lins = con.prepareStatement("insert into Workout(phone,date,remarks) values(?,?,?)");
				System.out.println("Enter the phone Number");
				phone=sc6.nextLine();
				
				System.out.println("Enter date Workout ");
			    String date=sc5.nextLine();
				
				
																						//no Error
				System.out.println("Enter you Workout of the day");
				String remarks=sc5.nextLine();
				
				ps_lins.setString(1,phone);
				ps_lins.setString(2,date);
				ps_lins.setString(3,remarks);
				ps_lins.execute();
				break;
				
				case 2:
					ps_sel = con.prepareStatement(
							"select * from Member inner join Workout on Member.phone= Workout.phone order by name");
					
					System.out.println("--------------------DAILY WORKOUT DETAILS--------------------");
					System.out.println();
					
					ps_sel.execute();
					rs = ps_sel.getResultSet();
					
					while (rs.next()) {
						
						name=rs.getString("name");				//Error
						date = rs.getString("date");
						remarks = rs.getString("remarks");
						

						if(remarks!=null) {
						System.out.println();
						System.out.println("Name:"+name +"\tdate : " + date + "\t Workout : " + remarks
								);
					}
						
				}
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
}
