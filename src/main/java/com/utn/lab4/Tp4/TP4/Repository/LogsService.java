package com.utn.lab4.Tp4.TP4.Repository;

import com.utn.lab4.Tp4.TP4.Model.UserLogs;
import nl.basjes.parse.useragent.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LogsService {

        @Autowired
        private UserLogsReposity userLogsReposity;

        public Optional getUserByUserLog(long id) {
            return userLogsReposity.findById(id);
        }

        public List<UserLogs> getAll() {
            return userLogsReposity.findAll();
        }

        public UserLogs save(UserLogs usuario) {
            return userLogsReposity.save(usuario);
        }

        public void registrarLog (UserAgent userAgent){

            String navegador = userAgent.getValue("AgentName");
            String sistemaOperativo = userAgent.getValue("OperatingSystemNameVersion");
            UserLogs usuario = new UserLogs(navegador, sistemaOperativo);
            userLogsReposity.save(usuario);
        }

        public String sOmasUtilizado(){
            List<UserLogs> lista = userLogsReposity.sistemaOMasUsado();
            String sistemaO = String.valueOf(lista.get(0).getSistemaOperativo());
            return sistemaO;
        }

        public List navegadorMasUtilizado(){
            List<UserLogs> lista = userLogsReposity.navegadorMasUsado();
            return lista;
        }

        public Hashtable sOUtilizados(){

            List<UserLogs> lista = userLogsReposity.findAll();
            Hashtable hashLista = new Hashtable();

            for (UserLogs userLogs : lista) {
                String sO = userLogs.getSistemaOperativo();

                if(hashLista.containsKey(sO)){

                    hashLista.put(sO, (Integer)hashLista.get(sO) + 1);
                }else{
                    hashLista.put(sO, 1);
                }
            }

            return hashLista;
        }

        public Hashtable sOyNavegadorUtilizados(){

            List<UserLogs> lista = userLogsReposity.findAll();
            Hashtable hashLista = new Hashtable();

            for (UserLogs userLogs : lista) {
                String navegador = userLogs.getNavegador();
                String sO = userLogs.getSistemaOperativo();
                if (hashLista.containsKey(navegador) && hashLista.containsKey(sO)) {
                    hashLista.put(navegador + " " + sO, (Integer) hashLista.get(navegador + " " + sO) + 1);
                } else {
                    hashLista.put(navegador + " " + sO, 1);
                }
            }
            return hashLista;
        }

        public Hashtable navegadoresUtilizados(){

            List<UserLogs> lista = userLogsReposity.findAll();
            Hashtable hashLista = new Hashtable();

            for (UserLogs userLogs : lista) {
                String navegador = userLogs.getNavegador();

                    if(hashLista.containsKey(navegador)){
                        hashLista.put(navegador, (Integer)hashLista.get(navegador) +1);
                    }else{
                        hashLista.put(navegador, 1);
                    }
            }


            return hashLista;

        }


}







