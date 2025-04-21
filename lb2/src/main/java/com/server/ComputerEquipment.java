package com.server;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter  
@AllArgsConstructor  
@NoArgsConstructor 
public class ComputerEquipment {	
	
	private String cpu;
	private int hddCapacity;
	
	public void Show() {

		System.out.printf("""
                CPU - %s
                HDD capacity - %d
                
                """, cpu, hddCapacity);
	}

}