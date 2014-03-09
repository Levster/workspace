package uk.ac.reading.sis05kol.mooc;

import android.graphics.Bitmap;

public class Ball {

	public Bitmap mBall;
	
	// stores the position of the ball
	public float mBallX;
	public float mBallY;
	
	// stores the speed of the ball
	public float mBallSpeedX;
	public float mBallSpeedY;

	public Ball(float initialX, float initialY, float initialXSpeed, float initialYSpeed) {
		mBallX = initialX;
		mBallY = initialY;
		mBallSpeedX = initialXSpeed;
		mBallSpeedY = initialYSpeed;
			
	}
	
	public void changeCourse(float touchX, float touchY) {
		
		mBallSpeedX = (touchX - mBallX)/2;
		mBallSpeedY = (touchY - mBallY)/2;
		
	}
	
	public void positionUpdate (int mCanvasWidth, int mCanvasHeight, float secondsElapsed) {
		
		if (mBallX < 0){
			mBallX = 0;
			mBallSpeedX = mBallSpeedX*(-1);
		} else if (mBallX > mCanvasWidth){
			mBallX = mCanvasWidth;
			mBallSpeedX = mBallSpeedX*(-1);
		} 
		mBallX = mBallX + secondsElapsed * mBallSpeedX;
	
		if (mBallY < 0){
			mBallY = 0;
			mBallSpeedY = mBallSpeedY*(-1);
		} else if (mBallY > mCanvasHeight){
			mBallY = mCanvasHeight;
			mBallSpeedY = mBallSpeedY*(-1);
		} 
		mBallY = mBallY + secondsElapsed * mBallSpeedY;
		
				
	}
	
}
