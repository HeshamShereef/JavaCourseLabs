import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DaoImp implements CDao {
	private List country_list = new ArrayList<Country>();
	private List<City> city_list =  new ArrayList<City>();
	
	public List<Country> ReadCountryFromCSV(String fileName) throws IOException{
		
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		Country c1;
		
		do {
			line = br.readLine();
			if (line != null)
			{
				String[] attr = line.split(",");
			
				
				c1= new Country(attr[0], attr[1], attr[2],Double.parseDouble(attr[3]), Integer.parseInt(attr[4]));
				country_list.add(c1);
				
			}
		} while(line != null);
		br.close();
		return country_list;
		
	}
	
	public List<City> ReadCityFromCSV(String fileName) throws IOException{
		
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		String line1 = br.readLine();
		City ci1;
		
		do {
			line1 = br.readLine();
			if (line1 != null)
			{
				String[] attr_ = line1.split(",");
			
				
				ci1= new City(Integer.parseInt(attr_[0]), attr_[1], Integer.parseInt(attr_[2]),attr_[3]);
				city_list.add(ci1);
				
			}
		} while(line1 != null);
		br.close();
		return city_list;
		
	}

}
