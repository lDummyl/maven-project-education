package simpleTasks.DomesticAppliances.MyVersion;

public class Multivarka extends SmartDevice {

    Program program;

    public Multivarka(Program program) {
        this.program = program;
    }

    public void executeProgram() {
        if("Switch on porridge".equals(program.voiceCommand)){
            System.out.println("Your porridge is cooked");
        }
    }
}
