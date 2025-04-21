package com.server;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PDA extends ComputerEquipment{
	@JsonCreator
	public PDA(@JsonProperty("cpu") String cpu, @JsonProperty("hddCapacity") int hddcapacity, @JsonProperty("type") String type) {
		super(cpu, hddcapacity);
		
		this.type = type;
	}
	
	@JsonProperty
	private String type;
	
	public void Show() {
		System.out.printf("Type - %s \n", type);
		super.Show();
	}
}
