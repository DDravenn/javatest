package control;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;

import sql.connectSQL;

public class hisdata {
	// 得到数据库表数据
			public static Vector getRows() throws PropertyVetoException, SQLException{
				Connection con;
				connectSQL source = new connectSQL();
		        con = connectSQL.getCon();
				PreparedStatement preparedStatement = null;
		 
				Vector rows = null;
				Vector columnHeads = null;
				
				try {
					preparedStatement = con.prepareStatement("select * from BUYticket");
					ResultSet result1 = preparedStatement.executeQuery();
					
					if(result1.wasNull())
						JOptionPane.showMessageDialog(null, "结果集中无记录");
					
					rows = new Vector();
					
					ResultSetMetaData rsmd = result1.getMetaData();
							
					while(result1.next()){
						rows.addElement(getNextRow(result1,rsmd));
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return rows;
			}

			// 得到数据库表头
			public static Vector getHead() throws PropertyVetoException, SQLException{
				Connection con;
				connectSQL source = new connectSQL();
		        con = connectSQL.getCon();
				PreparedStatement preparedStatement = null;
		 
				Vector columnHeads = null;
				
				try {
					preparedStatement = con.prepareStatement("select * from BUYticket");
					ResultSet result1 = preparedStatement.executeQuery();
					
					boolean moreRecords = result1.next();
					if(!moreRecords)
						JOptionPane.showMessageDialog(null, "结果集中无记录");
					
					columnHeads = new Vector();
					ResultSetMetaData rsmd = result1.getMetaData();
					for(int i = 1; i <= rsmd.getColumnCount(); i++)
						columnHeads.addElement(rsmd.getColumnName(i));
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("未成功加载驱动。");
					e.printStackTrace();
				}
				return columnHeads;
			}
			
			// 得到数据库中下一行数据
			private static Vector getNextRow(ResultSet rs,ResultSetMetaData rsmd) throws SQLException{
				Vector currentRow = new Vector();
				for(int i = 1; i <= rsmd.getColumnCount(); i++){
//					currentRow.addElement(rs.getString(i));
					currentRow.add(rs.getString(i));
				}
				return currentRow;
			}

	}

