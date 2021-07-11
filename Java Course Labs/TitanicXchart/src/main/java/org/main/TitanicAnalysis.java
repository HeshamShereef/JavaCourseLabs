package org.main;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TitanicAnalysis {
    public static void main(String[] args) throws IOException {
        TitanicAnalysis titanicAnalysis = new TitanicAnalysis();
        List<Passenger> allPassengers = titanicAnalysis.getPassengersFromJsonFile ();
        titanicAnalysis.graphPassengerAges(allPassengers);
        titanicAnalysis.graphPassengerClass(allPassengers);
        titanicAnalysis.graphPassengersSurvived(allPassengers);
        titanicAnalysis.graphPassengersSurvivedGender(allPassengers);
    }

    public List<Passenger> getPassengersFromJsonFile() throws IOException {
        List<Passenger> allPassengers = new ArrayList<Passenger>();
        ObjectMapper objectMapper = new ObjectMapper ();
        objectMapper.configure (DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        InputStream input = new FileInputStream("titanic_passengers.json");
        allPassengers = objectMapper.readValue(input,new TypeReference<List<Passenger>>(){});
        return allPassengers;
    }

    public void graphPassengerAges(List<Passenger> passengerList) {
        List<Float> pAges = passengerList.stream ().map (Passenger::getAge).limit (8).collect (Collectors.toList ());
        List<String> pNames = passengerList.stream ().map (Passenger::getName).limit (8).collect (Collectors.toList ());
        CategoryChart chart = new CategoryChartBuilder().width (800).height (600).title ("Histogram").xAxisTitle ("Name").yAxisTitle ("Age").build ();
        chart.getStyler ().setLegendPosition (Styler.LegendPosition.InsideNW);
        chart.getStyler ().setHasAnnotations (true);
        chart.getStyler ().setStacked (true);
        chart.addSeries ("Ages", pNames, pAges);
        new SwingWrapper(chart).displayChart ();
    }

    public void graphPassengerClass(List<Passenger> passengerList) {
        Map<String, Long> result = passengerList.stream ()
                .collect (Collectors.groupingBy (Passenger::getPclass, Collectors.counting ()));
        PieChart chart = new PieChartBuilder().width (800).height (600).title ("Classes Pie Chart").build ();
        Color[] sliceColors = new Color[]{new Color (200, 100, 50), new Color (12, 99, 54), new Color (99, 12, 33)};
        chart.getStyler ().setSeriesColors (sliceColors);
        chart.addSeries ("First Class", result.get ("1"));
        chart.addSeries ("Second Class", result.get ("2"));
        chart.addSeries ("Third Class", result.get ("3"));
        new SwingWrapper (chart).displayChart ();
    }

    public void graphPassengersSurvived(List<Passenger> passengerList) {
        Map<String, Long> result = passengerList.stream ()
                .collect (Collectors.groupingBy (Passenger::getSurvived, Collectors.counting ()));
        PieChart chart = new PieChartBuilder ().width (800).height (600).title ("Survivors Pie Chart").build ();
        Color[] sliceColors = new Color[]{new Color (144, 55, 111), new Color (140, 199, 21)};
        chart.getStyler ().setSeriesColors (sliceColors);
        chart.addSeries ("Survived", result.get ("1"));
        chart.addSeries ("Died", result.get ("0"));
        new SwingWrapper (chart).displayChart ();
    }

    public void graphPassengersSurvivedGender(List<Passenger> passengerList) {
        List<Passenger> survivors = passengerList.stream().filter(titanicPassenger -> titanicPassenger.getSurvived().equals("1")).collect(Collectors.toList());
        Map<String, Long> result = survivors.stream ()
                .collect (Collectors.groupingBy (Passenger::getSex, Collectors.counting ()));
        PieChart chart = new PieChartBuilder ().width (800).height (600).title ("Survivors by gender Pie Chart").build ();
        Color[] sliceColors = new Color[]{new Color (20, 40, 77), new Color (120, 40, 10)};
        chart.getStyler ().setSeriesColors (sliceColors);
        chart.addSeries ("Male", result.get ("male"));
        chart.addSeries ("Female", result.get ("female"));
        new SwingWrapper (chart).displayChart ();
    }
}
