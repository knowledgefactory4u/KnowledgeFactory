package com.knf.dev.KotlinSpringExportPDF.util

import com.itextpdf.text.*
import com.itextpdf.text.pdf.PdfPCell
import com.itextpdf.text.pdf.PdfPTable
import com.itextpdf.text.pdf.PdfWriter
import com.knf.dev.KotlinSpringExportPDF.model.Employee
import org.slf4j.LoggerFactory
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.util.stream.Stream


object PDFGenerator {
    private val logger = LoggerFactory.getLogger(PDFGenerator::class.java)
    fun employeePDFReport(employees: List<Employee>): ByteArrayInputStream {
        val document = Document()
        val out = ByteArrayOutputStream()
        try {
            PdfWriter.getInstance(document, out)
            document.open()

            // Add Text to PDF file ->
            val font = FontFactory.getFont(
                FontFactory.COURIER, 14f,
                BaseColor.BLACK
            )
            val para = Paragraph("Employee Table", font)
            para.alignment = Element.ALIGN_CENTER
            document.add(para)
            document.add(Chunk.NEWLINE)
            val table = PdfPTable(3)
            // Add PDF Table Header ->
            Stream.of("ID", "First Name", "Last Name").forEach { headerTitle: String? ->
                val header = PdfPCell()
                val headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD)
                header.backgroundColor = BaseColor.LIGHT_GRAY
                header.horizontalAlignment = Element.ALIGN_CENTER
                header.borderWidth = 2f
                header.phrase = Phrase(headerTitle, headFont)
                table.addCell(header)
            }
            for (employee in employees) {
                val idCell = PdfPCell(Phrase(employee.id.toString()))
                idCell.paddingLeft = 4f
                idCell.verticalAlignment = Element.ALIGN_MIDDLE
                idCell.horizontalAlignment = Element.ALIGN_CENTER
                table.addCell(idCell)
                val firstNameCell = PdfPCell(Phrase(employee.firstName))
                firstNameCell.paddingLeft = 4f
                firstNameCell.verticalAlignment = Element.ALIGN_MIDDLE
                firstNameCell.horizontalAlignment = Element.ALIGN_LEFT
                table.addCell(firstNameCell)
                val lastNameCell = PdfPCell(Phrase(employee.lastName.toString()))
                lastNameCell.verticalAlignment = Element.ALIGN_MIDDLE
                lastNameCell.horizontalAlignment = Element.ALIGN_RIGHT
                lastNameCell.paddingRight = 4f
                table.addCell(lastNameCell)
            }
            document.add(table)
            document.close()
        } catch (e: DocumentException) {
            logger.error(e.toString())
        }
        return ByteArrayInputStream(out.toByteArray())
    }
}