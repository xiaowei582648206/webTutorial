package com.hnu.cloudmining.dao.test;

import com.hnu.cloudmining.dao.IEmpDao;
import com.hnu.cloudmining.factory.DaoFactory;
import com.hnu.cloudmining.vo.Emp;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2019/3/8.
 */
public class TestInsert {
    public static void main(String[] args) throws ParseException, SQLException, ClassNotFoundException {
        Emp e = new Emp();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2018-08-08");
        e.setEmpno(1080);
        e.setEname("小丽");
        e.setJob("策划部");
        e.setHiredate(date);
        e.setSal(3000);

        IEmpDao dao = DaoFactory.getIEmpDaoInstance();
        dao.doCreate(e);

    }
}
