package opmode.auto;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.arcrobotics.ftclib.command.WaitUntilCommand;
import com.pedropathing.commands.FollowPath;
import com.pedropathing.localization.Pose;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import config.commands.AlignSixSampFirst;
import config.commands.AlignSixSampSecond;
import config.commands.Bucket;
import config.commands.Submersible;
import config.commands.Transfer;
import config.core.Robot;
import config.core.util.Alliance;
import config.core.util.OpModeCommand;

@Autonomous(name = "0+4", group = "...Sigma")
public class SixSamp extends OpModeCommand {
    Robot r;

    @Override
    public void initialize() {
        r = new Robot(hardwareMap, telemetry, Alliance.BLUE, config.core.paths.SixSamp.start, false, 2);
        r.getI().init();
        r.getO().sevenInit();
        r.getO().close();
        r.getE().toZero();
        r.getT().addData("init", true);
        r.getT().addData("sub2", config.core.paths.SixSamp.sub2);
        r.getT().addData("sub3", config.core.paths.SixSamp.sub3);
        r.getT().update();

        schedule(
                new RunCommand(r::aPeriodic),
                new SequentialCommandGroup(
                        new Bucket(r)
                                .alongWith(
                                        new FollowPath(r.getF(), config.core.paths.SixSamp.score1())
                                ),
                        new FollowPath(r.getF(), config.core.paths.SixSamp.grab2())
                                                .alongWith(
                                        new WaitCommand(700)
                                                //.andThen(
//                                        new InstantCommand(() -> r.getE().toFull())
//                                                .andThen(
//                                                        new WaitCommand(450),
//                                                        new Submersible(r),
//                                                        new Transfer(r)
//                                                )
//                                        )
                                ),
                        new Bucket(r)
                                .alongWith(
                                        new FollowPath(r.getF(), config.core.paths.SixSamp.score2())
                                ),
                        new FollowPath(r.getF(), config.core.paths.SixSamp.grab3())
                                .alongWith(
                                        new WaitCommand(500)
//                                                .andThen(
//                                        new InstantCommand(() -> r.getE().toFull())
//                                                .andThen(
//                                                        new WaitCommand(450),
//                                                        new Submersible(r),
//                                                        new Transfer(r)
//                                                )
//                                        )
                                ),
                        new Bucket(r)
                                .alongWith(
                                        new FollowPath(r.getF(), config.core.paths.SixSamp.score3())
                                ),
                        new FollowPath(r.getF(), config.core.paths.SixSamp.grab4())
                                                .alongWith(
                                                        new WaitCommand(500)
//                                                                .andThen(
//                                                        new InstantCommand(() -> r.getE().toFull())
//                                                                .andThen(
//                                                                        new WaitCommand(450),
//                                                                        new Submersible(r),
//                                                                        new Transfer(r)
//                                                                )
//                                                        )
                                ),
                        new Bucket(r)
                                .alongWith(
                                        new FollowPath(r.getF(), config.core.paths.SixSamp.score4())
                                ),
       /*                 new AlignSixSampFirst(r, r.getM().getManualPoses().get(0))
                                .alongWith(
                                        new InstantCommand(() -> {
                                            r.getO().transfer();
                                            r.getI().hover();
                                        }
                                        )
                                                .andThen(
                                                        new WaitCommand(1500),
                                                        new InstantCommand(() -> r.getE().toFull()),
                                                        new WaitCommand(600),
                                                        new Submersible(r)
                                                )
                                ),
                        new FollowPath(r.getF(), config.core.paths.SixSamp.score3())
                                .alongWith(
                                        new WaitCommand(450),
                                        new Transfer(r)
                                ),
                        new Bucket(r)
                                .andThen(new AlignSixSampSecond(r, r.getM().getManualPoses().get(1))
                                        .alongWith(
                                                new InstantCommand(() -> {
                                                    r.getO().transfer();
                                                    r.getI().hover();
                                                }
                                                )
                                                        .andThen(
                                                                new WaitCommand(1500),
                                                                new InstantCommand(() -> r.getE().toFull()),
                                                                new WaitCommand(600),
                                                                new Submersible(r)
                                                        )
                                        ),
                        new FollowPath(r.getF(), config.core.paths.SixSamp.score3())
                                                .alongWith(
                                                        new WaitCommand(450),
                                                        new Transfer(r)
                                                )
                                ),
                        new Bucket(r)*/
                        new FollowPath(r.getF(), config.core.paths.SixSamp.park(), 1)
                                .alongWith(
                                        new InstantCommand(() -> {
                                            r.getO().transfer();
                                            r.getI().hover();
                                            //r.getL().toPark();
                                            //r.getE().toZero();
                                        }
                                        )
                                )
//                                ),
//                        new InstantCommand(() -> r.getE().toFull())
                )
        );
    }

    @Override
    public void init_loop() {
        super.init_loop();
        r.getM().update(gamepad2);

        r.getT().addLine();
        r.getT().addData("sub2", config.core.paths.SixSamp.sub2);
        r.getT().addData("sub3", config.core.paths.SixSamp.sub3);
        r.getT().addLine();
        r.getT().update();
    }
}