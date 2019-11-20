import cn.zjf.twoway.Two_Way_LinkedList;
import cn.zjf.twowayloop.Two_Way_Loop_LinkedList;

public class test {
    public static void main(String[] args) {
        Two_Way_Loop_LinkedList<String> twl = new Two_Way_Loop_LinkedList<>();
        //twl.display();
        twl.add("1");
        twl.add("2");
        twl.add("3");
        twl.add("4");
        twl.add("5");
        twl.remove(0);
        twl.remove(2);
        twl.display();
    }
}
