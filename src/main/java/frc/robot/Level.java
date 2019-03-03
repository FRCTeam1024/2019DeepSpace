/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public enum Level {
	//INTAKE (Constants.INTAKE_HEIGHT),
	//SWITCH (Constants.SWITCH_HEIGHT),
	//SCALE_OWNERSHIP (Constants.SCALE_OWNERSHIP_HEIGHT),
	//SCALE_NEUTRAL (Constants.SCALE_NEUTRAL_HEIGHT),
	//SCALE_LOSS (Constants.SCALE_LOSS_HEIGHT),
    //PORTAL (Constants.PORTAL_HEIGHT);


    //need to configure acutal heights in constants *delete this once completed*

    CARGO_SHIP (Constants.CARGO_SHIP_HEIGHT),
    ROCKET_CARGO_1 (Constants.ROCKET_LEVEL_ONE_CARGO_HEIGHT),
    ROCKET_CARGO_2 (Constants.ROCKET_LEVEL_TWO_CARGO_HEIGHT),
    ROCKET_CARGO_3 (Constants.ROCKET_LEVEL_THREE_CARGO_HEIGHT),
    ROCKET_HATCH_1 (Constants.ROCKET_LEVEL_ONE_HATCH_HEIGHT),
    ROCKET_HATCH_2 (Constants.ROCKET_LEVEL_TWO_HATCH_HEIGHT),
    ROCKET_HATCH_3 (Constants.ROCKET_LEVEL_THREE_HATCH_HEIGHT);

	private final double height;
	
	Level(double height) {
		this.height = height;
	}
	
	public double getHeight() {
		return height;
	}
}