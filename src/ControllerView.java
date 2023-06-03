public class ControllerView {

    public static void actionStart(){
        try {
            ViewGame.on();
            ViewMenu.start.setEnabled(false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void actionTopPlayers(){
        try {
            ViewTopPlayers.on();
            ViewMenu.top10.setEnabled(false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void actionOptions(){
        try {
            ViewOptions.on();
            ViewMenu.options.setEnabled(false);
            ViewMenu.start.setEnabled(false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void actionRules(){
        try {
            ViewRules.on();
            ViewMenu.rules.setEnabled(false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void actionIndex(){
        try {
            ViewMenu.on();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void actionExitOptions() {
        ViewMenu.options.setEnabled(true);
        ViewMenu.start.setEnabled(true);
        ViewOptions.obj = null;
    }

    public static void actionExitRules() {
        ViewMenu.rules.setEnabled(true);
        ViewRules.obj = null;
    }

    public static void actionExitGame() {
        ViewMenu.start.setEnabled(true);
        ViewGame.obj = null;
        Engine.close();
    }

    public static void actionExitTopPlayers() {
        ViewMenu.top10.setEnabled(true);
        ViewTopPlayers.obj = null;
    }
}
