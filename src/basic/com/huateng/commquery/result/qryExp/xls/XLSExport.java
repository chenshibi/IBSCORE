package com.huateng.commquery.result.qryExp.xls;

import java.io.IOException;
import java.util.List;

import com.huateng.commquery.result.qryExp.QueryExport;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 * 导出数据到XLS格式的文件
 */
public class XLSExport extends QueryExport {
    /** Excel **/
    private WritableWorkbook book = null;
    /** Excel工作表 **/
    private WritableSheet sheet = null;
    /** 行数 */
    private int row = 0;

    /** 导出类的描述 **/
    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * 初始化Excel工作表
     * 
     * @throws IOException
     */
    private void init() throws IOException {
        if (book == null) {
            book = Workbook.createWorkbook(out);
        }
        if (sheet == null) {
            sheet = book.createSheet("Sheet1", 0);
        }
    }

    /**
     * 将文件内容写入输出流 details => List<String[]>
     */
    public void writeDetails(List<String[]> details) throws IOException {
        init();
        for (int i = 0; i < details.size(); i++) {
            String[] strings = details.get(i);
            for (int j = 0; j < strings.length; j++) {
                try {
                    sheet.addCell(new Label(j, row, strings[j]));
                } catch (Exception e) {
                    throw new IOException(e.getMessage());
                }
            }
            row++;
        }
    }

    /**
     * 将文件头信息写入输出流 titles => List<String[]>
     */
    public void writeHead(List<String[]> titles) throws IOException {
        init();
        row = 0;
        try {
            for (int i = 0; i < titles.size(); i++) {
                String[] strings = titles.get(i);
                if ("TITLE".equals(strings[0])) {
                    WritableCellFormat wcf = new WritableCellFormat(
                            new WritableFont(WritableFont.ARIAL, 12, WritableFont.BOLD));
                    wcf.setAlignment(Alignment.CENTRE);
                    sheet.addCell(new Label(0, row, strings[2], wcf));
                    sheet.mergeCells(0, row, Integer.valueOf(strings[1]), row);
                } else {
                    WritableCellFormat wcf = new WritableCellFormat(
                            new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD));
                    for (int j = 0; j < strings.length; j++) {
                        sheet.addCell(new Label(j, row, strings[j], wcf));
                    }
                }
                row++;
            }
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

    /**
     * 将文件尾信息写入输出流 tails => List<String[]>
     */
    public void writeTail(List<String[]> tails) throws IOException {
        init();
        for (int i = 0; i < tails.size(); i++) {
            String[] strings = tails.get(i);
            for (int j = 0; j < strings.length; j++) {
                try {
                    sheet.addCell(new Label(j, row, strings[j]));
                } catch (Exception e) {
                    throw new IOException(e.getMessage());
                }
            }
            row++;
        }
    }

    @Override
    public void clear() throws IOException {
        try {
            book.write();
            book.close();
            out.close();
            //
            sheet = null;
            book = null;
        } catch (WriteException e) {
            throw new IOException(e.getMessage());
        }
    }

}
