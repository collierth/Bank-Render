package com.fdmgroup.bankUserStories.geoCoder;

import jakarta.persistence.Entity;

public class Geodata 
{
    private Standard standard = new Standard();

	public Standard getStandard() 
	{
		return standard;
	}

	@Override
	public String toString() {
		return "Geodata [standard=" + standard + "]";
	}
	
}
