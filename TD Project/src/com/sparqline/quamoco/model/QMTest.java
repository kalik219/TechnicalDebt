package com.sparqline.quamoco.model;

import java.io.*;
import java.util.*;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class QMTest {

	public static void main(String[] args) throws FileNotFoundException{
		QualityModel qm = new QualityModel("Technical Debt Quality Model"); //quality model object
		ProductFactor pf = null; //product factor object
		ProductQualityAttribute qa = null; //quality aspect object
		Impact imp = null;
		InfluenceEffect inf = null;
		
		try{
			
			/*
			 * Reading CSV file below
			 */
			
			CSVReader reader = new CSVReader(new FileReader("GRAPH.csv")); //using lib opencsv to read in CSV file
			String[] nextLine; //will hold next line of CSV file
			
			String[] firstLine = reader.readNext(); //first line of file should contain # of nodes & # of edges
			int numNodes = Integer.parseInt(firstLine[0]); //number of nodes in CSV file
			int numEdges = Integer.parseInt(firstLine[1]); //number of Edges in CSV file ... how to implement?
			int numPF = Integer.parseInt(firstLine[2]); //number of product factors
			int numQA = Integer.parseInt(firstLine[3]); //number of Product Quality Attributes/Quality Aspects
			
			int pfCount =0; //count to keep track of number of product factors read in
			int qaCount =0; //count to keep track of number of quality attributes/aspects read in
			int edgeCount =0; //count to keep track of number of edges read in
			
			ArrayList<Factor> arr = new ArrayList<Factor>(numNodes);
			ArrayList<Impact> arrI = new ArrayList<Impact>(numEdges);
			
			System.out.println("Number of nodes: " + numNodes + "   Number of edges: " + numEdges + "	Number of product factors: " + numPF + "	Number of Quality Aspects: " + numQA);
			
			while(edgeCount<numEdges && (nextLine=reader.readNext()) != null)
			{
				imp = Impact.builder(nextLine[0]).severity(Integer.parseInt(nextLine[2])).create(); //builds the impacts from the rest of the CSV file
				if(nextLine[1].equalsIgnoreCase("TRUE"))
					inf = InfluenceEffect.POSITIVE; //makes the influence effect positive
				else if(nextLine[1].equalsIgnoreCase("FALSE"))
					inf = InfluenceEffect.NEGATIVE; //makes the influence effect negative
				else
					System.out.println("NO INFLUENCE");
				imp.setEffect(inf); //sets the influence effect to the impact
				imp.setFutureTarget(nextLine[4]); //method added to the impact class so that i could add targets after being read in
				//how to add these to factors? Factor.addInfluence()?? what order should i read in???
				arrI.add(imp);
				edgeCount++;				
				//later on go through arraylist (arrI) and setTarget for each of the impacts after I create the factors!
			}

			while(pfCount< numPF && (nextLine=reader.readNext()) != null) //loop will read in next line of CSV file as long as its not null
			{
				pf = ProductFactor.builder(nextLine[0]).description("Multiplicity = " + nextLine[1]).create(); //instantiates product factor
				for(int i=0; i<arrI.size(); i++)
				{ //this isnt working??????????
					if(nextLine[2].equalsIgnoreCase(arrI.get(i).getIdentifier()))
					{
						pf.addInfluence(arrI.get(i));
					}
					if(nextLine[3].equalsIgnoreCase(arrI.get(i).getIdentifier()))
					{
						pf.addInfluence(arrI.get(i));
					}
					//come back and check this
				}
//				System.out.println("\n PF: " + pf.toString()); //prints out the product factor
//				System.out.println(pf.influences); //prints out the pf's influences
				arr.add(pf); //adds the PF to the Factor ArrayList
				pfCount++; //increments pfCount by 1
			}

			while(qaCount< numQA && (nextLine=reader.readNext()) != null) //loop will read in next line of CSV file as long as its not null
			{
				qa = ProductQualityAttribute.builder(nextLine[0]).description("Multiplicity = " + nextLine[1]).create(); //instantiates product factor
				for(int i=0; i<arrI.size(); i++)
				{
					if(nextLine[2].equalsIgnoreCase(arrI.get(i).getIdentifier()))
					{
						qa.addInfluence(arrI.get(i));						
					}
					if(nextLine[3].equalsIgnoreCase(arrI.get(i).getIdentifier()))
					{
						qa.addInfluence(arrI.get(i));
					}
					//come back and check this
				}
//				System.out.println("\n QA: " + qa.toString()); //prints out quality aspect
//				System.out.println(qa.influences); //prints out the qa's influences
				arr.add(qa); //adds QA to Factor ArrayList
				qaCount++; //increments qaCount by 1
			}
			//go through arrI and setTargets, then go through arr and set Impacts or vice versa
			for(int x=0; x<arrI.size(); x++) //going through impact arraylist
			{
				for(int y=0; y<arr.size(); y++) //going through factor arraylist
				{
					if(arrI.get(x).getFutureTarget().equalsIgnoreCase(arr.get(y).getName()))
					{
						arrI.get(x).setTarget(arr.get(y)); //setting targets for the impacts!						
					}
				}
			}
			for(int j=0; j<arr.size(); j++)
			{
				qm.addFactor(arr.get(j)); //adding all of the factors to the model
				System.out.println("ADDED TO QUALITY MODEL: " + arr.get(j));
			}
			
			System.out.println();
			System.out.println(qm.getFactors());
			for(int n=0; n<arrI.size(); n++)
			{
				System.out.println(arrI.get(n));
			}
			
			System.out.println("\n***CSV read complete...");
			
			/*
			 * Writing to CSV file below
			 */
			
			String filename = "GRAPH1.csv";
			
			try(CSVWriter writer = new CSVWriter(new FileWriter(filename))) 
			{
				String[] fLine = {"" + numNodes, "" + numEdges, "" + numPF, "" + numQA};
				writer.writeNext(fLine);

				String[] impactLine = new String[4];
				for(int a=0; a<arrI.size(); a++)
				{
					System.out.println(arrI.get(a).getIdentifier());
					impactLine[0] = "" + arrI.get(a).getIdentifier();
					impactLine[1] = "" + arrI.get(a).getEffect();
					impactLine[2] = "" + arrI.get(a).getSeverity();
					impactLine[3] = "" + arrI.get(a).getTarget().getName();
							
					writer.writeNext(impactLine);
				}
				
				
				writer.close();
				reader.close();

				System.out.println("\n ***CSV write complete...");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

}

//need to add to qm model!!!
//how to set influences? not working
