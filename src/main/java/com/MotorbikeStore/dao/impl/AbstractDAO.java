package com.MotorbikeStore.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import com.MotorbikeStore.dao.impl.DBConnection;
import com.MotorbikeStore.dao.GenericDAO;
import com.MotorbikeStore.mapper.RowMapper;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AbstractDAO<T> implements GenericDAO<T> {


        @Override
        public <T> List<T> query(String sql , RowMapper<T> rowMapper, Object... parameters) {
            List<T> result = new ArrayList<>();
            PreparedStatement statement = null;
            Connection conn = null;
            ResultSet resultSet = null;
            try {
                conn= DBConnection.getInstance().getConnection();             
                statement = conn.prepareStatement(sql);
                setParameter(statement, parameters);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    result.add(rowMapper.mapRow(resultSet));
                }
                return result;
            } catch (SQLException e) {
                return null;
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                    if (statement != null) {
                        statement.close();
                    }
                    if (resultSet != null) {
                        resultSet.close();
                    }
                } catch (SQLException e) {
                    return null;
                }
            }
        }

	

    private void setParameter(PreparedStatement statement, Object... parameters) {
        try {
            for (int i = 0; i < parameters.length; i++) {
                Object parameter = parameters[i];
                int index = i + 1;
                if (parameter instanceof Long) {
                    statement.setLong(index, (Long) parameter);
                } else if (parameter instanceof Integer) {
                    statement.setInt(index, (Integer) parameter);
                } else if (parameter instanceof String) {
                    statement.setString(index, (String) parameter);
                } else if (parameter instanceof java.sql.Date) {
                    statement.setDate(index, (java.sql.Date) parameter);
                } else if (parameter instanceof Float) {
                    statement.setFloat(index, (Float) parameter);
                } else if (parameter instanceof Timestamp) {
                    statement.setTimestamp(index, (Timestamp) parameter);
                } else if (parameter == null) {
                    statement.setNull(index, Types.NULL);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(String sql, Object... parameters) {
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            conn = DBConnection.getInstance().getConnection();      
            conn.setAutoCommit(false);
            statement = conn.prepareStatement(sql);
            setParameter(statement, parameters);
            statement.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (statement != null) {
                    statement.close();
                }

            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }

    }

    @Override
    public int insert(String sql, Object... parameters) {
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            Integer id = null;
            conn = DBConnection.getInstance().getConnection();      
            conn.setAutoCommit(false);
            statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            setParameter(statement, parameters);
            statement.executeUpdate();
            rs = statement.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            conn.commit();
            return id;
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return 0;
    }
}
