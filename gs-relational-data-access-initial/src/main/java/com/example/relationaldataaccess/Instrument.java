package com.example.relationaldataaccess;

public class Instrument {

	private int instrumentId;
	private String shortName;
	private String longName;
	
	public Instrument(int instrumentId, String shortName, String longName) {
		this.instrumentId = instrumentId;
		this.shortName = shortName;
		this.longName = longName;
	}

	public int getInstrumentId() {
		return instrumentId;
	}

	public void setInstrumentId(int instrumentId) {
		this.instrumentId = instrumentId;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getLongName() {
		return longName;
	}

	public void setLongName(String longName) {
		this.longName = longName;
	}

	@Override
	public String toString() {
		return String.format("Instrument [instrumentId=%s, shortName=%s, longName=%s]", instrumentId, shortName,
				longName);
	}
	
	

}
