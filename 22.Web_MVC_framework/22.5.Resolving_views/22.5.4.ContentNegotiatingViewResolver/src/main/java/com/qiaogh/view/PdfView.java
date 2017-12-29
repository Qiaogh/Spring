package com.qiaogh.view;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.qiaogh.domain.User;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.Map;

public class PdfView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument( Map<String, Object> model,
                                     Document document,
                                     PdfWriter writer,
                                     HttpServletRequest request,
                                     HttpServletResponse response ) throws Exception {
        User user = (User) model.get( "user" );

        PdfPTable table = new PdfPTable( 3 );
        table.getDefaultCell().setHorizontalAlignment( Element.ALIGN_CENTER );
        table.getDefaultCell().setVerticalAlignment( Element.ALIGN_MIDDLE );
        table.getDefaultCell().setBackgroundColor( Color.lightGray );

        table.addCell( "Id" );
        table.addCell( "Name" );
        table.addCell( "Password" );

        table.addCell( user.getId() );
        table.addCell( user.getName() );
        table.addCell( user.getPassword() );

        document.addTitle( "用户信息" );
        document.add( table );
    }
}
