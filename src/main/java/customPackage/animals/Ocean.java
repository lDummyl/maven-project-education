package customPackage.animals;


public class Ocean {
    public static void main(String[] args) {
        Whale toomie = new Whale("toomie", true);
        System.out.println(toomie);
        Krill noname_001 = new Krill("noname-001", true);
        System.out.println(noname_001);
        toomie.eatsKrill(noname_001);
        System.out.println(noname_001);

        Krill luckyKrill = new Krill("luckyKrill", true);
        System.out.println(luckyKrill);
//        Krill.isAlive=true;
        System.out.println(noname_001);
    }
}
