package com.archer.dao;

import com.archer.domain.Manager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by archerlj on 2017/5/25.
 */
@Repository
public interface ManagerDao {
    Manager selectManagerByName(@Param("name") String name);
}
