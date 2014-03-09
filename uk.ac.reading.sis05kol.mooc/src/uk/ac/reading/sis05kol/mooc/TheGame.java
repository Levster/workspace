package uk.ac.reading.sis05kol.mooc;

import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class TheGame extends GameThread{

	//Will be used as the ball object
	Ball mBallObj = new Ball(0,0,0,0);
	
	//This is run before anything else, so we can prepare things here
	public TheGame(GameView gameView) {
		//House keeping
		super(gameView);
		//Prepare the image so we can draw it on the screen (using a canvas)
		mBallObj.mBall = BitmapFactory.decodeResource
				(gameView.getContext().getResources(), 
				R.drawable.small_red_ball);
		}
	
	//This is run before a new game (also after an old game)
	@Override
	public void setupBeginning() {
		
		mBallObj.mBallX = mCanvasWidth / 2;
		mBallObj.mBallY = mCanvasHeight / 2;
		mBallObj.mBallSpeedX = 0;
		mBallObj.mBallSpeedY = 0;
		

	}

	@Override
	protected void doDraw(Canvas canvas) {
		//If there isn't a canvas to draw on do nothing
		//It is ok not understanding what is happening here
		if(canvas == null) return;
		
		super.doDraw(canvas);
		
		//draw the image of the ball using the X and Y of the ball
		//drawBitmap uses top left corner as reference, we use middle of picture
		//null means that we will use the image without any extra features (called Paint)
		canvas.drawBitmap(mBallObj.mBall, mBallObj.mBallX - mBallObj.mBall.getWidth() / 2, mBallObj.mBallY - mBallObj.mBall.getHeight() / 2, null);
	}
	
	//This is run whenever the phone is touched by the user

	@Override
	protected void actionOnTouch(float x, float y) {
		//Increase/decrease the speed of the ball making the ball move towards the touch
		mBallObj.changeCourse(x, y);
					
	}

	/*
	//This is run whenever the phone moves around its axises 
	@Override
	protected void actionWhenPhoneMoved(float xDirection, float yDirection, float zDirection) {
		//Increase/decrease the speed of the ball
		mBallSpeedX = mBallSpeedX - 1.5f * xDirection;
		mBallSpeedY = mBallSpeedY - 1.5f * yDirection;
	}
	*/
	
	//This is run just before the game "scenario" is printed on the screen
	@Override
	protected void updateGame(float secondsElapsed) {
		//Move the ball's X and Y using the speed (pixel/sec)
		mBallObj.positionUpdate(mCanvasWidth, mCanvasHeight, secondsElapsed);
				
	}
}

// This file is part of the course "Begin Programming: Build your first mobile game" from futurelearn.com
// Copyright: University of Reading and Karsten Lundqvist
// It is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// It is is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// 
// You should have received a copy of the GNU General Public License
// along with it.  If not, see <http://www.gnu.org/licenses/>.
