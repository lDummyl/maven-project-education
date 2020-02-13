package bonus;

import lombok.SneakyThrows;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class RobotPusher {


    public static final String ROOT_PACKAGE = "/media/ludovd/F63AAD3A3AACF8AF/Users/mi/Desktop/REPETITION/maven-project-education/src/main/java/bonus/refactor/lombok";
    private static final int START_SEC_DELAY = 3;
    private static Robot robot;

    public static void main(String[] args) throws AWTException, InterruptedException, IOException {

        robot = new Robot();
        TimeUnit.SECONDS.sleep(START_SEC_DELAY);
//        Runnable sl4fjToNext = () -> {
//            moveToNextFile();
//            addLombokLog();
//        };
//        doNtimes(sl4fjToNext, 2);

        List<Path> classes = Files.walk(Paths.get(ROOT_PACKAGE)).map(Path::getFileName).peek(System.out::println).filter(p -> p.toString().endsWith(".java")).collect(Collectors.toList());
//        classes.forEach(RobotPusher::addBoilerplate);
        classes.forEach(RobotPusher::addLombokDataToClass);

    }

    private static void addBoilerplate(Path path) {
        navigateToClass(path);
        keysHoldCombination(KeyEvent.VK_ALT, KeyEvent.VK_INSERT);
        keysPressFastCombination(KeyEvent.VK_DOWN, KeyEvent.VK_DOWN, KeyEvent.VK_DOWN);
        enter();
        keysHoldCombination(KeyEvent.VK_CONTROL, KeyEvent.VK_A);
        enter();

        keysHoldCombination(KeyEvent.VK_ALT, KeyEvent.VK_INSERT);
        keysPressFastCombination(KeyEvent.VK_DOWN, KeyEvent.VK_DOWN, KeyEvent.VK_DOWN, KeyEvent.VK_DOWN);
        enter(5); // warning! times depends on a fields, primitives only -> on time less.
        hold();

        keysHoldCombination(KeyEvent.VK_ALT, KeyEvent.VK_INSERT);
        keysPressFastCombination(KeyEvent.VK_DOWN, KeyEvent.VK_DOWN, KeyEvent.VK_DOWN, KeyEvent.VK_DOWN, KeyEvent.VK_DOWN);
        enter(2);
    }

    private static void navigateToClass(Path path) {
        callFileFindWindow();
        type(path.toString());
        enter();
        doNtimes(()->keysHoldCombination(KeyEvent.VK_ALT, KeyEvent.VK_UP), 5);
    }

    private static void addLombokDataToClass(Path path) {
        navigateToClass(path);
        addLombokData();
        hold(Duration.ofSeconds(2));
    }

    private static void addLombokData() {
        callLombokWindow();
        enter();
    }

    private static void callFileFindWindow() {
        keysHoldCombination(KeyEvent.VK_CONTROL, KeyEvent.VK_SHIFT, KeyEvent.VK_N);
    }

    private static void type(String text) {
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);
        keysHoldCombination(KeyEvent.VK_CONTROL, KeyEvent.VK_V);
    }

    private static void doNtimes(Runnable runnable, int n) {
        for (int i = 0; i < n; i++) {
            runnable.run();
        }
    }

    private static void addLombokLog() {
        callLombokWindow();
        keysPressCombination(KeyEvent.VK_UP, KeyEvent.VK_ENTER);
    }

    private static void callLombokWindow() {
        callActionsWindow();
        type("lombok");
        enter();
    }

    private static void enter() {
        keySinglePush(KeyEvent.VK_ENTER);
        hold(Duration.ofMillis(700));
    }

    private static void enter(int times) {
        doNtimes(RobotPusher::enter, times);
    }

    private static void callActionsWindow() {
        keysHoldCombination(KeyEvent.VK_SHIFT, KeyEvent.VK_CONTROL, KeyEvent.VK_A);
    }


    private static void moveToNextFile() {
        keysHoldCombination(KeyEvent.VK_ALT, KeyEvent.VK_HOME);
        keysPressCombination(KeyEvent.VK_DOWN, KeyEvent.VK_DOWN, KeyEvent.VK_ENTER);
    }


    private static void keySinglePush(int keyEvent) {
        robot.keyPress(keyEvent);
        robot.keyRelease(keyEvent);
    }


    private static void keysHoldCombination(int... keyEvents) {
        for (int keyEvent : keyEvents) {
            robot.keyPress(keyEvent);
        }
        for (int keyEvent : keyEvents) {
            robot.keyRelease(keyEvent);
        }
        hold();
    }

    private static void keysPressCombination(int... keyEvents) {
        for (int keyEvent : keyEvents) {
            keySinglePush(keyEvent);
            hold();
        }
    }
  private static void keysPressFastCombination(int... keyEvents) {
        for (int keyEvent : keyEvents) {
            keySinglePush(keyEvent);
            hold(Duration.ofMillis(100));
        }
        hold();
    }

    @SneakyThrows
    private static void hold() {
        TimeUnit.MILLISECONDS.sleep(500);
    }

    @SneakyThrows
    private static void hold(Duration duration) {
        long millis = duration.toMillis();
        TimeUnit.MILLISECONDS.sleep(millis);
    }
}
