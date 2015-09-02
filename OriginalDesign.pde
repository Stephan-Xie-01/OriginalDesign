void setup()
{
	size(800, 600);
	frameRate(60);
}

int opacity = 1000;

//ball coords
int ballX = 300;
int ballY = 590;

int ranX = ((int)(Math.random()));
int ranY = ((int)(Math.random()));

int carX = -100;
float carY = 400;

float carElevation = 0;

int drop = 400;

void draw()
{
	background(0, 0, 0);
	car();
	drops();
	explosion();
	

	//turning pt
	if(carX > 200){
		carElevation = carElevation - 0.1;
	}

	//reset
	if(carX > 900){
		carY = 400;
		carX = -100;
		carElevation = 0;
		drop = 400;		
	}

	//changes
	carX = carX + 10;
	carY = carY + carElevation;
	carElevation = carElevation*1.02;
	//System.out.println(carY);
	//System.out.println(carElevation);
	drop++;


}	




void car(){
	noStroke();
	fill(250, 250, 250);
	
	ellipse(carX, carY,160,30);
	ellipse(carX, carY - 10, 100, 40);
}


void drops(){
	ellipse(carX+10, drop, 30, 10);
	ellipse(carX+60, drop + 20, 30, 10);

}

int explode = 0;
void explosion(){

	if(carX > 400){
		explode = 0;
	}
	fill(250,250,250,30);
	ellipse(800, 500, explode, explode);
	ellipse(700, 600, explode, explode);
	explode += 10;
	
}












