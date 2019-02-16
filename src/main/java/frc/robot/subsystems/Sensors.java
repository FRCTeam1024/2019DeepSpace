/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.I2C;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Sensors {

private I2C ColorSensor;
private ByteBuffer buf = ByteBuffer.allocate(5);

public void startColorSensor(){
    ColorSensor = new I2C(RobotMap.COLOR_SENSOR_PORT, 0x39);
    ColorSensor.write(0x00, 0b00000011);
}

public int red(){
    ColorSensor.read(0x80 | 0x20 | 0x16, 2, buf);
    buf.order(ByteOrder.LITTLE_ENDIAN);
    return buf.getShort(0);
}

public int green(){
    ColorSensor.read(0x80 | 0x20 | 0x18, 2, buf);
    buf.order(ByteOrder.LITTLE_ENDIAN);
    return buf.getShort(0);
}

public int blue(){
    ColorSensor.read(0x80 | 0x20 | 0x1A, 2, buf);
    buf.order(ByteOrder.LITTLE_ENDIAN);
    return buf.getShort(0);
}

public void printValue(){
    red();
    SmartDashboard.putNumber("Red Value", red());
    green();
    SmartDashboard.putNumber("Green Value", green());
    blue();
    SmartDashboard.putNumber("Blue Value", blue());
}


}
