package application;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import utils.Utils;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VideoController {
	
		@FXML
		private Button start_button;
		@FXML
		private ImageView currentFrame;
		
		private ScheduledExecutorService timer;
		
		private VideoCapture capture=new VideoCapture();
		
		private Boolean cameraActive = false;
		
		private static int cameraId=0;
		
		@FXML
	  protected  void startCamera(ActionEvent event) {

			if(!this.cameraActive) 
			{
				this.capture.open(cameraId);
				
				if(this.capture.isOpened()) 
				{
					this.cameraActive= true;
					
					Runnable frameGrabber=new Runnable() 
					{
						@Override
						public void run() 
						{
							
							Mat frame=grabFrame();
							
							Image imageToShow=Utils.mat2Image(frame);
							updateImageView(currentFrame, imageToShow);
						}
						
					};
						this.timer=Executors.newSingleThreadScheduledExecutor();
						this.timer.scheduleAtFixedRate(frameGrabber, 0, 33, TimeUnit.MILLISECONDS);
						this.start_button.setText("Stop Camera");
					
				}
				else 
				{
					System.err.println("Kamera bağlantısı Sağlanamadı");
				}
				
				}
			else 
			{
				this.cameraActive= false;
				this.start_button.setText("Start Camera");
				this.stopAcquisition();
			}
	    }
		private void stopAcquisition() {

			if(this.timer!=null && !this.timer.isShutdown()) 
			{
				try 
				{
					this.timer.shutdown();
					this.timer.awaitTermination(33, TimeUnit.MILLISECONDS);
				}
				catch (InterruptedException e)
				{
					System.err.println("Tekrar deneyin.. " + e);
				}
			}
			if(this.capture.isOpened()) 
			{
			this.capture.release();	
			}
		}
	
		private Mat grabFrame() {
			
				Mat frame=new Mat();
				
				if(this.capture.isOpened()) 
				{
					try 
					{
						
						this.capture.read(frame);
						
						if(!frame.empty()) 
						{
							Imgproc.cvtColor(frame, frame, Imgproc.COLOR_BGR2GRAY);
						}
						
					}
					
					catch (Exception e) 
					{
						System.err.println("RGB Hatası.." + e);					
					}
				}
			return frame;
		}
		private void updateImageView(ImageView view,Image image) 
		{
			
			Utils.onFXThread(view.imageProperty(),image);
		}
		
		protected void setClosed() 
		{
		this.stopAcquisition();
		}

}
