package com.sqli.train.utils;

import java.util.HashMap;
import java.util.Map;

import com.sqli.train.exception.WagonNotFoundException;
import com.sqli.train.model.cargo.Cargo;
import com.sqli.train.model.locomotive.Locomotive;
import com.sqli.train.model.passenger.Passenger;
import com.sqli.train.model.restaurant.Restaurant;

public class WagonFactory {


	private static final Map<WagonTypeEnum, Wagon> wagons = new HashMap<WagonTypeEnum, Wagon>();
	static{
		addWagonInstance(new Cargo());
		addWagonInstance(new Locomotive());
		addWagonInstance(new Passenger());
		addWagonInstance(new Restaurant());
	}

	private static WagonFactory instance;

	/**
	 * single instance for application
	 * @return instance wagon factory
	 */
	public static WagonFactory getInstance(){
		if(instance==null){
			synchronized (WagonFactory.class) {
				if (instance==null) {
					instance = new WagonFactory();
				}
			}
		}
		return instance;
	}

	protected static synchronized void addWagonInstance(Wagon wagon) {
		//TODO verifier if wagon is not null
		wagons.put(wagon.getWagonType(), wagon);
	}



	/**
	 * get wagon for given wagon type
	 * @param wagonTypeEnum wagon type
	 * @return wagon if exist
	 * @throws WagonNotFoundException if wagon not existe in metadata (database for example)
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public Wagon getWagonForType(WagonTypeEnum wagonTypeEnum) throws WagonNotFoundException, InstantiationException, IllegalAccessException{
		if(wagons.containsKey(wagonTypeEnum)){
			return wagons.get(wagonTypeEnum).getClass().newInstance();
		}else{
			throw new WagonNotFoundException(wagonTypeEnum);
		}
	}
}
