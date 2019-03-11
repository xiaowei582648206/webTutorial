package com.hnu.cloudmining.factory;

import com.hnu.cloudmining.dao.IEmpDao;
import com.hnu.cloudmining.dao.impl.EmpDaoImpl;
import com.hnu.cloudmining.dao.proxy.EmpDaoProxy;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Administrator on 2019/3/8.
 */
public class DaoFactory {
    public static IEmpDao getIEmpDaoInstance() throws SQLException, ClassNotFoundException, IOException {
        return new EmpDaoProxy();
    }
}
