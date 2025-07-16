package config.core;

import com.acmerobotics.dashboard.config.Config;

@Config
public class RobotConstants {

    // Outtake
    public static double outtakeGrabClose = 0.65;   // dont change
    public static double outtakeGrabOpen = 0.82;    // increase = wide, decrease = narrow. should decrease
    public static double outtakeRotateTransfer = 0.615;
    public static double outtakeRotateSpecimenGrab180 = 0.9;    // increase = higher, decrease = lower
    public static double outtakeRotateSpecimenScore0 = 0.495; //.55 // dont change
    public static double outtakeRotateLeftScore = 0.94;
    public static double outtakeRotateRightScore = 0.54;
    public static double outtakeRotateLeftSpecimenScore180 = 0.24; //  diff. 0.88 should be closer to 0.9 in my opinion this is full rotate
    public static double outtakeRotateRightSpecimenScore180 = 0.88; //^ diff
    public static double outtakeRotateLeftSpecimenGrab0 = 0.34;
    public static double outtakeRotateRightSpecimenGrab0 = 0.74;
    public static double outtakePivotTransfer= 0.3; // init height of pivot
    public static double outtakePivotScore = 0.35;
    public static double outtakePivotSpecimenGrab180 = 0.1; // grab position
    public static double outtakePivotSpecimenScore180 = 0.8;
    public static double outtakePivotHalfScore = 0.5;

    public static double outtakePivotSpecimenGrab0 = 0.1;
    public static double outtakePivotSpecimenScore0 = 0.59;
    public static double outtakePivotAfterSpecScore = 0.85;
    public static double outtakePivotSpecimenScore0After = 0.75;
    public static double outtakeRotateSpecimenScore0After = 0.515; //.6

    // Intake
    public static double intakeGrabClose = 0.075;
    public static double intakeGrabOpen = 0.34;
    public static double intakeRotateTransfer = 0; // idk
    public static double intakeRotateHoverVertical = 0; // idk
    public static double intakeRotateGroundVertical = 0; // idk
    public static double intakeRotateCloudVertical = 0; // idk
    public static double intakeRotateSpecimen = 0.45;
    public static double intakePivotTransfer= 0.625;
    public static double intakePivotGround = 0.78; // i changed idk
    public static double intakePivotHover = 0.38;
    public static double intakePivotCloud = 0.70; // i changed idk
    public static double intakePivotSpecimen = 0;
    public static double intakeRotatePerDegree = 0.0011;
    public static double intakePivotDrag = 1;
    public static double intakeRotateDrag = 0.31; // 0.31 for OLD

    // Lift Positions
    public static int liftToZero = 10;
    public static int liftToHumanPlayer = 200;
    public static int liftToHighChamber = 325;
    public static int liftAfterHighChamber = 100;
    public static int liftToHighBucket = 2100;
    public static int liftToTransfer = 200;
    public static int liftToPark = 925;
    public static int liftToHang = 1250;

    // Extend Positions
    public static double extendZero = 0.54;
    public static double extendFull = 0.36; //.27 // i changed this
    public static double extendTransfer = .53;
    public static double extendInchesPer = 0.01484375 * 16;

}