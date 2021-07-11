
public class Country {
	private String code;
	private String name;
	private String continent;
	private double surface_area;
	private int population;
	
	
	
	
	public Country(String code, String name, String continent, double surface_area, int population) {
		
		this.code = code;
		this.name = name;
		this.continent = continent;
		this.surface_area = surface_area;
		this.population = population;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public double getSurface_area() {
		return surface_area;
	}
	public void setSurface_area(double surface_area) {
		this.surface_area = surface_area;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + ", continent=" + continent + ", surface_area="
				+ surface_area + ", population=" + population + "]";
	}
	
	

}
