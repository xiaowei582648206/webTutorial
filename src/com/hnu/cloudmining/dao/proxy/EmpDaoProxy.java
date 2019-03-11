package com.hnu.cloudmining.dao.proxy;

import com.hnu.cloudmining.dao.IEmpDao;
import com.hnu.cloudmining.dao.impl.EmpDaoImpl;
import com.hnu.cloudmining.dbc.DatabaseConnection;
import com.hnu.cloudmining.vo.Emp;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019/3/8.
 */
public class EmpDaoProxy implements IEmpDao {
    private IEmpDao dao = null;
    private DatabaseConnection dbc = null;

    public EmpDaoProxy() throws SQLException, ClassNotFoundException, IOException {
        dbc = new DatabaseConnection();
        dao = new EmpDaoImpl(dbc.getConn());
    }

    @Override
    public boolean doCreate(Emp emp) throws SQLException {
        boolean flag = false;
        try {
            if (dao.findById(emp.getEmpno()) == null) {
                flag = dao.doCreate(emp);
            }
        } catch(Exception e){
            e.printStackTrace();
        }finally {
            dbc.close();
        }
        return flag;
    }

    @Override
    public List<Emp> findAll(String keyword) throws SQLException {
        List<Emp> all = null;
        try{
             all = dao.findAll(keyword);
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            dbc.close();
        }
        return all;
    }

    @Override
    public Emp findById(int empno) throws SQLException {
        Emp emp = null;
        try{
             emp = dao.findById(empno);
        }catch (Exception e ){
            e.printStackTrace();
        }finally {
            dbc.close();
        }
        return emp;
    }
}
