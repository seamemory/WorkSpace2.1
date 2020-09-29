package com.etc.project.dao.Impl;

import com.etc.project.dao.ProductDao;
import com.etc.project.domain.Product;
import com.etc.project.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public List<Product> findProductByNameLike(String name) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = DBUtil.getPstmt(conn,"select * from easybuy_product where name like?","%"+name+"%");
        ResultSet rs = DBUtil.query(pstmt);
        List<Product> list = new ArrayList<>();
        try {
            while(rs.next()){
                list.add(new Product(rs.getInt("id"),rs.getString("name"),rs.getString("description"),
                        rs.getDouble("price"),rs.getInt("stock"),rs.getInt("categoryLevel1Id"),
                        rs.getInt("categoryLevel2Id"), rs.getInt("categoryLevel3Id"),rs.getString("fileName"),
                        rs.getInt("isDelete"),rs.getInt("brand_id")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return list;
        }
    }
}
