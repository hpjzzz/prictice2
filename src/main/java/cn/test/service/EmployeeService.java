package cn.test.service;

import cn.test.pojo.Employee;

public interface EmployeeService {
    Employee selectByPrimaryKey(Long id);
}
