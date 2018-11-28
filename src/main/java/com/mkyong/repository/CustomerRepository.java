package com.mkyong.repository;

import com.mkyong.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findAll();
    List<Customer> findById(long id);
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO \"customer\"(id, name, secondname) VALUES (?, ?, ?)", nativeQuery = true)
    void insertCustomer(@Param("id")Long id, @Param("name")String name, @Param("secondName")String secondName);
    @Modifying
    @Transactional
    @Query(value = "UPDATE \"customer\" SET name=?, secondname=? WHERE id=?;", nativeQuery = true)
    void updateCustomer(@Param("name")String name, @Param("secondName")String secondName, @Param("id")Long id);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM \"customer\" WHERE id=?;", nativeQuery = true)
    void deleteCustomerById(@Param("id")Long id);

}