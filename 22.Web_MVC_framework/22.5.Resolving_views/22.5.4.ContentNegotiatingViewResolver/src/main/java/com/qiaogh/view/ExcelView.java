package com.qiaogh.view;

import com.qiaogh.domain.User;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class ExcelView extends AbstractXlsView {


    @Override
    protected void buildExcelDocument( Map<String, Object> model,
                                       Workbook workbook,
                                       HttpServletRequest request,
                                       HttpServletResponse response ) throws Exception {
        User user = (User) model.get( "user" );

        Sheet sheet = workbook.createSheet( "用户信息" );
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFillForegroundColor( IndexedColors.GREEN.index );
        cellStyle.setFillPattern( FillPatternType.SOLID_FOREGROUND );
        cellStyle.setAlignment( HorizontalAlignment.CENTER );

        Row row = sheet.createRow( 0 );
        Cell cell = row.createCell( 0 );
        cell.setCellStyle( cellStyle );
        cell.setCellValue( "Id" );

        cell = row.createCell( 1 );
        cell.setCellStyle( cellStyle );
        cell.setCellValue( "Name" );

        cell = row.createCell( 2 );
        cell.setCellStyle( cellStyle );
        cell.setCellValue( "Password" );

        row = sheet.createRow( 1 );

        cell = row.createCell( 0 );
        cell.setCellStyle( cellStyle );
        cell.setCellValue( user.getId() );

        cell = row.createCell( 1 );
        cell.setCellStyle( cellStyle );
        cell.setCellValue( user.getName() );

        cell = row.createCell( 2 );
        cell.setCellStyle( cellStyle );
        cell.setCellValue( user.getPassword() );

        for ( int i = 0; i < 3; i++ ) {
            sheet.autoSizeColumn( i, true );
        }
    }
}
