package hg.wzz.main;

import hg.wzz.main.gui.JiaoWuYuanJieMian;
import hg.wzz.main.gui.Login;
import hg.wzz.main.service.DbUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
         final Login login = new Login();
         login.setVisible(true);
         login.getButton().addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 JTextField userAccount = login.getUserAccount();
                 //获取用户账号的字符串
                 String acc = userAccount.getText();

                 JPasswordField userPassword = login.getUserPassword();
                 //获取用户密码的字符串
                 String password = userPassword.getText();

                 //connection 是数据库的链接
                 Connection connection = DbUtil.getConnection();
                 //下面的sql意思：寻找password和type但得在满足account的条件下
                 String sql = "select password , type from user where account = ? limit 1 ";

                 PreparedStatement preparedStatement = null;
                 try {
                     //获取sql执行器
                     preparedStatement = connection.prepareStatement(sql);
                     // 给问号赋值
                     preparedStatement.setString(1, acc);
                     //执行sql
                     ResultSet resultSet = preparedStatement.executeQuery();
                     //判断密码是否相等
                     if (resultSet.next() && resultSet.getString("password").equals(password)){
                         //密码匹配逻辑
                         //教务员登录界面
                         if(resultSet.getInt("type") == 0){
                             JiaoWuYuanJieMian jiaowuyuanjiemian =  new JiaoWuYuanJieMian();
                             JButton b1 = jiaowuyuanjiemian.getB1();
                             login.setVisible(false);
                             jiaowuyuanjiemian.setVisible(true);
                         }
                         //教师登录界面
                         if(resultSet.getInt("type") == 1){
                             JiaoWuYuanJieMian jiaowuyuanjiemian = new JiaoWuYuanJieMian();

                             login.setVisible(false);
                             jiaowuyuanjiemian.setVisible(true);
                         }
                         //学生登录界面
                         if(resultSet.getInt("type") == 2){
                             new JiaoWuYuanJieMian();
                             login.setVisible(false);
                         }
                     } else {
                         System.out.println("密码错误请重新输入");
                         userAccount.setText("");
                         userPassword.setText("");
                     }
                 } catch (SQLException throwables) {
                     throwables.printStackTrace();
                 }




                 /**
                  * 2.截取账号数据
                  * 3.截取密码数据
                  * 4.将账号数据与数据库中的账号数据比对（要先获得数据库的链接connection，写String sql，再获取sql执行器，给问号赋值，最后执行sql）
                  *     错误 弹框重新输入
                  *     正确 进入管理界面
                  * 5.完成登录
                  */
             }
         });


    }
}
