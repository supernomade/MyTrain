package com.sqli.train.model.cargo;

import com.sqli.train.exception.CargoNotEmptyException;
import com.sqli.train.utils.Fillable;
import com.sqli.train.utils.Wagon;
import com.sqli.train.utils.WagonTypeEnum;

public class Cargo extends Wagon implements Fillable{

	private boolean isEmpty=true;

	private static final String CARGO_FILLED = "|^^^^|";

	public Cargo() {
		super(WagonTypeEnum.C);
	}

	public void fill() throws CargoNotEmptyException {
		if(isEmpty){
			isEmpty = false;
		}else{
			throw new CargoNotEmptyException();
		}
	}


	/**
	 * return stat of cargo
	 * @return
	 */
	public boolean isEmpty(){
		return isEmpty;
	}
	@Override
	public String print() {
		if(isEmpty()){
			return super.print();
		}else{
			return CARGO_FILLED;
		}
	}
}
