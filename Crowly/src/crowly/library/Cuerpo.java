package crowly.library;

import java.util.Date;
import java.util.UUID;

public class Cuerpo {
	private int PosX;
	private int PosY;
	private int Time;
	private UUID Id;
	
	public Cuerpo(int pX, int pY, int videoTime)
	{
		Id = UUID.randomUUID();
		Time = videoTime;
		PosY = pY;
		PosX = pX;
	}

	public int getPosX() {
		return PosX;
	}

	public void setPosX(int posX) {
		PosX = posX;
	}

	public int getPosY() {
		return PosY;
	}

	public void setPosY(int posY) {
		PosY = posY;
	}

	public int getTime() {
		return Time;
	}

	public void setTime(int time) {
		this.Time = time;
	}

	public UUID getId() {
		return Id;
	}

	public void setId(UUID id) {
		Id = id;
	}
	
	
}