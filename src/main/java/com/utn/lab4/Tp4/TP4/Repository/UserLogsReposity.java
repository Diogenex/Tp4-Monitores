package com.utn.lab4.Tp4.TP4.Repository;


import com.utn.lab4.Tp4.TP4.Model.UserLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserLogsReposity extends JpaRepository<UserLogs,Long> {

    @Query( " SELECT u.navegador , COUNT( u.navegador) as maximo" +
            " FROM UserLogs u " +
            " GROUP BY u.navegador " +
            " ORDER BY maximo DESC ")
    public List<UserLogs> navegadorMasUsado();

    @Query( " SELECT u.sistemaOperativo , COUNT( u.sistemaOperativo) as maximo" +
            " FROM UserLogs u " +
            " GROUP BY u.sistemaOperativo " +
            " ORDER BY maximo DESC ")
    public List<UserLogs> sistemaOMasUsado();


}




