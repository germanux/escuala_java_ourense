/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.appweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pc
 */
public class HolaCssServlet  extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest peticionHttp,
            HttpServletResponse respuestaHttp) throws IOException  {
        
        // Definimos el tipo de contenido según los tipos MIME
        // Formatos conocidos de ficheros para emails
        respuestaHttp.setContentType("text/css");
        try (PrintWriter salida = respuestaHttp.getWriter() )
        {
            salida.println(".color-rojo {  ");
            salida.println("    color: red; }");
            for (int i = 0; i < 10; i++) {
                salida.println(".fuente-1" + i + " {" );
            salida.println("  font-size:  " + ((float) 10 + i * 2) / 10  +"em; ");
            salida.println("}");
            }
        }
    }
}
