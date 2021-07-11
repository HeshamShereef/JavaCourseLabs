
import java.io.*;
import java.util.*;

public class Lab2 {

	public static void main(String[] args) throws IOException {
		PyramidCSVDao pDAO = new PyramidCSVDao();
		List<Pyramid> pyramids = pDAO.readPyramidsFromCSV("pyramids.csv");
		int i =0;
		for(Pyramid p : pyramids)
			System.out.println("# " + (i++) + " "+ p);
		
		System.out.println("###############################################");
		
		
		pyramids.sort(Comparator.comparingDouble(Pyramid::getHeight));
		int j =0;
		for(Pyramid p : pyramids)
			System.out.println("# " + (j++) + " "+ p);
		
		System.out.println("###############################################");
		
		Map <String, Integer> sitesCounts = new LinkedHashMap<>();
		
		for (Pyramid p: pyramids) {
			String site = p.getSite();
			Integer count = sitesCounts.get(site);
			if (count == null)
				count =1;
			else
				count++;
			
			sitesCounts.put(site, count);
			
			}
		System.out.println(sitesCounts);

	}

}
