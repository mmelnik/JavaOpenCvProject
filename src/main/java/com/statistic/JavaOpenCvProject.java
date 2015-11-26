package com.statistic;

import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import com.statistic.gui.GUIFilter;
import com.statistic.gui.Handler;

/**
 * Created by senich on 7/24/2015.
 */
public class JavaOpenCvProject {

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    private static HsvValuesHolder hsvValuesHolder = new HsvValuesHolder();

    private static Mat hsvMatrix;
    private static Mat hMatrix;
    private static Mat sMatrix;
    private static Mat vMatrix;
    private static Mat destMatrix;
    private static BufferedImage sourceImage;
    private static BufferedImage hImage;
    private static BufferedImage sImage;
    private static BufferedImage vImage;
    private static Mat sourceMatrix;
    private static GUIFilter gui;

    private static Mat contourMat;

    private static List<MatOfPoint> contours;
    private static Mat hierarchy;

    public static void main(String[] args) throws Exception {
        final File file1 = new File("src/main/resources/pics/car3.jpg");
        final File file2 = new File("src/main/resources/pics/car6.jpg");
        final File file3 = new File("src/main/resources/pics/car7.jpg");
        final File file4 = new File("src/main/resources/pics/kotenok-s-klubkom2.jpg");
        
        sourceImage = ImageIO.read(file1);
        sourceMatrix = convertImageToMat(sourceImage);

        hsvMatrix = initializeMatrixForImage(sourceImage);
        hMatrix = initializeMatrixForImage(sourceImage);
        sMatrix = initializeMatrixForImage(sourceImage);
        vMatrix = initializeMatrixForImage(sourceImage);

        destMatrix = initializeMatrixForImage(sourceImage);

        EventQueue.invokeLater(new Runnable() {
            public void run() {

                gui = new GUIFilter();
                gui.setPreviewImages(sourceImage);
                gui.setVisible(true);

                gui.setHandler11(new Handler() {
                    public void handle(int newValue) {
                        hsvValuesHolder.sethMin(newValue);
                        handleSlidersValuesChange();
                    }
                });

                gui.setHandler12(new Handler() {
                    public void handle(int newValue) {
                        hsvValuesHolder.sethMax(newValue);
                        handleSlidersValuesChange();
                    }
                });
                gui.setHandler21(new Handler() {
                    public void handle(int newValue) {
                        hsvValuesHolder.setsMin(newValue);
                        handleSlidersValuesChange();
                    }
                });

                gui.setHandler22(new Handler() {
                    public void handle(int newValue) {
                        hsvValuesHolder.setsMax(newValue);
                        handleSlidersValuesChange();
                    }
                });
                gui.setHandler31(new Handler() {
                    public void handle(int newValue) {
                        hsvValuesHolder.setvMin(newValue);
                        handleSlidersValuesChange();
                    }
                });

                gui.setHandler32(new Handler() {
                    public void handle(int newValue) {
                        hsvValuesHolder.setvMax(newValue);
                        handleSlidersValuesChange();
                    }
                });
                gui.setHandler41(new Handler() {
                    public void handle(int newValue) {
//                        hsvValuesHolder.setvMin(newValue);
//                        handleSlidersValuesChange();
                    }
                });

                gui.setHandler42(new Handler() {
                    public void handle(int newValue) {
//                        hsvValuesHolder.setvMax(newValue);
//                        handleSlidersValuesChange();
                    }
                });
            }
        });
        /*

        Core.inRange(hsvMatrix, new Scalar(20, 100, 100), new Scalar(30, 255, 255), destMatrix);

        Mat contourMat = initializeMatrixForImage(sourceImage);
        destMatrix.copyTo(contourMat);
        List<MatOfPoint> contours = new ArrayList<MatOfPoint>();
        Mat hierarchy = initializeMatrixForImage(sourceImage);
        Imgproc.findContours(contourMat, contours, hierarchy, Imgproc.RETR_CCOMP, Imgproc.CHAIN_APPROX_SIMPLE);


        Mat destRgbMatrix = initializeMatrixForImage(sourceImage);
        Imgproc.cvtColor(destMatrix, destRgbMatrix, Imgproc.COLOR_GRAY2BGR);
        BufferedImage destImage = convertMatToRgbImage(sourceMatrix);

        if (hierarchy.size().height > 0 && hierarchy.size().width > 0) {
            double numObjects = hierarchy.size().width * hierarchy.size().height;
            *//*for (int i = 0; i < hierarchy.size().width; i++) {
                for (int j = 0; j < hierarchy.size().height; j++) {
                    double[] d = hierarchy.get(i, j);
//                    Moments moment = contours.get();
                    String p = "";
                }
            }*//*
            for (int i = 0; i < contours.size(); i++) {
                if (Imgproc.contourArea(contours.get(i)) > 50) {
                    Rect rect = Imgproc.boundingRect(contours.get(i));
                    if (rect.height > 28) {
//                        Core.rectangle(rgbMatrix, new Point(rect.x, rect.height), new Point(rect.y, rect.width), new Scalar(0, 255, 0, 255));
                        drawRectangleOnImage(destImage, rect.x, rect.y, rect.width, rect.height);
                    }
                }
            }

        }

        displayImage(destImage);*/
    }

