/*
 * Technical Debt REU Research Project
 * Quamoco Quality Metamodel Extension from CSV File
 * *reads from CSV file
 * *populates extension of model
 * *writes new CSV file
 * 
 * @author Kali Kimball
 */

package com.sparqline.quamoco.model;

import java.io.*;
import java.util.*;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class QMTest {

	//create diff methods
	
	public static void main(String[] args) throws FileNotFoundException{
		
		buildModel(); //method reads the CSV file, builds the model, and writes the new CSV file
	
	}
	
	public static void buildModel()
	{
		QualityModel qm = new QualityModel("Technical Debt Quality Model");	 	//quality model object
		ProductFactor pf = null; 												//product factor object
		ProductQualityAttribute qa = null; 										//quality aspect object
		Impact imp = null; 														//impact object
		InfluenceEffect inf = null;												//influence effect object
		
		try{
			
			/*
			 * Reading CSV file below
			 */
			System.out.println("***Reading CSV File...");
			
			CSVReader reader = new CSVReader(new FileReader("GRAPH.csv")); //using lib opencsv to read in CSV file
			String[] nextLine; //will hold next line of CSV file
			
			/*
			 * The first line of the CSV file contains, in order, the number of total factors/nodes,
			 * the number of impacts/edges, the number of product factors, and the number of quality
			 * aspects. This is read in and saved under the corresponding variables below.
			 */
			
			String[] firstLine = reader.readNext();			 	//first line of file should contain # of nodes & # of edges
			int numNodes = Integer.parseInt(firstLine[0]); 		//number of nodes in CSV file
			int numEdges = Integer.parseInt(firstLine[1]); 		//number of Edges in CSV file 
			int numPF = Integer.parseInt(firstLine[2]); 		//number of product factors
			int numQA = Integer.parseInt(firstLine[3]);		 	//number of Product Quality Attributes/Quality Aspects
			
			int pfCount =0; 	//count to keep track of number of product factors read in
			int qaCount =0; 	//count to keep track of number of quality attributes/aspects read in
			int edgeCount =0; 	//count to keep track of number of edges read in
			
			ArrayList<Factor> arr = new ArrayList<Factor>(numNodes);	//ArrayList to hold all of the factors so they can be accessed later
			ArrayList<Impact> arrI = new ArrayList<Impact>(numEdges);	//ArrayList to hold all of the impacts so they can be accessed later
			
			System.out.println("Number of nodes: " + numNodes + "   Number of edges: " + numEdges + "	Number of product factors: " + numPF + "	Number of Quality Aspects: " + numQA);
			
			/*
			 * The next lines of the file that are read in are the impacts/edges. These impact objects 
			 * hold the following information:
			 *  - the effect the impact object will have on a factor object (FALSE = negative, TRUE = positive)
			 *  - the severity of the impact (1 = highest, 5 = lowest)
			 *  - the node the impact originates from (where it is coming from)
			 *  - the target of the impact (where it is going)
			 *  These are read in and saved under the corresponding variables below.
			 */
			while(edgeCount<numEdges && (nextLine=reader.readNext()) != null)
			{
				imp = Impact.builder(nextLine[0]).severity(Integer.parseInt(nextLine[2])).create(); //builds the impacts 
		
				if(nextLine[1].equalsIgnoreCase("TRUE"))
					inf = InfluenceEffect.POSITIVE; 			//makes the influence effect positive if CSV file says TRUE
				else if(nextLine[1].equalsIgnoreCase("FALSE"))
					inf = InfluenceEffect.NEGATIVE; 			//makes the influence effect negative if CSV file says FALSE
				else
					System.out.println("NO INFLUENCE");
			
				imp.setEffect(inf); 							//assigns the influence effect to the impact
				imp.setOriginName(nextLine[3]);					//saves the name of the Factor the impact originates from
				imp.setFutureTarget(nextLine[4]); 				//saves the name of the future target of the impact (to be assigned later)
				arrI.add(imp); 									//adds the impact to the ArrayList of impacts
				edgeCount++;				
			}
			
			/*
			 * After the impacts are read in, the nextLine will begin to read in the values that
			 * will become the factor objects. These values include:
			 * 
			 *  - the name/identifier of the Factor (ex. CWE-397: ...)
			 *  - the multiplicity of each factor
			 *  - the impact(s) that the Factor points to
			 *  
			 *  The following while loop specifically reads in Product Factors which are the most 
			 *  specific of the Factor types because they are directly measurable. 
			 */

			while(pfCount< numPF && (nextLine=reader.readNext()) != null) 
			{
				pf = ProductFactor.builder(nextLine[0]).description(nextLine[1]).create(); //builds product factors
				for(int i=0; i<arrI.size(); i++)
				{
					if(nextLine[2].equalsIgnoreCase(arrI.get(i).getIdentifier()))
					{
						pf.addInfluence(arrI.get(i));								//adds the correct impact to the PF
						System.out.println("ADDED INFLUENCE TO FACTOR: " + arrI.get(i));
					}
					if(nextLine[3].equalsIgnoreCase(arrI.get(i).getIdentifier()))
					{
						pf.addInfluence(arrI.get(i));								//adds 2nd correct impact to the PF
						System.out.println("ADDED INFLUENCE TO FACTOR: " + arrI.get(i));
					}
				}
				
				arr.add(pf); 			//adds the PF to the Factor ArrayList
				pfCount++; 
			}

			/*
			 * The following while loop is essentially the same as the previous Product Factor loop, but
			 * this one reads in Quality Aspects which are more abstract and not directly measurable. 
			 * 
			 * Again, the following read-in values include:
			 * 
			 *  - the name/identifier of the Factor (ex. Integrity)
			 *  - the multiplicity of each factor
			 *  - the impact(s) that the Factor points to
			 */
			while(qaCount< numQA && (nextLine=reader.readNext()) != null) 
			{
				qa = ProductQualityAttribute.builder(nextLine[0]).description(nextLine[1]).create(); //builds Quality Aspect
				for(int i=0; i<arrI.size(); i++)
				{
					if(nextLine[2].equalsIgnoreCase(arrI.get(i).getIdentifier()))
					{
						qa.addInfluence(arrI.get(i));								//adds the correct impact to the QA
						System.out.println("ADDED INFLUENCE TO FACTOR: " + arrI.get(i));
					}
					if(nextLine[3].equalsIgnoreCase(arrI.get(i).getIdentifier()))
					{
						qa.addInfluence(arrI.get(i));								//adds 2nd correct impact to the QA
						System.out.println("ADDED INFLUENCE TO FACTOR: " + arrI.get(i));
					}
				}
				
				arr.add(qa); 			//adds QA to Factor ArrayList
				qaCount++; 
			}
			
			/*
			 * The following for loop will set the currently-accessed Impact's target if the name 
			 * under the getFutureTarget value matches the name of the currently-accessed Factor 
			 */
			
			for(int x=0; x<arrI.size(); x++) 						//going through impact ArrayList
			{
				for(int y=0; y<arr.size(); y++) 					//going through factor ArrayList
				{
					if(arrI.get(x).getFutureTarget().equalsIgnoreCase(arr.get(y).getName()))
					{
						arrI.get(x).setTarget(arr.get(y)); 			//sets target for current Impact					
					}
				}
			}
			
			/*
			 * The following for loop adds all of the Factors in the Factor ArrayList to 
			 * the quality model object.
			 */
			
			for(int j=0; j<arr.size(); j++)
			{
				qm.addFactor(arr.get(j)); //adding all of the factors to the model
				System.out.println("ADDED FACTOR TO QUALITY MODEL: " + arr.get(j));
			}
			
			System.out.println();
			System.out.println(qm.getName() + ": ");
			System.out.println(qm.getFactors());

			System.out.println("\n***CSV read complete...");
			System.out.println();
			
			/*
			 * Writing to CSV file below
			 */
			
			System.out.println("***Writing new CSV File...");
			
			String filename = "GRAPH1.csv";
			
			try(CSVWriter writer = new CSVWriter(new FileWriter(filename))) 
			{
				String[] fLine = {"" + numNodes, "" + numEdges, "" + numPF, "" + numQA};
				writer.writeNext(fLine);									//writes first line of CSV File

				String[] impactLine = new String[5];
				for(int a=0; a<arrI.size(); a++)
				{
					impactLine[0] = "" + arrI.get(a).getIdentifier(); 		//name of impact
					if(arrI.get(a).getEffect()==InfluenceEffect.POSITIVE)
						impactLine[1] = "TRUE";								//effect of impact (TRUE or FALSE)
					else if(arrI.get(a).getEffect()==InfluenceEffect.NEGATIVE)
						impactLine[1] = "FALSE";							//effect of impact (TRUE or FALSE)
					else
						impactLine[1] = null;
					impactLine[2] = "" + arrI.get(a).getSeverity(); 		//severity of impact (1-5)
					impactLine[3] = "" + arrI.get(a).getOriginName();		//name of the factor the impact is coming from
					impactLine[4] = "" + arrI.get(a).getTarget().getName();	//name of the factor that is the target of this imapct
							
					writer.writeNext(impactLine);							//writes the impacts to CSV File
				}
				String[] factorLine = new String[4];
				for(int b=0; b<arr.size(); b++)
				{
					factorLine[0] = arr.get(b).getName(); 					//name of the factor
					factorLine[1] = arr.get(b).getDescription();			//the multiplicity
					if(arr.get(b).getInfluences().size()==1)
					{
						factorLine[2] = arr.get(b).influences.get(0).getIdentifier();	//impact it effects
						factorLine[3] = null;
					}
					else if(arr.get(b).getInfluences().size()==2)
					{
						factorLine[2] = arr.get(b).influences.get(0).getIdentifier();	//impacts it effects
						factorLine[3] = arr.get(b).influences.get(1).getIdentifier();
					}
					else
					{
						factorLine[2] = null;
						factorLine[3] = null;
					}
					writer.writeNext(factorLine);		//writes the factors to CSV File
				}
				System.out.println("\n***CSV write complete...");
				writer.close();
			}
			catch(Exception e)
			{
				//ignoring the stream closed exception
			}
			reader.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		
		
	}

}