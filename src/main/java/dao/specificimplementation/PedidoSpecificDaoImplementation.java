/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.specificimplementation;

import bean.specificimplementation.UsuarioSpecificBeanImplementation;
import dao.genericimplementation.TableGenericDaoImplementation;
import java.sql.Connection;

/**
 *
 * @author a053629318b
 */
public class PedidoSpecificDaoImplementation extends TableGenericDaoImplementation{
    
    public PedidoSpecificDaoImplementation( Connection oPooledConnection, UsuarioSpecificBeanImplementation oPuserBean_security, String strWhere) {
        super("pedido", oPooledConnection, oPuserBean_security, strWhere);
    }
    
}
