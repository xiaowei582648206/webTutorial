package com.hnu.cloudmining.test;

import com.hnu.cloudmining.dao.IEmpDao;
import com.hnu.cloudmining.factory.DaoFactory;
import com.hnu.cloudmining.vo.Emp;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2019/3/8.
 */
// this file has bean save as "utf-8" encoding on the disk ,please reload it from disk by "utf-8"
public class TestInsert {
    public static void main(String[] args) throws ParseException, SQLException, ClassNotFoundException, IOException {
        Emp e = new Emp();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2018-01-08");
        // 凡是出现中文的地方，一定要切记：一定要注意java代码的编码格式，mysql数据库的编码格式，jsp页面的编码格式，
        // jsp接收request参数编码格式一定都要设置一致"utf-8"，否则就会出现中文乱码
        // 修改WEB-INF/classes/中的代码后一定要记得重启服务器
        //本java文件已经用utf-8的编码格式保存在磁盘上了，下次再打开功能，一定要记得使用utf-8格式从磁盘上reload
        e.setEmpno(1019);
        e.setEname("小冰");
        e.setJob("策划部");
        e.setHiredate(date);
        e.setSal(3000.50f);

        IEmpDao dao = DaoFactory.getIEmpDaoInstance();
        boolean b = dao.doCreate(e);
        System.out.println(b);

    }
}
