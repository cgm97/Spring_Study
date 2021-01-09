package hello.core.singleton;

import java.lang.ref.SoftReference;

public class SingletonService {

    // static 영역에 객체 딱 한개를 생성
    private static final SingletonService instance = new SingletonService();
    
    // 해당 객체가 필요하면 새로 객체를 생성하지않고 만들어둔 객체를 호출
    public static SingletonService getInstance() {
        return instance;
    }
    
    // private 로 외부에서 new 키워드로 객체 인스턴스가 생성되는것을 막는다 
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