    private static void handleSlidersValuesChange() {

        Imgproc.cvtColor(sourceMatrix, hsvMatrix, Imgproc.COLOR_BGR2HSV);

        Core.inRange(hsvMatrix, new Scalar(hsvValuesHolder.gethMin(), 0, 0), new Scalar(hsvValuesHolder.gethMax(), 255, 255), hMatrix);
        hImage = convertMatToGrayScaleImage(hMatrix);

        Core.inRange(hsvMatrix, new Scalar(0, hsvValuesHolder.getsMin(), 0), new Scalar(255, hsvValuesHolder.getsMax(), 255), sMatrix);
        sImage = convertMatToGrayScaleImage(sMatrix);

        Core.inRange(hsvMatrix, new Scalar(0, 0, hsvValuesHolder.getvMin()), new Scalar(255, 255, hsvValuesHolder.getvMax()), vMatrix);
        vImage = convertMatToGrayScaleImage(vMatrix);

        Core.inRange(hsvMatrix, new Scalar(hsvValuesHolder.gethMin(), hsvValuesHolder.getsMin(), hsvValuesHolder.getvMin()),
                new Scalar(hsvValuesHolder.gethMax(), hsvValuesHolder.getsMax(), hsvValuesHolder.getvMax()), destMatrix);

        BufferedImage destGrayScaleImage = convertMatToGrayScaleImage(destMatrix);
        BufferedImage destRgbImage = convertGrayScaleImageToRgb(destGrayScaleImage);
        BufferedImage sourceRgbImage = convertMatToRgbImage(sourceMatrix);

        contourMat = initializeMatrixForImage(sourceImage);
        contours = new ArrayList<MatOfPoint>();
        hierarchy = initializeMatrixForImage(sourceImage);

        destMatrix.copyTo(contourMat);

        Mat thresh = new Mat();
//        Imgproc.threshold(destMatrix, thresh, 1, 255, Imgproc.THRESH_BINARY_INV);
        Imgproc.threshold(destMatrix, thresh, 1, 10, Imgproc.THRESH_BINARY_INV);
        Imgproc.findContours(contourMat, contours, hierarchy, Imgproc.RETR_CCOMP, Imgproc.CHAIN_APPROX_SIMPLE);

        for (int i = 0; i < contours.size(); i++) {
            if (Imgproc.contourArea(contours.get(i)) > 10) {
                Rect rect = Imgproc.boundingRect(contours.get(i));
                if (rect.height > 1) {
                    drawRectangleOnImage(destRgbImage, rect.x, rect.y, rect.width, rect.height);
                    drawRectangleOnImage(sourceRgbImage, rect.x, rect.y, rect.width, rect.height);
                }
            }
        }

        Mat destRgbMatrix = initializeMatrixForImage(sourceImage);
        Imgproc.cvtColor(destMatrix, destRgbMatrix, Imgproc.COLOR_GRAY2BGR);


        gui.setImage1(hImage);
        gui.setImage2(sImage);
        gui.setImage3(vImage);
        gui.setImage4(destRgbImage);
//        gui.setImage5(sourceRgbImage);
        
        gui.showBigImage(sourceRgbImage);
    }

    private static BufferedImage convertGrayScaleImageToRgb(BufferedImage destGrayScaleImage) {
        BufferedImage image = new BufferedImage(destGrayScaleImage.getWidth(), destGrayScaleImage.getHeight(),
                BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.drawImage(destGrayScaleImage, 0, 0, null);
        g.dispose();
        return image;
    }

    public static void displayImage(Image img2) {
        ImageIcon icon = new ImageIcon(img2);
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(img2.getWidth(null) + 50, img2.getHeight(null) + 50);
        JLabel lbl = new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private static Mat convertImageToMat(BufferedImage image) {
        byte[] data = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        Mat mat = initializeMatrixForImage(image);
        mat.put(0, 0, data);

        return mat;
    }

    private static BufferedImage convertMatToGrayScaleImage(Mat matrix) {
        byte[] data1 = new byte[matrix.rows() * matrix.cols() * (int) (matrix.elemSize())];
        matrix.get(0, 0, data1);
        BufferedImage image = new BufferedImage(matrix.cols(), matrix.rows(), BufferedImage.TYPE_BYTE_GRAY);
        image.getRaster().setDataElements(0, 0, matrix.cols(), matrix.rows(), data1);

        return image;
    }

    private static BufferedImage convertMatToRgbImage(Mat matrix) {
        byte[] data1 = new byte[matrix.rows() * matrix.cols() * (int) (matrix.elemSize())];
        matrix.get(0, 0, data1);
        BufferedImage image = new BufferedImage(matrix.cols(), matrix.rows(), BufferedImage.TYPE_3BYTE_BGR);
        image.getRaster().setDataElements(0, 0, matrix.cols(), matrix.rows(), data1);

        return image;
    }

    public static int safeLongToInt(long l) {
        if (l < Integer.MIN_VALUE || l > Integer.MAX_VALUE) {
            throw new IllegalArgumentException
                    (l + " cannot be cast to int without changing its value.");
        }
        return (int) l;
    }

    private static Mat initializeMatrixForImage(BufferedImage image) {
        return new Mat(image.getHeight(), image.getWidth(), CvType.CV_8UC3);
    }

    public static void drawRectangleOnImage(BufferedImage image, int x, int y, int width, int height) {
        Graphics2D graph = image.createGraphics();
        graph.setColor(Color.GREEN);
        graph.setStroke(new BasicStroke(1));
        graph.draw(new Rectangle(x, y, width, height));
        graph.dispose();
    }

}
