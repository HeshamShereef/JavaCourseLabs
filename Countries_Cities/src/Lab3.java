import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;


public class Lab3 {

	public static void main(String[] args) throws IOException {
	List countryList = new ArrayList<Country>();
	List cityList = new ArrayList<City>();
	DaoImp co_ci = new DaoImp();
	countryList = co_ci.ReadCountryFromCSV("Countries.csv");
	cityList = co_ci.ReadCityFromCSV("Cities.csv");
	
	Map <String, List<City>> map1 = (Map<String, List<City>>) cityList.stream().collect(groupingBy(City::getCountry_code));
	
	map1.entrySet().forEach(entry -> {
	    System.out.println(entry.getKey() + " " + entry.getValue());
	});
	

System.out.println("Please Enter country code to sort the country's cities based on population: ");
Scanner input = new Scanner(System.in);
String s0 = input.next();
	
List <City> req_cities = map1.get(" "+s0);

req_cities.sort(Comparator.comparingInt(City::getPopulation));
System.out.println("The sorted list for the requested country is: ");
System.out.println(req_cities);

System.out.println("############################################");



Map<String, Integer> population_map = (Map<String, Integer>) countryList.stream().collect(Collectors.toMap(Country::getName, Country:: getPopulation));

System.out.println("populaiton list is: ");

population_map.entrySet().forEach(entry -> {
    System.out.println(entry.getKey() + " " + entry.getValue());
});

System.out.println("############################################");

OptionalDouble average, max;

Calculations cal = new Calculations();
average = cal.getAvgPop(countryList);
System.out.println("Average of population is: ");
System.out.println(average);

System.out.println("############################################");

System.out.println("Maximum of population is: ");
max = cal.getMaxPop(countryList);
System.out.println(max);

System.out.println("############################################");

Map highest = cal.gethighestPopcity(cityList);
System.out.println("Highest population city of each country : ");
System.out.println(highest);




	

	}
}
