package com.sqli.train;

import java.util.ArrayList;
import java.util.List;

import com.sqli.train.exception.CargoNotEmptyException;
import com.sqli.train.exception.TrainModelNotFoundException;
import com.sqli.train.exception.WagonNotFoundException;
import com.sqli.train.utils.Fillable;
import com.sqli.train.utils.Wagon;
import com.sqli.train.utils.WagonFactory;
import com.sqli.train.utils.WagonTypeEnum;

public class Train {

	private final List<Wagon> wagons = new ArrayList<Wagon>();
	private static final String CONNEXION = "::";
	private static final String header = "<";
	private static final String footer = ">";

	public Train(String trainModel) {
		if(trainModel!=null){
			try {
				initWagonsWithTranModel(trainModel);
			} catch (TrainModelNotFoundException e) {
				System.err.println(e.getMessage());
			} catch (WagonNotFoundException e) {
				System.err.println(e.getMessage());
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}else{
			System.err.println("ERROR! Value null is not autorized");
		}
	}
	private void initWagonsWithTranModel(String trainModel) throws TrainModelNotFoundException, WagonNotFoundException, Exception {
		char[] wagonsType = trainModel.toCharArray();
		int position = 0;
		for (char wagonType : wagonsType) {
			try{
				WagonTypeEnum wagonTypeEnum = getWagonType(wagonType);
				createWagonByType(wagonTypeEnum);
			}catch(IllegalArgumentException illegalArgumentException){
				throw new TrainModelNotFoundException(position+1);
			}
			position++;
		}
	}

	private void createWagonByType(WagonTypeEnum wagonType) throws WagonNotFoundException, Exception {
		Wagon wagon = WagonFactory.getInstance().getWagonForType(wagonType);
		wagons.add(wagon);
	}
	private WagonTypeEnum getWagonType(Character wagon) throws IllegalArgumentException {
		return WagonTypeEnum.valueOf(wagon.toString());
	}
	public String print() {
		return constructAndPrintTrain();
	}
	private String constructAndPrintTrain() {
		StringBuilder trainFormat = new StringBuilder();
		int position=0;
		for (Wagon wagon : wagons) {
			if(position==0 && WagonTypeEnum.H.equals(wagon.getWagonType())){
				trainFormat.append(header);
			}
			trainFormat.append(wagon.print());
			position++;
			if(position<wagons.size()){
				trainFormat.append(CONNEXION);
			}else if(WagonTypeEnum.H.equals(wagon.getWagonType())){
				trainFormat.append(footer);
			}
		}
		return trainFormat.toString();
	}
	public void detachEnd() {
		int sizeTrain = wagons.size();
		if(sizeTrain>0){
			wagons.remove(sizeTrain-1);
		}
	}
	public void detachHead() {
		if(wagons.size()>0){
			wagons.remove(0);
		}
	}
	public boolean fill() {
		for (Wagon wagon : wagons) {
			if(wagon instanceof Fillable && ((Fillable) wagon).isEmpty()){
				try {
					((Fillable) wagon).fill();
					return true;
				} catch (CargoNotEmptyException e) {
					System.err.println(e.getMessage());
				}
			}
		}
		return false;
	}

}
