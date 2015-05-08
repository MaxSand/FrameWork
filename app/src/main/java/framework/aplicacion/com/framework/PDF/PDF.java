package framework.aplicacion.com.framework.PDF;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.widget.Toast;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import java.io.File;
import java.io.FileOutputStream;

import framework.aplicacion.com.framework.R;

/**
 * Created by Max_Sandoval on 07/05/2015.
 */
public class PDF extends Activity {
    public static void crear(Context c) {

        String nombrePDF = "FrameWork";
        String tituloT="TituloT", cuerpoT="CuerpoT", itemList="itemList", academia="Academia de Software",desicion="SI";
        String preside="Preside",secunda="Secunda",rolP="Presidente",rolS="Secunda";
        String nombreG="Nombre General", rolG="Rol General";

        int presentes=5,miembrosTotales=10, hr=8, min=31, dia=15, mes=7, anio=2015;

        try {
            Document documento = new Document(PageSize.A4, 55, 55, 30, 40);                     //Margen
            documento.setMarginMirroring(true);

            boolean mExternalStorageAvailable;
            boolean mExternalStorageWriteable;
            String state = Environment.getExternalStorageState();
            if (Environment.MEDIA_MOUNTED.equals(state)) {                                      //leer y escribir en Media
                mExternalStorageAvailable = mExternalStorageWriteable = true;
            } else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {                     // Solo leer Media
                mExternalStorageAvailable = true;
                mExternalStorageWriteable = false;
            } else {                                                                            // Hay un problema
                mExternalStorageAvailable = mExternalStorageWriteable = false;
            }
            String file = null;
            if(mExternalStorageWriteable) {
                file = Environment.getExternalStorageDirectory().
                        getAbsolutePath()+ R.string.ruta;
                File dir = new File(file);                                                      //Si no existe crear
                if(!dir.exists())
                    dir.mkdirs();
                file = Environment.getExternalStorageDirectory().
                        getAbsolutePath()+ R.string.ruta + nombrePDF+".pdf";
            }
            if(!mExternalStorageAvailable){
                Toast.makeText(c, R.string.errorPDF, Toast.LENGTH_LONG).show();
            }
            //INICIO DEL DOCUMENTO

            PdfWriter.getInstance(documento, new FileOutputStream(file));
            documento.open();

            //Fuentes
            Font tituloF = FontFactory.getFont(FontFactory.TIMES_BOLD, 14);
            tituloF.setColor(BaseColor.BLACK);
            Font tituloN = FontFactory.getFont(FontFactory.TIMES_BOLD, 12);
            tituloN.setColor(BaseColor.BLACK);
            Font cuerpoF = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12);
            cuerpoF.setColor(BaseColor.BLACK);

            //Titulo
            Paragraph titulo = new Paragraph(tituloT,tituloF);
            titulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(titulo);

            documento.add(Chunk.NEWLINE);

            //Cuerpo bajo Titulo
            Chunk cuerpo = new Chunk(cuerpoT,cuerpoF);
            Paragraph parrafo =new Paragraph(cuerpo);
            parrafo.setAlignment(Element.ALIGN_JUSTIFIED);
            documento.add(parrafo);

            documento.add(Chunk.NEWLINE);

            //Lista de Orden
            List list = new List(true,20);
            list.add(new ListItem("Lista de asistencia y declaratoria de quórum legal.", cuerpoF));

            list.add(new ListItem(itemList, cuerpoF));
            list.setIndentationLeft(20);
            documento.add(list);

            documento.add(Chunk.NEWLINE);
            documento.add(new LineSeparator(0.5f, 100, null, 0, -5));
            documento.add(Chunk.NEWLINE);

            //Revision del Orden
            List acto = new List(true, 20);
            acto.add(new ListItem("Con la presencia de "+presentes+" de un total de "+miembrosTotales+
                    " miembros de la "+academia+", se declaro que "+desicion+
                    " había quórum legal."+"\n\n", cuerpoF));

            acto.add(new ListItem(" "+"\n\n", cuerpoF));
            documento.add(acto);

            //Final de minuta
            Paragraph Final = new Paragraph("No habiendo mas asuntos que tratar, se dio por concluida la reunión siendo las "+hr+":"+min+
                    " horas del "+dia+"/"+mes+"/"+anio+".",cuerpoF);
            documento.add(Final);

            documento.add(new LineSeparator(0.5f, 100, null, 0, -5));
            documento.add(Chunk.NEWLINE);

            //Tabla Encargados
            PdfPTable tablaPrincipal = new PdfPTable(2);
            tablaPrincipal.setWidthPercentage(100);
            PdfPCell cellTitulo = new PdfPCell(new Paragraph(academia,tituloN));
            cellTitulo.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellTitulo.setColspan(2);
            cellTitulo.setBorder(PdfPCell.NO_BORDER);
            tablaPrincipal.addCell(cellTitulo);
            //nombres y roles Tabla Encargados
            PdfPCell miembroP = new PdfPCell(new Paragraph(preside+"\n"+rolP,cuerpoF));
            PdfPCell miembroS= new PdfPCell(new Paragraph(secunda+"\n"+rolS, cuerpoF));
            miembroP.setFixedHeight(60);
            miembroS.setFixedHeight(60);
            miembroP.setVerticalAlignment(Element.ALIGN_BOTTOM);
            miembroP.setHorizontalAlignment(Element.ALIGN_CENTER);
            miembroS.setVerticalAlignment(Element.ALIGN_BOTTOM);
            miembroS.setHorizontalAlignment(Element.ALIGN_CENTER);
            miembroP.setBorder(PdfPCell.NO_BORDER);
            miembroS.setBorder(PdfPCell.NO_BORDER);
            tablaPrincipal.addCell(miembroP);
            tablaPrincipal.addCell(miembroS);
            documento.add(tablaPrincipal);

            documento.add(new LineSeparator(0.5f, 100, null, 0, -5));
            documento.add(Chunk.NEWLINE);

            //Tabla Miembros
            PdfPTable table2 = new PdfPTable(2);
            table2.setWidthPercentage(100);
            PdfPCell cellTitulo2 = new PdfPCell(new Paragraph("Miembros de la "+academia,tituloN));
            cellTitulo2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellTitulo2.setColspan(2);
            cellTitulo2.setBorder(PdfPCell.NO_BORDER);
            table2.addCell(cellTitulo2);
            //nombre y firma
            PdfPCell nombre = new PdfPCell(new Paragraph("Nombre",cuerpoF));
            PdfPCell firma = new PdfPCell(new Paragraph("Firma", cuerpoF));
            nombre.setNoWrap(false);
            firma.setNoWrap(false);
            nombre.setHorizontalAlignment(Element.ALIGN_CENTER);
            firma.setHorizontalAlignment(Element.ALIGN_CENTER);
            nombre.setBorder(PdfPCell.NO_BORDER);
            firma.setBorder(PdfPCell.NO_BORDER);
            table2.addCell(nombre);
            table2.addCell(firma);
            //nombres y roles
            PdfPCell miembro = new PdfPCell(new Paragraph(nombreG+"\n"+rolG,cuerpoF));
            PdfPCell linea= new PdfPCell(new Paragraph("______________________", cuerpoF));
            miembro.setFixedHeight(60);
            linea.setFixedHeight(60);
            miembro.setVerticalAlignment(Element.ALIGN_BOTTOM);
            miembro.setHorizontalAlignment(Element.ALIGN_CENTER);
            linea.setVerticalAlignment(Element.ALIGN_BOTTOM);
            linea.setHorizontalAlignment(Element.ALIGN_CENTER);
            miembro.setBorder(PdfPCell.NO_BORDER);
            linea.setBorder(PdfPCell.NO_BORDER);
            table2.addCell(miembro);
            table2.addCell(linea);
            documento.add(table2);


            //cierre Documento
            documento.add(new LineSeparator(0.5f, 100, null, 0, -5));

            documento.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        //Llama a aplicacion de PDF reader
        String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/FrameWork/PDF/"+ nombrePDF;
        File targetFile = new File(path);
        Uri targetUri = Uri.fromFile(targetFile);
        Intent intent;
        intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(targetUri, "application/pdf");
        c.startActivity(intent);

    }
}
