

package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;


public class MySQL
{
	static final String Driver="com.mysql.jdbc.Driver";
	static final String URL="jdbc:mysql://localhost/ICT_Office";
	static final String USER="root";
	static final String PASS="ict";

	  Connection con=null;
	  Statement state=null;
	  ResultSet rs=null;
	  ResultSetMetaData data=null;


        public boolean Connect()
        {
			try
			{
				Class.forName(Driver);
				con=DriverManager.getConnection(URL,USER,PASS);

			}catch(SQLException e)
			{
				JOptionPane.showMessageDialog(null,"Could not connect to Database","Error",JOptionPane.ERROR_MESSAGE);
				return false;
			}
			catch(ClassNotFoundException p)
			{
				JOptionPane.showMessageDialog(null,"Could not load JDBC Driver","Error",JOptionPane.ERROR_MESSAGE);
				return false;
			}

         return true;
		}


		public boolean Table_Insert_Update(String query)
		{

			 try
			 {
				 state=con.createStatement();
				 state.executeUpdate(query);

			 }catch(SQLException e)
			 {
				return false;
			 }

             return true;
		}

    public Vector get_Data(String query)
    {
		int column,loop;
		Vector<String> result=new Vector<String>();

	    try
		{
			state=con.createStatement();
			rs=state.executeQuery(query);
			data=rs.getMetaData();

			column=data.getColumnCount();

			 while(rs.next())
			 {
				 for(loop=1;loop<=column;loop++)
				     result.addElement(rs.getString(loop));
			 }

		}catch(SQLException e)
		{
			//JOptionPane.showMessageDialog(null,"Table name does not exists","Error",JOptionPane.ERROR_MESSAGE);
			return result;
		}

    return result;

	}



public static void main(String args[])
	{
		//MySQL k=new MySQL();
		//if(k.Connect()==true)
		 // System.out.println("Succesfull to connect database");

		 // String s="CREATE TABLE LOGIN (Name varchar(100), Password varchar(100), Role varchar(100),primary key (Name))";
	   // if(kTable_Insert_Update(s))
		   //   System.out.println("Succesfull to crete table");

		    // String t="INSERT INTO LOGIN values('Noman','ict','Owner')";
		     //   if(k.Table_Insert_Update(t))
		      //    System.out.println("Succesfull to insert data");

		    // String n="UPDATE LOGIN set Password='ict' ";
		    //   if(k.Table_Insert_Update(n))
		    //    System.out.println("Succesfull to update data");

              // Vector<String> v=new Vector<String>();
		      // String y="SELECT *from LOGIN";
		      // v=k.get_Data(y);

		         // if(v.size()==0)
		         //    System.out.println("Your given User-Name or Password is not valid");
		         //   else
		         //   {
				//		y=v.get(0);
				//		 if(y.equals("Admin"))
				//		System.out.println(y);


				//	}

	}



}