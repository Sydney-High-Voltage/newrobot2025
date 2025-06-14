package config.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.pedropathing.util.Timer;

import config.core.Robot;
import config.subsystems.Extend;
import config.subsystems.Outtake;

public class SpecTransfer extends CommandBase {
    private final Robot robot;

    private int state = 0;
    private Timer timer = new Timer();

    public SpecTransfer(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void initialize() {
        setState(0);
    }

    @Override
    public void execute() {
        robot.getT().addData("t state", state);
        robot.getT().update();
        switch (state) {
            case 0:
                //     transferSampleDetected = (intake.getColor() == IntakeColor.BLUE || intake.getColor() == IntakeColor.RED || intake.getColor() == IntakeColor.YELLOW);
                robot.getO().transfer();
                robot.getI().hover();
                robot.getL().pidOff();
                setState(1);
                break;
            case 1:
                if (robot.getF().getCurrentTValue() >= 0.2) {
                    robot.getI().transfer();
                    setState(2);
                }
                break;
            case 2:
                if (timer.getElapsedTimeSeconds() > 0.1) {
                    robot.getE().toTransfer();
                    setState(3);
                }
                break;
            case 3:
                int temp;

                if (robot.getE().getState() == Extend.ExtendState.FULL)
                    temp = 1;
                else
                    temp = 0;

                if (timer.getElapsedTimeSeconds() > 0.4 && temp == 0) {
                    robot.getO().close();
                    setState(4);
                } else if (timer.getElapsedTimeSeconds() > 0.6 && temp == 1) {
                    robot.getO().close();
                    setState(4);
                }
                break;
            case 4:
                if (timer.getElapsedTimeSeconds() > 0.25) {
                    robot.getI().open();
                    setState(5);
                }
                break;
            case 5:
                if (timer.getElapsedTimeSeconds() > 0.2) {
                    robot.getO().score();
                    setState(6);
                }
                break;
            case 6:
                if (timer.getElapsedTimeSeconds() > 0.2) {
                    setState(-1);
                }
                break;
        }
    }

    @Override
    public boolean isFinished() {
        return state == -1;
    }

    public void setState(int x) {
        state = x;
        timer.resetTimer();
    }

}
