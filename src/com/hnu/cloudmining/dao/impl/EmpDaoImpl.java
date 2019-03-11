package com.hnu.cloudmining.dao.impl;

import com.hnu.cloudmining.dao.IEmpDao;
import com.hnu.cloudmining.vo.Emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/3/8.
 */
public class EmpDaoImpl implements IEmpDao {
    private Connection conn = null;
    private PreparedStatement pstmt = null;

    public EmpDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean doCreate(Emp emp) throws SQLException {
        boolean flag = false;
        String sql = "insert into emp(empno , ename, job , hiredate , sal) values(?,?,?,?,?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, emp.getEmpno());
        pstmt.setString(2, emp.getEname());
        pstmt.setString(3, emp.getJob());
        pstmt.setDate(4, new java.sql.Date(emp.getHiredate().getTime()));
        pstmt.setFloat(5, emp.getSal());
        int size = pstmt.executeUpdate();
        if (size > 0) {
            flag = true;
        }
        pstmt.close();
        return flag;
    }

    @Override
    public List<Emp> findAll(String keyword) throws SQLException {
        String sql = "select empno, ename, job, hiredate, sal from emp where ename like ? or job like ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, "%" + keyword + "%");
        pstmt.setString(2, "%" + keyword + "%");
        ResultSet rs = pstmt.executeQuery();
        List<Emp> emps = new ArrayList<>();
        while (rs.next()) {
            Emp emp = new Emp();
            emp.setEmpno(rs.getInt(1));
            emp.setEname(rs.getString(2));
            emp.setJob(rs.getString(3));
            emp.setHiredate(rs.getDate(4));
            emp.setSal(rs.getFloat(5));
            emps.add(emp);
        }
        pstmt.close();
        return emps;
    }

    @Override
    public Emp findById(int empno) throws SQLException {
        String sql = "select empno, ename, job, hiredate, sal from emp where empno=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,empno);
        ResultSet rs = pstmt.executeQuery();
        Emp emp = null;
        while(rs.next()) {
            emp = new Emp();
            emp.setEmpno(rs.getInt(1));
            emp.setEname(rs.getString(2));
            emp.setJob(rs.getString(3));
            emp.setHiredate(rs.getDate(4));
            emp.setSal(rs.getFloat(5));
        }
        pstmt.close();
        return emp;
    }
}
