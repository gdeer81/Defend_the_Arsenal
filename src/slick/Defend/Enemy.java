package slick.Defend;

public class Enemy {
	private double x;
	private double y;
	private double speed = 20.0f; // pix/second
	
	private Player player;
	
	public Enemy() {
		x = 0;
		y = 250;
	}
	
	public Enemy(Player player) {
		this();
		this.player = player;		
	}
	
	public int getX() {
		return (int)x;
	}
	
	public int getY() {
		return (int)y;
	}
	
	public void think(long millisSinceLastThink) {
		
		// we just want to move towards the player
		//x_location+=(MAX_RUN_SPEED * (millisSinceLastStep * 0.001f));
		if( x > player.getX())
			x-=(speed * ((double)millisSinceLastThink * 0.001f));
		if( x < player.getX())
			x+=(speed * ((double)millisSinceLastThink * 0.001f));
		
		//keep this guy on the screen
		if(x > 800)
			x = 750;
		if(x < 0)
			x = 0;
		if(y > 600)
			y = 550;
		if(y < 0)
			y = 0;
	}
}
