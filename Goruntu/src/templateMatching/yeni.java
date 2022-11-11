package templateMatching;

import org.opencv.core.Core;
import org.opencv.core.Core.MinMaxLocResult;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class yeni {

	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		Mat kaynak=null;
		Mat sablon=null;
		
		String dosyaYolu = "C:\\XboxGames\\kalemler";
		kaynak=Imgcodecs.imread(dosyaYolu+"\\kalem.jpg");
		sablon=Imgcodecs.imread(dosyaYolu+"\\filtre.jpg");
		
		Mat cikti = new Mat();
		int metod = Imgproc.TM_CCOEFF;
		
		Imgproc.matchTemplate(kaynak, sablon, cikti, metod);
		MinMaxLocResult mmr = Core.minMaxLoc(cikti);
		Point matchloc = mmr.maxLoc;
		
		Imgproc.rectangle(kaynak, matchloc, new Point(matchloc.x + sablon.cols(),matchloc.y + sablon.rows()), new Scalar(255, 0, 0));
		
		Imgcodecs.imwrite(dosyaYolu+"\\eslesme.jpg", kaynak);
	}

}
