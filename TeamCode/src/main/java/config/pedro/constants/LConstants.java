package config.pedro.constants;

import com.pedropathing.localization.*;
import com.pedropathing.localization.constants.*;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;

public class LConstants {
    static {
        TwoWheelConstants.forwardTicksToInches = .001989436789;
        TwoWheelConstants.strafeTicksToInches = .001989436789;
        TwoWheelConstants.forwardY = 1; // to-do
        TwoWheelConstants.strafeX = -2.5; // to-do
        TwoWheelConstants.forwardEncoder_HardwareMapName = "leftFront"; // to-do
        TwoWheelConstants.strafeEncoder_HardwareMapName = "rightRear"; // to-do
        TwoWheelConstants.forwardEncoderDirection = Encoder.REVERSE;
        TwoWheelConstants.strafeEncoderDirection = Encoder.FORWARD;
        TwoWheelConstants.IMU_HardwareMapName = "imu";
        TwoWheelConstants.IMU_Orientation = new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.UP, RevHubOrientationOnRobot.UsbFacingDirection.LEFT);

//        PinpointConstants.forwardY = -5;
//        PinpointConstants.strafeX = -2;
//        PinpointConstants.hardwareMapName = "pinpoint";
//
//        PinpointConstants.useYawScalar = false;
//        PinpointConstants.yawScalar = 1.0;
//
//        PinpointConstants.useCustomEncoderResolution = false;
//        PinpointConstants.encoderResolution = GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD;
//        PinpointConstants.customEncoderResolution = 13.26291192;
//
//        PinpointConstants.forwardEncoderDirection = GoBildaPinpointDriver.EncoderDirection.FORWARD;
//        PinpointConstants.strafeEncoderDirection = GoBildaPinpointDriver.EncoderDirection.REVERSED;

    }
}




