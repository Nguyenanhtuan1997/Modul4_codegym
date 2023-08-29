package service;

import model.Department;
import model.Staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffService implements IStaffService<Staff> {
  Connection connection = ConnectToMySQL.getConnection();
    @Override
    public void add(Staff staff) {
    String sql = "insert into staff( name, email,salary, address, phoneNumber, idDepartment) values (?,?,?,?,?,?);";
      try {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, staff.getName());
        preparedStatement.setString(2, staff.getEmail());
        preparedStatement.setFloat(3,staff.getSalary());
        preparedStatement.setString(4, staff.getAddress());
        preparedStatement.setInt(5, staff.getPhoneNumber());
        preparedStatement.setInt(6, staff.getDepartment().getId());
        preparedStatement.executeUpdate();
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public void delete(int id) {
     String sql = "delete from staff where id = ?;";
      try {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();

      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public List<Staff> findAll() {
      List<Staff> staff = new ArrayList<>();
      String sql = "select staff.*, d.name as nameDepartment from staff join department d on d.id = staff.idDepartment;";
      try {
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
          int id = resultSet.getInt("id");
          String name = resultSet.getString("name");
          String email = resultSet.getString("email");
          float salary = resultSet.getFloat("salary");
          String address = resultSet.getString("address");
          int phoneNumber = resultSet.getInt("phoneNumber");
          int idDepartment = resultSet.getInt("idDepartment");
          String nameDepartment = resultSet.getString("nameDepartment");
         Department department = new Department(idDepartment,nameDepartment);
          Staff staff1 = new Staff(id, name, salary, email,address,phoneNumber,department);
          staff.add(staff1);
        }
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
      return staff;
    }


    @Override
    public void edit(int id, Staff staff) {
      String sql = "UPDATE staff SET name = ?, email = ?, Salary = ?, address = ?, phonenumber = ?, idDepartment= ? WHERE id = ?;";
      try {
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setString(1, staff.getName());
        preparedStatement.setString(2, staff.getEmail());
        preparedStatement.setFloat(3,staff.getSalary());
        preparedStatement.setString(4, staff.getAddress());
        preparedStatement.setInt(5, staff.getPhoneNumber());
        preparedStatement.setInt(6, staff.getDepartment().getId());
        preparedStatement.setInt(7, id);
        preparedStatement.executeUpdate();
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    }
}
