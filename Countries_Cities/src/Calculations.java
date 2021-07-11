import static java.util.stream.Collectors.groupingBy;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;


public class Calculations {
	public OptionalDouble getAvgPop(List<Country> countryList) {
		OptionalDouble average = countryList.stream().mapToDouble(Country::getPopulation).average();
		return average;
	}
	
	public OptionalDouble getMaxPop(List<Country> countryList) {
		OptionalDouble max = countryList.stream().mapToDouble(Country::getPopulation).max();
		return max;
	}
	
    public Map<String, Optional<City>> gethighestPopcity(List <City> cities){
    Map<String, Optional<City>> highestPop = cities.stream()
                .collect(groupingBy(City::getCountry_code,Collectors.maxBy(Comparator.comparing(City::getPopulation))));
        return highestPop;
    }
}
