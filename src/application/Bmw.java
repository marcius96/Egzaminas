package application;

public class Bmw {
	private int vin;
	private String series;
	private String fuel;
	private String type;
	private String condition;
	
	public Bmw(int vin, String series, String fuel, String type, String condition) {
		this.vin = vin;
		this.series = series;
		this.fuel = fuel;
		this.type = type;
		this.condition = condition;
		
		
	}

	public int getVin() {
		return vin;
	}

	public void setVIN(int vin) {
		vin = vin;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	
}
