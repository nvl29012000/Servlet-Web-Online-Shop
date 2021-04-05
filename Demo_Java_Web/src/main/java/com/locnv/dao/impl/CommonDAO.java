package com.locnv.dao.impl;

import com.locnv.Map.Mapper;
import com.locnv.dao.IGenericDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommonDAO<T> implements IGenericDAO<T> {
    public Connection getConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost:1433;database=QLBHJAva;";
            String username = "sa";
            String password = "vietloc123";
            return DriverManager.getConnection(connectionUrl, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }


    @Override
    public <T> List<T> execute(String sql, Mapper<T> mapper, Object... parameters) {
        List<T> results = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            connection = getConnection();
            ps = connection.prepareStatement(sql);
            setParameters(ps,parameters);
            rs = ps.executeQuery();
            while (rs.next()){
                results.add(mapper.mapRowtoObj(rs));
            }
            return results;
        }catch (SQLException e){
            return null;
        }finally {
            try{
                if(rs != null){
                    rs.close();
                }
                if(ps != null){
                    ps.close();
                }
                if(connection != null){
                    connection.close();
                }
            }catch (SQLException ex){
                return null;
            }
        }
    }

    @Override
    public int countItem(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            int count = 0;
            connection = getConnection();
            ps = connection.prepareStatement(sql);
            setParameters(ps,parameters);
            rs = ps.executeQuery();
            while (rs.next()){
                count = rs.getInt(1);
            }
            return count;
        }catch (SQLException e){
            return 0;
        }finally {
            try{
                if(rs != null){
                    rs.close();
                }
                if(ps != null){
                    ps.close();
                }
                if(connection != null){
                    connection.close();
                }
            }catch (SQLException ex){
                return 0;
            }
        }
    }

    @Override
    public Long insert(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Long id = null;
        try{
            connection = getConnection();
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            setParameters(ps,parameters);
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if(rs.next()){
                id = rs.getLong(1);
            }
            connection.commit();
            return id;
        }catch (SQLException e){
            try{
                connection.rollback();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
            return null;
        }
        finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                return null;
            }
        }
    }

    @Override
    public Boolean update(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement ps = null;
        try{
            connection = getConnection();
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(sql);
            setParameters(ps,parameters);
            ps.executeUpdate();
            connection.commit();
            return true;
        }catch (SQLException e){
            try{
                connection.rollback();
            }catch (SQLException ex){
                e.printStackTrace();
            }
            return false;
        }finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                return false;
            }
        }
    }



    private void setParameters(PreparedStatement statement, Object... parameters){
        try{
            for(int i = 0; i< parameters.length; i++){
                Object parameter = parameters[i];
                int j = i + 1;
                if(parameter instanceof Long){
                    statement.setLong(j,(Long)parameter);
                }
                if(parameter instanceof String){
                    statement.setString(j, (String)parameter);
                }
                if(parameter instanceof Timestamp){
                    statement.setTimestamp(j, (Timestamp) parameter);
                }
                if(parameter instanceof Integer){
                    statement.setInt(j, (Integer) parameter);
                }
                if(parameter == null){
                    statement.setNull(j, Types.NULL);
                }
                if(parameter instanceof Boolean){
                    statement.setBoolean(j, (Boolean) parameter);
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
