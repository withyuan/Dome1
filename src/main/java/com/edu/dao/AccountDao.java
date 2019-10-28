package com.edu.dao;


import org.apache.ibatis.annotations.Param;

public interface AccountDao {

    /**
     * 转出账号
     * @param  out:转出账号
     * @param money:转出金额
     * */
    public void outMoney(@Param("out") String out,@Param("money") Double money);
    /**
     * 转入账号
     * @param in :转出账号
     * @param money:转出金额
     * */
    public void inMoney(@Param("in") String in,@Param("money") Double money);
}
