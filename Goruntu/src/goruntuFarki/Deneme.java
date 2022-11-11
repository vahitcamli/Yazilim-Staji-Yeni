package goruntuFarki;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Deneme {

	public static void main(String[] args) 
	{
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat goruntu1 = Imgcodecs.imread("C:\\XboxGames\\kalemler\\kalem.jpg");
		Mat goruntu1Gray = new Mat();
		Imgproc.cvtColor(goruntu1, goruntu1Gray, Imgproc.COLOR_RGB2GRAY);
		Mat goruntu2= Imgcodecs.imread("C:\\XboxGames\\kalemler\\kalem2.jpg");
		Mat goruntu2Gray = new Mat();
		Imgproc.cvtColor(goruntu2, goruntu2Gray, Imgproc.COLOR_RGB2GRAY);
		Mat islemSonucu = new Mat();
		Core.absdiff(goruntu2Gray, goruntu1Gray, islemSonucu);
		Imgcodecs.imwrite("C:\\XboxGames\\kalemler\\yeni.jpg", islemSonucu);
		
		Mat thresholdcikti = new Mat();
		Imgproc.threshold(islemSonucu, thresholdcikti, 20, 200, Imgproc.THRESH_BINARY);
		Imgcodecs.imwrite("C:\\XboxGames\\kalemler\\yenithresold.jpg", thresholdcikti);
	}
}
