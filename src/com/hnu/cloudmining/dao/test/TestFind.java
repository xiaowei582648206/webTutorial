package com.hnu.cloudmining.dao.test;

import com.hnu.cloudmining.dao.IEmpDao;
import com.hnu.cloudmining.factory.DaoFactory;
import com.hnu.cloudmining.vo.Emp;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019/3/8.
 */
public class TestFind {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        IEmpDao dao = DaoFactory.getIEmpDaoInstance();
        Emp e = dao.findById(1010);
        System.out.println(e);
    }

}
