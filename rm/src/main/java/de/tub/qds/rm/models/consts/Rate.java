package de.tub.qds.rm.models.consts;

public enum Rate {

	FIFTEEN_SECONDS(15000),
	THIRTY_SECONDS(30000),
	ONE_MINUTE(60000),
	FIVE_MINUTES(300000),
	FIFTEEN_MINUTES(900000),
	THIRTY_MINUTES(1800000),
	ONE_HOUR(3600000),
	TWO_HOURS(7200000),
	SIX_HOURS(21600000),
	TWELVE_HOURS(43200000),
	EIGHTEEN_HOURS(64800000),
	ONE_DAY(86400000);
	
	public final int inMilliseconds;
	
	private Rate(int inMilliseconds){
		this.inMilliseconds = inMilliseconds;
	}

	public int getInMilliseconds() {
		return inMilliseconds;
	}
	
}
