/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.specificimplementation;

import com.google.gson.annotations.Expose;
import bean.genericimplementation.TableGenericBeanImplementation;
import bean.publicinterface.GenericBeanInterface;
import dao.specificimplementation.TipousuarioSpecificDaoImplementation;
import dao.specificimplementation.UsuarioSpecificDaoImplementation;
import helper.EncodingUtilHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

/**
 *
 * @author a053629318b
 */
public class PedidoSpecificBeanImplementation extends TableGenericBeanImplementation {
    
    @Expose
    private Date fecha;
    @Expose
    private Integer iva;
    @Expose(serialize = false)
    private Integer id_usuario=0;
    @Expose(deserialize = false)
    private UsuarioSpecificBeanImplementation obj_usuario = null;
    
    public PedidoSpecificBeanImplementation() {

    }
    
    public PedidoSpecificBeanImplementation(Integer id) {
        this.id = id;
    }

   public PedidoSpecificBeanImplementation(Integer id_usuario, Date fecha) {
        this.id_usuario = id_usuario;
        this.fecha = fecha;
    }
    
     public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getIva() {
        return iva;
    }

    public void setIva(Integer iva) {
        this.iva = iva;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public UsuarioSpecificBeanImplementation getObj_usuario() {
        return obj_usuario;
    }

    public void setObj_usuario(UsuarioSpecificBeanImplementation obj_usuario) {
        this.obj_usuario = obj_usuario;
    }
    
    @Override
    public String getColumns() {
        String strColumns = "";
        strColumns += "id,";
        strColumns += "fecha,";
        strColumns += "iva,";
        strColumns += "id_usuario";
        return strColumns;
    }

    @Override
    public String getValues() {
        String strColumns = "";
        strColumns += id + ",";
        strColumns += EncodingUtilHelper.stringifyAndQuotate(fecha) + ",";
        strColumns += iva + ",";
        strColumns += id_usuario;
        return strColumns;
    }

    @Override
    public String toPairs() {
        String strPairs = "";
        strPairs += "fecha=" + EncodingUtilHelper.stringifyAndQuotate(fecha) + ",";
        strPairs += "iva=" + iva + ",";
        strPairs += "id_usuario=" + id_usuario;
        return strPairs;
    }

    @Override
    public GenericBeanInterface fill(ResultSet oResultSet, Connection oConnection, UsuarioSpecificBeanImplementation oPuserBean_security, Integer expand) throws SQLException, Exception {
        this.setId(oResultSet.getInt("id"));
        this.setFecha(oResultSet.getDate("fecha"));
        this.setIva(oResultSet.getInt("iva"));
        this.setId_usuario(oResultSet.getInt("id_usuario"));
        if (expand > 0) {
            UsuarioSpecificBeanImplementation oUsuarioBean = new UsuarioSpecificBeanImplementation();
            UsuarioSpecificDaoImplementation oUsuarioDao = new UsuarioSpecificDaoImplementation(oConnection, oPuserBean_security, null);
            oUsuarioBean = (UsuarioSpecificBeanImplementation) oUsuarioDao.get(oResultSet.getInt("id_usuario"), expand - 1);
            this.setObj_usuario(oUsuarioBean);
        } else {
            this.setId_usuario(oResultSet.getInt("id_usuario"));
        }

        return this;
    }
}
