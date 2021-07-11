import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PyramidCSVDao {
	List pyramid_list; 
	
	public PyramidCSVDao() {
		pyramid_list = new ArrayList<Pyramid>();
	
	}
	public List<Pyramid> readPyramidsFromCSV(String fileName) throws IOException{
		
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		Pyramid pd;
		
		do {
			line = br.readLine();
			if (line != null)
			{
				String[] attr = line.split(",");
				if (attr[7].length() == 0)
				{
					pd= new Pyramid(attr[0], attr[2], attr[4],0);
					pyramid_list.add(pd);
				}
				else
				{
				pd= new Pyramid(attr[0], attr[2], attr[4],Double.parseDouble(attr[7]));
				pyramid_list.add(pd);
				}
			}
		} while(line != null);
		br.close();
		return pyramid_list;
		
	}

}
