package com.komorebi.dao.role;

import com.komorebi.dao.BaseDao;
import com.komorebi.pojo.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDao{
    // 获取角色列表
    @Override
    public List<Role> getRoleList(Connection connection) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        ArrayList<Role> roleList = new ArrayList<>();

        if (connection != null){
            String sql = "select * from smbms_role";
            Object[] params = {};
            resultSet = BaseDao.execute(connection, pstm, resultSet, sql, params);

            while (resultSet.next()){
                Role _role = new Role();
                _role.setId(resultSet.getInt("id"));
                _role.setRoleCode(resultSet.getString("roleCode"));
                _role.setRoleName(resultSet.getString("roleName"));
                roleList.add(_role);
            }

            BaseDao.closeResource(connection, pstm, resultSet);
        }
        return roleList;
    }
}
