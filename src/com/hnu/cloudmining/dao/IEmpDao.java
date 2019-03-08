package com.hnu.cloudmining.dao;

import com.hnu.cloudmining.vo.Emp;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019/3/8.
 */
public interface IEmpDao {
    /**
     * 数据增加操作，一般以doXxx命令
     * @param emp  要增加的数据对象
     * @return  是否添加成功
     */
    public boolean doCreate(Emp emp) throws SQLException;

    /**
     * 根据关键字进行模糊查询数据库,一般以findXxx的方式命令
     * @param keyword  传入的关键字，看是否有匹配的记录
     * @return 将查询到的记录全部返回
     */
    public List<Emp>  findAll(String keyword) throws SQLException;

    /**
     * 根据员工id进行查询
     * @param empno 员工编号
     * @return 返回查询到的记录
     */
    public Emp findById(int empno) throws SQLException;
}
