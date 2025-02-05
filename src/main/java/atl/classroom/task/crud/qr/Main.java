package atl.classroom.task.crud.qr;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Base64;

@Component
public class Main {

    //    @PostConstruct
    @SneakyThrows
    public void generateQr() {
        String text = "https://www.linkedin.com/in/hasanovelnur/"; // Set the QR code URL

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 350, 350);
        BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);

        // Save as file to view
        File outputFile = new File("qr_code.png");
        ImageIO.write(bufferedImage, "png", outputFile);
        System.out.println("QR Code saved: " + outputFile.getAbsolutePath());

        // Convert to Base64 (Optional: If you want to send via API)
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", byteArrayOutputStream);
        String base64Image = Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
        System.out.println("Base64 QR Code: " + base64Image);
    }
}
