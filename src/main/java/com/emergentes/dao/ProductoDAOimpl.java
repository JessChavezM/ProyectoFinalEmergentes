
package com.emergentes.dao;

import com.emergentes.modelo.Producto;
import com.emergentes.utiles.ConexionDB;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;



public class ProductoDAOimpl extends ConexionDB implements ProductoDAO {

    @Override
    public void insert(Producto producto) throws Exception {
       
              try {
            this.conectar();
            String sql = "INSERT INTO productos (nombre,codigo,descripcion,img) values (?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getCodigo());
            ps.setString(3, producto.getDescripcion());         
            ps.setString(4, producto.getImg());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Producto producto) throws Exception {
       
        try {
            this.conectar();
            String sql = "UPDATE productos SET nombre=?,codigo=?,descripcion=?,img=? WHERE id=?";     
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getCodigo());
            ps.setString(3, producto.getDescripcion());           
            ps.setString(4, producto.getImg());
            ps.setInt(5, producto.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        } 
    }

    @Override
    public void delete(int id) throws Exception {
       try {
            this.conectar();
            String sql = "DELETE   FROM productos where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        
    }

    @Override
    public Producto getById(int id) throws Exception {
         Producto pro = new Producto();
        try {
            this.conectar();
            String sql = "SELECT *  FROM productos where id= ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pro.setId(rs.getInt("id"));
                pro.setNombre(rs.getString("nombre"));
                pro.setCodigo(rs.getString("codigo"));
                pro.setDescripcion(rs.getString("descripcion"));             
                pro.setImg(rs.getString("img"));
                 
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return pro;
        
    }

    @Override
      public List<Producto> getAll() throws Exception {
       
  
 List<Producto> lista = null;
        try {
            this.conectar();
            String sql = "SELECT * FROM productos";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            lista = new ArrayList <Producto>();  //libreri
            while (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
               p.setCodigo(rs.getString("codigo"));
                p.setDescripcion(rs.getString("descripcion"));          
                p.setImg(rs.getString("img"));
                lista.add(p);
            }
            rs.close();
            ps.close();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }

    }


 
























