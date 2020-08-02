package hg.wzz.main.gui;

import hg.wzz.main.service.DbUtil;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class JiaoWuYuanJieMian extends JFrame {
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JTable able;
	private JTable table;
	private JScrollPane scrollPane;
	private JScrollPane anotherScrollPane;

	public JButton getB1() {
		return b1;
	}

	public JButton getB2() {
		return b2;
	}

	public JButton getB3() {
		return b3;
	}

	public JiaoWuYuanJieMian() {
		setBounds(1, 1, 700, 600);
		setTitle("教务员管理界面");
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		b1 = new JButton("用户管理");
		b1.setBounds(0, 0, 100, 300);

		b2 = new JButton("申请单管理");
		b2.setBounds(0, 300, 100, 300);

		b3 = new JButton("新增");
		b3.setBounds(120, 10, 100, 30);

		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String column[] = {"id", "name", "role", "phone"};
				String[][] tableValue = new String[70][column.length];
				Connection connection = DbUtil.getConnection();
				String sql = "select * from personnel where id != ?";
				PreparedStatement preparedStatement = null;
				try {
					//获取sql执行器
					preparedStatement = connection.prepareStatement(sql);
					// 给问号赋值

					preparedStatement.setString(1, "0");

					//执行sql
					ResultSet resultSet = preparedStatement.executeQuery();
					label:	for(int i = 0 ; i < 10 ; i ++){
						for( int j = 0 ;  j <= 0 ; j ++){
							if(resultSet.next()) {
								tableValue[i][j] = resultSet.getString("id");
								tableValue[i][j+1] = resultSet.getString("name");
								tableValue[i][j+2] = resultSet.getString("role");
								tableValue[i][j+3] = resultSet.getString("phone");
							}else{
								break label;
							}
						}
					}
					able = new JTable(tableValue, column);
					scrollPane = new JScrollPane(able);
					scrollPane.setBounds(120, 60, 500, 600);
					add(scrollPane);
				} catch (SQLException throwables) {
					throwables.printStackTrace();
				}
			}
		});

		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String colum[] = {"id", "name", "subject", "time"};
				String[][] tableVal = new String[70][colum.length];
				Connection connection = DbUtil.getConnection();
				String sql = "select * from teacher where id != ?";
				PreparedStatement preparedStatement = null;
				try {
					//获取sql执行器
					preparedStatement = connection.prepareStatement(sql);
					// 给问号赋值

					preparedStatement.setString(1, "0");

					//执行sql
					ResultSet resultSet = preparedStatement.executeQuery();
					label:	for(int i = 0 ; i < 10 ; i ++){
						for( int j = 0 ;  j <= 0 ; j ++){
							if(resultSet.next()) {
								tableVal[i][j] = resultSet.getString("id");
								tableVal[i][j+1] = resultSet.getString("name");
								tableVal[i][j+2] = resultSet.getString("subject");
								tableVal[i][j+3] = resultSet.getString("time");
							}else{
								break label;
							}
						}
					}
					table = new JTable(tableVal, colum);
					anotherScrollPane = new JScrollPane(table);
					anotherScrollPane.setBounds(120, 60, 500, 600);
					add(anotherScrollPane);
				} catch (SQLException throwables) {
					throwables.printStackTrace();
				}
			}
		});



		add(b1);
		add(b2);
		add(b3);

	}
}
