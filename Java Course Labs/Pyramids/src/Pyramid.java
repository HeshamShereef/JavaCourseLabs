
public class Pyramid {
	private String pharoh;
	private String modern_name;
	private String site;
	private double height;
	public String getPharoh() {
		return pharoh;
	
	}
	public Pyramid(String pharoh, String modern_name, String site, double height) {

		this.pharoh = pharoh;
		this.site = site;
		this.modern_name = modern_name;
		this.height = height;
	}
	public void setPharoh(String pharoh) {
		this.pharoh = pharoh;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getModern_name() {
		return modern_name;
	}
	public void setModern_name(String modern_name) {
		this.modern_name = modern_name;
	}
	public double getHeight() {
		return height;
	}
	public void setheight(double height) {
		this.height = height;
	}
	@Override
	public String toString() {
		return "Pyramid [pharoh=" + pharoh + ", modern_name=" + modern_name + ", site=" + site + ", height=" + height
				+ "]";
	}
	
	
	
	

}
