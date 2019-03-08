package com.hnu.cloudmining.dao;

import com.hnu.cloudmining.vo.Emp;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019/3/8.
 */
public interface IEmpDao {
    /**
     * �������Ӳ�����һ����doXxx����
     * @param emp  Ҫ���ӵ����ݶ���
     * @return  �Ƿ���ӳɹ�
     */
    public boolean doCreate(Emp emp) throws SQLException;

    /**
     * ���ݹؼ��ֽ���ģ����ѯ���ݿ�,һ����findXxx�ķ�ʽ����
     * @param keyword  ����Ĺؼ��֣����Ƿ���ƥ��ļ�¼
     * @return ����ѯ���ļ�¼ȫ������
     */
    public List<Emp>  findAll(String keyword) throws SQLException;

    /**
     * ����Ա��id���в�ѯ
     * @param empno Ա�����
     * @return ���ز�ѯ���ļ�¼
     */
    public Emp findById(int empno) throws SQLException;
}
