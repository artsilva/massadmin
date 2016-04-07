/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.massmanager.swing.model;

import com.massmanager.controller.Atencion;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Artsk
 */
public class Utils {

    public String asuntoCorreo(List<Atencion> atencion) {
        StringBuilder asunto = new StringBuilder();
        for (Atencion atenciones : atencion) {
            asunto.append("Atencion a ").append(atenciones.getNombre()).append(" ").append(atenciones.getApellido()).append(" en Sala de Primeros Auxilios Lirquen Santiago");
        }
        return asunto.toString();
    }
    
    public String cuerpoCorreo(List <Atencion> atencion) {

        FechaHora fecha = new FechaHora("dd-MM-yyyy");
        StringBuilder correo = new StringBuilder();
        
        for (Atencion atenciones : atencion) {   
        correo.append("<head></head>");
        correo.append("<p class=MsoNormal>Estimado ").append(atenciones.getJefearea()).append(",</p>");
        correo.append("<p class=MsoNormal>&nbsp;</p>");
        correo.append("<p class=MsoNormal>").append(fecha.obtenerSaludoHorario(fecha.getHoraMinutos())).append(", junto con saludar, se informa sobre");
        correo.append(" la atención de índole ").append(atenciones.getIncidente()).append(" prestada al Sr. ").append(atenciones.getNombre()).append(" ").append(atenciones.getApellido()).append(" el día ").append(fecha.getFecha()).append(" a causa ");
        correo.append("de una lesión provocada por un/a ").append(atenciones.getLesion()).append(" cuando el trabajador desempeñaba sus funciones en el área ").append(atenciones.getArea()).append(" específicamente en ");
        correo.append(atenciones.getLugar()).append(" provocado por un ").append(atenciones.getDetalles()).append(", ");
        correo.append("siendo atendido en SPA con el siguiente comentario de atención: ").append(atenciones.getComentario()).append("</p><p class=MsoNormal><br></p>");

        correo.append("<table class='MsoTableGrid' style='border-collapse:collapse;border:none;mso-border-alt:solid windowtext .5pt;");
        correo.append(" mso-yfti-tbllook:1184;mso-padding-alt:0cm 5.4pt 0cm 5.4pt' border='1' cellpadding='0' cellspacing='0'>");
        correo.append("<tbody><tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>");
        correo.append("<td style='width:36.05pt;border:solid windowtext 1.0pt;");
        correo.append("mso-border-alt:solid windowtext .5pt;background:#4472C4;mso-background-themecolor:");
        correo.append("accent5;padding:0cm 5.4pt 0cm 5.4pt' valign='top' width='48'>");
        correo.append("<p class='MsoNormal' style='margin-bottom:0cm;margin-bottom:.0001pt;");
        correo.append("text-align:center;line-height:normal' align='center'><b style='mso-bidi-font-weight:normal'><span style='color:white;mso-themecolor:background1'>Hora</span></b></p>");
        correo.append("</td><td style='width:48.75pt;border:solid windowtext 1.0pt;");
        correo.append("border-left:none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:");
        correo.append("solid windowtext .5pt;background:#4472C4;mso-background-themecolor:accent5;");
        correo.append("padding:0cm 5.4pt 0cm 5.4pt' valign='top' width='65'>");
        correo.append("<p class='MsoNormal' style='margin-bottom:0cm;margin-bottom:.0001pt;");
        correo.append("text-align:center;line-height:normal' align='center'><b style='mso-bidi-font-weight:normal'><span style='color:white;mso-themecolor:background1'>Lugar</span></b></p>");
        correo.append("</td><td style='width:177.2pt;border:solid windowtext 1.0pt;");
        correo.append("border-left:none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:");
        correo.append("solid windowtext .5pt;background:#4472C4;mso-background-themecolor:accent5;");
        correo.append("padding:0cm 5.4pt 0cm 5.4pt' valign='top' width='236'>");
        correo.append("<p class='MsoNormal' style='margin-bottom:0cm;margin-bottom:.0001pt;");
        correo.append("text-align:center;line-height:normal' align='center'><b style='mso-bidi-font-weight:normal'><span style='color:white;mso-themecolor:background1'>Detalles</span></b></p>");
        correo.append("</td><td style='width:63.8pt;border:solid windowtext 1.0pt;");
        correo.append("border-left:none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:");
        correo.append("solid windowtext .5pt;background:#4472C4;mso-background-themecolor:accent5;");
        correo.append("padding:0cm 5.4pt 0cm 5.4pt' valign='top' width='85'>");
        correo.append("<p class='MsoNormal' style='margin-bottom:0cm;margin-bottom:.0001pt;");
        correo.append("text-align:center;line-height:normal' align='center'><b style='mso-bidi-font-weight:normal'><span style='color:white;mso-themecolor:background1'>Lesión</span></b></p>");
        correo.append("</td><td style='width:39.5pt;border:solid windowtext 1.0pt;");
        correo.append("border-left:none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:");
        correo.append("solid windowtext .5pt;background:#4472C4;mso-background-themecolor:accent5;");
        correo.append("padding:0cm 5.4pt 0cm 5.4pt' valign='top' width='53'>");
        correo.append("<p class='MsoNormal' style='margin-bottom:0cm;margin-bottom:.0001pt;");
        correo.append("text-align:center;line-height:normal' align='center'><b style='mso-bidi-font-weight:normal'><span style='color:white;mso-themecolor:background1'>Incidente</span></b></p>");
        correo.append("</td><td style='width:63.4pt;border:solid windowtext 1.0pt;");
        correo.append("border-left:none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:");
        correo.append("solid windowtext .5pt;background:#4472C4;mso-background-themecolor:accent5;");
        correo.append("padding:0cm 5.4pt 0cm 5.4pt' valign='top' width='85'>");
        correo.append("<p class='MsoNormal' style='margin-bottom:0cm;margin-bottom:.0001pt;");
        correo.append("text-align:center;line-height:normal' align='center'><b style='mso-bidi-font-weight:normal'><span style='color:white;mso-themecolor:background1'>Extremidad</span></b></p>");
        correo.append("</td><td style='width:131.0pt;border:solid windowtext 1.0pt;");
        correo.append("border-left:none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:");
        correo.append("solid windowtext .5pt;background:#4472C4;mso-background-themecolor:accent5;");
        correo.append("padding:0cm 5.4pt 0cm 5.4pt' valign='top' width='175'>");
        correo.append("<p class='MsoNormal' style='margin-bottom:0cm;margin-bottom:.0001pt;");
        correo.append("text-align:center;line-height:normal' align='center'><b style='mso-bidi-font-weight:normal'><span style='color:white;mso-themecolor:background1'>Tratamiento</span></b></p>");
        correo.append("</td>");
        correo.append("<td style='width:40.55pt;border:solid windowtext 1.0pt;");
        correo.append("border-left:none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:");
        correo.append("solid windowtext .5pt;background:#4472C4;mso-background-themecolor:accent5;");
        correo.append("padding:0cm 5.4pt 0cm 5.4pt' valign='top' width='54'>");
        correo.append("<p class='MsoNormal' style='margin-bottom:0cm;margin-bottom:.0001pt;");
        correo.append("text-align:center;line-height:normal' align='center'><b style='mso-bidi-font-weight:normal'><span style='color:white;mso-themecolor:background1'>Deriva</span></b></p>");
        correo.append("</td></tr><tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes;height:78.45pt'>");
        correo.append("<td style='width:36.05pt;border:solid windowtext 1.0pt;");
        correo.append("border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;");
        correo.append("padding:0cm 5.4pt 0cm 5.4pt;height:78.45pt' valign='top' width='48'>");
        correo.append("<p class='MsoNormal' style='margin-bottom:0cm;margin-bottom:.0001pt;");
        correo.append("text-align:center;line-height:normal' align='center'><i style='mso-bidi-font-style:normal'><span style='color:black;mso-themecolor:text1'>").append(fecha.getHoraMinutos()).append("</span></i></p>");
        correo.append("</td><td style='width:48.75pt;border-top:none;border-left:");
        correo.append("none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;");
        correo.append("mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;");
        correo.append("mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt;height:78.45pt' valign='top' width='65'>");
        correo.append("<p class='MsoNormal' style='margin-bottom:0cm;margin-bottom:.0001pt;");
        correo.append("text-align:center;line-height:normal' align='center'><i style='mso-bidi-font-style:normal'><span style='color:black;mso-themecolor:text1'>").append(atenciones.getLugar()).append("</span></i></p>");
        correo.append("</td><td style='width:177.2pt;border-top:none;border-left:");
        correo.append("none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;");
        correo.append("mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;");
        correo.append("mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt;height:78.45pt' valign='top' width='236'>");
        correo.append("<p class='MsoNormal' style='margin-bottom:0cm;margin-bottom:.0001pt;");
        correo.append("text-align:center;line-height:normal' align='center'><i style='mso-bidi-font-style:normal'><span style='color:black;mso-themecolor:text1'>").append(atenciones.getDetalles()).append("</span></i></p>");
        correo.append("</td><td style='width:63.8pt;border-top:none;border-left:none;");
        correo.append("border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;");
        correo.append("mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;");
        correo.append("mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt;height:78.45pt' valign='top' width='85'>");
        correo.append("<p class='MsoNormal' style='margin-bottom:0cm;margin-bottom:.0001pt;");
        correo.append("text-align:center;line-height:normal' align='center'><i style='mso-bidi-font-style:normal'><span style='color:black;mso-themecolor:text1'>").append(atenciones.getLesion()).append("</span></i></p>");
        correo.append("</td><td style='width:39.5pt;border-top:none;border-left:none;");
        correo.append("border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;");
        correo.append("mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;");
        correo.append("mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt;height:78.45pt' valign='top' width='53'>");
        correo.append("<p class='MsoNormal' style='margin-bottom:0cm;margin-bottom:.0001pt;");
        correo.append("text-align:center;line-height:normal' align='center'><i style='mso-bidi-font-style:normal'><span style='color:black;mso-themecolor:text1'>").append(atenciones.getIncidente()).append("</span></i></p>");
        correo.append("</td><td style='width:63.4pt;border-top:none;border-left:none;");
        correo.append("border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;");
        correo.append("mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;");
        correo.append("mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt;height:78.45pt' valign='top' width='85'>");
        correo.append("<p class='MsoNormal' style='margin-bottom:0cm;margin-bottom:.0001pt;");
        correo.append("text-align:center;line-height:normal' align='center'><i style='mso-bidi-font-style:normal'><span style='color:black;mso-themecolor:text1'>").append(atenciones.getExtremidad()).append("</span></i></p>");
        correo.append("</td><td style='width:131.0pt;border-top:none;border-left:");
        correo.append("none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;");
        correo.append("mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;");
        correo.append("mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt;height:78.45pt' valign='top' width='175'>");
        correo.append("<p class='MsoNormal' style='margin-bottom:0cm;margin-bottom:.0001pt;");
        correo.append("text-align:center;line-height:normal' align='center'><i style='mso-bidi-font-style:normal'><span style='color:black;mso-themecolor:text1'>").append(atenciones.getTratamiento()).append("</span></i></p>");
        correo.append("</td><td style='width:40.55pt;border-top:none;border-left:");
        correo.append("none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;");
        correo.append("mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;");
        correo.append("mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt;height:78.45pt' valign='top' width='54'>");
        correo.append("<p class='MsoNormal' style='margin-bottom:0cm;margin-bottom:.0001pt;");
        correo.append("text-align:center;line-height:normal' align='center'><i style='mso-bidi-font-style:normal'><span style='color:black;mso-themecolor:text1'>").append(atenciones.getDeriva()).append("</span></i></p>");
        correo.append("</td></tr></tbody></table>");
        
        correo.append("<p class=MsoNormal>&nbsp;</p><p class=MsoNormal>&nbsp;</p>");
        correo.append("<p class=MsoNormal style='margin-bottom:0cm;margin-bottom:.0001pt'><i style='mso-bidi-font-style:normal'><span style='color:#44546A;mso-themecolor:");
        correo.append("text2'></span><span style='color:#4472C4;mso-themecolor:accent5'>").append(atenciones.getParamedico()).append("</span><span style='color:#44546A;mso-themecolor:text2'></span></i></p>");
        correo.append("<p class=MsoNormal style='margin-bottom:0cm;margin-bottom:.0001pt'><i style='mso-bidi-font-style:normal'>Paramédico SPA Lirquen Santiago.</i></p>");
        correo.append("<p class=MsoNormal style='margin-bottom:0cm;margin-bottom:.0001pt'><i style='mso-bidi-font-style:normal'><span style='color:#4472C4;mso-themecolor:");
        correo.append("accent5'>Tél:</span><span style='color:#44546A;mso-themecolor:text2'> </span>+562-4736251</i></p>");
        correo.append("<p class=MsoNormal style='margin-bottom:0cm;margin-bottom:.0001pt'><i style='mso-bidi-font-style:normal'><span style='color:#4472C4;mso-themecolor:");
        correo.append("accent5'>Mail:</span><span style='color:#44546A;mso-themecolor:text2'> </span>spasantiago@pilkington.cl</i></p><p class=MsoNormal style='margin-bottom:0cm;margin-bottom:.0001pt'><i style='mso-bidi-font-style:normal'><br></i></p>");
        correo.append("<p class=MsoNormal>&nbsp;</p>");

        correo.append("<p class=MsoNormal><span style='font-size:10.0pt;line-height:107%;color:#7F7F7F;");
        correo.append("mso-themecolor:text1;mso-themetint:128;mso-style-textfill-fill-color:#7F7F7F;");
        correo.append("mso-style-textfill-fill-themecolor:text1;mso-style-textfill-fill-alpha:100.0%;");
        correo.append("mso-style-textfill-fill-colortransforms:&quot;lumm=50000 lumo=50000&quot;'>Este");
        correo.append("mensaje ha sido generado automáticamente por MassAdmin Software®, para más información");
        correo.append("comunicarse a SPA Vidrios Lirquen Santiago o MASS Lirquen Santiago.</span></p>");
        }
        return correo.toString();
    }
    
    public void showMessage(String msg, String title) {
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.WARNING_MESSAGE);
    }
    
    public boolean showMessageOption() {
        boolean respuesta = false;
        Toolkit.getDefaultToolkit().beep();
        int confirmado = JOptionPane.showConfirmDialog(null, "¿Desea visualizar el archivo guardado?", "Archivo exportado exitosamente", JOptionPane.YES_NO_OPTION);
        if (JOptionPane.OK_OPTION == confirmado) {
            respuesta = true;
        }
        return respuesta;
    }
}
