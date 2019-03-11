package com.hnu.cloudmining.test;

import com.hnu.cloudmining.dao.IEmpDao;
import com.hnu.cloudmining.factory.DaoFactory;
import com.hnu.cloudmining.vo.Emp;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Administrator on 2019/3/8.
 */
public class TestFind {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        IEmpDao dao = DaoFactory.getIEmpDaoInstance();
        Emp e = dao.findById(1010);
        System.out.println(e);
    }

}
