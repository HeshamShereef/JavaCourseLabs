import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface CDao {
	public List<Country> ReadCountryFromCSV(String fileName) throws FileNotFoundException, IOException;
	public List<City> ReadCityFromCSV(String fileName) throws IOException;

}
