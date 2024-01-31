package exception;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.JTable;

import java.io.FileOutputStream;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PDFExporter {

    public static void exportTableToPDF(JTable table, String title) {
        Document document = new Document(PageSize.A4.rotate());

        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Chọn vị trí để xuất file PDF");
            fileChooser.setFileFilter(new FileNameExtensionFilter("PDF Files (*.pdf)", "pdf"));
            int userSelection = fileChooser.showSaveDialog(table);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                String filePath = fileChooser.getSelectedFile().getAbsolutePath();

                // Ensure the file has a .xlsx extension
                if (!filePath.toLowerCase().endsWith(   ".pdf")) {
                    filePath += ".pdf";
                }

                File file = new File(filePath);

                // Check if the file already exists
                if (file.exists()) {
                    MessageDialog.showErrorDialog(table, "Tên file đã tồn tại! Vui lòng chọn tên khác.", "Lỗi");
                } else {
                    PdfWriter.getInstance(document, new FileOutputStream(filePath));
                    document.open();

                    // Chọn font Roboto
                    BaseFont baseFont = BaseFont.createFont("src/fonts/Roboto-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                    com.itextpdf.text.Font roboto = FontFactory.getFont("src/fonts/Roboto-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 13);
                    BaseFont baseFontTitle = BaseFont.createFont("src/fonts/Roboto-Medium.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                    com.itextpdf.text.Font robotoTitle = FontFactory.getFont("src/fonts/Roboto-Medium.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 16);

                    // Tạo một bảng iText
                    PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
                    pdfTable.setWidthPercentage(100);

                    // Tạo một ô đặc biệt chứa tiêu đề và đặt căn giữa
                    PdfPCell titleCell = new PdfPCell(new Phrase(title, robotoTitle));
                    titleCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    titleCell.setColspan(table.getColumnCount());
                    titleCell.setPaddingTop(12);
                    titleCell.setPaddingBottom(12);
                    titleCell.setPaddingLeft(14);
                    titleCell.setPaddingRight(14);
                    titleCell.setBorder(Rectangle.NO_BORDER);
                    pdfTable.addCell(titleCell);

                    // Thêm tiêu đề từ tên cột của bảng Swing
                    TableColumnModel columnModel = table.getColumnModel();
                    for (int column = 0; column < columnModel.getColumnCount(); column++) {
                        TableColumn tableColumn = columnModel.getColumn(column);
                        PdfPCell cell = new PdfPCell(new Phrase(tableColumn.getHeaderValue().toString(), roboto));
                        titleCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setBackgroundColor(BaseColor.YELLOW);
                        cell.setPaddingTop(4);
                        cell.setPaddingLeft(8);
                        cell.setPaddingRight(8);
                        cell.setPaddingBottom(4);
                        pdfTable.addCell(cell);
                    }

                    // Thêm dữ liệu từ bảng Swing
                    for (int row = 0; row < table.getRowCount(); row++) {
                        for (int column = 0; column < table.getColumnCount(); column++) {
                            PdfPCell cellContent = new PdfPCell(new Phrase(table.getValueAt(row, column).toString(), roboto));
                            cellContent.setPaddingTop(4);
                            cellContent.setPaddingBottom(4);
                            cellContent.setPaddingLeft(8);
                            cellContent.setPaddingRight(8);
                            pdfTable.addCell(cellContent);
                        }
                    }

                    document.add(pdfTable);
                    MessageDialog.showInfoDialog(table, "Đã xuất PDF thành công, xem file của bạn ở " + filePath, "Thông báo");
                }
            }

        } catch (Exception ex) {
            MessageDialog.showErrorDialog(table, "Có lỗi khi xuất PDF, chi tiết: " + ex.getMessage(), "Lỗi");
            ex.printStackTrace();
        } finally {
            document.close();
        }
    }

}
