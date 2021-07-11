
public class City {
	
	private int id;
	private String name;
	private int population;
	private String country_code;
	
	
	
	public City(int id, String name, int population, String country_code) {
		
		this.id = id;
		this.name = name;
		this.population = population;
		this.country_code = country_code;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public String getCountry_code() {
		return country_code;
	}
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", population=" + population + ", country_code=" + country_code
				+ "]";
	}
	
	
	

}
