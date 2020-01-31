package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="preseasonTeleop", group="Linear Opmode")
//@Disabled
public class preseasonTeleop {


    private ElapsedTime runtime = new ElapsedTime();

    // For Gamepad 1
    private DcMotor frontLeft = null;
    private DcMotor frontRight = null;
    private DcMotor backLeft = null;
    private DcMotor backRight = null;
   //for arm motor
   // private DcMotor armMotor = null;

    // For Gamepad 2

    /*
    private DcMotor hangArm = null;
    private Servo leftArm = null;
    private Servo rightArm = null;
    */

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        //For Gamepad 1
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        armMotor = hardwareMap.get(DcMotor.class, "arm");

        // hangArm = hardwareMap.get(DcMotor.class, "hang_arm");
        // leftArm = hardwareMap.get(Servo.class, "left_arm");
        // rightArm = hardwareMap.get(Servo.class, "right_arm");



        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.REVERSE);
        armMotor.setDirection(DcMotor.Direction.REVERSE);
        


        waitForStart();
        runtime.reset();

        //gamepad 1
        while (opModeIsActive()) {

            // double leftDrivePower = gamepad1.left_stick_y;
            // double rightDrivePower = gamepad1.right_stick_y;
            
            boolean forward = gamepad1.y;
            boolean backward = gamepad1.a;
            boolean right = gamepad1.b;
            boolean left = gamepad1.x;
            boolean rightDiagonal = gamepad1.right_bumper;
            boolean leftDiagonal = gamepad1.left_bumper;
            float arm = gamepad1.right_trigger;
            
            
            movements(forward, backward, right, left, leftDiagonal, rightDiagonal, arm);
                
              
        }
    }


    /*
        public void mecccanumFinal (){
        //Divider for Left and Right Strafe
        if(gamepad1.right_bumper) {
            leftBDrive.setPower(-1);
            leftFDrive.setPower(1);
            rightBDrive.setPower(1);
            rightFDrive.setPower(-1);

        }
        if(gamepad1.left_bumper) {
            leftFDrive.setPower(-1);
            leftBDrive.setPower(1);
            rightFDrive.setPower(1);
            rightBDrive.setPower(-1);
        }
    }
    */

    public void movements(boolean forward, boolean backward, boolean right, boolean left, boolean rightDiagonal, boolean leftDiagonal, float arm) {
        while (forward) {
            frontLeft.setPower(-0.5);
            frontRight.setPower(-0.5);
            backLeft.setPower(-0.5);
            backRight.setPower(-0.5);
            break;
        }
        while (backward) {
            frontLeft.setPower(0.5);
            frontRight.setPower(0.5);
            backLeft.setPower(0.5);
            backRight.setPower(0.5);

            break;
        }
        while (right) {
            frontLeft.setPower(-0.5);
            frontRight.setPower(0.5);
            backLeft.setPower(0.5);
            backRight.setPower(-0.5);
            break;
        }
        while (left) {
            frontLeft.setPower(0.5);
            frontRight.setPower(-0.5);
            backLeft.setPower(-0.5);
            backRight.setPower(0.5);
            break;
        }
        while (rightDiagonal) {
            frontLeft.setPower(-0.5);
            backRight.setPower(-0.5);
            break;
        }
        while (leftDiagonal) {
            frontRight.setPower(-0.5);
            backLeft.setPower(-0.5);
            break;
        }
        while (arm) {
            armMotor.setPower(0.2)
            break;
        }
    }
}
